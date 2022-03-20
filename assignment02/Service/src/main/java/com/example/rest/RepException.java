package com.example.rest;

import jakarta.xml.ws.WebFault;

@WebFault
public class RepException extends RuntimeException{
    public RepException(String s) {
        super(s);
    }

    public String getFaultMessage()
    {
        return getMessage();
    }
}
