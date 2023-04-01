package repository;

import model.Course;
import model.CourseEnrollment;
import model.Student;

import java.sql.*;

public class EnrollmentRepository {
    public static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String login = "postgres";
    private static String password = "Codemika13";
    public static void getAll(){
        String query = "Select * from enrollmets";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String id = resultSet.getString("id");
                int studentid = resultSet.getInt("studentid");
                int courseid = resultSet.getInt("courseid");
                if (Student.getStudentById(studentid) != null && Course.getCourseById(courseid) != null) {
                    new CourseEnrollment(Integer.parseInt(id), Student.getStudentById(studentid), Course.getCourseById(courseid));
                }
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }
    public static void insertEnrollmet(int studentid, int courseid){
        String query = "insert into enrollmets(studentid, courseid) values(?, ?)";

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, studentid);
            statement.setInt(2, courseid);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e){
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }
}
