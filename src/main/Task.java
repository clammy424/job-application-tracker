package main;

public class Task {
    private String task;
    private boolean completed;

    public Task(String task) {
        this.task = task;
        this.completed = false;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    public String toString() {
        return task + " - " + (completed ? "Completed" : "Incomplete");
    }
}
