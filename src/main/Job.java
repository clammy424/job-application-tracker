package main;

public class Job {
    private static int count = 0;

    private int id;
    private String company;
    private String role;
    private String salary;
    private String status;
    private String location;

    public Job(String company, String role, String salary, String status, String location) {
        id = ++count;
        this.company = company;
        this.role = role;
        this.salary = salary;
        this.status = status;
        this.location = location;
    }
    
    public Job(int id, String company, String role, String salary, String status, String location) {
        this.id = id;
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
        String s = id + "," + this.company + "," + this.role + "," + this.status + "," + this.salary + "," + this.location;
        return s;
    }

    public static Job parser(String line) {
        String[] split = line.split(",");
        int id = Integer.valueOf(split[0]);
        String company = split[1];
        String role = split[2];
        String salary = split[3];
        String status = split[4];
        String location = split[5];
        Job j = new Job(id, company,role,salary,status,location);
        return j;
    }

}
