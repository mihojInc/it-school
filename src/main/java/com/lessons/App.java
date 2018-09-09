package com.lessons;

import java.sql.*;
import java.util.Scanner;

public class App {

    /**
     * Connection interface
     */
    private static Connection connection;

    public static void main(String[] args) throws SQLException {

        Connections database = new Connections();
        String name, control = "";
        int id;

        System.out.println("Hello in the data base app");

        Scanner scanner = new Scanner(System.in);

        database.h2connection();
        connection = Connections.connection;
        helper();

        while (!control.equals("q")) {

            control = scanner.nextLine();

            switch (control.charAt(0)) {
                case 'q':
                    System.out.println("Bye bye");
                    break;
                case 'a':
                    System.out.println("Input name");
                    name = scanner.nextLine();
                    addUser(name);
                    break;
                case 'h':
                    helper();
                    break;
                case 'p':
                    getTable();
                    break;
                case 'c':
                    System.out.println("What id you wont change?");//todo
                    id = Integer.valueOf(scanner.nextLine());
                    System.out.println("... & name: ");
                    name = scanner.nextLine();
                    changeById(id, name);
                    break;
                case 'd':
                    System.out.println("What user with id you wont delete?");
                    deleteById(Integer.valueOf(scanner.nextLine()));
                    break;
                case 's':
                    System.out.println("1 - H2 else - MySQL");
                    try {
                        id = Integer.valueOf(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        id = 0; // d't course
                    }
                    if (id == 1) {
                        database.h2connection();
                    } else {
                        database.initUser(scanner);
                        database.mysqlConnection();
                    }
                    connection = Connections.connection;
                    break;
            }
        }

    }


    public static void addUser(String name) throws SQLException {
        String sql = "INSERT INTO user(name) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name);

        ps.execute();
    }

    /**
     *  Print in console all data from table user
     */
    public static void getTable() throws SQLException {
        String sql = "SELECT * FROM user";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("ID : " + resultSet.getInt("id") +
                    " and NAME : " + resultSet.getString("name"));
        }
    }

    /**
     * Change user name in base for his id
     */
    public static void changeById(int id, String name) throws SQLException {
        String sql = "UPDATE user SET name=? WHERE id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, id);

        ps.executeUpdate();
    }

    public static void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id =" + id;
        connection.createStatement().execute(sql);
    }

    /**
     * All possible console commands
     */
    private static void helper() {
        System.out.println("q - to quit, a - to add new data, h -help, p - print all, " +
                "c - change data, d - delete data, s - select database");
    }


}
