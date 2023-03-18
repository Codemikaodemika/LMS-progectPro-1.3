package model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Course {
    private int id;
    private String title;
    private String description;


    static ArrayList<Course> list = new ArrayList<>();

    private static int lastID = 0;

    public Course(String title, String description) {
        this.id = ++lastID;
        this.title = title;
        this.description = description;
        list.add(this);
        addRow(this);
    }
    static String[] headers = {"Id", "Title", "Description"};
    public static DefaultTableModel model = new DefaultTableModel(headers, 0);
    public static void addRow(Course course){
        model.addRow(
                new Object[] {
                        course.id,
                        course.title,
                        course.description
                });


    }

    public String toString() {
        return this.id + " " + this.title + " " + this.description;

    }
    ArrayList<Student> getStudents(){
        return CourseEnrollment.getStudentsByCourse(this);
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Course> getList() {
        return list;
    }

    public static void setList(ArrayList<Course> list) {
        Course.list = list;
    }
}
