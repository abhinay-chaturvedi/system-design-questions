package org.abhinay.stack_overflow;

import java.util.ArrayList;
import java.util.List;

public class User {
//    private ArrayList<Question> questions;
    private int id;
    private String username;
    private String email;
    private int reputation;
    private ArrayList<Question> questions;
    private ArrayList<Answer> answers;
    private ArrayList<Comment> comments;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public int getReputation() {
        return reputation;
    }

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }
    public synchronized void  updateReputation(int value) {
        this.reputation += value;
        if(this.reputation < 0) this.reputation = 0;
    }
    public Question addQuestion(String title, String content, ArrayList<String> tags) {
        Question question = new Question(title, content, this, tags);
        questions.add(question);
        updateReputation(5);
        return question;
    }
    public Answer addAnswer(String content, Question question) {

        Answer answer = new Answer(content, this, question);
        answers.add(answer);
        question.addAnswer(answer);
        updateReputation(10);
        return answer;
    }
    public Comment addComment(String text, Commentable com) {

        Comment comment = new Comment(text, this);
        comments.add(comment);
        com.addComment(comment);
        updateReputation(2);

        return comment;
    }
    public ArrayList<Question> getQuestions() { return new ArrayList<>(questions); }
    public ArrayList<Answer> getAnswers() { return new ArrayList<>(answers); }
    public ArrayList<Comment> getComments() { return new ArrayList<>(comments); }
}
