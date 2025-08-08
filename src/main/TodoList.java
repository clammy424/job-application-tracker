package main;

import java.util.ArrayList;
public class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String taskText) {
        tasks.add(new Task(taskText));
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public int size() {
        return tasks.size();
    }

    public void markCompleted(int index) {
        tasks.get(index).setCompleted(true);
    }

    public void markIncomplete(int index) {
        tasks.get(index).setCompleted(false);
    }

    public void removeTaskAt(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public static TodoList parser(String line) {
        TodoList todoList = new TodoList();

        if (line == null || line.trim().isEmpty()) {
            return todoList;  // return empty list if no to-dos
        }

        String[] taskStrings = line.split("\\|");
        for (String taskString : taskStrings) {
            String[] parts = taskString.split(":", 2); // split into task and status
            if (parts.length == 2) {
                String text = parts[0].trim();
                boolean completed = Boolean.parseBoolean(parts[1].trim());
                Task task = new Task(text);
                task.setCompleted(completed);
                todoList.getAllTasks().add(task);
            }
        }

        return todoList;
    }

    public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tasks.size(); i++) {
        Task task = tasks.get(i);
        sb.append(task.getTask()).append(":").append(task.isCompleted());
        if (i < tasks.size() - 1) sb.append("|");
    }
    return sb.toString();
}
}