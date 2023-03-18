package view.course;

import model.Course;
import model.Student;

import javax.swing.*;

public class CourseListPanel extends JPanel {
    public CourseListPanel(){
        JTable table = new JTable();
        table.setModel(Course.model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

    }
}