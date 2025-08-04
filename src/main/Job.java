package main;

import java.util.List;

public class Job {
    private String company;
    private String role;
    private String salary;

    // unsure todo type
    private List<Todo> todo;

    public Job(String company, String role, String salary, Todo todo) {
        this.company = company;
        this.role = role;
        this.salary = salary;
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

    public String toString() {

    }

    public static Job parser(String line) {

    }

}
