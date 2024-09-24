package org.abhinay.stack_overflow;

public class Vote {
    private int value;
    private User author;

    public int getValue() {
        return value;
    }

    public User getAuthor() {
        return author;
    }

    public Vote(User user, int value) {
        this.author = user;
        this.value = value;
    }
}
