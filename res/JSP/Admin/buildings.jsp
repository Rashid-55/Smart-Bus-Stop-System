<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="com.dev.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>View Buildings</title>

<link href="<%=request.getContextPath() %>/res/CSS/list.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/list1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/pagination.js"></script>

</head>

<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
%>

<body onload="startTimer()">
<section id="content">
<form action="<%=request.getContextPath()%>/BuildingList">	

<h1>View Building Details</h1>

<div style="position:relative;width:800px;height:375px;">

<div style="position: relative;top: -15px;left:150px;">
	
	<input type="submit" name="action" value="Add"  id="button" style="width:100px; "/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Genereate QRCode"  id="button" style="width: 150px;"/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Edit" id="button" style="width:100px;"/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Delete" id="button" style="width:100px;"/>&nbsp;&nbsp;
</div>

<table id="results" class="tab" align="center">
	<tr>
		<th>Select</th>
		<th>Short Name</th>
		<th>Building Name</th>
		<th>Plane Image</th>
		<th>Latitude</th>
		<th>Longitude</th>
		<th>Bulding City</th>
		<th>Bulding Address</th>
		
		
	</tr>
	<%
	if(rs!=null)
		while(rs.next())
		{%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=rs.getInt(1)%>"></td>
		        <td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(10)%></td>
				<td><%=rs.getDouble(8)%></td>
				<td><%=rs.getDouble(9)%></td>
				<td><%=rs.getString(5)%></td>
				<td><%=rs.getString(6)%></td>
			</tr>
		<%}
	%>
</table>

</div>	
	
<div class="footer" id="pageNavPosition" style="cursor:hand"></div>
	
<script type="text/javascript"><!--
       var pager = new Pager('results',5); 
       pager.init(); 
       pager.showPageNav('pager', 'pageNavPosition'); 
       pager.showPage(1);
   //--></script>
   
</form><!-- form -->   
</section>

<%
	if(Utility.parse(request.getParameter("no"))==1)
    {
%>
    	<div class="success" id="message" style="position:absolute;top:421px;left:11px">	
    		<p>Building Details Added Successfully.....!</p>
    	</div>			
<%
    }
	if(Utility.parse(request.getParameter("no"))==-1)
	{
%>
		<div class="success" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opp's something went wrong.....!</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opp's select atleast one record ....!</p>
		</div>			
	<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>
		<div class="success" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Building Details Deleted Successfully.....!</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==4)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opp's Select only one record ....!</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==5)
	{
%>
		<div class="success" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Building Details Updated Successfully....!</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==6)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opp's Something Went Wrong!!!!!</p>
		</div>			
<%
	}
%>		

</body>
</html>