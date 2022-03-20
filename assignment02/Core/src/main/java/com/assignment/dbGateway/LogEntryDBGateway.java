package com.assignment.dbGateway;

import com.assignment.entity.LogEntry;

import java.util.List;

public interface LogEntryDBGateway {

    void save(LogEntry log);
    List<LogEntry> findAll(String fromDate, String toDate, String logType);
}
