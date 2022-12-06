<!DOCTYPE html>

<%@page import="com.dev.dao.UserDAO"%>
<%@page import="com.dev.dao.AdminDAO"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<html xmlns='http://www.w3.org/1999/xhtml'>
<head>
	<title>Google Maps Latitude and Longitude Picker jQuery plugin</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/CSS/demo.css"/>

	<!-- Dependencies: JQuery and GMaps API should be loaded first -->
	<script src="<%=request.getContextPath()%>/res/JS/jquery-1.7.2.min.js"></script>
	<script src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

	<!-- CSS and JS for our code -->
	<link href="<%=request.getContextPath() %>/res/CSS/templatemo_style.css" rel="stylesheet" type="text/css" /> 
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/res/CSS/jquery-gmaps-latlon-picker.css"/>
	<script src="<%=request.getContextPath()%>/res/JS/jquery-gmaps-latlon-picker.js"></script>
</head>

<%!
        ResultSet rs = null;
		String busRouteNumber="";
		double latitude=0,longitude=0;
%>

<%
		String bno = request.getParameter("busno");

		System.out.println("Bus Route No. : " + bno);

		
		latitude = UserDAO.getBusLatitude(bno);
		longitude = UserDAO.getBusLongitude(bno);
        System.out.println("---------------- Bus Location Info ----------------");
        System.out.println("Bus Route No. : " + bno);
        System.out.println("Latitude : " + latitude);
        System.out.println("Longitude : " + longitude);
        // Assigning The Default Value For Location Jayanagar
        if(latitude == 0)
        {
        	latitude = 12.931288;
        	System.out.println("Default Latitude : " + latitude);
        }
        if(longitude == 0)
        {
        	longitude = 77.587582;
        	System.out.println("Default Longitude : " + longitude);
        }
        
        
        System.out.println("----------------------------------------------------");
        
%>

<body>

	<H2 style="position: absolute;top: -30px;color: #DB7093;">View Location</H2>


	<fieldset class="gllpLatlonPicker">
	
	<!--  <input type="text" class="gllpSearchField">
		<input type="button" class="gllpSearchButton" value="search">
		!-->
		
		
		<div class="gllpMap" style="position: relative;width: 800px;height: 400px;">Google Maps</div>
		<br/>
		<font style="color: #DB7093;"></font>
			<input type="hidden" name="lat" class="gllpLatitude" value="<%=latitude%>"/>
			
			<input type="hidden" name="lon" class="gllpLongitude" value="<%=longitude %>"/>
		<input type="hidden" class="gllpZoom" value="5"/>
		
		<br/>
	</fieldset>

	

</body>
</html>
