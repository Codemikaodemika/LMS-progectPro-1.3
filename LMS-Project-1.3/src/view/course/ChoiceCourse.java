package view.course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceCourse extends JFrame {
    CourseListPanel panel;
    public ChoiceCourse(){
        setTitle("Выбор курса");
        setLocation(300,300);
        setSize(500,500);
        setLayout(new FlowLayout());
        panel = new CourseListPanel();


        JButton button = new JButton("Зачислить");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
