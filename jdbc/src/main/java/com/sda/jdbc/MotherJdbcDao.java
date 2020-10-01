package com.sda.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    }
    //read
    public List<Mother> readAll(){
        List<Mother> motherList = new ArrayList<>();
        String sql = "Select * from mother";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rezultat = preparedStatement.executeQuery();

            while (rezultat.next()){
                String name = rezultat.getString("name");
                int age = rezultat.getInt("age");
                String address = rezultat.getString("address");
                Mother mother = new Mother(name,age,address);
                motherList.add(mother);
            }
            System.out.println("Success read");

        } catch (SQLException e) {
            System.out.println("Inseration error");
            e.printStackTrace();
        }

        return motherList;
    }
    //update
    public void update(int id,Mother mother){
        String sql = "UPDATE mother SET name = ?,age = ?,address = ? " +
                "WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, mother.getName());
            preparedStatement.setInt(2, mother.getAge());
            preparedStatement.setString(3, mother.getAddress());
            preparedStatement.setInt(4, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1){
                System.out.println("mother updated");
            }

        } catch (SQLException e) {
            System.out.println("Inseration error");
            e.printStackTrace();
        }
    }
    //delete
    public void delete(int id){
        String sql = "DELETE FROM mother WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1){
                System.out.println("mother deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    }
