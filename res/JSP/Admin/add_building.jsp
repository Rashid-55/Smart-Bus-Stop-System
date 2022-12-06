<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Add Building</title>
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/tcal.css" rel="stylesheet" type="text/css" />
	
<link href="<%=request.getContextPath() %>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/tcal.js"></script>


<script
src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
</script>


<script>
var map;
var myCenter=new google.maps.LatLng(12.931288,77.587582);

function initialize()
{
var mapProp = {
  center:myCenter,
  //zoom:5,
  zoom:12,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };

  map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
 
  //var marker=new google.maps.Marker({position:myCenter,});
  //marker.setMap(map);
  
  google.maps.event.addListener(map, 'click', function(event)
  {
    placeMarker(event.latLng);
  });
}

function placeMarker(location) 
{
	  var marker = new google.maps.Marker({
	    position: location,
	    map: map,
		});
 
	  var infowindow = new google.maps.InfoWindow(
	  {
	    	content: 'Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng()
	  });
 	 infowindow.open(map,marker);
 	 
 	 //Setting The Latitude and Longitude Value in Input Field
 	 document.getElementById("x").value = location.lat();
 	 document.getElementById("y").value = location.lng();
 	
}

// Loding The Map While Looding The Page
//Note: To load map on button clock just comment the line below and calll initiallize() on button click
google.maps.event.addDomListener(window, 'load', initialize);

</script>

</head>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:25;left:60px;">
	<form action="<%=request.getContextPath()%>/AddBuildingDetails" enctype="multipart/form-data" method="post">
			
	<h1>Add Bulding Details</h1>
	<table style="width: 750px;text-align: center;">
		
	  <tr align="center">
	        <td>
	        		Short Nane<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="short_name"  placeholder="Enter Building Short Name" class="easyui-validatebox" required="required"  autofocus required  title="Enter The Building Short Name."/>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Building Name<font color="red" size="4">*</font>
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="building_name" placeholder="Enter Building Name" class="easyui-validatebox" required="required"  title="Enter The Building Name."/>
			</td>
			
   	  </tr>
   	  
   	  
   	  <tr align="center">
	        <td>
	        		Building Plan Img<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="file" name="file" required="required" title="Enter The Building Plan Image Name." style="position: relative;left: 20px;"/>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Area
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="area" placeholder="Enter The Building Area" class="easyui-validatebox" title="Enter The Building Area."/>
			</td>
			
   	  </tr>
   	  
   	   <tr align="center">
	       
	       
	       <td>
	        		City<font color="red" size="4">*</font>
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="city" placeholder="Enter The Building City" class="easyui-validatebox" required="required"  title="Enter The Building City."/>
			</td>
	       
			<td width="15px"></td>
			
			<td>
	        		Address<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="address"  placeholder="Enter Building Address" class="easyui-validatebox" required="required"  title="Enter The Building Address."/>
			</td>
			
   	  </tr>
   	  
   	  
   	  <tr align="center">
	       
			<td>
	        		Descryption
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="desc" placeholder="Enter The Building Discryption" class="easyui-validatebox"  title="Enter The Building Discryption." style="height: 100px;"/>
			</td>
			
			<td width="15px"></td>
			
			<td colspan="2">
	        		Latitude <font color="red" size="4">*</font>
	        		<br><br>
	        		Longitude <font color="red" size="4">*</font>
	        </td>
	        
	       
	        
			<td>
					<input type="text" id="x" name="latitude"  placeholder="Enter The Latitude" class="easyui-validatebox" required="required"   title="Enter The Latitude."/>
					<br>
					<input type="text" id="y" name="longitude"  placeholder="Enter The Longitude" class="easyui-validatebox" required="required"  title="Enter The Longitude."/>
					<%-- 
					<input type="button" onclick="initialize()" value="Get Map" style="position: absolute;top:350px;left:620px;">
					--%>
			</td>
			
   	  </tr>
   	  
	  <tr align="center">
			<td colspan="3" align="center">
					<input type="submit" value="Add Building" style="left: 275px;"/>
			</td>
	 </tr>
	
	</table>
	   
	   
<%-- Getting The Map(Starts) --%>   

		<div id="googleMap" style="width:700px;height:400px;left:21px;"></div>

<%-- Getting The Map(Ends) --%>   
	   
	</form><!-- form -->
	<div class="button">
	</div><!-- button -->
</section><!-- content -->

<div align="center" style="position:absolute;left:401px; ;top:2px;">
	<img src="<%=request.getContextPath()%>/res/CSS/images/building.jpg" width="75" height="75" alt="User" />	
</div>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<div class="success" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Building Details Addedd Sucessfully.....</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opps,Something Went Wrong Try Again Latter!!!!!</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opps,The Building Already Exists,Provide Different Short Name!!!!!</p>
		</div>			
<%
	}
%>

</body>
</html>