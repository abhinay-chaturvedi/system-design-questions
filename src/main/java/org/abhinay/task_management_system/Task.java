package org.abhinay.task_management_system;

import java.util.Date;

public class Task {
    private final int id;
    private String title;
    private String desc;
    private TaskStatus taskStatus;
    private Priority priority;
    private Date duedate;
    private User assignedUser;

    public Task(int id, String title, String desc, Date date) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.duedate = date;
        this.taskStatus = TaskStatus.PENDING;
        this.priority = Priority.LOW;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getDuedate() {
        return duedate;
    }

    public User getAssignedUser() {
        return assignedUser;
    }
}
