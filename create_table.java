package net.codejava;
import java.sql.*;
public class create_table {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:/C:\\Users\\nitesh\\OneDrive\\Desktop\\sqlite\\moviedb.db");
		System.out.println("Database Opened...\n");
		stmt = conn.createStatement();
		String sql = "CREATE TABLE MOVIE_DB " +
		"(p_id INTEGER PRIMARY KEY AUTOINCREMENT," +
		" movie_name TEXT NOT NULL, " +
		" lead_actor TEXT NOT NULL, " +
		" lead_actress TEXT NOT NULL, " +
		" Dir_Name TEXT NOT NULL," + 
		" Release_Date TEXT NOT NULL)" ;
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
		}
		catch ( Exception e ) {
		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		System.exit(0);
		}
		System.out.println("Table MOVIE_DB Created Successfully!!!");
		}
	}