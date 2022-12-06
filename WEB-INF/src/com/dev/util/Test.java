

package com.dev.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dev.dao.DAO;

public class Test 
{
	public static void main(String[] args) throws Exception 
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
// Truncate Table(truncate table temp)		
		
		try
		{
			con = DAO.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("select * from temp");
			
			
			if(rs.getConcurrency() == ResultSet.CONCUR_READ_ONLY)
			{
				System.out.println("ResultSet is Non-Updatable.");
			}
			else
			{
				System.out.println("ResultSet is Updatable.");
				
				// Move the cursor to the insert row
			    rs.moveToInsertRow();
			    rs.updateString(2,"Qn");
			    rs.updateDouble(3,14.12);
			    rs.updateDouble(4,23.85);
			    rs.updateDouble(5,24.38);
			    rs.updateDouble(6,0.0);
			    
			    // Store the insert into database
			    rs.insertRow();
			    
			    rs.moveToCurrentRow();
			    
			    System.out.println("Row Inserted Sucessfully.....");
			    
			    //Displaying The Reords
			    
			    while(rs.next())
			    {
			    	System.out.println("Id  : " + rs.getInt(1));
			    	System.out.println("Question : " + rs.getString(2));
			    	System.out.println("Lower BMI : " + rs.getDouble(3));
			    	System.out.println("My Answer : " + rs.getDouble(4));
			    	System.out.println("Higher BMI : " + rs.getDouble(5));
			    	System.out.println("Predictive Power : " + rs.getDouble(6));
			    	
			    	System.out.println("------------------------");
			    }
			    
			    //Close The Resources
			    rs.close();
			    stmt.close();
			    con.close();

			}
		} 
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Test Class : ");
			e.printStackTrace();
		}
	}
}
