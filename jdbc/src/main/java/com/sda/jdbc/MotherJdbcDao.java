package com.sda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MotherJdbcDao {

    public static final String URL = "jdbc:mysql://localhost:3306/motherdatabase?serverTimezone" +
            "=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "12345";


    //create
    public void create(Mother mother) {

        String sql = "INSERT INTO mother(name, age, address) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, mother.getName());
            preparedStatement.setInt(2, mother.getAge());
            preparedStatement.setString(3, mother.getAddress());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1){
                System.out.println("mother saved");
            }

        } catch (SQLException e) {
            System.out.println("Inseration error");
            e.printStackTrace();
        }
        //read
        //update
        //delete
    }

    }
