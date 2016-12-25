package com.dex.desktopstudent.view;

import com.dex.desktopstudent.controller.manager.Manager;
import com.dex.desktopstudent.controller.manager.StudentManager;
import com.dex.desktopstudent.model.Degree;
import com.dex.desktopstudent.model.Student;
import com.dex.desktopstudent.model.Teacher;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dexter on 24.12.16.
 */
class EditFrame extends JFrame{

    private Manager<Student> manager = StudentManager.getInstance();

    private JLabel nameLabel = new JLabel("Enter name");
    private JLabel ageLabel = new JLabel("Enter age");
    private JLabel averageLabel = new JLabel("Enter averageGrade");
    private JLabel teacherLabel = new JLabel("Enter teacher name");
    private JLabel teacherAgeLabel = new JLabel("Enter teacher age");
    private JLabel teacherDegreeLabel = new JLabel("Enter teacher degree");
    private JLabel teacherSalaryLabel = new JLabel("Enter teacher salary");

    private JTextArea nameTextArea = new JTextArea();
    private JTextArea ageTextArea = new JTextArea();
    private JTextArea averageTextArea = new JTextArea();
    private JTextArea teacherTextArea = new JTextArea();
    private JTextArea teacherAgeTextArea = new JTextArea();
    private JTextArea teacherDegreeTextArea = new JTextArea();
    private JTextArea teacherSalaryTextArea = new JTextArea();

    private JButton saveButton = new JButton("save");
    private JButton cancelButton = new JButton("cancel");

    private JPanel mainPanel = new JPanel();
    private JPanel southPanel = new JPanel();

    private JTable table;
    private int index;


    EditFrame(JTable table, int index) {
        this.table = table;
        this.index = index;
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Save Student");
        init();
        setResizable(false);
        setActionListeners();
        setVisible(true);
    }

    private void setActionListeners() {
        cancelButton.addActionListener(e -> dispose());
        saveButton.addActionListener(e -> editStudent());
    }

    private void editStudent() {
        try{
            manager.edit(index, getStudent());
        } catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Wrong input data", "Incorrect", JOptionPane.ERROR_MESSAGE);
            return;
        }
        table.updateUI();
        dispose();
    }

    private Student getStudent() {
        Student.StudentBuilder student = new Student.StudentBuilder();
        student.setAge(Integer.parseInt(ageTextArea.getText()));
        student.setAverageGrade(Double.parseDouble(averageTextArea.getText()));
        student.setName(nameTextArea.getText());
        student.setTeacher(new Teacher(teacherTextArea.getText(), Integer.parseInt(teacherAgeTextArea.getText()), Degree.getDegree(teacherDegreeTextArea.getText()), Integer.parseInt(teacherSalaryTextArea.getText())));
        return student.build();
    }

    private void init(){
        nameTextArea.setColumns(30);
        ageTextArea.setColumns(30);
        averageTextArea.setColumns(30);
        teacherTextArea.setColumns(30);
        teacherAgeTextArea.setColumns(30);
        teacherDegreeTextArea.setColumns(30);
        teacherSalaryTextArea.setColumns(30);

        southPanel.setLayout(new GridLayout(1, 2));
        southPanel.add(saveButton);
        southPanel.add(cancelButton);

        getContentPane().add(southPanel, BorderLayout.SOUTH);


        mainPanel.add(nameLabel);
        mainPanel.add(nameTextArea);
        mainPanel.add(ageLabel);
        mainPanel.add(ageTextArea);
        mainPanel.add(averageLabel);
        mainPanel.add(averageTextArea);
        mainPanel.add(teacherLabel);
        mainPanel.add(teacherTextArea);
        mainPanel.add(teacherAgeLabel);
        mainPanel.add(teacherAgeTextArea);
        mainPanel.add(teacherDegreeLabel);
        mainPanel.add(teacherDegreeTextArea);
        mainPanel.add(teacherSalaryLabel);
        mainPanel.add(teacherSalaryTextArea);

        add(mainPanel);
    }

}
