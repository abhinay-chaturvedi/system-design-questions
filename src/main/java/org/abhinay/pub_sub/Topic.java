package org.abhinay.pub_sub;

import java.util.HashSet;
import java.util.Set;

public class Topic {
    private final int id;
    private final String topicName;
    private final Set<Subscriber> subscriberSet;

    public Topic(int id, String topicName) {
        this.id = id;
        this.topicName = topicName;
        this.subscriberSet = new HashSet<>();
    }
    public void addSubscriber(Subscriber subscriber) {
        subscriberSet.add(subscriber);
    }
    public void removeSubscriber(Subscriber subscriber) {
        this.subscriberSet.remove(subscriber);
    }
    public void publishMessage(Message message) {
        this.subscriberSet.forEach((subscriber -> subscriber.onMessage(message)));
    }
}
