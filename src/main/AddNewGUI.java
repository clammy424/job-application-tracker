package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddNewGUI extends JFrame {
    private JPanel pane;
	private JLabel lblCompany;
    private JLabel lblRole;
    private JLabel lblStatus;
    private JLabel lblSalary;
    private JLabel lblLocation;
    private JTextField txtCompany;
    private JTextField txtRole;
    private JTextField txtStatus;
    private JTextField txtSalary;
    private JTextField txtLocation;
    private JButton btnSave;
    private JButton btnReset;
    private JButton btnCancel;

    public AddNewGUI(JobTableModel jobTableModel, FileManager fm) {
		setBounds(100,100,600,400);
		
		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(pane);
		pane.setLayout(null);

        lblCompany = new JLabel("Company:");
        lblCompany.setBounds(70, 35, 100, 26);
        pane.add(lblCompany);

        txtCompany = new JTextField();
        txtCompany.setBounds(165, 35, 200, 26);
        pane.add(txtCompany);

        lblRole = new JLabel("Role:");
        lblRole.setBounds(70, 70, 100, 26);
        pane.add(lblRole);

        txtRole = new JTextField();
        txtRole.setBounds(165, 70, 200, 26);
        pane.add(txtRole);

        lblStatus = new JLabel("Status:");
        lblStatus.setBounds(70, 105, 100, 26);
        pane.add(lblStatus);

        txtStatus= new JTextField();
        txtStatus.setBounds(165, 105, 200, 26);
        pane.add(txtStatus);

        lblSalary = new JLabel("Salary:");
        JLabel note = new JLabel("enter numbers only");
        lblSalary.setBounds(70, 140, 100, 26);
        note.setBounds(70, 155, 100, 26);
        Font noteFont = new Font("Arial", Font.PLAIN, 10);
        note.setFont(noteFont);
        pane.add(lblSalary);
        pane.add(note);

        txtSalary = new JTextField();
        txtSalary.setBounds(165, 140, 200, 26);
        pane.add(txtSalary);

        lblLocation = new JLabel("Location:");
        lblLocation.setBounds(70, 175, 100, 26);
        pane.add(lblLocation);

        txtLocation = new JTextField();
        txtLocation.setBounds(165, 175, 200, 26);
        pane.add(txtLocation);

        btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String company = txtCompany.getText();
                String role = txtRole.getText();
                String salary = txtSalary.getText();
                String status = txtStatus.getText();
                String location = txtLocation.getText();
                Job.setCount(fm.maxID());
                Job j = new Job(company,role,salary,status,location);
                jobTableModel.addJob(j);
                fm.save(j);
                
                dispose();
			}
		});
	    btnSave.setBounds(450, 50, 100, 29);
	    pane.add(btnSave);

        btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                txtCompany.setText("");
                txtRole.setText("");
                txtStatus.setText("");
                txtSalary.setText("");
                txtLocation.setText("");
			}
		});
	    btnReset.setBounds(450, 85, 100, 29);
	    pane.add(btnReset);

        // button to close current frame
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();
			}
		});
		btnCancel.setBounds(450, 120, 100, 29);
		pane.add(btnCancel);
    }
}
