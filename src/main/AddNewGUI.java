package main;

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
    private JTextField txtCompany;
    private JTextField txtRole;
    private JTextField txtStatus;
    private JTextField txtSalary;
    private JButton btnSave;
    private JButton btnReset;
    private JButton btnCancel;

    public AddNewGUI(JobTableModel jobTableModel) {
		setBounds(100,100,600,400);
		
		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(pane);
		pane.setLayout(null);

        lblCompany = new JLabel("Company:");
        lblCompany.setBounds(70, 35, 100, 26);
        pane.add(lblCompany);

        txtCompany = new JTextField();
        txtCompany.setBounds(150, 35, 200, 26);
        pane.add(txtCompany);

        lblRole = new JLabel("Role:");
        lblRole.setBounds(70, 70, 100, 26);
        pane.add(lblRole);

        txtRole = new JTextField();
        txtRole.setBounds(150, 70, 200, 26);
        pane.add(txtRole);

        lblStatus = new JLabel("Status:");
        lblStatus.setBounds(70, 105, 100, 26);
        pane.add(lblStatus);

        txtStatus= new JTextField();
        txtStatus.setBounds(150, 105, 200, 26);
        pane.add(txtStatus);

        lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(70, 140, 100, 26);
        pane.add(lblSalary);

        txtSalary = new JTextField();
        txtSalary.setBounds(150, 140, 200, 26);
        pane.add(txtSalary);

        btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String company = txtCompany.getText();
                String role = txtRole.getText();
                String salary = txtSalary.getText();
                String status = txtStatus.getText();
                Job j = new Job(company,role,salary,status);
                jobTableModel.addJob(j);
                
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
