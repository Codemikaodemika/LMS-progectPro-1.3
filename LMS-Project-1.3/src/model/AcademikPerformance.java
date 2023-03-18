package model;

import java.util.ArrayList;

public class AcademikPerformance {
    private int id;
    private int mark;
    private CourseEnrollment courseEnrollment;



    private static ArrayList<AcademikPerformance> list = new ArrayList<>();
    static int lastID = 0;


    AcademikPerformance(CourseEnrollment courseEnrollment, int mark) {
        this.id = ++lastID;
        this.courseEnrollment = courseEnrollment;
        setMark(mark);
        list.add(this);

    }

    AcademikPerformance(Student student, Course course, int mark){
        this(CourseEnrollment.getCourseEnrollment(student,course), mark);

    }

    void setMark(int mark){
        if (mark < 1) mark = 1;
        if (mark > 100) mark = 100;
        this.mark = mark;
    }


    static ArrayList<Integer> getMaksByStudentAndCourse(Student student, Course course){
        ArrayList<Integer> marks = new ArrayList<>();
        CourseEnrollment ce = CourseEnrollment.getCourseEnrollment(student, course);
        for (AcademikPerformance ap : list){
            if (ap.courseEnrollment == ce){
                marks.add(ap.mark);
            }
        }
        return marks;
    }
}
