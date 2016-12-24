package view;

import controller.Manager;
import controller.StudentManager;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.TableModel.ColumnName.NAME;

/**
 * Created by dexter on 18.12.16.
 */
class MainFrame extends JFrame{

    private Manager<Student> manager = StudentManager.getInstance();

    private JButton saveButton = new JButton("SAVE");
    private JButton editButton =  new JButton("EDIT");
    private JButton removeButton = new JButton("REMOVE");
    private JButton searchButton = new JButton("SEARCH");

    private JTable table = new JTable(new TableModel());

    private JPanel mainPanel = new JPanel();
    private JPanel northPanel = new JPanel();

    MainFrame(){
        setSize(400, 400);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Manager");
        setActionListener();
        init();
        setVisible(true);
    }

    private void init(){
        JScrollPane scroll = new JScrollPane(table);

        mainPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new GridLayout(1, 4));

        northPanel.add(saveButton);
        northPanel.add(editButton);
        northPanel.add(removeButton);
        northPanel.add(searchButton);

        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void setActionListener(){
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SaveFrame(table);
            }
        });
        removeButton.addActionListener(e -> removeStudent());
        searchButton.addActionListener(e -> new SearchFrame(table));
        editButton.addActionListener(e -> editStudent());
    }

    private void editStudent() {
        int i = table.getSelectedRow();
        new EditFrame(table, i);
    }

    private void removeStudent() {
        int i = table.getSelectedRow();
        manager.remove(i);
        table.updateUI();
    }

}
