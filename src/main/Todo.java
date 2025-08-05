package main;

public class Todo {
    private String task;
    private boolean completed;
    
    public Todo(String task) {
        this.task = task;
        completed = false;
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
}