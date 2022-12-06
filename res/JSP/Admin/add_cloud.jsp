<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Add User</title>
<link href="<%=request.getContextPath() %>/res/CSS/form.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>

</head>
<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:150px;">
	<form action="<%=request.getContextPath()%>/CloudList">
			
	<h1>Add Cloud Details</h1>
	<table style="width: 500px;text-align: center;">
		<tr align="center">
				<td>Host Name </td>
				<td width="25px">:</td>
				<td>
						 <input type="text" name="host" placeholder="Enter The Server Host Name" required="required" title="Enter The Cloud Server Host Name." />
				</td>
		</tr>
		
		<tr align="center">
				<td>Username</td>
				<td width="25px">:</td>
				<td>
						 <input type="text" name="un"  placeholder="Enter The Server Username" required="required"  title="Enter The Cloud Server Username." />
				</td>
		</tr>
		
		<tr align="center">
				<td>Password</td>
				<td width="25px">:</td>
				<td>
						 <input type="text" name="pwd"  placeholder="Enter The Server Passwod" required="required"  title="Enter The Cloud Server Password." />
				</td>
		</tr>
		
		<tr align="center">
				<td>Directory</td>
				<td width="25px">:</td>
				<td>
						 <input type="text" name="dir"  placeholder="Directory To Upload/Download" />
				</td>
		</tr>
		
		<tr align="center">
				<td colspan="3" align="center">
						<input type="submit" name="action" value="Add" style="left: 175px;"/>
						<input type="hidden" name="add1" value="YES"></input>
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
		<div class="info" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Cloud Server Details Added Successfully.....</p>
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
			<p>Sorry,Server Hostname Already Exists</p>
		</div>			
<%
	}
%>

</body>
</html>