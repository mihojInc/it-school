package com.lessons;

import java.sql.*;

public class AppMySql {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static int idVal = 0;

    public static void main(String[] argv) {

        try {
            log("-------- Simple Tutorial on how to make JDBC connection to MySQL DB locally ------------");
            makeJDBCConnection();
//
//            log("\n---------- Adding companies  to DB ----------");
//            addDataToDB("Alex, LLC.", "NYC, US", 5, "https://alex.com");
//            addDataToDB("Google Inc.", "Mountain View, CA, US", 50000, "https://google.com");
//            addDataToDB("Apple Inc.", "Cupertino, CA, US", 30000, "http://apple.com");

            log("\n---------- Get Data from DB ----------");
            getDataFromDB();

            preparedStatement.close();
            connection.close(); // connection close

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    private static void makeJDBCConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            log("Congrats - Seems your MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return;
        }

        try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?serverTimezone=Europe/Kiev", "root", "rootroot");
            if (connection != null) {
                log("Connection Successful! Enjoy. Now it's time to push data");
            } else {
                log("Failed to make connection!");
            }
        } catch (SQLException e) {
            log("MySQL Connection Failed!");
            e.printStackTrace();
        }

    }

    private static void addDataToDB(String companyName, String address, int totalEmployee, String webSite) {

        try {
            String insertQueryStatement = "INSERT  INTO  employee  VALUES  (?,?,?,?,?)";
            idVal = idVal + 1;
            preparedStatement = connection.prepareStatement(insertQueryStatement);
            preparedStatement.setInt(1, idVal);
            preparedStatement.setString(2, companyName);
            preparedStatement.setString(3, address);
            preparedStatement.setInt(4, totalEmployee);
            preparedStatement.setString(5, webSite);

            // execute insert SQL statement
            preparedStatement.executeUpdate();
            log(companyName + " added successfully");
        } catch (

                SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getDataFromDB() {

        try {
            // MySQL Select Query Tutorial
            String getQueryStatement = "SELECT * FROM employee";

            preparedStatement = connection.prepareStatement(getQueryStatement);

            // Execute the Query, and get a java ResultSet
            ResultSet rs = preparedStatement.executeQuery();

            // Let's iterate through the java ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                int employeeCount = rs.getInt("employee_count");
                String website = rs.getString("website");

                // Simply Print the results
                System.out.format("%s, %s, %s, %s, %s\n", id, name, address, employeeCount, website);
            }

        } catch (

                SQLException e) {
            e.printStackTrace();
        }

    }

    // Simple log utility
    private static void log(String string) {
        System.out.println(string);

    }
}