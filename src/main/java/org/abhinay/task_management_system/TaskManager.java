package org.abhinay.task_management_system;

import java.util.ArrayList;
import java.util.Date;
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
    public List<Task> filterTask(TaskStatus status, Date startDate, Date endDate, Priority priority) {
        return this.tasks.values().stream().filter((item) -> {
            return (item.getTaskStatus() == status && item.getPriority() == priority &&
                    item.getDuedate().compareTo(startDate) >= 0 &&
                    item.getDuedate().compareTo(endDate) <= 0);
        }).toList();
    }
    public void markTaskAsCompleted(Task task) {
//        task.setTaskStatus(TaskStatus.COMPLETED);
        synchronized (task) {
            task.setTaskStatus(TaskStatus.COMPLETED);
        }
    }
    public List<Task> getTaskHistory(User user) {
        return this.tasks.values().stream().filter((item) -> item.getAssignedUser().equals(user)).toList();
    }
    public void updateTask(Task updatedTask) {
        Task existingTask = tasks.get(updatedTask.getId());
        if (existingTask != null) {
            synchronized (existingTask) {
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDesc(updatedTask.getDesc());
                existingTask.setDuedate(updatedTask.getDuedate());
                existingTask.setPriority(updatedTask.getPriority());
                existingTask.setTaskStatus(updatedTask.getTaskStatus());
                existingTask.setAssignedUser(updatedTask.getAssignedUser());
            }
        }
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
