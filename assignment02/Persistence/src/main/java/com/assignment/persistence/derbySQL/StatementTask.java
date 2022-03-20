package com.assignment.persistence.derbySQL;

import java.sql.Statement;

public interface StatementTask<T> {

    T  doItInsideStatement(Statement statement) throws Throwable;

}
