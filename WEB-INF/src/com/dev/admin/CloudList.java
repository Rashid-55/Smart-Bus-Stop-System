
package com.dev.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.AdminDAO;
import com.dev.util.Utility;

@SuppressWarnings("serial")
public class CloudList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		boolean flag = false;
		try
		{
			int cloudId=0;
			String hostName="",username="",password="",dir="";
			
			String submit=request.getParameter("action");
			
			/*ResultSet rs=AdminDAO.getClouds();
			RequestDispatcher rd=null;
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/clouds.jsp");
				rd.forward(request, response);
			}
			
			if(submit.equals("Add"))
			{
				if(Utility.parse1(request.getParameter("add1")).equals("YES"))
				{
					hostName=request.getParameter("host");
					username=request.getParameter("un");
					password=request.getParameter("pwd");
					dir=request.getParameter("dir").trim();
					
					flag = AdminDAO.checkCloudExistance(hostName);
					
					if(!flag)
					{
						flag = AdminDAO.addCloudInfo(hostName, username, password, dir);
						
						if(flag)
						{
							rs=AdminDAO.getClouds();
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/res/JSP/Admin/clouds.jsp?no=1");
							rd.forward(request, response);
						}
						else
						{
							rd=request.getRequestDispatcher("/res/JSP/Admin/add_cloud.jsp?no=2");
							rd.forward(request, response);
						}
					}
					else
					{
						rd=request.getRequestDispatcher("/res/JSP/Admin/add_cloud.jsp?no=3");
						rd.forward(request, response);
					}
					
				}
				else
				{
					rd=request.getRequestDispatcher("/res/JSP/Admin/add_cloud.jsp");
					rd.forward(request, response);
				}
			}
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit1")).equals("YES"))
				{
					String s[]=new String[5];
					s[0]=request.getParameter("id");
					s[1]=request.getParameter("host");
					s[2]=request.getParameter("un");
					s[3]=request.getParameter("pwd");
					s[4]=request.getParameter("dir");
					
					flag = AdminDAO.checkCloudExistance(s[1]);
					
					if(!flag)
					{
						flag = AdminDAO.editCloudInfo(s);
						
						if(flag)
						{
							rs=AdminDAO.getClouds();
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/res/JSP/Admin/clouds.jsp?no=5");
							rd.forward(request,response);
						}
						else
						{
							rs=AdminDAO.getClouds(Integer.parseInt(s[0]));
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/res/JSP/Admin/edit_cloud.jsp?no=2");
							rd.forward(request,response);
						}
					}
					else
					{
						rs=AdminDAO.getClouds(Integer.parseInt(s[0]));
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/edit_cloud.jsp?no=1");
						rd.forward(request,response);
					}
					
					
				}
				else if(chk==null)
				{
					rs=AdminDAO.getClouds();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/clouds.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getClouds();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/clouds.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					rs=AdminDAO.getClouds(Integer.parseInt(chk[0]));
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/edit_cloud.jsp");
					rd.forward(request,response);
				}
			}
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs=AdminDAO.getClouds();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/clouds.jsp?no=2");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						cloudId = Integer.parseInt(chk[i]);
						AdminDAO.deleteCloudInfo(cloudId);
					}
					rs=AdminDAO.getClouds();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/clouds.jsp?no=3");
					rd.forward(request,response);
				}
			}
			*/
			//
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin CloudList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin CloudList Servlet : "+e);
		}
	}
}
