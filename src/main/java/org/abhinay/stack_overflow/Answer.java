package org.abhinay.stack_overflow;

import java.util.ArrayList;
import java.util.Date;

public class Answer implements Votable, Commentable {

    private final int id;
//    private final String title;
    private final String content;
    private final User author;
    private boolean isAccepted;
    private final Question associatedQuestion;
    private final ArrayList<Comment> comments;
    private final ArrayList<Vote> votes;
    private Date creationDate;


    public Answer(String content, User author, Question question) {
        this.id = generateId();
//        this.title = title;
        this.content = content;
        this.author = author;
        this.associatedQuestion = question;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.creationDate = new Date();
        this.isAccepted = false;

    }
    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }


    @Override
    public void addVote(User user, int val) {
        if(val !=1 && val != -1) {
            System.out.println("Value canbe ether 1 or -1");
            throw new IllegalArgumentException("Argument can either be 1 or -1");
        }
        votes.removeIf((item) -> item.getAuthor().equals(user));
        votes.add(new Vote(user, val));
        this.author.updateReputation(val * 10);
    }

    @Override
    public ArrayList<Comment> getComments() {
        return new ArrayList<>(comments);
    }
    @Override
    public int getVoteCount() {
        return this.votes.stream().mapToInt(Vote::getValue).sum();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Question getAssociatedQuestion() {
        return associatedQuestion;
    }

    public ArrayList<Vote> getVotes() {
        return votes;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void addComment(Comment comment) {

        comments.forEach((com) -> {
            if(com.equals(comment)) {
                System.out.println("Comment already exists!");
                return ;
            }
        });
        comments.add(comment);
    }
    public void markIsAccepted() {
        if(isAccepted) {
            System.out.println("Already accepted!");
            return ;
        }
        this.isAccepted = true;
        this.author.updateReputation(15);
    }

}
