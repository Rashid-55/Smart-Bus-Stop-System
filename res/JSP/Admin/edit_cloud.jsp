<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Update Cloud</title>
<link href="<%=request.getContextPath() %>/res/CSS/form.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>

</head>

<%
	ResultSet rs=(ResultSet)request.getAttribute("rs");
	int cloudId=0;
	String hostName="",username="",password="",dir="";
	while(rs.next())
	{
		cloudId=rs.getInt(1);
		hostName=rs.getString(2);
		username=rs.getString(3);
		password=rs.getString(4);
		dir=rs.getString(5);
	}
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:125px;">
	<form action="<%=request.getContextPath()%>/CloudList">
			
	<h1>Update Cloud Details</h1>
	<table style="width: 500px;text-align: center;">
		<tr align="center">
				<td>Host Name </td>
				<td width="25px">:</td>
				<td>
						 <input type="text" name="host" value="<%=hostName%>" required="required" title="Enter The Cloud Server Host Name." />
				</td>
		</tr>
		
		<tr align="center">
				<td>Username</td>
				<td width="25px">:</td>
				<td>
						 <input type="text" name="un"  value="<%=username%>" required="required"  title="Enter The Cloud Server Username." />
				</td>
		</tr>
		
		<tr align="center">
				<td>Password</td>
				<td width="25px">:</td>
				<td>
						 <input type="text" name="pwd"  value="<%=password%>" required="required"  title="Enter The Cloud Server Password." />
				</td>
		</tr>
		
		<tr align="center">
				<td>Directory</td>
				<td width="25px">:</td>
				<td>
						 <input type="text" name="dir"  value="<%=dir%>" />
				</td>
		</tr>
		
		<tr align="center">
				<td colspan="3" align="center">
						<input type="submit" value="Update" style="left: 175px;"/>
						<input type="hidden" name="action" value="Edit"></input>
						<input type="hidden" name="edit1" value="YES"></input>
						<input type="hidden" name="id" value="<%=cloudId%>"></input>
				</td>
		</tr>
	</table>
	   
	</form><!-- form -->
	<div class="button">
		
	</div><!-- button -->
</section><!-- content -->

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Sorry,Server Hostname Already Exists</p>
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
%>

</body>
</html>