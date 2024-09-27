package org.abhinay.logging_framework;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{
    private final String filePath;
    public FileAppender(String path) {
        this.filePath = path;
    }
    @Override
    public void append(LogMessage logMessage) {
        // here i will write to file
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(logMessage.toString());
            System.out.println(logMessage.getLogLevel().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

    }
}
