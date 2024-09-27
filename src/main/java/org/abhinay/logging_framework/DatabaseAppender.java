package org.abhinay.logging_framework;

public class DatabaseAppender implements LogAppender{
    private final String jdbcUrl;
    private final String username;
    private final String password;

    public DatabaseAppender(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    @Override
    public void append(LogMessage logMessage) {
        // here just connect to database and add the log message to it.
    }
}
