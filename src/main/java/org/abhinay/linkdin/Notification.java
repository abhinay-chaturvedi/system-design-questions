package org.abhinay.linkdin;

public class Notification {
    private final String id;
    private final NotificationType type;
    private final String message;
    private final User user;

    public Notification(String id, User user, NotificationType type, String message) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.user = user;
    }
}
