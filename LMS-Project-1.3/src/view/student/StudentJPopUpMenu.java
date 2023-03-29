package view.student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentJPopUpMenu extends JPopupMenu {
    static MenuItemListener menuItemListener = new MenuItemListener();
    public static JTable table;
    public StudentJPopUpMenu(JTable table){
        this.table = table;
        add(createItem("Сохранить", "save"));
        add(createItem("Зачислить на курс", "enroll"));
        add(createItem("Удалить", "delete"));
    }

    JMenuItem createItem(String title, String command){
        JMenuItem item = new JMenuItem(title);
        item.setActionCommand(command);
        item.addActionListener(menuItemListener);
        return item;
    }
    static  class MenuItemListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = table.getSelectedRow();

        }
    }
}
