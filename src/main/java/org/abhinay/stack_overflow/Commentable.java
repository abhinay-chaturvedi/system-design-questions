package org.abhinay.stack_overflow;

import java.util.ArrayList;

public interface Commentable {
    public void addComment(Comment comment);
    public ArrayList<Comment> getComments();
}
