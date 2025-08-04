package main;

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
	private JTextField txtSearch;
	private FileManager fm;
	private DefaultListModel<Job> jobListModel;
	private JList<Job> jobList;
	private JScrollPane scrollPane;
	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,600,400);

		fm = new FileManager();
		
		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(pane);
		pane.setLayout(null);

		// TODO: view list of jobs
		jobListModel = new DefaultListModel<>();
		jobList = new JList<>(jobListModel);
		scrollPane = new JScrollPane(jobList);
		scrollPane.setBounds(50, 80, 350, 200);
		pane.add(scrollPane);

//		TODO: Implement search feature

		
//		TODO: Implement btnAdd
		btnAddNew = new JButton("Add Job");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewGUI AddNewGUI = new AddNewGUI(jobListModel);
				AddNewGUI.show();
			}
		});
	    btnAddNew.setBounds(450, 50, 100, 29);
	    pane.add(btnAddNew);
		
//		TODO: Implement btnDelete
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			// implement
			public void actionPerformed(ActionEvent e) {

				ArrayList<Job> jobs = fm.loadJobs();
				int index = jobList.getSelectedIndex();
				
				if (index != -1) {
					Job jobToDelete = jobListModel.getElementAt(index);
					jobListModel.remove(index);

					// remove from array list jobs
					// write to update data file
				}
			}
		});
		btnDelete.setBounds(450, 85, 100, 29);
		pane.add(btnDelete);

		

		// TODO: Implement view one job feature
		jobList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
					JList<?> list = (JList<?>) e.getSource();
					int index = list.locationToIndex(e.getPoint());
		
					if (index != -1) {
						Object selectedItem = list.getModel().getElementAt(index);
						
						// Open the new GUI and pass the selected job
						if (selectedItem instanceof Job) {
							Job selectedJob = (Job) selectedItem;
							JobGUI jobGUI = new JobGUI(selectedJob);
							jobGUI.setVisible(true);  // open only once per double-click
						}
					}
				}
			}
		});
	}
}
