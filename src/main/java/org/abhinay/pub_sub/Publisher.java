package org.abhinay.pub_sub;

public class Publisher {

    private final int id;
    private final String name;
    private final Topic topic;

    public Publisher(int id, String name, Topic topic) {
        this.id = id;
        this.name = name;
        this.topic = topic;
    }
    public void publishMessage(String message) {
        this.topic.publishMessage(new Message(message));
    }
}
