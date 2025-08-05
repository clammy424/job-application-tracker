package main;
import javax.swing.*;
public class EditGUI extends JFrame {
    private JTextField txtJobTitle;
    private JTextField txtCompany;
    private JTextField txtLocation;
    private JTextField txtStatus;
    private JButton btnSave;
    private JobTableModel jobTableModel;
    private int selectedRow;

    public EditGUI(JobTableModel jobTableModel, int selectedRow) {
        this.jobTableModel = jobTableModel;
        this.selectedRow = selectedRow;

        setTitle("Edit Job");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        txtJobTitle = new JTextField();
        txtJobTitle.setBounds(150, 30, 200, 25);
        getContentPane().add(txtJobTitle);

        txtCompany = new JTextField();
        txtCompany.setBounds(150, 70, 200, 25);
        getContentPane().add(txtCompany);

        txtLocation = new JTextField();
        txtLocation.setBounds(150, 110, 200, 25);
        getContentPane().add(txtLocation);

        txtStatus = new JTextField();
        txtStatus.setBounds(150, 150, 200, 25);
        getContentPane().add(txtStatus);

        btnSave = new JButton("Save");
        btnSave.setBounds(150, 200, 100, 30);
        btnSave.addActionListener(e -> saveChanges());
        getContentPane().add(btnSave);

        loadJobData();
    }

    //TODO: implement getJobAt method in JobTableModel and getLocation

    private void loadJobData() {
        Job job = jobTableModel.getJobAt(selectedRow);
        if (job != null) {
            txtJobTitle.setText(job.getCompany());
            txtCompany.setText(job.getCompany());
            txtLocation.setText(job.getLocation());
            txtStatus.setText(job.getStatus());
        }
    }

    private void saveChanges() {
        Job updatedJob = new Job(
                txtJobTitle.getText(),
                txtCompany.getText(),
                txtLocation.getText(),
                txtStatus.getText()
        );
        
        //TODO: implement updateJobAt method in JobTableModel
        jobTableModel.updateJobAt(selectedRow, updatedJob);
        dispose();
    }
    
}
