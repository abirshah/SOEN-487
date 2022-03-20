package com.example.rest.logEntry;


import com.example.rest.RepException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface LogEntrySoapWebService {

    @WebMethod
    String deleteAll() throws RepException;

    @WebMethod
    String fetchAll();

    @WebMethod
    String fetchFromDate(@WebParam(name = "fromDate") String fromDate);

    @WebMethod
    String fetchFromDateToDate(@WebParam(name = "fromDate") String fromDate, @WebParam(name = "toDate") String toDate);

    @WebMethod
    String fetchFromDateToDateWithLogType(@WebParam(name = "fromDate") String fromDate, @WebParam(name = "toDate") String toDate, @WebParam(name = "logType") String logType);

    @WebMethod
    String fetchAllWithLogType(@WebParam(name = "logType") String logType);


}
