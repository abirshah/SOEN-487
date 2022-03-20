package com.example.rest.logEntry;

import com.assignment.repository.LogEntryRepository;
import com.example.rest.RepException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class LogEntrySoapWebServiceImpl implements LogEntrySoapWebService{


    @WebMethod
    public String deleteAll() throws RepException
    {
        throw new RepException("not implemented yet!");
    }

    @WebMethod
    @Override
    public String fetchAll() {
        return LogEntryRepository.instance().fetchAllLogEntries().toString();
    }

    @Override
    @WebMethod
    public String fetchFromDate(@WebParam(name = "fromDate") String fromDate){
        return LogEntryRepository.instance().fetchAllLogEntries(fromDate).toString();
    }

    @Override
    @WebMethod
    public String fetchFromDateToDate(@WebParam(name = "fromDate") String fromDate, @WebParam(name = "toDate") String toDate) {
        return LogEntryRepository.instance().fetchAllLogEntries(fromDate,toDate).toString();
    }

    @Override
    @WebMethod
    public String fetchFromDateToDateWithLogType(@WebParam(name = "fromDate") String fromDate, @WebParam(name = "toDate") String toDate, @WebParam(name = "logType") String logType)
    {
        return LogEntryRepository.instance().fetchAllLogEntries(fromDate, toDate,logType).toString();
    }

    @Override
    @WebMethod
    public String fetchAllWithLogType(@WebParam(name = "logType") String logType)
    {
        return LogEntryRepository.instance().fetchAllLogEntries(null,null,logType).toString();
    }
}
