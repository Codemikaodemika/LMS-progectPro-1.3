package view.course;

import model.Course;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceCourse extends JFrame {
    CourseListPanel panel;
    public ChoiceCourse(Student student){
        setTitle("Выбор курса");
        setLocation(500,300);
        setSize(500,500);
        setLayout(new FlowLayout());
        panel = new CourseListPanel();
        add(panel);


        JButton button = new JButton("Зачислить");
        add(button);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = panel.table.getSelectedRow();
                int courseID = Integer.parseInt(panel.table.getValueAt(index,0).toString());
                student.addCourse(Course.getCourseById(courseID));
            }
        });

    }
}
