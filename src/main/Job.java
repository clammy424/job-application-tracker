package main;

public class Job {
    private String company;
    private String role;
    private String salary;
    private String status;
    private String location;

    public Job(String company, String role, String salary, String status, String location) {
        this.company = company;
        this.role = role;
        this.salary = salary;
        this.status = status;
        this.location = location;
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

    public String toString() {
        String s = this.company + "," + this.role + "," + this.status + "," + this.salary + "," + this.location;
        return s;
    }

}
