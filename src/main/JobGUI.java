
package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class JobGUI extends JFrame {
    private JPanel pane;
    private JTextField txtCompany, txtRole, txtStatus, txtSalary, txtLocation;
    private JTextArea txtTodoList;
    private JLabel lblCompany, lblRole, lblStatus, lblSalary, lblLocation;
    private JButton btnCancel, btnEdit, btnSave, btnReset, btnClose;
    private DefaultListModel<String> todoListModel = new DefaultListModel<>();

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

    private void initComponents() {
        setBounds(100, 100, 600, 400);
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

        // Todo List
        JList<String> todoJList = new JList<>(todoListModel);
        JScrollPane scrollPane = new JScrollPane(todoJList);
        scrollPane.setBounds(70, 250, 400, 100);
        pane.add(scrollPane);

        // Cancel button
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(450, 40, 80, 25);
        btnCancel.addActionListener(e -> dispose());
        pane.add(btnCancel);

        // Edit button
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(450, 160, 100, 29);
        btnEdit.addActionListener(e -> {
            if (!isEditMode) {
                enterEditMode();
            } else {
                saveChanges();
            }
        });
        pane.add(btnEdit);

        // Save, Reset, Close (initialized but not added until edit mode)
        btnSave = new JButton("Save");
        btnSave.setBounds(450, 200, 100, 25);
        btnSave.addActionListener(e -> saveChanges());

        btnReset = new JButton("Reset");
        btnReset.setBounds(450, 240, 100, 25);
        btnReset.addActionListener(e -> populateFieldsFromJob(job));

        btnClose = new JButton("Close");
        btnClose.setBounds(450, 280, 100, 25);
        btnClose.addActionListener(e -> exitEditMode());
    }

    private void populateFieldsFromJob(Job job) {
        txtCompany.setText(job.getCompany());
        txtRole.setText(job.getRole());
        txtStatus.setText(job.getStatus());
        txtSalary.setText(job.getSalary());
        txtLocation.setText(job.getLocation());

        todoListModel.clear();
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
        txtTodoList.setEditable(true);

        btnEdit.setText("Save");

        // Add buttons
        pane.add(btnSave);
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
        txtTodoList.setEditable(false); 

        btnEdit.setText("Edit");

        // Remove buttons
        pane.remove(btnSave);
        pane.remove(btnReset);
        pane.remove(btnClose);
        pane.revalidate();
        pane.repaint();
    }

    private void saveChanges() {
    job.setCompany(txtCompany.getText());
    job.setRole(txtRole.getText());
    job.setStatus(txtStatus.getText());
    job.setSalary(txtSalary.getText());
    job.setLocation(txtLocation.getText());

    fm.save(job);

    if (rowIndex >= 0) {
        jobTableModel.updateJob(rowIndex, job);
    }

    exitEditMode();
    }
}

