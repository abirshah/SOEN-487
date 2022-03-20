package com.assignment.entity;

import java.util.Calendar;

public class LogEntry{

    public final String recordKey;

    /**
     * Only Supported Date Format :   YYYY:MM:DD-H:M:S
     */
    public final String timestamp;
    public final LogType logType;

    /**
     * Only Supported Date Format :   YYYY:MM:DD-H:M:S
     */
    public LogEntry(String recordKey, LogType logType,String timestamp)
    {
        this.recordKey = recordKey;
        this.logType = logType;
        this.timestamp = timestamp;
    }

    public LogEntry(String recordKey, LogType logType) {
      this(recordKey,logType,getCurrentTime());
    }

    private static String getCurrentTime()
    {
        var d = Calendar.getInstance();

        return d.get(Calendar.YEAR)
                +":"+
                (d.get(Calendar.MONTH)+1)
                +":"+
                d.get(Calendar.DAY_OF_MONTH)
                +"-"+
                d.get(Calendar.HOUR_OF_DAY)
                +":"+
                d.get(Calendar.MINUTE)
                +":"+
                d.get(Calendar.SECOND);
    }



    public enum LogType{
        Create,Update,Delete
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "recordKey='" + recordKey + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", logType=" + logType +
                '}';
    }
}
