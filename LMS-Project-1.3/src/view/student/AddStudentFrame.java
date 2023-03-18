package view.student;

import javax.swing.*;
import java.awt.*;

public class AddStudentFrame extends JFrame {
    public AddStudentFrame(){
        setTitle("Создание нового студента");
        setSize(500,300);
        setLocation(700, 350);
        setLayout(new FlowLayout());
        add(new AddStudentPanel());

        setVisible(false);
    }
}
