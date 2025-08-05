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

        lblCompany = new JLabel(job.getCompany());
        lblCompany.setBounds(70, 35, 100, 50);
        Font companyFont = new Font("Arial", Font.PLAIN, 24);
        lblCompany.setFont(companyFont);
        pane.add(lblCompany);

        lblRole = new JLabel(job.getRole());
        lblRole.setBounds(70, 58, 100, 50);
        Font roleFont = new Font("Arial", Font.PLAIN, 20);
        lblRole.setFont(roleFont);
        pane.add(lblRole);

        // lblLocation = new JLabel(job.getLocation());
        // lblStatus = new JLabel(job.getStatus());
        // lblSalary = new JLabel(job.getSalary());



    }
}
