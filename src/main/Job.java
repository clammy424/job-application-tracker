package main;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Job {
    private static int count = 0;

    private int id;
    private String company;
    private String role;
    private String salary;
    private String status;
    private String location;
    private TodoList todoList;

    public Job(String company, String role, String salary, String status, String location, TodoList todoList) {
        id = ++count;
        this.company = company;
        this.role = role;
        this.salary = salary;
        this.status = status;
        this.location = location;
        this.todoList = todoList != null ? todoList : new TodoList();
    }
    
    public Job(int id, String company, String role, String salary, String status, String location, TodoList todoList) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.salary = salary;
        this.status = status;
        this.location = location;
        this.todoList = todoList != null ? todoList : new TodoList();
    }
    
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Job.count = count;
    }

    public String toString() {
        String s = id + "," + this.company + "," + this.role + "," + this.salary + "," + this.status + "," + this.location + "," + this.todoList;
        return s;
    }

    public static Job parser(String line) {
        if (line == null || line.trim().isEmpty()) {
            // skip empty lines
            return null;
        }

        String[] split = line.split(",", -1); // -1 preserves trailing empty strings

        if (split.length < 6) {
            System.out.println("Skipping line: not enough fields -> " + line);
            return null;
        }

        try {
            int id = Integer.parseInt(split[0].trim());

            String company = split[1].trim();
            String role = split[2].trim();
            String salary = split[3].trim();
            String status = split[4].trim();
            String location = split[5].trim();
            TodoList todoList = TodoList.parser(split.length > 6 ? split[6].trim() : ""); // handle optional todo list

            return new Job(id, company, role, salary, status, location, todoList);
        } catch (NumberFormatException e) {
            System.out.println("Skipping line: invalid ID -> " + line);
            return null;
        }
    }
}
