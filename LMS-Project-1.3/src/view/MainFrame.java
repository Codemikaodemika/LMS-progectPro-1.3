package view;

import view.course.AddCourseFrame;
import view.course.AddCoursePanel;
import view.course.CourseListPanel;
import view.student.AddStudentFrame;
import view.student.AddStudentPanel;
import view.student.StudentListPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static AddStudentFrame addStudentFrame = new AddStudentFrame();

    public static AddCourseFrame addCourseFrame = new AddCourseFrame();

    public static StudentListPanel studentListPanel = new StudentListPanel();

    public static CourseListPanel courseListPanel = new CourseListPanel();

    public MainFrame(){
        setTitle("LMS");

        setSize(500, 600);
        setLocation(500, 100);
        setLayout(new FlowLayout());
        setJMenuBar(new MainMenuBar());
        add(studentListPanel);

        setVisible(true);
    }
}
