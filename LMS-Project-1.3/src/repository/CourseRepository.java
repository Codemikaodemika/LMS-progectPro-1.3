package repository;

import model.Course;
import model.Student;

import java.sql.*;

public class CourseRepository {
    public static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String login = "postgres";
    private static String password = "Codemika13";
    public static void getAll(){
        String query = "Select * from courses";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
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
    public static void insert(String title, String description){
        String query = "insert into courses(title, description) values(?, ?)";

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
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
    public static void deleteCourse(int id){
        String query = "delete from courses where id=?";

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e){
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }

    }

}
