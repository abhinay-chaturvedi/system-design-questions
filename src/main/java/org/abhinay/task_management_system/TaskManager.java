package org.abhinay.task_management_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManager {
    private static TaskManager instance;
    private final Map<Integer, Task> tasks;

    public static TaskManager getInstance() {
        if(instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }
    // This is just because of, we don't want anyone to create the object of this class
    private TaskManager() {
        this.tasks = new ConcurrentHashMap<>();
    }
    public boolean createTask(Task task) {
        // check if task is already there
        if(this.tasks.containsKey(task.getId())) {
            System.out.println("Task already exists");
            return false;
        }
        this.tasks.put(task.getId(), task);
        return true;
    }
    public boolean deleteTask(Task task) {
        if(!this.tasks.containsKey(task.getId())) {
            System.out.println("Task does not exists!");
            return false;
        }
        this.tasks.remove(task.getId());
        return true;
    }
    public List<Task> searchTask(String keyword) {
        return this.tasks.values().stream().filter((item) -> {
            return (item.getTitle().contains(keyword) || item.getDesc().contains(keyword));
        }).toList();
    }
    public void assignTaskToUser(User user, Task task) {
        task.setAssignedUser(user);
    }
}
