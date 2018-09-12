package com.lessons;

import java.sql.*;
import java.util.Scanner;

public class App {

    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static final String H2DRIVER = "org.h2.Driver";
    private static final String PATHTOH2DB = "jdbc:h2:mem:test";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        App.choseDB(scanner);
        App.createTable();
        App.exampleInsert(101, "Alina","Albasova", 19);
        App.exampleSelect();
        App.exampleUpdate();
        App.exampleSelect();
        App.exampleDelete();
    }

    private static void choseDB(Scanner scanner) throws ClassNotFoundException, SQLException {
        Integer choice = null;
        System.out.println("If your want to use h2 enter 1 and if you want to use my database enter 2");
        if(scanner.hasNextInt()){
            choice = scanner.nextInt();
            if(choice.equals(1)){
                makeJDBSConnection(H2DRIVER,PATHTOH2DB);
            }else if(choice.equals(2)){
                makeJDBSConnection();
            }
        }
    }

    private static void makeJDBSConnection(String driver, String path){
        try {
            Class.forName(driver);
            System.out.println("Driver is downloaded");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver is not downloaded");
            return;
        }

        try {

            connection = DriverManager.getConnection(path);
            if (connection != null) {
                System.out.println("Connection Successful!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("not connected");
            e.printStackTrace();
        }
    }
    private static void makeJDBSConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is downloaded");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver is not downloaded");
            return;
        }

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?serverTimezone=Europe/Kiev", "root", "0308");
            if (connection != null) {
                System.out.println("Connection Successful!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("not connected");
            e.printStackTrace();
        }
    }

    private static void createTable(){

        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            statement.executeUpdate(sql);
            System.out.println("Table is successfully created");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Table is not successfully created");
        }
    }

    private static void exampleInsert(int id, String firstname, String lastname, int age){
        try {
            String insertStatement = "INSERT  INTO  REGISTRATION  VALUES  (?,?,?,?)";
            preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstname);
            preparedStatement.setString(3, lastname);
            preparedStatement.setInt(4, age);


            preparedStatement.executeUpdate();
            System.out.println(firstname + lastname + " added successfully");
        } catch (

                SQLException e) {
            e.printStackTrace();
        }
    }

    private static void exampleSelect(){
        try {
            statement = connection.createStatement();
            String selectStatement = "SELECT * FROM Registration";
            ResultSet rs = statement.executeQuery(selectStatement);
            rs.next();
            int id  = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.println(", Last: " + last);

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void exampleUpdate(){
        try {
            statement = connection.createStatement();
            String sql = "UPDATE Registration " +
                    "SET age = 30 WHERE id in (100, 101)";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void exampleDelete(){
        try {
            statement = connection.createStatement();
            String sqlDelete = "DELETE FROM Registration " +
                    "WHERE id = 101";
            statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
