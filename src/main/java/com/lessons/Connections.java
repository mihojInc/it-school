package com.lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Connections {

    private static String name, password;

    static Connection connection;

    public void mysqlConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lesson", name, password);
            createTableIsDontExist();
            System.out.println("MySql change");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Can`t create connection");
            e.printStackTrace();
        }
    }

    public void h2connection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:mem:test");
            createTableIsDontExist();
            System.out.println("H2 change");

            //catch all exception =)
        } catch (Exception e) {
            System.out.println("somthing wrong");
        }
    }

    /**
     * Create 2 user in base if it empty
     */
    public void createTableIsDontExist() {
        String sql = "SELECT * FROM user";
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute(sql);
        } catch (SQLException e) {

            try {
                statement.execute("CREATE TABLE user(id INT PRIMARY KEY auto_increment, name VARCHAR(20));");
                statement.execute("INSERT INTO user(name) VALUES('Mitya'),('Sveta')");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    /**
     * Initialization MySql user for connection
     */
    public void initUser(Scanner scanner) {
        if (name == null) {
            System.out.println("Input database user name:");
            name = scanner.nextLine();
            System.out.println("... & password:");
            password = scanner.nextLine();
        }
    }

    /**
     * Clean MySql user for take new (don't need in this application)
     */
    public void resetUser() {
        name = null;
        password = null;
    }

}
