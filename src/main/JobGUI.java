package main;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JobGUI extends JFrame {
    JPanel pane;
    Job job;
    JLabel lblCompany;
    JLabel lblRole;
    JLabel lblLocation;
    JLabel lblStatus;
    JLabel lblSalary;

    public JobGUI(Job job) {
		setBounds(100,100,600,400);

        pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(pane);
		pane.setLayout(null);

        //width for each label: 400
        //30 spaces between each label
        lblCompany = new JLabel("Company: " + job.getCompany());
        lblCompany.setBounds(70, 30, 400, 50);
        Font companyFont = new Font("Arial", Font.PLAIN, 20);
        lblCompany.setFont(companyFont);
        pane.add(lblCompany);

        lblRole = new JLabel("Role: " + job.getRole());
        lblRole.setBounds(70, 60, 400, 50);
        Font roleFont = new Font("Arial", Font.PLAIN, 20);
        lblRole.setFont(roleFont);
        pane.add(lblRole);

        lblLocation = new JLabel("Location: " + job.getLocation());
        lblLocation.setBounds(70, 90, 400, 50);
        Font locationFont = new Font("Arial", Font.PLAIN, 20);
        lblLocation.setFont(locationFont);
        pane.add(lblLocation);
        
        lblStatus = new JLabel("Status: " + job.getStatus());
        lblStatus.setBounds(70, 120, 400, 50);
        Font statusFont = new Font("Arial", Font.PLAIN, 20);
        lblStatus.setFont(statusFont);
        pane.add(lblStatus);

        lblSalary = new JLabel("Salary: " + job.getSalary());
        lblSalary.setBounds(70, 150, 400, 50);
        Font salaryFont = new Font("Arial", Font.PLAIN, 20);
        lblSalary.setFont(salaryFont);
        pane.add(lblSalary);



    }
}
