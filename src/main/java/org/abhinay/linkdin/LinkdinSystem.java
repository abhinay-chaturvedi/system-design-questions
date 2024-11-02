package org.abhinay.linkdin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkdinSystem {

    private static LinkdinSystem instance;
    private final Map<String, User> users;
    private final Map<String, JobPosting> jobPostings;
    private final Map<String, List<Notification>> notifications;

    public LinkdinSystem() {
        this.users = new ConcurrentHashMap<>();
        this.jobPostings = new ConcurrentHashMap<>();
        this.notifications = new ConcurrentHashMap<>();
    }

    public static LinkdinSystem getInstance() {
        if(instance == null) {
            instance = new LinkdinSystem();
        }
        return instance;
    }
    // here i am going to write the logic for the register user
    public User registerUser(String name, String email, String password) {
        // Here first we will check if the user is already exists

        User isUserExists = users.getOrDefault(email, null);
        if(isUserExists != null) {
            System.out.println("User already exists!");
            return null;
        }
        User user = new User(name, email, password);
        users.put(user.getEmail(), user);
        return user;
    }
    // here i am going to write the logic for the login user.
    public User login(String email, String password) {
        User user = users.getOrDefault(email, null);
        if(user == null) {
            System.out.println("User does not exists! please register first");
            return null;
        }
        return user;
    }
    public List<User> searchUser(String keyword) {
        List<User>  searchResult = new ArrayList<>();
        for(User user: users.values()) {
            if(user.getName().contains(keyword)) {
                searchResult.add(user);
            }
        }
        return searchResult;
    }
    public void sendConnectionRequest(User sender, User receiver) {
        Connection connection = new Connection(sender);
        receiver.getConnections().add(connection);
        // after sending the connection request - we need to send the notification to the receiver
        Notification notification = new Notification(generateNotificationId(), receiver, NotificationType.CONNECTION_REQUEST, "Connection request from - " + receiver.getName());
        addNotification(receiver.getEmail(), notification);
    }

    public void acceptConnectionRequest(User user, User connectionUser) {
        for (Connection connection : user.getConnections()) {
            if (connection.getUser().equals(connectionUser)) {
//                user.getConnections().add(new Connection(connectionUser, new Timestamp(System.currentTimeMillis())));
                user.getConnections().add(new Connection(connectionUser));
                break;
            }
        }
    }
    public void jobPosting(JobPosting jobPosting){
        this.jobPostings.put(jobPosting.getId(), jobPosting);
        for(User user: users.values()) {
            Notification notification = new Notification(generateNotificationId(), user, NotificationType.CONNECTION_REQUEST, "New Job posting: " + jobPosting.getTitle());
            addNotification(user.getEmail(), notification);
        }
    }
    public List<JobPosting> searchJobPosting(String keyword) {
        return this.jobPostings.values().stream().filter((job) -> job.getTitle().contains(keyword) || job.getDesc().contains(keyword)).toList();
    }
    public void sendMessage(User sender, User receiver, String content) {
        Message message = new Message(generateMessageId(), sender, receiver, content);
//        receiver.getInbox().add(message);
//        sender.getSentMessages().add(message);
        Notification notification = new Notification(generateNotificationId(), receiver, NotificationType.MESSAGE, "New message from : " + sender.getName());
        addNotification(receiver.getEmail(), notification);
    }
    public List<Notification>  getNotificationByEmail(String email) {
        return this.notifications.getOrDefault(email, new ArrayList<>());
    }
    public void addNotification(String email, Notification notification) {
        this.notifications.computeIfAbsent(email, (k) -> new CopyOnWriteArrayList<>()).add(notification);
    }
    public String generateNotificationId() {
        return UUID.randomUUID().toString();
    }
    public String generateMessageId() {
        return UUID.randomUUID().toString();
    }
}
