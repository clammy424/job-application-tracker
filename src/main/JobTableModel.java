package main;

import javax.swing.table.DefaultTableModel;

public class JobTableModel extends DefaultTableModel {
    private final String[] columnNames = {"Company", "Role", "Status", "Salary"};

    public JobTableModel() {
        super.setColumnIdentifiers(columnNames);
    }

    public void addJob(Job job) {
        Object[] row = {
            job.getCompany(),
            job.getRole(),
            job.getStatus(),
            job.getSalary()
        };
        addRow(row);
    }
}
