package org.abhinay.stack_overflow;

public interface Votable {
    void addVote(User user, int val);
    int getVoteCount();
}
