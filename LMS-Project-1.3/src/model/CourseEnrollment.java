package model;

import repository.EnrollmentRepository;

import java.util.ArrayList;

public class CourseEnrollment {
    private int id;
    private Student student;
    private Course course;

    static ArrayList<CourseEnrollment> list = new ArrayList<>();
    private static int lastID;

    public CourseEnrollment(Student student, Course course) {
        this.id = ++lastID;
        this.setPropeties(student, course);
        EnrollmentRepository.insertEnrollmet(student.getId(), course.getId());
    }

    public CourseEnrollment(int id, Student student, Course course){
        this.id = id;
        this.setPropeties(student, course);
    }
    public void setPropeties(Student student, Course course){
        this.student = student;
        this.course = course;
        list.add(this);
    }

    static ArrayList<Course> getCoursesByStudent(Student student){
        ArrayList<Course> courses = new ArrayList<>();
        for (CourseEnrollment courseEnrollment : list) {
            if (student.getId() == courseEnrollment.student.getId()){
                courses.add(courseEnrollment.course);
            }
        }
        return courses;
    }


    static ArrayList<Student> getStudentsByCourse(Course course){
        ArrayList<Student> students = new ArrayList<>();
        for (CourseEnrollment courseEnrollment : list) {
            if (course.getId() == courseEnrollment.course.getId()){
                students.add(courseEnrollment.student);
            }
        }
        return students;
    }


    static  CourseEnrollment getCourseEnrollment(Student student, Course course){
        for (CourseEnrollment ce : list) {
            if (ce.student == student && ce.course == course){
                return ce;
            }
        }
        return new CourseEnrollment(student, course);
    }

}
