

package com.dev.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.UserDAO;
import com.dev.util.Distance;
import com.dev.util.Utility;
import com.sun.org.apache.bcel.internal.generic.LADD;

@SuppressWarnings("serial")
public class GetBusCurrentLocation extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		boolean flag = false;
		ResultSet rs = null;
		double busLatitude=0,busLongitude=0;
		double latitude=0,longitude=0,distance=0;
		String landMark="";
		String resp="",dateTime="",studentRollNumber="",busRouteNumber="",alertMsg="",requestStatus="",busStatus="Active";
		ArrayList list = null;
		ArrayList<String> landMarkList=null;
		ArrayList<Double> distList = null;
		ArrayList<Double> latitudeList = null;
		ArrayList<Double> longitudeList = null;
		
		PrintWriter out = response.getWriter();
		try 
		{
			studentRollNumber = request.getParameter("username");
			
			dateTime = Utility.getDateTime();
			busRouteNumber = UserDAO.getBusRouteNumber(studentRollNumber);
			
			//Getting The Bus Current GPS Info
			busStatus = UserDAO.getBusStatus(busRouteNumber);
			if(busStatus.equals("Active") || busStatus.equals("Processing") )
			{
				//Getting The Bus Current GPS Info (Lat,Long)
				busLatitude = UserDAO.getBusLatitude(busRouteNumber);
				busLongitude = UserDAO.getBusLongitude(busRouteNumber);
				
				landMarkList = new ArrayList<String>();
				distList = new ArrayList<Double>();
				latitudeList = new ArrayList<Double>();
				longitudeList = new ArrayList<Double>();
				
				rs = UserDAO.getBusLandmarks(busRouteNumber);
				while(rs.next())
				{
					landMark = rs.getString(4);
					latitude = rs.getDouble(5);
					longitude = rs.getDouble(6);
					//Calculating The Distance Between Bus(Lat,Long) And LandMark(Lat,Long)
					distance = Distance.distFrom(busLatitude, busLongitude, latitude, longitude);
					
					System.out.println("Bus     (Latitude,Longitude) : ("+busLatitude+","+busLongitude+")");
					System.out.println("LandMark (Latitude,Longitude) : "+landMark+"("+latitude+","+longitude+")");
					System.out.println("Distance : "+ distance);
					
					landMarkList.add(landMark);
					latitudeList.add(latitude);
					longitudeList.add(longitude);
					distList.add(distance);
				}
				
				System.out.println("---------------------------------------------------");
				double minDistance = Collections.min(distList);
				int index = distList.indexOf(minDistance);
				landMark = landMarkList.get(index);
				alertMsg = "The Bus is nearby "+landMark+".";
				
				latitude = latitudeList.get(index);
				longitude = longitudeList.get(index);
				
				System.out.println("LandMark List : " + landMarkList);
				System.out.println("Distance List : " + distList);
				System.out.println("Min Distance : " + minDistance);
				System.out.println("Min Dist Index : "+index);
				System.out.println("Near By Location : " + landMark);
				
			}
			else
			{
				alertMsg = "Sorry,Bus is not running!!!!!";
			}
			
			//Updating The Alert Request Info
			requestStatus = "Completed";
			list = new ArrayList();
			list.add(dateTime);
			list.add(studentRollNumber);
			list.add(busRouteNumber);
			list.add(latitude);
			list.add(longitude);
			list.add(alertMsg);
			list.add(requestStatus);
			
			flag = UserDAO.updateStudentAlertRequestInfo(list);
			
			//resp = Boolean.toString(flag);
			
			out.println(alertMsg);//Returing Back The Response
			System.out.println("Response : " + alertMsg);
		}
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Android=>GetBusCurrentLocation Srevlet : " );
			e.printStackTrace();
		}
	}
}
