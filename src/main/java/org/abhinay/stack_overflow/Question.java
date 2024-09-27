package org.abhinay.stack_overflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable {

    private final int id;
    private final String title;
    private final String content;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public ArrayList<Vote> getVotes() {
        return votes;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    private final User author;
    private final ArrayList<Answer> answers;
    private final ArrayList<Comment> comments;
    private Date creationDate;
    private final ArrayList<Vote> votes;
    private final ArrayList<Tag> tags;

    public Question(String title, String content, User author, ArrayList<String> tags) {
        this.id = generateId();
        this.title = title;
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.tags = new ArrayList<>();
        for(String name: tags) {
            this.tags.add(new Tag(name));
        }
        this.creationDate = new Date();
    }
    private int generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public void addVote(User author, int val) {
        if(val != -1 && val != 1) {
            throw new IllegalArgumentException("Either 0 or -1 is allowed!");
        }
        this.votes.removeIf((item) -> item.getAuthor().equals(author));
        this.votes.add(new Vote(author, val));
        author.updateReputation(val * 5);

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
    @Override
    public void addComment(Comment comment) {
        comments.forEach((com) -> {
            if(com.equals(comment)) {
                System.out.println("Comment already exist!");
                return ;
            }
        });
        comments.add(comment);
    }

    @Override
    public ArrayList<Comment> getComments() {
        return new ArrayList<>(this.comments);
    }


    @Override
    public int getVoteCount() {
        return this.votes.stream().mapToInt(Vote::getValue).sum();
    }


}

