
package com.dev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static Statement stmt = null;
	private static ResultSet resultSet = null;
	private static AdminDAO adminDAO=null;
	private AdminDAO(){}
	
	public static AdminDAO initialize()
	{
		if(adminDAO==null)
		{
			adminDAO=new AdminDAO();
		}
		return adminDAO;
	}
	
	public static boolean loginCheck(String username,String password)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_admin where username='"+username+"' and password='"+password+"'";
			System.out.println("********** Investigator Login Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>loginCheck(String username,String password) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean changePassword(String username,String newPassword)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_admin set password='"+newPassword+"' where username='"+username+"'";
			System.out.println("********** Change Investigator Password Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Change Password status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return flag;
	}
	
	
	public static String getAdminName(String username)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select name from m_admin where username='"+username+"'";
			System.out.println("********** Get Investigator Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("Admin Name["+username+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getAdminName(String username) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static int getAdminIdByUsername(String username)
	{
		String sql="";
		int id = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select id from m_admin where username='"+username+"'";
			System.out.println("********** Getting The Investigator Id By Username**********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			System.out.println("Admin Id["+username+"] : "+id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getAdminIdByUsername(String username) : ");
			e.printStackTrace();
		}
		return id;
	}
	
	public static ResultSet getAdminProfile(int adminId) 
	{
		String sql = "";
		
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_admin where id='"+adminId+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getAdminProfile(int adminId): ");
			e.printStackTrace();
		}
		return resultSet;
	}

	public static boolean updateAdminProfile(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			statement = connection.createStatement();
			sql = "update m_admin set password='"+list.get(2)+"',name='"+list.get(3)+"',sex='"+list.get(4)+"',cell='"+list.get(5)+"',phone='"+list.get(6)+"',email='"+list.get(7)+"',address='"+list.get(8)+"' where id='"+list.get(0)+"'";
			System.out.println("********** Update Investigator Profile Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update Investigator Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateAdminProfile(ArrayList<String> list): ");
			e.printStackTrace();
		}
		return flag;
	}
	
// All About The User	

	public static ResultSet getUsers() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_student");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getUsers() : ");
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
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_student where stu_code='"+userId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO-getUser(int userId) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static boolean checkUserExistance(String username)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			statement = connection.createStatement();
			sql = "select * from m_user where username='"+username+"'";
			System.out.println("********** Check User Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>checkUserExistance(String username) : ");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean addUserDetails(String username,String password,String name,String gender,String dob,String mobileNumber,String phoneNumber,String emailId,String address)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into m_user(username,password,name,sex,dob,cell,phone,email,address) values('"+username+"','"+password+"','"+name+"','"+gender+"','"+dob+"','"+mobileNumber+"','"+phoneNumber+"','"+emailId+"','"+address+"')";
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
			System.out.println("Exception in AdminDAO==>addUserDetails() : ");
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
			statement = connection.createStatement();
			sql = "update m_student set stu_roll_no='"+list.get(1)+"',stu_class_sec='"+list.get(2)+"',stu_name='"+list.get(3)+"',stu_sex='"+list.get(4)+"',stu_dob='"+list.get(5)+"',stu_cell_no='"+list.get(6)+"',stu_father_name='"+list.get(7)+"',stu_mother_name='"+list.get(8)+"',stu_address='"+list.get(9)+"',route_bus_no='"+list.get(10)+"',land_id='"+Integer.parseInt(list.get(11))+"' where stu_code='"+list.get(0)+"'";
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
			System.out.println("Exception in AdminDAO==>updateUserDetails(ArrayList<String> list): ");
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
			statement = connection.createStatement();
			sql = "delete from m_student where stu_code='"+userId+"'";
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
			System.out.println("Exception in AdminDAO==>deleteUserDetails(int userId): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean changeUserPassword(String username,String newPassword)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			statement = connection.createStatement();
			sql = "update m_user set password='"+newPassword+"' where username='"+username+"'";
			System.out.println("********** Change User Password Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Change Password status  : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in Authority==>changeUserPassword(String username,String newPassword): "+ e);
		}
		return flag;
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
			System.out.println("Exception in AdminDAO==>getUserName(int UserId) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static int getMaxUserId()
	{
		String sql="";
		int id = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select max(u_id) from m_user";
			System.out.println("********** Getting The Max User Id **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			System.out.println("Max User Id : "+id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getMaxUserId() : ");
			e.printStackTrace();
		}
		return id;
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
			System.out.println("Exception in AdminDAO==>getUserId(String username) : ");
			e.printStackTrace();
		}
		return id;
	}

	
// All About The Route	

	public static ResultSet getRoute() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_route");
			
			/*while(resultSet.next())
			{
				list.add(resultSet.getString(1)+"~"+resultSet.getString(2));
			}*/
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getRoute() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getRoute(String routeId) 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_route where route_bus_no='"+routeId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getRoute(int routeId) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static boolean checkRouteExistance(String routeName)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_route where route_name='"+routeName+"'";
			System.out.println("********** Check Route Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Route Existance : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>checkRouteExistance(String routeName) : ");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean addRouteDetails(String busno,String routeName,String routeFrom,String routeTo,String pwd)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into m_route(route_bus_no,route_name,route_from,route_to,route_bus_pwd,route_bus_latitude,route_bus_longitude) values('"+busno+"','"+routeName+"','"+routeFrom+"','"+routeTo+"','"+pwd+"','0','0')";
			System.out.println("********** Add Route Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Add Route Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>addRouteDetails() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateRouteDetails(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_route set route_name='"+list.get(1)+"',route_from='"+list.get(2)+"',route_to='"+list.get(3)+"',route_bus_pwd='"+list.get(4)+"' where route_bus_no='"+list.get(0)+"'";
			System.out.println("********** Update Route Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update Route Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateRouteDetails(ArrayList<String> list): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteRouteDetails(String routeId)
	{
		boolean flag=false;
		String sqlChild = "",sqlRoot = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			stmt = connection.createStatement();
			statement = connection.createStatement();
			//sqlChild = "delete from t_route where route_bus_no='"+routeId+"'";
			sqlRoot = "delete from m_route where route_bus_no='"+routeId+"'";
			System.out.println("********** Delete Route Details Info **********");
			
			//i = stmt.executeUpdate(sqlChild);
			//if(i>0)
			//{
				//flag = true;
				//System.out.println("Delete Route Child Status : "+flag);
				
				System.out.println(sqlRoot);
				i = statement.executeUpdate(sqlRoot);
				if(i>0)
				{
					flag=true;
				}
			//}
			System.out.println("Delete Route Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>deleteRouteDetails(int routeId): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static String getRouteName(String routeId)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select route_name from m_route where route_bus_no='"+routeId+"'";
			System.out.println("********** Getting The Route Name By Id **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("Route Name["+routeId+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getRouteName(int routeId) : ");
			e.printStackTrace();
		}
		return name;
	}

// All About The Land Mark
	
	public static ResultSet getLandMarks(String routeId) 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from t_route where route_bus_no='"+routeId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getLandMarks(int routeId)  : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getSpecificLandMark(String routeId,int serialNumber) 
	{
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from t_route where route_bus_no='"+routeId+"' and land_id='"+serialNumber+"'";
			System.out.println("******* Getting Specific Land Mark Details *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getSpecificLandMark(int routeId,int serialNumber)  : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static boolean checkLandMarkExistance(String busno,String landMark)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from t_route where route_bus_no='"+busno+"' and land_mark='"+landMark+"'";
			System.out.println("********** Check Route Land Mark Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Route Land Mark Existance : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>checkLandMarkExistance(int routeId,String landMark) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int getMaxSerialNumber(int routeId)
	{
		String sql="";
		int id = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select max(pickup_no) from t_route where route_bus_no='"+routeId+"'";
			System.out.println("********** Getting The Land Mark Max Serial Number **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			System.out.println("Max Land Mark Sl. No. : "+id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getMaxSerialNumber(int routeId) : ");
			e.printStackTrace();
		}
		return id;
	}
	
	public static int select_pickupno(String busno)
	{
		boolean flag=false;
		String sql = "";
		int pino = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select pickup_no from t_route where route_bus_no='"+busno+"'";
			System.out.println("********** Check Route Land Mark Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				pino =resultSet.getInt(1) ;
				
			}
			System.out.println("Route Land Mark Existance : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>checkLandMarkExistance(int routeId,String landMark) : ");
			e.printStackTrace();
		}
		return pino;
	}
	
	public static boolean addRouteLandMark(String routeId,int serialNumber,String landMark,double latitude,double longitude,String inst)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into t_route(route_bus_no,pickup_no,land_mark,latitude,longitude,text_msg) values('"+routeId+"','"+serialNumber+"','"+landMark+"','"+latitude+"','"+longitude+"','"+inst+"')";
			System.out.println("********** Add Route Land Mark Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Add Route Land Mark Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>addRouteLandMark() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateLandMarkDetails(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update t_route set land_mark='"+list.get(1)+"',latitude='"+list.get(2)+"',longitude='"+list.get(3)+"',text_msg='"+list.get(4)+"' where land_id='"+list.get(0)+"'";
			System.out.println("********** Update Land Mark Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update Land Mark Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateLandMarkDetails(ArrayList<String> list): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteLandMarkDetails(String routeId,int serialNumber)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "delete from t_route where route_bus_no='"+routeId+"' and pickup_no='"+serialNumber+"'";
			System.out.println("********** Delete Land Mark Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Delete LandMark Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>deleteLandMarkDetails(int routeId,String serialNumber): ");
			e.printStackTrace();
		}
		return flag;
	}
}
