<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Add Land Mark</title>
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<%-- Easy UI Validation (Starts) --%>	
<link href="<%=request.getContextPath() %>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<link href="<%=request.getContextPath() %>/res/CSS/popup.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/map.js"></script>

<%-- Easy UI Validation (Ends) --%>	

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>

<script
src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
</script>

<style type="text/css">
	
#file
{
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	-ms-border-radius: 3px;
	-o-border-radius: 3px;
	border-radius: 3px;
	-webkit-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-moz-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-ms-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-o-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-ms-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	
	border: 1px solid #c8c8c8;
	color: #777;
	font: 13px Helvetica, Arial, sans-serif;
	margin: 0 0 10px;
	padding: 5px 1px 5px 1px;
	width: 100px;
	
}

</style>
</head>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:15;left:190px;">
<%-- 
	<form name="frm" action="<%=request.getContextPath()%>/UploadFileAction"  method="post">
--%>
	
	<form name="frm" action="<%=request.getContextPath()%>/LandMarkList">
			
	<h1>Add Route Land Mark Details</h1>
	<table style="width: 500px;text-align: center;">
		
		<tr align="center">
	        <td>
	        		Land Mark<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="land_mark"  placeholder="Enter The Land Mark" class="easyui-validatebox"   required="required" title="Please,Enter The Land Mark."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		
		
		
		<tr align="center">
	        <td>
	        		Latitude<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
			        <%--
			        		pattern="^-?([0-8]?[0-9]|90)\.[0-9]{1,6}"
			        		It valids lat -90.XXXXXX to 90.XXXXXX
			        		Example : -85.123456
			         --%>
					<input type="text" id="x" name="latitude" placeholder="Enter The Latitude(x-asis)" class="easyui-validatebox"  pattern="^-?([0-8]?[0-9]|90)\.[0-9]{1,6}" required="required" title="Math The Format : -90.XXXXXX to 90.XXXXXX"/>
			</td>
			
			
			<td width="15px" style="position: relative;top: 25px;left: -20px">
				<input type="image"  src="<%=request.getContextPath()%>/res/Images/google_maps.png" onclick="return getMap();"></input>
			</td>
		<tr>	
		
		<tr align="center">
	        <td>
	        		Longitude<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
			        <%--
			        		pattern="-?((1?[0-7]?|[0-9]?)[0-9]|180)\.[0-9]{1,6}"
			        		It valids  lng -180.XXXXXX to 180.XXXXXX
			        		Example : -100.123456
			         --%>
					<input type="text" id="y" name="longitude" placeholder="Enter The Longitude(y-axis)" class="easyui-validatebox" required="required" pattern="-?((1?[0-7]?|[0-9]?)[0-9]|180)\.[0-9]{1,6}"   title="Match The Formate : -180.XXXXXX to 180.XXXXXX"/>
			</td>
			
			
			<td width="15px">
			</td>
		<tr>
		
		<tr align="center">
	        <td>
	        		Message<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="inst" placeholder="Land Mark Instruction" class="easyui-validatebox" required="required" title="Please,Enter The Land Mark Instruction."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		<tr align="center">
				<td colspan="3" align="center">
						<input  type="submit" name="action" value="Add LandMark" style="left:190px;width: 150px;"/>
						<input  type="hidden" name="add" value="YES" style="left:190px;width: 150px;"/>
				</td>
		</tr>
	</table>
	
	<%-- Getting Google Map Popup(Starts) --%>  
	<div id="light" class="white_content" > 
		<a href = "javascript:void(0)" onclick = "closelightbox()" style="float:right"><img src="<%=request.getContextPath()%>/res/Images/close.gif" alt="" /></a>
		
		<%--
				<div id="googleMap"  style="width:675px;height:300px;"></div>
		 --%>
		<div  id="googleMap" style="width:710px;height:510px;"></div>
		
    </div>
    <div id="fade" class="black_overlay"></div>
	 
	<%-- Getting Google Map Popup(Ends) --%>  
	</form><!-- form -->
	<div class="button">
		
	</div><!-- button -->
</section><!-- content -->

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<div class="info" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Land Mark Details Added Successfully......</p>
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
			<p>Sorry,This Land Mark Already Exists!!!!!</p>
		</div>			
<%
	}
%>

</body>
</html>