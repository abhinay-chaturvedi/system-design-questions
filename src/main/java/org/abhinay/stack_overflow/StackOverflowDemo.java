package org.abhinay.stack_overflow;

import java.util.ArrayList;
import java.util.Arrays;

public class StackOverflowDemo {
    public void run() {
        StackOverflow stackOverflow = StackOverflow.getInstance();
//        User user1 = new User();
//        stackOverflow.addUser(user1);
//        stackOverflow.addUser(user1);
        User abhinay = stackOverflow.addUser("abhinay", "abhinay@example.com");
        User nitesh = stackOverflow.addUser("nitesh", "nitesh@example.com");
        User third = stackOverflow.addUser("third", "third@example.com");


        Question javaQuestion = stackOverflow.addQuestion( "What is polymorphism in Java?",
                "Can someone explain polymorphism in Java with an example?",abhinay,
                new ArrayList<>(Arrays.asList("java", "oop")));


        Answer niteshAnswer = stackOverflow.addAnswer(javaQuestion,
                "Polymorphism in Java is the ability of an object to take on many forms...", nitesh);

        // third comments on the question
        stackOverflow.addComment("Great question! I'm also interested in learning about this.", third, javaQuestion);

        // Alice comments on Bob's answer
        stackOverflow.addComment("Thanks for the explanation! Could you provide a code example?", abhinay, niteshAnswer);

        // Charlie votes on the question and answer
        stackOverflow.vote(javaQuestion, 1, third);  // Upvote
        stackOverflow.vote(niteshAnswer, 1, third);  // Upvote

        // Alice accepts Bob's answer
        stackOverflow.acceptAnswer(niteshAnswer);



        // Print out the current state
        System.out.println("Question: " + javaQuestion.getTitle());
        System.out.println("Asked by: " + javaQuestion.getAuthor().getUsername());
        System.out.println("Tags: " + javaQuestion.getTags().stream().map(Tag::getName).reduce((a, b) -> a + ", " + b).orElse(""));
        System.out.println("Votes: " + javaQuestion.getVoteCount());
        System.out.println("Comments: " + javaQuestion.getComments().size());
        System.out.println("\nAnswer by " + niteshAnswer.getAuthor().getUsername() + ":");
        System.out.println(niteshAnswer.getContent());
        System.out.println("Votes: " + niteshAnswer.getVoteCount());
        System.out.println("Accepted: " + niteshAnswer.isAccepted());
        System.out.println("Comments: " + niteshAnswer.getComments().size());

        System.out.println("\nUser Reputations:");
        System.out.println("abhinay: " + abhinay.getReputation());
        System.out.println("nitesh: " + nitesh.getReputation());
        System.out.println("third: " + third.getReputation());

        // Demonstrate search functionality
        System.out.println("\nSearch Results for 'java':");
        ArrayList<Question> searchResults = stackOverflow.searchQueston("java");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        System.out.println("\nSearch Results for 'python':");
        searchResults = stackOverflow.searchQueston("python");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        // Demonstrate getting questions by user
        System.out.println("\nBob's Questions:");
        ArrayList<Question> abhinayQuestions = stackOverflow.getQuestionByUser(abhinay);
        for (Question q : abhinayQuestions) {
            System.out.println(q.getTitle());
        }
    }
}
