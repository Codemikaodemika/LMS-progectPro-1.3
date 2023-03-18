
package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrame extends JFrame {
    UserFrame(){
        setSize(500, 500);
        setLocation(500, 250);
        setLayout(new FlowLayout());

        JTextField name = new JTextField(10);
        JTextField phone = new JTextField(10);
        JPasswordField password = new JPasswordField(10);
        JButton create = new JButton("Создать");
        JLabel label = new JLabel("");
        JCheckBox checkBox = new JCheckBox("Преподаватель");

        add(name);
        add(phone);
        add(password);
        add(checkBox);
        add(create);
        add(label);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String createDate = "";
                String type = "";
                if (checkBox.isSelected()){
                    Teacher teacher = new Teacher(phone.getText(), name.getText(), password.getText());
                    type = "teacher";
                    createDate = teacher.getCre ate().toString();
                } else {
                    Student student = new Student(phone.getText(), name.getText(), password.getText());
                    type = "student";
                    createDate = student.getCreate().toString();
                }
                label.setText(createDate + " " + type);
            }
        });

        setVisible(true);
    }
}