package org.abhinay.linkdin;

import java.sql.Timestamp;

public class Notification {
    private final String id;
    private final NotificationType type;
    private final String content;
    private final User user;
    private final Timestamp timestamp;

    public Notification(String id, User user, NotificationType type, String content, Timestamp timestamp) {
        this.id = id;
        this.type = type;
        this.timestamp = timestamp;
        this.content = content;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
