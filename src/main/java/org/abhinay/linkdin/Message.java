package org.abhinay.linkdin;

public class Message {
    private final String id;
    private final User sender;
    private final User receiver;
    private String content;

    public Message(String id, User sender, User receiver, String content) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }
}
