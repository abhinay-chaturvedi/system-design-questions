package org.abhinay.linkdin;

import java.util.ArrayList;
import java.util.List;

public class LinkdinSystem {

    private final List<User> userList;

    public LinkdinSystem() {
        this.userList = new ArrayList<>();
    }


    public User registerUser(String name, String email, String password) {
        // Here first we will check if the user is already exists

        boolean isUserExists = userList.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
        if(isUserExists) {
            System.out.println("User already exists!");
            return null;
        }
        User user = new User(name, email, password);
        return user;
    }
    public User login(String email, String password) {
        User user = userList.stream().filter((user1 -> user1.getEmail().equalsIgnoreCase(email))).findFirst().orElse(null);
        if(user == null) return user;
        return user;
    }
}
