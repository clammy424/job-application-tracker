package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    private String fileName = "job_storer";

    public FileManager() {
    }

    public void save(Job job) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(job.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Job> loadJobs() {
        ArrayList<Job> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Job entry = Job.parser(line);
                entries.add(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public Job findByID(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if (Integer.valueOf(split[0]) == id) {
                    return Job.parser(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int maxID() {
        int id = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if (Integer.valueOf(split[0]) > id) {
                    id = Integer.valueOf(split[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void rewrite(ArrayList<Job> jobs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) { // false ensures overwrite
            for (Job j : jobs) {
                writer.write(j.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}
