package com.company.model;

import view.MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static MainFrame mainFrame = new MainFrame();
    public static void main(String[] args) {
        String url = "jbdc:postgreql://localhost:5432/postgres";
        String query = "Select * from students";
        try {
            Connection connection = DriverManager.getConnection(url, "postgres", "Codemika13");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
            }
            connection.close();
        }
        catch (Exception e){
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }





    }
}