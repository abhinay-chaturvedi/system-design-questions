package org.abhinay.logging_framework;

public class Logger {
    public static Logger instance;
    private Config config;
    private Logger() {
        this.config = new Config(LogLevel.INFO, new ConsoleAppender());
    }
    public static Logger getInstance() {
        if(instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void setConfig(Config config) {
        this.config = config;
    }
    public void log(LogLevel level, String message) {
//        System.out.println(message + level);
        if(level.ordinal() >= this.config.getLogLevel().ordinal()) {
            System.out.println(level.ordinal());
            System.out.println(this.config.getLogLevel().ordinal());
            this.config.getLogAppender().append(new LogMessage(level, message));
        }

    }
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
