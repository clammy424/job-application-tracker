package main;

import javax.swing.table.DefaultTableModel;

public class JobTableModel extends DefaultTableModel {
    private final String[] columnNames = {"id","Company", "Role", "Status", "Salary","Location"};

    public JobTableModel() {
        super.setColumnIdentifiers(columnNames);
    }

    public void addJob(Job job) {
        Object[] row = {
            job.getID(),
            job.getCompany(),
            job.getRole(),
            job.getStatus(),
            job.getSalary(),
            job.getLocation()
        };
        addRow(row);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // Return false to make all cells non-editable
        return false;
    }
}
