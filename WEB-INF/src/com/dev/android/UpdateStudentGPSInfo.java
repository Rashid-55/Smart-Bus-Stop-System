

package com.dev.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.UserDAO;
import com.dev.util.Distance;
import com.dev.util.Utility;

@SuppressWarnings("serial")
public class UpdateStudentGPSInfo extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		boolean flag = false;
		double busLatitude=0,busLongitude=0;
		double latitude=0,longitude=0,distance=0;
		String resp="",dateTime="",studentRollNumber="",busRouteNumber="",alertMsg="",requestStatus="",busStatus="Active";
		ArrayList list = null;
		
		PrintWriter out = response.getWriter();
		try 
		{
			studentRollNumber = request.getParameter("username");
			latitude = Utility.parseDouble(request.getParameter("latitude"));//Latitude
			longitude = Utility.parseDouble(request.getParameter("longitude"));//Longitude
			
			dateTime = Utility.getDateTime();
			busRouteNumber = UserDAO.getBusRouteNumber(studentRollNumber);
			requestStatus = "Processing";
			
			//Updating The Alert Request Info
			list = new ArrayList();
			list.add(dateTime);
			list.add(studentRollNumber);
			list.add(busRouteNumber);
			list.add(latitude);
			list.add(longitude);
			list.add(alertMsg);
			list.add(requestStatus);
			
			flag = UserDAO.updateStudentAlertRequestInfo(list);
			
			//Getting The Bus Current GPS Info
			busStatus = UserDAO.getBusStatus(busRouteNumber);
			if(busStatus.equals("Active") || busStatus.equals("Processing"))
			{
				busLatitude = UserDAO.getBusLatitude(busRouteNumber);
				busLongitude = UserDAO.getBusLongitude(busRouteNumber);
			}
			//Calculating The Distance Between Bus(Lat,Long) And Student(Lat,Long)
			
			distance = Distance.distFrom(busLatitude, busLongitude, latitude, longitude);
			
			System.out.println("Bus     (Latitude,Longitude) : ("+busLatitude+","+busLongitude+")");
			System.out.println("Student (Latitude,Longitude) : ("+latitude+","+longitude+")");
			System.out.println("Distance : "+ distance);
			
			resp = Boolean.toString(flag);
			
			out.println(resp);//Returing Back The Response
			System.out.println("Update Student GPS Info Response : " + resp);
		}
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Android=>UpdateStudentGPSInfo Srevlet : " );
			e.printStackTrace();
		}
	}
}
