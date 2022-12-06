
package com.dev.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.AdminDAO;
import com.dev.util.Utility;

@SuppressWarnings("serial")
public class RouteList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean flag = false;
		int routeId=0;
		String routeName="",routeFrom="",routeTo="",busno="",buspwd="";
		
		
		try
		{
			String submit=request.getParameter("action");
			
			rs=AdminDAO.getRoute();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/route_list.jsp");
				rd.forward(request, response);
			}
			
			if(submit.equals("Add Route"))
			{
				if(Utility.parse1(request.getParameter("add")).equals("YES"))
				{
					busno = request.getParameter("route_busno");
					
					routeName = request.getParameter("route_name");
					routeFrom = request.getParameter("route_from");
					routeTo = request.getParameter("route_to");
					buspwd = request.getParameter("bus_pwd");
					
					//flag = AdminDAO.checkRouteExistance(routeName);
					
					if(!flag)
					{
						flag = AdminDAO.addRouteDetails(busno,routeName, routeFrom, routeTo,buspwd);
						
						
						if(flag)
						{
							rs=AdminDAO.getRoute();
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/res/JSP/Admin/route_list.jsp?no=1");
							rd.forward(request, response);
						}
						else
						{
							rd=request.getRequestDispatcher("/res/JSP/Admin/add_route.jsp?no=2");
							rd.forward(request, response);
						}
							 
					}
					else
					{
						rd=request.getRequestDispatcher("/res/JSP/Admin/add_route.jsp?no=3");
						rd.forward(request, response);
					}
					
				}
				else
				{
					rd=request.getRequestDispatcher("/res/JSP/Admin/add_route.jsp");
					rd.forward(request, response);
				}
			}
			
			
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit")).equals("YES"))
				{
					String id =request.getParameter("id");
					routeName = request.getParameter("route_name");
					routeFrom = request.getParameter("route_from");
					routeTo = request.getParameter("route_to");
					buspwd = request.getParameter("bus_pwd");
					
					ArrayList<String> list = new ArrayList<String>();
					list.add(id);
					list.add(routeName);
					list.add(routeFrom);
					list.add(routeTo);
					list.add(buspwd);
					
					
					flag = AdminDAO.updateRouteDetails(list);
					
					if(flag)
					{
						rs=AdminDAO.getRoute();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/route_list.jsp?no=5");
						rd.forward(request,response);
					}
					else
					{
						rs=AdminDAO.getRoute(chk[0]);
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/edit_route.jsp?no=2");
						rd.forward(request,response);
					}
					
				}
				else if(chk==null)
				{
					rs=AdminDAO.getRoute();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/route_list.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getRoute();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/route_list.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					rs=AdminDAO.getRoute(chk[0]);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/edit_route.jsp");
					rd.forward(request,response);
				}
			}

			
			
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				
				/*
					//Without Delete Confirmation
					if(chk==null)
					{
						rs=AdminDAO.getRoute();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/route_list.jsp?no=2");
						rd.forward(request,response);
					}
					else
					{
						for(int i=0;i<chk.length;i++)
						{
							routeId = Integer.parseInt(chk[i]);
							AdminDAO.deleteRouteDetails(routeId);
						}
						rs=AdminDAO.getRoute();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/route_list.jsp?no=3");
						rd.forward(request,response);
					}
				*/
				
				//With Delete Confirmation
				
				for(int i=0;i<chk.length;i++)
				{
					String routeId1 = chk[i];
					AdminDAO.deleteRouteDetails(routeId1);
					
				}
				rs=AdminDAO.getRoute();
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/route_list.jsp?no=3");
				rd.forward(request,response);
			}
		
			//
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin RouteList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin RouteList Servlet : "+e);
		}
	}
}
