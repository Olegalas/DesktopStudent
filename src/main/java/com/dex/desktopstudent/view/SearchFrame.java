package com.dex.desktopstudent.view;

import com.dex.desktopstudent.controller.manager.Manager;
import com.dex.desktopstudent.controller.manager.StudentManager;
import com.dex.desktopstudent.model.Student;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dexter on 24.12.16.
 */
class SearchFrame extends JFrame {

    private Manager<Student> manager = StudentManager.getInstance();

    private JLabel label = new JLabel("Enter name");
    private JTextArea textArea = new JTextArea();

    private JPanel mainPanel = new JPanel();
    private JPanel southPanel = new JPanel();

    private JButton cancelButton = new JButton("cancel");
    private JButton searchButton = new JButton("search");

    private JTable table;

    SearchFrame(JTable table) {
        this.table = table;
        setSize(320, 100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Student");
        init();
        setResizable(false);
        setActionListeners();
        setVisible(true);
    }

    private void setActionListeners() {
        cancelButton.addActionListener(e -> dispose());
        searchButton.addActionListener(e -> selectRow());
    }

    private void selectRow() {
        table.clearSelection();

        String name = textArea.getText();
        int row = manager.getRows().get(name);

        table.setRowSelectionInterval(row, row);
    }

    private void init(){
        textArea.setColumns(20);

        southPanel.setLayout(new GridLayout(1, 2));
        southPanel.add(searchButton);
        southPanel.add(cancelButton);

        getContentPane().add(southPanel, BorderLayout.SOUTH);

        mainPanel.add(label);
        mainPanel.add(textArea);

        add(mainPanel);
    }


}
