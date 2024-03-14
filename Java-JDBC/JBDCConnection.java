

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
interface Data{
	String jdbcUrl = "jdbc:mysql://localhost:3306/dbname";
    String username = "root";
    String password = "Password";
}
public class JBDCConnection implements Data{
	 public static void main(String[] args) {
	        // JDBC URL, username, and password of your database
	        

	        // SQL query to create the 'employees' table
	       String data="Succesfully created connection";

	        try {
	            // Register JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Open a connection
	            Connection connection = DriverManager.getConnection(Data.jdbcUrl, Data.username, Data.password);

	            // Create a PreparedStatement for the SQL query
	            try (PreparedStatement preparedStatement = connection.prepareStatement(data)) {
	                
	                System.out.println(data);
	            }

	            // Close the connection
	            connection.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	}