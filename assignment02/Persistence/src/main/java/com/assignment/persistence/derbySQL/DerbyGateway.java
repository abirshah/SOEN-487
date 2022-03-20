package com.assignment.persistence.derbySQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DerbyGateway {

    public final Connection connection;

    private DerbyGateway()
    {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.connection = DriverManager.getConnection("jdbc:derby:memory:myDb;create=true");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static DerbyGateway instance;

    public static DerbyGateway instance()
    {
        if(instance == null)
            instance = new DerbyGateway();

        return instance;
    }


}
