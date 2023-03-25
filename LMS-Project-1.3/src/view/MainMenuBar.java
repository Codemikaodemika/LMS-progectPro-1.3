package view;


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
        JMenuItem settings = new JMenuItem("Настройки");
        JMenuItem exit = new JMenuItem("Выйти");



        file.add(newItem);
        newItem.add(newStudent);
        newItem.add(newCourse);
        file.add(settings);
        file.add(exit);


        newStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addStudentFrame.setVisible(true);
            }
        });

        newCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addCourseFrame.setVisible(true);
            }
        });
        return  file;
    }
}
