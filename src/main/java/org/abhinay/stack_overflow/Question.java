package org.abhinay.stack_overflow;

import java.util.ArrayList;
import java.util.Date;

public class Question {

    private final int id;
    private final String title;
    private final String content;
    private final User author;
    private final ArrayList<Answer> answers;
    private final ArrayList<Comment> comments;
    private Date creationDate;
    private final ArrayList<Vote> votes;
    private final ArrayList<Tag> tags;

    public Question(int id, String title, String content, User author) {
        this.id = generateId();
        this.title = title;
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.creationDate = new Date();
    }
    private int generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void addVote(User user, int val) {
        if(val != -1 && val != 1) {
            throw new IllegalArgumentException("Either 0 or -1 is allowed!");
        }
        this.votes.removeIf((item) -> item.getAuthor().equals(user));
        this.votes.add(new Vote(user, val));

    }
    public void addTag(String tag) {
        if(this.tags.stream().anyMatch((t) -> t.getName().equals(tag))) {
            System.out.println("Tag already exists!");
            return ;
        }
        this.tags.add(new Tag(tag));
    }
    public void addAnswer(Answer answer) {

        answers.forEach((ans) -> {
            if(ans.equals(answer)) {
                System.out.println("Answer already exists!");
                return ;
            }
        });
        answers.add(answer);
    }
    public void addComment(Comment comment) {
        comments.forEach((com) -> {
            if(com.equals(comment)) {
                System.out.println("Comment already exist!");
                return ;
            }
        });
        comments.add(comment);
    }
}

