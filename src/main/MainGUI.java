package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainGUI extends JFrame {
	private JPanel pane;
	private JButton btnAddNew;
	private JButton btnDelete;
	private JButton btnEdit;
	private JTextField txtSearch;
	private FileManager fm;
	private JobTableModel jobTableModel;
	private JTable jobTable;
	private JScrollPane scrollPane;
	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,600,400);

		fm = new FileManager();
		
		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(pane);
		pane.setLayout(null);

		JLabel title = new JLabel("Job Application Tracker");
		Font titleFont = new Font("Arial",Font.PLAIN,24);
		title.setBounds(50,10,350,40);
		title.setFont(titleFont);
		pane.add(title);

//		TODO: Implement search feature
		JLabel search = new JLabel("Search: ");
		search.setBounds(50,50,100,20);
		JTextField searchBar = new JTextField();
		searchBar.setBounds(100,50,353,26);
		pane.add(search);
		pane.add(searchBar);

		// TODO: view list of jobs
		ArrayList<Job> jobList = fm.loadJobs();
		jobTableModel = new JobTableModel();
		for (Job j : jobList) {
			if (j != null) {
				jobTableModel.addJob(j);
			}
		}
		jobTable = new JTable(jobTableModel);
		scrollPane = new JScrollPane(jobTable);
		jobTable.getColumnModel().getColumn(0).setMinWidth(0);
		jobTable.getColumnModel().getColumn(0).setMaxWidth(0);
		jobTable.getColumnModel().getColumn(0).setWidth(0);
		scrollPane.setBounds(50, 90, 400, 250);
		pane.add(scrollPane);

		
//		TODO: Implement btnAdd
		btnAddNew = new JButton("Add Job");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewGUI AddNewGUI = new AddNewGUI(jobTableModel, fm);
				AddNewGUI.show();
			}
		});
	    btnAddNew.setBounds(475, 50, 100, 29);
	    pane.add(btnAddNew);
		
//		TODO: Implement btnDelete
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			// implement
			public void actionPerformed(ActionEvent e) {

				ArrayList<Job> jobs = fm.loadJobs();
				int index = jobTable.getSelectedRow();
				
				if (index != -1) {
					
					// remove from array list jobs
					for (Job j : jobs) {
						if (j.getID() == (int) jobTableModel.getValueAt(index, 0)) {
							jobs.remove(j);
							break;
						}
					}
					// remove from table model to update JTable visually
					jobTableModel.removeRow(index);
					// write to update data file
					fm.rewrite(jobs);
				}
			}
		});
		btnDelete.setBounds(475, 85, 100, 29);
		pane.add(btnDelete);


		
		// TODO: Implement view one job feature
		jobTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
					jobTable = (JTable) e.getSource();
					int row = jobTable.rowAtPoint(e.getPoint());

					if (row != -1) {
						int id = (int) jobTable.getValueAt(row, 0);
						
						Job j = fm.findByID(id);
						if (j != null) {
							JobGUI jobGUI = new JobGUI(j);
							jobGUI.setVisible(true);  // open only once per double-click
						}

					}
				}
			}
		});
	
	}
}
