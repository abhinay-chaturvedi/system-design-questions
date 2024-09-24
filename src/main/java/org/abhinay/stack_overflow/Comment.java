package org.abhinay.stack_overflow;

import java.util.Date;

public class Comment {
    private int id;

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    private String text;
    private User author;
    private Date creationDate;
    public Comment(String text, User author) {
        this.id = generateId();
        this.text = text;
        this.author = author;
        this.creationDate = new Date();
    }
    private int generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
