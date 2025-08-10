package main;

import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

public class JobGUI extends JFrame {
    private JPanel pane;
    private JTextField txtCompany, txtRole, txtStatus, txtSalary, txtLocation;
    private JTextField txtTodoList;  
    private JLabel lblCompany, lblRole, lblStatus, lblSalary, lblLocation;
    private TodoList todoList = new TodoList();
    private JButton btnCancel, btnEdit, btnReset, btnClose, btnDeleteTask;
    private DefaultListModel<String> todoListModel = new DefaultListModel<>();
    private JList<String> todoJList;

    private Job job;
    private JobTableModel jobTableModel;
    private FileManager fm;
    private boolean isEditMode = false;

    private int rowIndex = -1;

    public JobGUI(Job job, int rowIndex, JobTableModel model, FileManager fm) {
        this.job = job;
        this.rowIndex = rowIndex;
        this.jobTableModel = model;
        this.fm = fm;

        initComponents();
        populateFieldsFromJob(job);
    }

    public JobGUI(Job job, JobTableModel jobTableModel, FileManager fm) {
        this.job = job;
        this.jobTableModel = jobTableModel;
        this.fm = fm;

        initComponents();
        populateFieldsFromJob(job);
    }

    private int findJobRow(int jobId) {
        for (int i = 0; i < jobTableModel.getRowCount(); i++) {
            if ((int) jobTableModel.getValueAt(i, 0) == jobId) {
                return i;
            }
        }
        return -1; 
    }

    private void initComponents() {
        setBounds(100, 100, 620, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = new JPanel();
        pane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(pane);
        pane.setLayout(null);

        // Labels and Text Fields
        lblCompany = new JLabel("Company:");
        lblCompany.setBounds(70, 35, 100, 26);
        pane.add(lblCompany);

        txtCompany = new JTextField();
        txtCompany.setBounds(165, 35, 200, 26);
        txtCompany.setEditable(false);
        pane.add(txtCompany);

        lblRole = new JLabel("Role:");
        lblRole.setBounds(70, 70, 100, 26);
        pane.add(lblRole);

        txtRole = new JTextField();
        txtRole.setBounds(165, 70, 200, 26);
        txtRole.setEditable(false);
        pane.add(txtRole);

        lblStatus = new JLabel("Status:");
        lblStatus.setBounds(70, 105, 100, 26);
        pane.add(lblStatus);

        txtStatus = new JTextField();
        txtStatus.setBounds(165, 105, 200, 26);
        txtStatus.setEditable(false);
        pane.add(txtStatus);

        lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(70, 140, 100, 26);
        pane.add(lblSalary);

        txtSalary = new JTextField();
        txtSalary.setBounds(165, 140, 200, 26);
        txtSalary.setEditable(false);
        pane.add(txtSalary);

        lblLocation = new JLabel("Location:");
        lblLocation.setBounds(70, 175, 100, 26);
        pane.add(lblLocation);

        txtLocation = new JTextField();
        txtLocation.setBounds(165, 175, 200, 26);
        txtLocation.setEditable(false);
        pane.add(txtLocation);

        //Todo List area - using JList inside JScrollPane
        todoJList = new JList<>(todoListModel);
        JScrollPane scrollPane = new JScrollPane(todoJList);
        scrollPane.setBounds(70, 240, 400, 140);
        pane.add(scrollPane);

        txtTodoList = new JTextField();
        txtTodoList.setBounds(70, 210, 400, 30);
        pane.add(txtTodoList);
        txtTodoList.setEditable(false); // Initially not editable
        

        txtTodoList.addActionListener(e -> {
            String taskText = txtTodoList.getText().trim();
            if (!taskText.isEmpty()) {
                todoList.addTask(taskText);
                todoListModel.addElement(taskText);
                txtTodoList.setText("");
            }
        });

        //Delete Task button
        btnDeleteTask = new JButton("Delete Task");
        btnDeleteTask.setBounds(480, 220, 120, 29);
        btnDeleteTask.setEnabled(false); // Disabled initially
        btnDeleteTask.addActionListener(e -> {
            int selectedIndex = todoJList.getSelectedIndex();
            if (selectedIndex != -1) {
                todoListModel.remove(selectedIndex);
                job.getTodoList().removeTaskAt(selectedIndex);
            }
        });
        pane.add(btnDeleteTask);

        //Enable Delete button only when a task is selected
        todoJList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                btnDeleteTask.setEnabled(todoJList.getSelectedIndex() != -1);
            }
        });

        //Cancel button
        btnCancel = new JButton("Close");
        btnCancel.setBounds(480, 35, 120, 29);
        btnCancel.addActionListener(e -> dispose());
        pane.add(btnCancel);

        //Edit button
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(480, 75, 120, 29);
        btnEdit.addActionListener(e -> {
            if (!isEditMode) {
                enterEditMode();
            } else {
                saveChanges();
            }
        });
        pane.add(btnEdit);


        btnReset = new JButton("Reset");
        btnReset.setBounds(480, 115, 120, 29);
        btnReset.addActionListener(e -> populateFieldsFromJob(job));

        btnClose = new JButton("Cancel");
        btnClose.setBounds(480, 155, 120, 29);
        btnClose.addActionListener(e -> exitEditMode());
    }

    private void populateFieldsFromJob(Job job) {
        txtCompany.setText(job.getCompany());
        txtRole.setText(job.getRole());
        txtStatus.setText(job.getStatus());
        txtSalary.setText(job.getSalary());
        txtLocation.setText(job.getLocation());

        //todoListModel.clear();
        for (Task task : job.getTodoList().getAllTasks()) {
            todoListModel.addElement(task.toString());
        }
    }

    private void enterEditMode() {
        isEditMode = true;
        txtCompany.setEditable(true);
        txtRole.setEditable(true);
        txtStatus.setEditable(true);
        txtSalary.setEditable(true);
        txtLocation.setEditable(true);
        txtTodoList.setEditable(true); // Allow editing of todo list input

        // JList is read-only; for tasks, user deletes tasks by Delete button

        btnEdit.setText("Save");
        pane.add(btnReset);
        pane.add(btnClose);
        pane.revalidate();
        pane.repaint();
    }

    private void exitEditMode() {
        isEditMode = false;
        txtCompany.setEditable(false);
        txtRole.setEditable(false);
        txtStatus.setEditable(false);
        txtSalary.setEditable(false);
        txtLocation.setEditable(false);

        btnEdit.setText("Edit");

        //pane.remove(btnSave);
        pane.remove(btnReset);
        pane.remove(btnClose);
        pane.revalidate();
        pane.repaint();
    }

    private void saveChanges() {
     
        ArrayList<Job> jobs = fm.loadJobs();

        
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getID() == job.getID()) {
                // Replace job with updated data
                TodoList updatedTodoList = new TodoList();
                for (int j = 0; j < todoListModel.size(); j++) {
                    updatedTodoList.addTask(todoListModel.get(j));
                }
                jobs.set(i, new Job(
                    job.getID(),
                    txtCompany.getText(),
                    txtRole.getText(),
                    txtSalary.getText(),
                    txtStatus.getText(),
                    txtLocation.getText(),
                    updatedTodoList
                ));
                break;
            }
        }

       
        fm.rewrite(jobs);
        job.setTodoList(todoList);

        
        int rowIndex = findJobRow(job.getID());
        if (rowIndex != -1) {
            jobTableModel.setValueAt(txtCompany.getText(), rowIndex, 1);
            jobTableModel.setValueAt(txtRole.getText(), rowIndex, 2);
            jobTableModel.setValueAt(txtSalary.getText(), rowIndex, 3);
            jobTableModel.setValueAt(txtStatus.getText(), rowIndex, 4);
            jobTableModel.setValueAt(txtLocation.getText(), rowIndex, 5);
        }

        exitEditMode();
    }
}



