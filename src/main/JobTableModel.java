package main;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class JobTableModel extends DefaultTableModel {
    private final String[] columnNames = {"ID", "Company", "Role", "Status", "Salary", "Location"};

    public JobTableModel() {
        super(new String[]{"ID", "Company", "Role", "Status", "Salary", "Location"}, 0);
    }

    public void addJob(Job job) {
        Object[] row = new Object[]{
            job.getID(),
            job.getCompany(),
            job.getRole(),
            job.getStatus(),
            job.getSalary(),
            job.getLocation()
        };
        addRow(row);
    }

    public void updateJob(int rowIndex, Job updatedJob) {
        setValueAt(updatedJob.getID(), rowIndex, 0);
        setValueAt(updatedJob.getCompany(), rowIndex, 1);
        setValueAt(updatedJob.getRole(), rowIndex, 2);
        setValueAt(updatedJob.getStatus(), rowIndex, 3);
        setValueAt(updatedJob.getSalary(), rowIndex, 4);
        setValueAt(updatedJob.getLocation(), rowIndex, 5);
    }

    public void removeJob(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < getRowCount()) {
            removeRow(rowIndex);
        }
    }

    public Job getJobAt(int rowIndex) {
        return new Job(
            (String) getValueAt(rowIndex, 0),
            (String) getValueAt(rowIndex, 1),
            (String) getValueAt(rowIndex, 2),
            (String) getValueAt(rowIndex, 3),
            (String) getValueAt(rowIndex, 4),
            (TodoList) getValueAt(rowIndex, 5)
        );
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Make cells non-editable
    }
}

