package net.codejava;
import java.util.Scanner;

import java.sql.*;

class operations {

	public static void main(String[] args) {
		String flag="Y";

		do{

		System.out.println("Select DML Operation For Product Table...");

		System.out.println("1. Insert");

		System.out.println("2. Show all records");
		
		System.out.println("3. Show records according to particular actor name");
		
		System.out.println("4. Exit");

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter a choice: ");

		int n = reader.nextInt();

		Connection conn = null;

		Statement stmt = null;

		try {

		Class.forName("org.sqlite.JDBC");

		conn = DriverManager.getConnection("jdbc:sqlite:/C:\\Users\\nitesh\\OneDrive\\Desktop\\sqlite\\moviedb.db");
		
		conn.setAutoCommit(false);

		stmt = conn.createStatement();

		String movie_name ="", sql="";

		String lead_actor = ""; 
		
		String lead_actress = ""; 
		
		String Dir_Name = ""; 
		
		String  Release_Date = ""; 
		
		int id;

		Scanner scanName;

		switch(n){

		 

		case 1:

		scanName=new Scanner(System.in);

		System.out.println("Enter movie Name:");

		movie_name=scanName.nextLine();

		System.out.println("Enter lead actor");

		lead_actor=scanName.nextLine();
		
		System.out.println("Enter lead actress:");
        lead_actress=scanName.nextLine();
        
        System.out.println("Enter Director:");

        Dir_Name =scanName.nextLine();
        
        System.out.println("Enter Realease date:");

        Release_Date =scanName.nextLine();

		sql = "INSERT INTO MOVIE_DB (movie_name,lead_actor,lead_actress,Dir_Name,Release_Date) " +

		"VALUES ('" +movie_name+ "','" +

        lead_actor + "','" + lead_actress +  "','" + Dir_Name + "','" + Release_Date + "'" + ")";

		stmt.executeUpdate(sql);

		System.out.println("Inserted Successfully!!!");

		break;

		 
		 

		case 2:

		ResultSet rs = stmt.executeQuery("SELECT * FROM MOVIE_DB;");

		System.out.println("ID\t Movie\t\t Lead Actor\t Lead Actress\tRealease date\tDirector ");

		while ( rs.next() ) 
		{

		id = rs.getInt("p_id");

		movie_name = rs.getString("movie_name");

		lead_actor = rs.getString("lead_actor");

		lead_actress = rs.getString("lead_actress");
		
		Dir_Name = rs.getString("Dir_Name");
		
		Release_Date = rs.getString("Release_Date");

		System.out.println(id+"\t "+movie_name+"       \t "+lead_actor+"      \t "+lead_actress+"            \t "+Release_Date+"         \t "+Dir_Name);

		}

		rs.close();

		break;

		case 3:
        scanName=new Scanner(System.in);
			
			System.out.println("Enter actor Name:");
			
			String ask = scanName.next();
				
		    sql = "Select movie_name from MOVIE_DB where lead_actor = '"+ ask +"' ;";
			
		    ResultSet r = stmt.executeQuery(sql);
		    
		    System.out.println("List of movies in which Actor " + ask +" acted  :");
			
		    System.out.println("Movies");
			
		    while(r.next())
		    {
		    	movie_name = r.getString("movie_name");
		    	
		    	System.out.println(movie_name);
				  	
		    }
			
			
			r.close();
			break;

		case 4:

		System.exit(0);

		break;

		 

		default:

		System.out.println("Oops!!! Wrong Choice...");

		break;

		}
		stmt.close();

		conn.commit();

		conn.close();
		}

		catch ( Exception e )

		{

		System.err.println( e.getClass().getName() + ": " + e.getMessage() );

		System.exit(0);

		}

		System.out.println("Continue Y OR N?");

		reader=new Scanner(System.in);

		flag=reader.nextLine();
		}while(flag.equalsIgnoreCase("Y"));

		System.exit(0);

		}
	}