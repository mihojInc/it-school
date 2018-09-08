package com.lessons;

import java.sql.*;
import java.util.Properties;

public class App {
    static Connection connection = null;
    private static PreparedStatement preparedStatement = null;

    public static void main(String[] args) {
        makeConnection();
        try {
            createTableStatement(connection);
            insertTableStatement(1, "Tom");
            insertTableStatement(2, "Mark");
            System.out.println("===================state after insert===============");
            printData(selectTableStatement());
            updateTableStatement(1, "Kate");
            System.out.println("===================state after update===============");
            printData(selectTableStatement());
            deleteTableStatement(1);
            System.out.println("===================state after delete===============");
            printData(selectTableStatement());

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void makeConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("There are some problems with driver loading");
        }

        try {
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "root");
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=Europe/Kiev", properties);
        } catch (SQLException e) {
            System.out.println("failed connection");
        }
        System.out.println("successful connection");
    }

    public static void createTableStatement(Connection connection) throws SQLException{
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS persons (ID int, Name varchar(255));");
        }
    }

    public static void insertTableStatement(int id, String name){
        try {
            String insertQueryStatement = "INSERT  INTO  persons  VALUES  (?,?)";
            preparedStatement = connection.prepareStatement(insertQueryStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
            System.out.println("Data was inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet selectTableStatement(){
        ResultSet rs = null;
        try {
            String selectDataStatement = "SELECT * FROM persons";
            preparedStatement = connection.prepareStatement(selectDataStatement);
            rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void printData(ResultSet rs) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println("id - " + id + ", name - " + name + ";");
        }
    }

    public static void updateTableStatement(int id, String name){
        try {
            String updateQueryStatement = "UPDATE persons SET name = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(updateQueryStatement);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();
            System.out.println("Data was updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTableStatement(int id){
        try {
            String deleteQueryStatement = "DELETE FROM persons WHERE id = ?;";
            preparedStatement = connection.prepareStatement(deleteQueryStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Data was deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
