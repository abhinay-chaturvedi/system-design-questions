package org.abhinay.pub_sub;

public class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }
    public String toString() {
        return this.content;
    }
}
