package org.abhinay.logging_framework;

public class Config {
    private final LogLevel logLevel;
    private final LogAppender logAppender;
    public Config(LogLevel logLevel, LogAppender logAppender) {
        this.logAppender = logAppender;
        this.logLevel = logLevel;
    }
    public LogAppender getLogAppender() {
        if(this.logAppender == null) {
            System.out.println("Plase configure log appender!");
        }
        return this.logAppender;
    }
    public LogLevel getLogLevel() {
        return this.logLevel;
    }
}
