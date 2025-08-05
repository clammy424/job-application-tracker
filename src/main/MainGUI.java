package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainGUI extends JFrame {
	JPanel pane;
	JButton btnAddNew;
	JButton btnDelete;
	JTextField txtSearch;
	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,600,400);
		
		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(pane);
		pane.setLayout(null);
		
//		TODO: Implement btnAdd
		btnAddNew = new JButton("Add Job");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNew AddGUI = new AddNew();
				AddGUI.show();
			}
		});
	    btnAddNew.setBounds(450, 50, 100, 29);
	    pane.add(btnAddNew);
		
//		TODO: Implement btnDelete
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			// implement
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(450, 100, 100, 29);
		pane.add(btnDelete);

		// TODO: view JList

		// TODO: Implement view one job feature
	}
}
