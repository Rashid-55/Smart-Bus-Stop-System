
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
public class UpdateGPSInfo extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		boolean flag = false;
		double latitude=0,longitude=0;
		String resp="",busRouteNumber="";
		
		PrintWriter out = response.getWriter();
		try 
		{
			busRouteNumber = request.getParameter("username");
			latitude = Utility.parseDouble(request.getParameter("latitude"));//Latitude
			longitude = Utility.parseDouble(request.getParameter("longitude"));//Longitude
			
			flag = UserDAO.updateBusGPSInfo(busRouteNumber, latitude, longitude);
			
			resp = Boolean.toString(flag);
			
			out.println(resp);//Returing Back The Response
			System.out.println("Update GPS Info Response : " + resp);
		}
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Android=>UpdateGPSInfo Srevlet : " );
			e.printStackTrace();
				
		}
	}
}
