package com.silicon.crud;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



 class Perform implements Data{
	 String JDBC_URL = "jdbc:mysql://localhost:3306/dbname";
	   String USERNAME = "root";
	    final String PASSWORD = "password";
	public void showdata() {
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

	public void insertdata() {
		// TODO Auto-generated method stub

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // SQL query for insertion
            String insertQuery = "INSERT INTO employees VALUES (3,'Raghu',30,20000)";
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
		
		
	

	@Override
	public void deletedata() {
		// TODO Auto-generated method stub
		   int employeeIdToDelete = 8;

	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
	            // SQL query for deletion based on employee ID
	            String deleteQuery = "DELETE FROM employees WHERE id = ?";

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
	public void updatedata() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			 String updatedata= "UPDATE employees SET name='Ravi' WHERE id=2";
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

	@Override
	public void createEmployee() {
		// TODO Auto-generated method stub
		
	}

	

	
	
		
	}
 
public class CRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Insert c=new Insert();
//		c.createEmployee();
		Perform p=new Perform();
//		p.insertdata();
//		p.deletedata();
//		p.updatedata();
//		p.showdata();
	}

}
