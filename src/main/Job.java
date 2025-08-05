package main;

import java.util.List;

public class Job {
    private String company;
    private String role;
    private String salary;
    private String status;

    public Job(String company, String role, String salary, String status) {
        this.company = company;
        this.role = role;
        this.salary = salary;
        this.status = status;
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

}
