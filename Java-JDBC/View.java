package com.silicon.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class View {
	 static String JDBC_URL = "jdbc:mysql://localhost:3306/dbname";
	   static String USERNAME = "root";
	    final static String PASSWORD = "password";
	public static void deletedata() {
		// TODO Auto-generated method stub
		   int employeeIdToDelete = 10;

	       
			try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
	            // SQL query for deletion based on employee ID
	            String deleteQuery = "DELETE FROM empolyees WHERE id = ?";

	            // Prepare the statement
	            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
	                // Set the parameter value (employee ID to be deleted)
	                preparedStatement.setInt(1, employeeIdToDelete);

	                // Execute the query to delete data
	                int rowsAffected = preparedStatement.executeUpdate();

	                if (rowsAffected > 0) {
	                    System.out.println("Deleted the employee with ID: " + employeeIdToDelete);
	                } else {
	                    System.out.println("No employee found with ID: " + employeeIdToDelete);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	
}
	public static void showdata() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String selectSQL = "SELECT * FROM employees";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Employee Data:");
                System.out.println("ID\tName\tAge\tSalary");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    double salary = resultSet.getDouble("salary");
                    System.out.println(id + "\t" + name + "\t" + age + "\t" + salary);
                }
                System.out.println("------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	public static void insertdata() {
		// TODO Auto-generated method stub

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // SQL query for insertion
            String insertQuery = "INSERT INTO employees VALUES (8,'Ram',32,25000)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            
            // Prepare the statement
            int rowsAffected = preparedStatement.executeUpdate(insertQuery);
            System.out.println("Rows affected: " + rowsAffected);
            

            // Close resources
           
            connection.close();

        }  catch (Exception e) {
            e.printStackTrace();
        }
}
	public static void updatedata() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			 String updatedata= "UPDATE employees SET name='vera' WHERE id=2";
			 PreparedStatement preparedStatement = connection.prepareStatement(updatedata);

	            
			  int rowsAffected = preparedStatement.executeUpdate();
              System.out.println("Rows affected after updating: " + rowsAffected);

	            // Close resources
	            preparedStatement.close();
	            connection.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice :");
		System.out.println("1 for Delete data from table");
		System.out.println("2 for Show data present in table");
		System.out.println("3 for Insert data into table");
		System.out.println("4 to update the data into table");
		int choicetoselect=sc.nextInt();
		switch(choicetoselect) {
		case 1:
			System.out.println("Deleted row from table");
			deletedata();
			break;
		case 2:
			System.out.println("Show data in table");
			showdata();
			break;
		case 3:
			insertdata();
			System.out.println("Inserted data into table");
			break;
		case 4:
			updatedata();
			System.out.println("Sucessfully updated data");
			showdata();
			break;
		default:
			System.out.println("Invalid operation performed");
			
		}
        

	}

}
