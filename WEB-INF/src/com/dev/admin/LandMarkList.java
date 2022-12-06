
package com.dev.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.dao.AdminDAO;
import com.dev.util.Utility;

@SuppressWarnings("serial")
public class LandMarkList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean flag = false;
		int routeId=0,serialNumber=0;
		double latitude=0,longitude=0;
		String landMark="",instruction="",voiceFile="";
		
		HttpSession session = request.getSession();
		
		try
		{
			String submit=request.getParameter("action");
			
			//System.out.println("Action : "+submit);
			
			rs=AdminDAO.getRoute();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/route_mark.jsp");
				rd.forward(request, response);
			}
			
			//View Land Mark Details
			if(submit.equals("View LandMark"))
			{
				String []chk=request.getParameterValues("chk");
				
				if(chk==null)
				{
					rs=AdminDAO.getRoute();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/route_mark.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getRoute();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/route_mark.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					String routeId1 = chk[0];
					session.setAttribute("route_id",routeId);
					
					rs=AdminDAO.getLandMarks(routeId1);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/view_landmark.jsp");
					rd.forward(request,response);
				}
				
			}
			
			//Adding The Land Mark Details
			if(submit.equals("Add LandMark"))
			{
				
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("add")).equals("YES"))
				{
					String routeId1 = (String)session.getAttribute("route_busno");
					routeId = Utility.parse(routeId1);
					serialNumber = AdminDAO.getMaxSerialNumber(routeId);
					serialNumber = serialNumber+1;
					
					landMark = request.getParameter("land_mark");
					instruction = request.getParameter("inst");
					latitude = Double.parseDouble(request.getParameter("latitude"));
					longitude = Double.parseDouble(request.getParameter("longitude"));
					//voiceFile = request.getParameter("voice_file");
					
					flag = AdminDAO.checkLandMarkExistance(routeId1, landMark);
					
					if(!flag)
					{
						flag = AdminDAO.addRouteLandMark(routeId1, serialNumber, landMark,  latitude, longitude, instruction);;
						
						if(flag)
						{
							rs=AdminDAO.getRoute();
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/res/JSP/Admin/add_landmark.jsp?no=1");
							rd.forward(request, response);
						}
						else
						{
							rd=request.getRequestDispatcher("/res/JSP/Admin/add_landmark.jsp?no=2");
							rd.forward(request, response);
						}
							 
					}
					else
					{
						rd=request.getRequestDispatcher("/res/JSP/Admin/add_landmark.jsp?no=3");
						rd.forward(request, response);
					}
					
				}
				else if(chk==null)
				{
					rs=AdminDAO.getRoute();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/route_mark.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getRoute();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/route_mark.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					String routeId1 = chk[0];
					session.setAttribute("route_busno",routeId1);
					
					rd=request.getRequestDispatcher("/res/JSP/Admin/add_landmark.jsp");
					rd.forward(request, response);
				}
				
			}
			
			//Updating The Land Mark Details
			if(submit.equals("Update LandMark"))
			{
				String routeId1 = (String)session.getAttribute("route_busno");
				
				String []chk=request.getParameterValues("chk");
				
				if(Utility.parse1(request.getParameter("update")).equals("YES"))
				{
					//routeId = (Integer)session.getAttribute("route_id");
					String id = request.getParameter("id");
					serialNumber = Integer.parseInt(request.getParameter("sl_no"));
					
					landMark = request.getParameter("land_mark");
					instruction = request.getParameter("inst");
					String lat = request.getParameter("latitude");
					String lon = request.getParameter("longitude");
					//voiceFile = request.getParameter("voice_file");
					
					ArrayList<String> list = new ArrayList<String>();
					list.add(id);
					list.add(landMark);
					
					list.add(lat);
					list.add(lon);
					list.add(instruction);
					
					flag = AdminDAO.updateLandMarkDetails(list);
					if(flag)
					{
						rs=AdminDAO.getLandMarks(routeId1);
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/view_landmark.jsp?no=5");
						rd.forward(request,response);
					}
					else
					{
						rs=AdminDAO.getSpecificLandMark(routeId1, serialNumber);
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/edit_landmark.jsp?no=2");
						rd.forward(request, response);
					}
						
				}
				else if(chk==null)
				{
					rs=AdminDAO.getLandMarks(routeId1);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/view_landmark.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getLandMarks(routeId1);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/view_landmark.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					serialNumber = Integer.parseInt(chk[0]);
					rs=AdminDAO.getSpecificLandMark(routeId1, serialNumber);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/edit_landmark.jsp");
					rd.forward(request, response);
				}
			}
			
			//
			if(submit.equals("Delete LandMark"))
			{
				String routeId1 = (String)session.getAttribute("route_busno");
				
				String []chk=request.getParameterValues("chk");
				//System.out.println("Selected : " + Arrays.toString(chk));
				for(int i=0;i<chk.length;i++)
				{
					serialNumber = Integer.parseInt(chk[i]);
					AdminDAO.deleteLandMarkDetails(routeId1,serialNumber);
				}
				
				rs=AdminDAO.getLandMarks(routeId1);
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/view_landmark.jsp?no=3");
				rd.forward(request,response);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin LandMarkList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin LandMarkList Servlet : "+e);
		}
	}
}
