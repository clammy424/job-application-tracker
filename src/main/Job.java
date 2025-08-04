package main;

import java.util.List;

public class Job {
    private static int id = 0;
    private String company;
    private String role;
    private String salary;

    // unsure todo type
    private List<Todo> todo;

    public Job(String company, String role, String salary, Todo todo) {
        ++id;
        this.company = company;
        this.role = role;
        this.salary = salary;
        this.todo = todo;
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

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public String toString() {

    }

    public static Job parser(String line) {

    }

}
