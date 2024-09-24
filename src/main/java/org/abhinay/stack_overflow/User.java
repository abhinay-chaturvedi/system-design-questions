package org.abhinay.stack_overflow;

import java.util.ArrayList;

public class User {
//    private ArrayList<Question> questions;
    private String id;
    private String username;
    private String email;
    private int reputation;
    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.reputation = 0;
    }
    public void updateReputation(int value) {
        this.reputation += value;
    }
}
