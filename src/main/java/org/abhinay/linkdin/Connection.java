package org.abhinay.linkdin;

public class Connection {
    private final User user;

    public Connection(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
