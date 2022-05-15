package net.codejava;
import java.sql.*;
public class connection {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:/C:\\Users\\nitesh\\OneDrive\\Desktop\\sqlite\\moviedb.db");
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
      System.out.println("database successfully created");
	}
}