package view;

import view.course.AddCourseFrame;
import view.student.AddStudentFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar(){
        add(fileMenu());
        add(helpMenu());
    }
    private JMenu helpMenu(){
        JMenu help = new JMenu("Помощь");
        JMenu aboutProgramme = new JMenu("О программе");
        JMenu reference = new JMenu("Справка");

        help.add(aboutProgramme);
        help.add(reference);

        return help;
    }
    private JMenu fileMenu(){
        JMenu file = new JMenu("Файл");
        JMenu newItem = new JMenu("Новый");
        JMenuItem newStudent = new JMenuItem("Студент");
        JMenuItem newCourse = new JMenuItem("Курс");
        JMenu Settings = new JMenu("Настройки");
        JMenu exit = new JMenu("Выйти");



        file.add(newItem);
        newItem.add(newStudent);
        newItem.add(newCourse);
        file.add(Settings);
        file.add(exit);


        newStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentFrame();
            }
        });

        newCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCourseFrame();
            }
        });
        return  file;
    }
}
