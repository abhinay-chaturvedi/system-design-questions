package org.abhinay.pub_sub;

public interface Subscriber {
    public void onMessage(Message message);
}
