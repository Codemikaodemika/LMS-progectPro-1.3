package model;

import repository.CourseRepository;
import repository.StudentRepository;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Course {
    private int id;
    private String title;
    private String description;


    static ArrayList<Course> list = new ArrayList<>();

    private static int lastID = 0;
    static String[] headers = {"Id", "Title", "Description"};
    public static DefaultTableModel model = new DefaultTableModel(headers, 0);

    public static void delete(int id, int index){
        list.remove(index);
        model.removeRow(index);
        CourseRepository.deleteCourse(id);
    }

    public Course(String title, String description) {
        this.id = ++lastID;
        this.setPropeties(title, description);
    }
    public Course(int id, String title, String description) {
        this.id = id;
        this.setPropeties(title, description);
    }

    public static DefaultTableModel getModelCourses(Student student) {
        DefaultTableModel model1 = new DefaultTableModel(headers, 0);
        for (Course course: student.getCourses()) {
            model1.addRow(
                    new Object[]{
                            course.getId(),
                            course.getTitle(),
                            course.getDescription()
                    }
            );
        }
        return model1;
    }
    public void setPropeties(String title, String description){
        this.title = title;
        this.description = description;
        list.add(this);
        addRow(this);
    }
    public static void addRow(Course course){
        model.addRow(
                new Object[] {
                        course.id,
                        course.title,
                        course.description
                });


    }

    public static Course getCourseById(int courseID) {
        for (Course course: list) {
            if (course.id == courseID)
                return course;
        }
        return null;
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
