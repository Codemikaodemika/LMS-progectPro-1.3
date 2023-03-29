package view.course;

import model.Course;
import repository.CourseRepository;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;



public class AddCoursePanel extends JPanel {
    public AddCoursePanel() {
        JTextField title = new JTextField(10);
        JTextField description = new JTextField(10);

        JButton addCourseButton = new JButton("Дабавить");
        addCourseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!title.getText().isEmpty() && !description.getText().isEmpty()){
                    new Course(title.getText(), description.getText());
                    CourseRepository.insert2(title.getText(), description.getText());
                    title.setText("");
                    description.setText("");
                    MainFrame.addCourseFrame.setVisible(false);
                }
            }
        });

        add(title);
        add(description);
        add(addCourseButton);
        setVisible(true);
    }
}
