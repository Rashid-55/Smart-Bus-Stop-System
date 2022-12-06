<%@page import="com.dev.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>View Cloud</title>

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

<form action="<%=request.getContextPath()%>/CloudList">	

<h1>View Cloud Details</h1>

<div style="position:relative;width:640px;height:375px;">

<div style="position: relative;top: -15px;left: 300px;">
	<input type="submit" name="action" value="Add"  id="button" style="width:100px; "/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Edit" id="button" style="width:100px;"/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Delete" id="button" style="width:100px;"/>&nbsp;&nbsp;
</div>

<table id="results" class="tab" align="center">
	<tr>
		<th>Select</th>
		<th>ID</th>
		<th>Host Name</th>
		<th>Username</th>
		<th>Password</th>
		<th>Directory</th>
		
	</tr>
	<%
	if(rs!=null)
		while(rs.next())
		{%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=rs.getInt(1)%>"></td>
				        <td><%=rs.getInt(1) %></td>
						<td><%=rs.getString(2) %></td>
						<td><%=rs.getString(3) %></td>
						<td><%=rs.getString(4) %></td>
						<td><%=rs.getString(5) %></td>
			</tr>
		<%}
	%>
</table>

</div>	
	
<div class="footer" id="pageNavPosition" style="cursor:hand"></div>
	
<script type="text/javascript"><!--
       var pager = new Pager('results', 5); 
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
    		<p>Cloud Details Added Successfully.....!</p>
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
			<p>Opp's select atleast one.....!</p>
		</div>			
	<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>
		<div class="success" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Cloud Details Deleted Successfully.....!</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==4)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opp's Select only one cloud to edit....!</p>
		</div>			
	<%
}
	if(Utility.parse(request.getParameter("no"))==5)
	{
%>
		<div class="success" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Cloud Details Updated Successfully....!</p>
		</div>			
<%
	}
%>		

</body>
</html>