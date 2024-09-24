package org.abhinay.stack_overflow;

import java.util.ArrayList;

public class StackOverflow {

    public static StackOverflow instance;
    private ArrayList<User> users;
    private ArrayList<Question> questions;

    public static StackOverflow getInstance() {

        if(instance == null) {
            instance = new StackOverflow();
        }
        return instance;
    }
    public StackOverflow() {
        this.users = new ArrayList<>();
    }
    // here i will make the method for adding users int the system.
    public void addUser(User user) {
        // first we will check if this user is already there
        users.forEach((item) -> {
            if(user.equals(item)) {
                System.out.println("User already exists!");
                return;
            }
        });
        System.out.println("User add successfully");
        users.add(user);
    }
    public void addQuestion(Question question) {

        questions.forEach((q) -> {
            if(q.equals(question)) {
                System.out.println("Question is already there!");
                return ;
            }
        });
        questions.add(question);
    }
    public void addAnswer(Question question, Answer answer) {
        question.addAnswer(answer);
    }
}
