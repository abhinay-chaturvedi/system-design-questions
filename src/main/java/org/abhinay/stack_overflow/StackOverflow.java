package org.abhinay.stack_overflow;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverflow {

    // here is the reference for the stack overflow instance
    // which will be created using the singleton pattern.
    public static StackOverflow instance;
    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<String, Tag> tags;

    public static synchronized StackOverflow getInstance() {

        if(instance == null) {
            instance = new StackOverflow();
        }
        return instance;
    }
    public StackOverflow() {
        this.users = new ConcurrentHashMap<>();
        this.questions = new ConcurrentHashMap<>();
        this.answers = new ConcurrentHashMap<>();
        this.tags = new ConcurrentHashMap<>();
    }
    // here i will make the method for adding users int the system.
    public User addUser(String username, String email) {
        int id = users.size() + 1;
        User user = new User(id, username, email);
        users.put(id, user);
        return user;
    }
    public Question addQuestion(String title, String content, User user, ArrayList<String> tags) {
        Question question = user.addQuestion(title, content, tags);
        questions.put(question.getId(), question);
        for (Tag tag : question.getTags()) {
//            this.tags.putIfAbsent(tag.getName(), tag);
            this.tags.putIfAbsent(tag.getName(), tag);
        }

        return question;
    }
    public Answer addAnswer(Question question, String content, User user) {
        Answer answer = user.addAnswer(content, question);
        answers.put(answer.getId(), answer);
        return  answer;

    }
    public void vote(Votable votable, int val, User user) {
        votable.addVote(user, val);
    }
    public Comment addComment(String text, User user, Commentable commentable) {
        return user.addComment(text, commentable);
    }
    public void acceptAnswer(Answer answer) {
        answer.markIsAccepted();
    }
    public ArrayList<Question> searchQueston(String q) {
        return (ArrayList<Question>) this.questions.values().stream().filter((item) -> item.getTitle().toLowerCase().contains(q.toLowerCase()) ||
                item.getContent().toLowerCase().contains(q.toLowerCase()) ||
                item.getTags().stream().anyMatch((tag) -> tag.getName().equalsIgnoreCase(q))).collect(Collectors.toList());
    }
    public ArrayList<Question> getQuestionByUser(User user) {
        return user.getQuestions();
    }

}
