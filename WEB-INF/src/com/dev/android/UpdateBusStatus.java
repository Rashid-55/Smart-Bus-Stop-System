
package com.dev.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.UserDAO;
import com.dev.util.Utility;

@SuppressWarnings("serial")
public class UpdateBusStatus extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		boolean flag = false;
		String resp="",busRouteNumber="",busStatus="";
		
		PrintWriter out = response.getWriter();
		try 
		{
			busRouteNumber = request.getParameter("username");
			busStatus = request.getParameter("bus_status");
			
			flag = UserDAO.updateBusStatus(busRouteNumber,busStatus);;
			
			resp = Boolean.toString(flag);
			
			out.println(resp);//Returing Back The Response
			System.out.println("Update Bus Status Response : " + resp);
		}
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Android=>UpdateBusStatus Srevlet : " );
			e.printStackTrace();
				
		}
	}
}
