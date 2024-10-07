package org.abhinay.pub_sub;

public class PubSub {
    private static PubSub instance;

    public static PubSub getInstance() {

        if(instance == null) {
            instance = new PubSub();
        }
        return instance;
    }
}
