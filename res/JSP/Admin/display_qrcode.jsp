<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Investigator Home</title>

<link href="<%=request.getContextPath() %>/res/CSS/list.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>

</head>
<%
	String fileName = Utility.parse1(request.getAttribute("file_name"));
%>
<body onload="startTimer()">

<section id="content">

<form action="<%=request.getContextPath()%>/BuildingList">	

<h1 id="wrapper">QR Code Image For Building Plan</h1>

<div style="position:relative;width:640px;height:400px;top:-125px;">
		<div style="position: relative;top:111;left:250px;">
			<input type="submit" name="action" value="Save QRCode"  id="button" style="width:121px; "/>&nbsp;&nbsp;
			<input type="submit" name="action" value="Cancel"  id="button" style="width:121px; "/>&nbsp;&nbsp;
		</div>
		
		<div style="position: relative;top:175;left:75px;">
				<img alt="QRCode" src="<%=request.getContextPath()%>/Files/QRCodes/<%=fileName%>" width="150" height="150">
		</div>
</div>	
	
<div class="footer"></div>
</form>
</section>	

<%
	if(Utility.parse(request.getParameter("no"))==1)
    {
%>
    	<div class="success" id="message" style="position:absolute;top:421px;left:11px">	
    		<p>QRCode Generated Successfully.....</p>
    	</div>			
<%
    }
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opp's something went wrong.....!</p>
		</div>			
<%
	}
%>
</body>
</html>