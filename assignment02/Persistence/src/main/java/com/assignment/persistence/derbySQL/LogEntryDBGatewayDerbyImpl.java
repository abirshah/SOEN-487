package com.assignment.persistence.derbySQL;

import com.assignment.dbGateway.LogEntryDBGateway;
import com.assignment.entity.LogEntry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogEntryDBGatewayDerbyImpl implements LogEntryDBGateway {

    private static LogEntryDBGatewayDerbyImpl instance;

    public static LogEntryDBGatewayDerbyImpl instance() {
        if (instance == null)
            instance = new LogEntryDBGatewayDerbyImpl();

        return instance;
    }

    private LogEntryDBGatewayDerbyImpl() {
        doItInsideStatement(statement -> statement.execute("""

                            CREATE TABLE LogEntry (
                               recordKey varchar(100) , 
                               timestamp varchar(100) , 
                               logType varchar(100) 
                                )
                           
                """));
    }


    private <T> T doItInsideStatement(StatementTask runner) {
        try {
            var statement = DerbyGateway.instance().connection.createStatement();
            var returnValue = runner.doItInsideStatement(statement);
            statement.close();
            return (T)returnValue;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(LogEntry log) {
        doItInsideStatement(statement -> {

            statement.execute("insert into LogEntry" +
                    " values("
                    +"'"+log.recordKey+"'" + ","
                    +"'"+log.timestamp+"'" +","
                    +"'"+log.logType+"'"+")"
            );


            if(statement.getUpdateCount()<1)
                throw new RuntimeException("could not save");

            return null;
        });
    }


    private LogEntry extractCurrentRecord(ResultSet resultSet) throws SQLException {

        if(!resultSet.next())
            return null;


        var recordKey = resultSet.getString("recordKey");
        var timestamp = resultSet.getString("timestamp");
        var logType = LogEntry.LogType.valueOf(resultSet.getString("logType"));


        return new LogEntry(recordKey,logType,timestamp);
    }


    @Override
    public List<LogEntry> findAll(String fromDate, String toDate, String logType) {
        return doItInsideStatement(statement -> {

            String sql = "select * from LogEntry ";
            String where = "";

            if(fromDate!=null && !fromDate.isBlank())
                where+=" (timestamp> '"+fromDate+"' )";

            if(toDate!=null && !toDate.isBlank())
            {
                if(!where.isBlank())
                    where+=" and ";
                where+=" (timestamp< '"+toDate+"')";
            }

            if(logType!=null && !logType.isBlank())
            {
                if(!where.isBlank())
                    where+=" and ";
                where+=" (logType= '"+logType+"')";
            }

            if(!where.isBlank())
                sql+= " where "+where;

            var resultSet = statement.executeQuery(sql);
            var list = new ArrayList<LogEntry>();
            LogEntry entry ;
            while((entry = extractCurrentRecord(resultSet))!=null)
                list.add(entry);

            resultSet.close();
            return list;
        });
    }


}
