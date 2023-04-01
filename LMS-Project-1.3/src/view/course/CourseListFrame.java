package view.course;

import model.Course;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class CourseListFrame extends JFrame {
    public CourseListFrame(Student student){
        setTitle("Курсы студента");
        setLocation(500,350);
        setSize(500,500);
        setLayout(new FlowLayout());

        JTable table = new JTable();
        table.setModel(Course.getModelCourses(student));

        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

        setVisible(true);
        pack();
    }
}
