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

            return new Job(id, company, role, salary, status, location);
        } catch (NumberFormatException e) {
            System.out.println("Skipping line: invalid ID -> " + line);
            return null;
        }
    }
}
