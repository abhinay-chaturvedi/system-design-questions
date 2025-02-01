package org.abhinay.task_management_system;

import java.util.Date;
import java.util.List;

public class TaskManagementDemo {
    public void run() {
        TaskManager taskManager = TaskManager.getInstance();

        // Create users
        User user1 = new User(1, "John Doe", "john@example.com");
        User user2 = new User(2, "Jane Smith", "jane@example.com");
        Task task1 = new Task(1, "Task 1", "Description 1", new Date());
        task1.setAssignedUser(user1);
        task1.setPriority(Priority.LOW);
        Task task2 = new Task(2, "Task 2", "Description 2", new Date());
        task2.setAssignedUser(user2);
        task2.setPriority(Priority.MEDIUM);
        Task task3 = new Task(3, "Task 3", "Description 3", new Date());
        task3.setAssignedUser(user2);
        task3.setPriority(Priority.HIGH);

        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);
        List<Task> searchResults = taskManager.searchTask("Task 1");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }
        List<Task> filteredTasks = taskManager.filterTask(TaskStatus.PENDING, new Date(0), new Date(), Priority.LOW);
        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }
        taskManager.markTaskAsCompleted(task1);

        // Get task history for a user
        List<Task> taskHistory = taskManager.getTaskHistory(user2);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }
    }
}
