package org.abhinay.pub_sub;

public class PubSub {
    private static PubSub instance;

    public static PubSub getInstance() {

        if(instance == null) {
            instance = new PubSub();
        }
        return instance;
    }
    public void run() {
        Topic topic1 = new Topic(1, "topic1");
        Topic topic2 = new Topic(2, "topic2");

        Subscriber subscriber1 = new PrintSubscriber(1, "subscriber1");
        Subscriber subscriber2 = new PrintSubscriber(2, "subscriber2");
        Subscriber subscriber3 = new PrintSubscriber(3, "subscriber3");
        Subscriber subscriber4 = new PrintSubscriber(4, "publisher4");
        topic1.addSubscriber(subscriber1);
        topic1.addSubscriber(subscriber3);
        topic2.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber4);

        Publisher publisher1 = new Publisher(1, "publisher1", topic1);
        Publisher publisher2 = new Publisher(2, "publisher2", topic2);
        publisher1.publishMessage("publishing the message through publisher1");
        publisher2.publishMessage("publishing message through publisher2");

        topic2.removeSubscriber(subscriber2);
        topic1.removeSubscriber(subscriber1);
        publisher1.publishMessage("publishing the message through publisher1");
        publisher2.publishMessage("publishing message through publisher2");
    }
}
