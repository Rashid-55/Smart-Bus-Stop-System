

package com.dev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDAO userDAO=null;
	private UserDAO(){}
	
	public static UserDAO initialize()
	{
		if(userDAO==null)
		{
			userDAO=new UserDAO();
		}
		return userDAO;
	}
	
	
	public static ResultSet getUsers() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in UserDAO==>getUsers() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getBusno() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select route_bus_no from m_route");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in UserDAO==>getUsers() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getLandmark() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select land_mark from t_route");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in UserDAO==>getUsers() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getLandmark1() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT land_mark FROM t_route a INNER JOIN m_student b");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in UserDAO==>getUsers() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getUser(int userId) 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+userId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in UserDAO==>getUser(int userId) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	public static boolean checkStudentExistance(String rollNumber)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_student where stu_roll_no='"+rollNumber+"'";
			System.out.println("********** Check Student Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Student Existance Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>checkStudentExistance(String rollNumber) : ");
			e.printStackTrace();
		}
		return flag;
	}

	
	public static boolean addStudentDetails(String rll,String sclass,String name,String gender,String dob,String mobileNumber,String fname,String mname,String addr,String bno,int lid)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into m_student(stu_roll_no,stu_class_sec,stu_name,stu_sex,stu_dob,stu_cell_no,stu_father_name,stu_mother_name,stu_address,route_bus_no,land_id) values('"+rll+"','"+sclass+"','"+name+"','"+gender+"','"+dob+"','"+mobileNumber+"','"+fname+"','"+mname+"','"+addr+"','"+bno+"','"+lid+"')";
			System.out.println("********** Add User Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Add User Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>addUserDetails() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean updateUserDetails(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_user set password='"+list.get(2)+"',name='"+list.get(3)+"',sex='"+list.get(4)+"',dob='"+list.get(5)+"',cell='"+list.get(6)+"',phone='"+list.get(7)+"',email='"+list.get(8)+"',address='"+list.get(9)+"' where u_id='"+list.get(0)+"'";
			System.out.println("********** Update User Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update User Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>updateUserDetails(ArrayList<String> list): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateUserProfile(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_user set password='"+list.get(2)+"',name='"+list.get(3)+"',cell='"+list.get(4)+"',phone='"+list.get(5)+"',email='"+list.get(6)+"',address='"+list.get(7)+"' where u_id='"+list.get(0)+"'";
			System.out.println("********** Update User Profile Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update User Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>updateUserProfile(ArrayList<String> list): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteUserDetails(int userId)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "delete from m_user where u_id='"+userId+"'";
			System.out.println("********** Delete User Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Delete User Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>deleteUserDetails(int userId): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static String getUserName(String username)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select name from m_user where username='"+username+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("User Name["+username+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getAdminName(String username) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getLM(int lid)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select land_mark from t_route where land_id='"+lid+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("Land Mark["+name+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getAdminName(String username) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static int getLand_id(String landmark)
	{
		String sql="";
		int lid=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select land_id from t_route where land_mark='"+landmark+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				lid = resultSet.getInt(1);
			}
			System.out.println("User Name["+lid+"]: "+lid);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getAdminName(String username) : ");
			e.printStackTrace();
		}
		return lid;
	}
	
	public static String getUserName(int userId)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select name from m_user where u_id='"+userId+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("User Name["+userId+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getUserName(int UserId) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getUserEmail(int userId)
	{
		String sql="";
		String email="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select email from m_user where u_id='"+userId+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				email = resultSet.getString(1);
			}
			System.out.println("User Email["+userId+"]: "+email);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getUserEmail(int userId) : ");
			e.printStackTrace();
		}
		return email;
	}
	
	public static String getUserPassword(int userId)
	{
		String sql="";
		String password="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select password from m_user where u_id='"+userId+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				password = resultSet.getString(1);
			}
			System.out.println("User Password["+userId+"]: "+password);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getUserPassword(int userId) : ");
			e.printStackTrace();
		}
		return password;
	}
	
	public static int getUserId(String username)
	{
		String sql="";
		int id = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select u_id from m_user where username='"+username+"'";
			System.out.println("********** Get User Id By Username Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			System.out.println("User Id["+username+"]: "+id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getUserId(String username) : ");
			e.printStackTrace();
		}
		return id;
	}
// All About The Bus Staff (STARTS)
	public static boolean authenticateBusStaff(String username,String password)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_route where route_bus_no='"+username+"' and route_bus_pwd='"+password+"'";
			System.out.println("********** Bus Staff Login Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Bus Staff Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>authenticateBusStaff(String username,String password) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean changeBusStaffPassword(String username,String newPassword)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_route set route_bus_pwd='"+newPassword+"' where route_bus_no='"+username+"'";
			System.out.println("********** Change Bus Staff Password Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Change Bus Staff Password Status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>changeBusStaffPassword(String username,String newPassword): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateBusGPSInfo(String busRouteNumber,double latitude,double longitude)
	{
		boolean flag=false;
		String sql = "",status="Processing";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_route set route_bus_latitude='"+latitude+"',route_bus_longitude='"+longitude+"',route_bus_status='"+status+"' where route_bus_no='"+busRouteNumber+"'";
			System.out.println("********** Update Bus GPS Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update GPS Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>updateBusGPSInfo(String busRouteNumber,double latitude,double longitude): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateBusStatus(String busRouteNumber,String busStatus)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_route set route_bus_status='"+busStatus+"' where route_bus_no='"+busRouteNumber+"'";
			System.out.println("********** Update Bus Status Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update Bus Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>updateBusStatus(String busRouteNumber,String busStatus) : ");
			e.printStackTrace();
		}
		return flag;
	}
// All About The Bus Staff (STARTS)	
	
// All About The Students (STARTS)
	public static boolean authenticateStudents(String username,String password)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_student where stu_roll_no='"+username+"' and stu_password='"+password+"'";
			System.out.println("********** Student Login Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Student Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>authenticateStudents(String username,String password) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean changeStudentPassword(String username,String newPassword)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_student set stu_password='"+newPassword+"' where stu_roll_no='"+username+"'";
			System.out.println("********** Change Student Password Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Change Student Password Status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>changeStudentPassword(String username,String newPassword): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int checkStudentRequestExistance(String rollNumber)
	{
		String sql="";
		int requestNumber = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select req_no from m_alert_request where stu_roll_no='"+rollNumber+"'";
			System.out.println("********** Checking The Student Request Existance **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				requestNumber = resultSet.getInt(1);
			}
			System.out.println("Request Number [Roll Number : "+rollNumber+"]: "+requestNumber);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>checkStudentRequestExistance(String rollNumber) : ");
			e.printStackTrace();
		}
		return requestNumber;
	}
	
	public static boolean updateStudentAlertRequestInfo(ArrayList list)
	{
		boolean flag=false;
		String sql = "",rollNumber="";
		int requestNumber = 0;
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			rollNumber = list.get(1).toString();
			requestNumber = checkStudentRequestExistance(rollNumber);
			if(requestNumber == 0)
			{
				sql = "insert into m_alert_request(req_date,stu_roll_no,route_bus_no,latitude,longitude,alert_msg,req_status) " +
					  "values('"+list.get(0)+"','"+list.get(1)+"','"+list.get(2)+"','"+list.get(3)+"','"+list.get(4)+"','"+list.get(5)+"','"+list.get(6)+"')";
			}
			else
			{
				sql = "update m_alert_request set req_date='"+list.get(0)+"',latitude='"+list.get(3)+"',longitude='"+list.get(4)+"',alert_msg='"+list.get(5)+"',req_status='"+list.get(6)+"' where req_no='"+requestNumber+"'";
			}
			
			System.out.println("********** Update Student Alert Request Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>updateStudentAlertRequestInfo(ArrayList list) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static String getBusRouteNumber(String studentRollNumber)
	{
		String sql="";
		String busRouteNumber="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select route_bus_no from m_student where stu_roll_no='"+studentRollNumber+"'";
			System.out.println("********** Getting Bus Route Number By studentRollNumber **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				busRouteNumber = resultSet.getString(1);
			}
			System.out.println("Bus Route Number : ["+studentRollNumber+"]: "+busRouteNumber);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusRouteNumber(String studentRollNumber) : ");
			e.printStackTrace();
		}
		return busRouteNumber;
	}
	
	public static String getBusStatus(String busRouteNumber)
	{
		String sql="";
		String busStatus="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select route_bus_status from m_route where route_bus_no='"+busRouteNumber+"'";
			System.out.println("********** Getting Bus Status By busRouteNumber **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				busStatus = resultSet.getString(1).trim();
			}
			System.out.println("Bus Status : ["+busRouteNumber+"]: "+busStatus);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusStatus(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return busStatus;
	}
	
	public static double getBusLatitude(String busRouteNumber)
	{
		String sql="";
		double latitude = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select route_bus_latitude from m_route where route_bus_no='"+busRouteNumber+"'";
			System.out.println("********** Getting Bus Latitude By busRouteNumber **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				latitude = resultSet.getDouble(1);
			}
			System.out.println("Bus Latitude : ["+busRouteNumber+"]: "+latitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusStatus(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return latitude;
	}
	
	public static double getBusLongitude(String busRouteNumber)
	{
		String sql="";
		double longitude = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select route_bus_longitude from m_route where route_bus_no='"+busRouteNumber+"'";
			System.out.println("********** Getting Bus Longitude By busRouteNumber **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				longitude = resultSet.getDouble(1);
			}
			System.out.println("Bus Longitude : ["+busRouteNumber+"]: "+longitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusLongitude(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return longitude;
	}
	
	public static ResultSet getBusLandmarks(String busRouteNumber) 
	{
		String sql="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql= "select * from t_route where route_bus_no='"+busRouteNumber+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in UserDAO==>getBusLandmarks(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
// All About The Students (ENDS)	
	
}
