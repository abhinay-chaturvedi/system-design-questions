package org.abhinay.pub_sub;

public class PrintSubscriber implements Subscriber{
    private final int id;
    private final String name;

    public PrintSubscriber(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Subscriber - " + this.name + " - " + message);
    }
}
