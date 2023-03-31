package view.course;


import model.Course;
import model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseJPopUpMenu extends JPopupMenu {
    static MenuItemListener menuItemListener = new MenuItemListener();
    public static JTable table;
    public CourseJPopUpMenu(JTable table){
        this.table = table;
        add(createItem("Редактировать", "edit"));
        add(createItem("Копировать", "copy"));
        add(createItem("Добавить студента", "addStudent"));
        add(createItem("Удалить", "delete"));
    }
    JMenuItem createItem(String title, String command){
        JMenuItem item = new JMenuItem(title);
        item.setActionCommand(command);
        item.addActionListener(menuItemListener);
        return item;
    }
    public static class MenuItemListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = table.getSelectedRow();
            int id = Integer.parseInt(table.getValueAt(index, 0).toString());
            String title = table.getValueAt(index, 1).toString();
            String description = table.getValueAt(index, 2).toString();

            switch (e.getActionCommand()) {
                case "delete":
                    Course.delete(id, index);
                    break;
            }
        }
    }


}
