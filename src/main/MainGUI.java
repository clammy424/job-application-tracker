package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainGUI extends JFrame {
	JPanel pane;
	JButton btnAddNew;
	JButton btnView;
	JButton btnDelete;
	JTextField txtSearch;
	JList list;
	
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
	    btnAddNew.setBounds(100, 100, 100, 29);
	    pane.add(btnAddNew);
		
//		TODO: Implement btnView
		
		
//		TODO: Implement btnDelete
	}
}
