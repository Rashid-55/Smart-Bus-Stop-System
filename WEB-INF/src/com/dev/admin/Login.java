
package com.dev.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.AdminDAO;



@SuppressWarnings("serial")
public class Login extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		boolean flag = false;
		try
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			flag = AdminDAO.loginCheck(username, password);
			if(flag)
			{
				session.setAttribute("username",username);
				RequestDispatcher rd=request.getRequestDispatcher("/res/JSP/Admin/home.jsp?no=1");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Exception is in Admin->Login Servlet : ");
			e.printStackTrace();
			out.println("Opps's Exception is in Admin->Login Servlet : ");
			e.printStackTrace();
		}
	}
}

