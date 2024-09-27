package org.abhinay.logging_framework;

public class LogMessage {
    private LogLevel logLevel;
    private String message;
    private long timestamp;
    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LogMessage(LogLevel level, String message) {
        this.logLevel = level;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "[" + logLevel + "] " + timestamp + " - " + message;
    }
}
