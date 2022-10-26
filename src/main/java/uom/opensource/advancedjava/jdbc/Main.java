package uom.opensource.advancedjava.jdbc;

import java.sql.*;

public class Main {
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/jdbctest";
    private static String password = "DemoAccount123!@#";
    private static String username = "konkos";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        insertData();
        getData();
    }

    private static void getData() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM students";
        // Obtain a connection
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            // Load driver class
            Class.forName(driverClassName);

            try (Statement st = con.createStatement()) {
                // Execute the query
                ResultSet resultSet = st.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Student student = new Student(id, name);
                    System.out.println(student);
                }

                // Closing the connection as per the
                // requirement with connection is completed
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void insertData() throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO students VALUES(102, 'john')";
        // Obtain a connection
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            // Load driver class
            Class.forName(driverClassName);

            try (Statement st = con.createStatement()) {
                // Execute the query
                int count = st.executeUpdate(query);
                System.out.println("number of rows affected by this query= " + count);

                // Closing the connection as per the
                // requirement with connection is completed
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}