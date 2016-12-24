package view;

import controller.manager.Manager;
import controller.manager.StudentManager;
import model.Degree;
import model.Student;
import model.Student.StudentBuilder;
import model.Teacher;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dexter on 20.12.16.
 */
class SaveFrame extends JFrame {

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

    SaveFrame(JTable table){
        this.table = table;
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
        saveButton.addActionListener(e -> initStudent());
    }

    private void initStudent() {
        try{
            manager.save(getStudent());
        } catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Wrong input data", "Incorrect", JOptionPane.ERROR_MESSAGE);
            return;
        }
        table.updateUI();
        dispose();
    }

    private Student getStudent() {
        StudentBuilder student = new StudentBuilder();
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
