package org.abhinay.linkdin;

import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private String email;
    private String password;
    private List<Connection> connections;
    private Profile profile;
    private final List<Message> inbox;
    private final List<Message> sendMessages;
    public User(String name, String email, String password,Profile profile, List<Message> inbox, List<Message> sendMessages) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.inbox = inbox;
        this.sendMessages = sendMessages;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
