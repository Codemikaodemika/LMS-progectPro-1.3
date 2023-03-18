package model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private String surname;
    static ArrayList<Student> list = new ArrayList<>();
    static String[] headers = {"Id", "Name", "Surname"};
    public static DefaultTableModel model = new DefaultTableModel(headers, 0);

    private static int lastID = 0;

    public Student(String name, String surname) {
        this.id = ++lastID;
        this.name = name;
        this.surname = surname;
        list.add(this);
        addRow(this);
    }

    public static void addRow(Student student){
        model.addRow(
                new Object[] {
                        student.id,
                        student.name,
                        student.surname
                });


    }

    public String toString() {
        return this.id + " " + this.name + " " + this.surname;

    }
    ArrayList<Course> getCourses(){
        return CourseEnrollment.getCoursesByStudent(this);
    }


    ArrayList<Integer> getMarks(Course course){
        return AcademikPerformance.getMaksByStudentAndCourse(this, course);
    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static ArrayList<Student> getList() {
        return list;
    }

    public static void setList(ArrayList<Student> list) {
        Student.list = list;
    }
}
