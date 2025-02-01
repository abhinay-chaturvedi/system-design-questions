package org.abhinay.logging_framework;

public class LoggerDemo {
    public void run() {
        Logger logger = Logger.getInstance();
        logger.info("hi there!");
        Config config = new Config(LogLevel.DEBUG, new FileAppender("app.txt"));
        logger.setConfig(config);
        logger.debug("hi debug");
    }
}
