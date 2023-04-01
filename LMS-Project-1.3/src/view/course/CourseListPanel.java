package view.course;

import model.Course;
import model.Student;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CourseListPanel extends JPanel {
    JTable table;
    public CourseListPanel(){
        table = new JTable();
        table.setModel(Course.model);

        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

        CourseJPopUpMenu courseJPopUpMenu = new CourseJPopUpMenu(table);

        table.setComponentPopupMenu(courseJPopUpMenu);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int currentRow = table.rowAtPoint(e.getPoint());
                table.setRowSelectionInterval(currentRow, currentRow);
            }
        });
    }
}