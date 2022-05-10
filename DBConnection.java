package com.QA.TestApp.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	String myName;
	private Properties loadFile() throws IOException{
		Properties obj = new Properties();					
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");									
	    obj.load(objfile);
	    return obj;
	}
	public String executeQuery(String query, String[] coloumnName) throws SQLException, ClassNotFoundException, IOException{
        String dbUrl = loadFile().getProperty("connectionString");					

		//Database Username		
		String username = loadFile().getProperty("username");	
        
		//Database Password		
		String password = loadFile().getProperty("password");				

		//Query to Execute		
		//String query = "select *  from employee;";	
        
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.jdbc.Driver");			
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 		
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		myName = rs.getString(coloumnName[0]);							        
                    String myAge = rs.getString(coloumnName[1]);		
                   
                    }
                    //System. out.println(myName+"  "+myAge);
		con.close();
		return myName;
            }		
			 // closing DB Connection		
			
			//return myName,myAge;			
}
	


