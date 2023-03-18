package view.student;

import model.Student;

import javax.swing.*;

public class StudentListPanel extends JPanel {



    public StudentListPanel() {
        JTable table = new JTable();
        table.setModel(Student.model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

    }

}
