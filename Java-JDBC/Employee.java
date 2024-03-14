package com.silicon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Employee {

	public static void main(String[] args) {
		 // JDBC URL, username, and password of your database
        String jdbcUrl = "jdbc:mysql://localhost:3306/dbname";
        String username = "root";
        String password = "password";

        // SQL query to create the 'employees' table
        String createTableSQL = "CREATE TABLE employees ("
                + "id INT PRIMARY KEY ,"
                + "name VARCHAR(100) NOT NULL,"
                + "age INT,"
                + "salary DOUBLE"
                + ")";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create a PreparedStatement for the SQL query
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
                // Execute the SQL statement to create the table
                preparedStatement.executeUpdate();
                System.out.println("Table 'employees' created successfully.");
            }

            // Close the connection
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
