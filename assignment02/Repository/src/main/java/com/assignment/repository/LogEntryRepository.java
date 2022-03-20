package com.assignment.repository;

import com.assignment.dbGateway.LogEntryDBGateway;
import com.assignment.entity.LogEntry;
import com.assignment.persistence.derbySQL.LogEntryDBGatewayDerbyImpl;

import java.util.List;

public class LogEntryRepository {

    private static LogEntryRepository instance ;
    public static LogEntryRepository instance()
    {
        if(instance ==null)
            instance = new LogEntryRepository();

        return instance;
    }

    private final LogEntryDBGateway logEntryDBGateway;

    private LogEntryRepository(){
        logEntryDBGateway = LogEntryDBGatewayDerbyImpl.instance();
    }



    public List<LogEntry> fetchAllLogEntries() {
        return logEntryDBGateway.findAll(null, null, null);
    }

    public List<LogEntry> fetchAllLogEntries(String fromDate) {
        return logEntryDBGateway.findAll(fromDate,null,null);
    }

    public List<LogEntry> fetchAllLogEntries(String fromDate, String toDate) {
        return logEntryDBGateway.findAll(fromDate,toDate,null);
    }

    public List<LogEntry> fetchAllLogEntries(String fromDate, String toDate, String logType) {
        return logEntryDBGateway.findAll(fromDate,toDate,logType);
    }
}
