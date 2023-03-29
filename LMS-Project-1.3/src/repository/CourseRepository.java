package repository;

import model.Course;
import model.Student;

import java.sql.*;

public class CourseRepository {
    public static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String login1 = "postgres";
    private static String password2 = "Codemika13";
    public static void getAll2(){
        String query = "Select * from courses";
        try {
            Connection connection = DriverManager.getConnection(url, login1, password2);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String id = resultSet.getString("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                new Course(title, description);
            }
            connection.close();
        }
        catch (Exception e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }
    public static void insert2(String title, String description){
        String query = "insert into courses(title, description) values(?, ?)";

        try {
            Connection connection = DriverManager.getConnection(url, login1, password2);
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, title);
            statement.setString(2, description);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e){
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }

}
