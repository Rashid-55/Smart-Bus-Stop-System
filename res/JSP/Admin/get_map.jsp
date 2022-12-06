<!DOCTYPE html>

<%--
		Reverse Geocoding (Address Lookup)
 --%>

<%@page import="com.dev.dao.UserDAO"%>
<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<html>
<head>
<title>View Map</title>

<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyByHt0Rn3cnw6t-IIWO18CR0Wv0QX1v6tk&sensor=false">
</script>
<%!
        ResultSet rs = null;
		String busRouteNumber="";
		double latitude=0,longitude=0;
%>

<%
		String bno = request.getParameter("busno");

		System.out.println("Bus Route No. : " + bno);

		busRouteNumber = (String)request.getAttribute("bno");
		latitude = UserDAO.getBusLatitude(busRouteNumber);
		longitude = UserDAO.getBusLongitude(busRouteNumber);
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

<script type="text/javascript">


function getMap()
{
      //var latitude = 12.931288;
      //var longitude = 77.587582;
      
      var latitude = '<%=latitude%>';
      var longitude = '<%=longitude%>';
      
         //alert("Lat : " +latitude+"\nLog : " + longitude);
      if((latitude == null || latitude == "") && (longitude == null || longitude == ""))
      {
    	  alert("Please,Enter The Latatude and Longitude.");
	  }
	  else
	  {
		     // Getting The Address Based On Latitude And Longitude(Starts)
		     	var latlng = new google.maps.LatLng(latitude,longitude);
		     
		     	var geo = new google.maps.Geocoder;
				geo.geocode({'latLng': latlng},function(results, status){
			    if (status == google.maps.GeocoderStatus.OK) 
			    {              
			    	 var address = results[0].formatted_address;
			    	 //alert("Address : " + address);
			    	 
			    	 //View Map
			    	 initialize(latitude,longitude,address);
			    	 
			    	 /*
			    	 var address1 = results[1].formatted_address;
			    	 var address2 = results[2].formatted_address;
			    	 var address3 = results[3].formatted_address;
			    	 var address4 = results[4].formatted_address;
			    	 var address5 = results[5].formatted_address;
			    	 var address6 = results[6].formatted_address;
			    	 var address7 = results[7].formatted_address;
				     alert("Address : " + address+"\n"+address1+"\n"+address2+"\n"+address3+"\n"+address4+"\n"+address5+"\n"+address6+"\n"+address7);
				     */
			    }
			    else
			    {
			        alert("Geocode was not successful for the following reason: " + status);
			    }
			});
		     
		     // Getting The Address Based On Latitude And Longitude(Ends)
		     
		    
	       
	  }

	return false;
}

//Displaying The Map	
function initialize(lat,lng,address)
{
    //var lat = 12.931288;
    //var lng = 77.587582;
    
    var myCenter=new google.maps.LatLng(lat,lng);
	
    var mapProp = 
    {
 		 center:myCenter,
 		 //zoom:5,
  		 zoom:12,
  		 mapTypeId:google.maps.MapTypeId.ROADMAP
  	};

	var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

	var marker=new google.maps.Marker({position:myCenter,});
	marker.setMap(map);
	
	var infowindow = new google.maps.InfoWindow({content:"Address :<br>"+address});
	google.maps.event.addListener(marker, 'click', function()
	{
		infowindow.open(map,marker);
	});
	
}
	
	
</script>
</head>
<body onload="getMap()">

<div id="googleMap" style="width:965px;height:640px;top:0px;left:0px;"></div>
	
</body>
</html>