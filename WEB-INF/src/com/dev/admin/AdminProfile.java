
package com.dev.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dev.dao.AdminDAO;

@SuppressWarnings("serial")
public class AdminProfile extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean flag = false;
		int adminId=0;
		String username="",password="",name="",gender="",address="",mobileNumber="",
			   phoneNumber="",emailId="";
		HttpSession session = request.getSession();
		
		try
		{
			if(session != null)
			{
				username = (String) session.getAttribute("username");
			}
			
			adminId = AdminDAO.getAdminIdByUsername(username);
			
			String submit=request.getParameter("action");
			
			rs=AdminDAO.getAdminProfile(adminId);
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/profile.jsp");
				rd.forward(request, response);
			}
			if(submit.equals("Update Profile"))
			{
				rs=AdminDAO.getAdminProfile(adminId);
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/edit_profile.jsp");
				rd.forward(request, response);
			}
			if(submit.equals("Update"))
			{
				
				String id =request.getParameter("id");
				username = request.getParameter("username");
				password = request.getParameter("password");
				name = request.getParameter("name");
				gender = request.getParameter("sex");
				mobileNumber = request.getParameter("mob");
				phoneNumber = request.getParameter("phone");
				emailId = request.getParameter("email");
				address = request.getParameter("address");
				
				ArrayList<String> list = new ArrayList<String>();
				list.add(id);
				list.add(username);
				list.add(password);
				list.add(name);
				list.add(gender);
				list.add(mobileNumber);
				list.add(phoneNumber);
				list.add(emailId);
				list.add(address);
				
				flag = AdminDAO.updateAdminProfile(list);
				
				if(flag)
				{
					adminId = Integer.parseInt(id);
					rs=AdminDAO.getAdminProfile(adminId);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/profile.jsp?no=1");
					rd.forward(request, response);
				}
				else
				{
					rs=AdminDAO.getAdminProfile(adminId);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/edit_profile.jsp?no=2");
					rd.forward(request, response);
				}
					
			}
			
			
			//
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin UserProfile Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin UserProfile Servlet : ");
			e.printStackTrace();
		}
	}
}
