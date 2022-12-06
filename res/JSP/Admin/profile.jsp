<%@page import="javax.swing.CellEditor"%>
<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Investigator Profile</title>
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/tcal.css" rel="stylesheet" type="text/css" />
	
<link href="<%=request.getContextPath() %>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/tcal.js"></script>

<style type="text/css">
#data 
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
	/*
	border: 1px solid #c8c8c8;
	*/
	color: #777;
	font: 13px Helvetica, Arial, sans-serif;
	margin: 0 0 10px;
	padding: 10px 10px 10px 10px;
	width: 200px;
}
</style>

</head>

<%!
	ResultSet rs = null;
	String username="",password="",name="",gender="",address="",mobileNumber="", phoneNumber="",emailId="";
	int adminId = 0;
%>

<%
	 rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	 while(rs.next())
	 {
		 adminId = rs.getInt(1);
		 username = rs.getString(2);
		 password = rs.getString(3);
		 name = rs.getString(4);
		 gender = rs.getString(5);
		 mobileNumber = rs.getString(6);
		 phoneNumber = rs.getString(7);
		 emailId = rs.getString(8);
		 address = rs.getString(9);
		 
	 }
%>

<body onload="startTimer()">

<section id="content" style="position: absolute;top:50;left:300px;">
	<form action="<%=request.getContextPath()%>/AdminProfile">
			
	<h1>Admin Profile</h1>
	<table cellspacing="15" style="width: 650px;text-align: center;" >
		
	  <tr align="center">
	        <td>
	        		Username
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td  id="data">
					<%=username %>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Password
	        </td>
	        
	        <td>:</td>
	        
			<td  id="data">
					<%=password%>
			</td>
			
   	  </tr>
   	  
   	  
   	  <tr align="center">
	        <td>
	        		Name
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td  id="data">
					<%=name%>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Gender
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td  id="data">
				<%
					if(gender.equals("Male"))
					{
				%>
						<input type="radio" name="sex" value="Male" checked="checked">Male
   						<input type="radio" name="sex" value="Female"/>Female
				<%
					}
					else
					{
				%>
						<input type="radio" name="sex" value="Male">Male
							<input type="radio" name="sex" value="Female" checked="checked"/>Female
				<%
					}
				%>
					
			</td>
			
   	  </tr>
   	  
   	  <tr align="center">
	        <td>
	        		Mobile
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td  id="data">
					<%=mobileNumber %>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Phone
	        </td>
	        
	        <td>:</td>
	        
			<td  id="data">
					 <%=phoneNumber%>
			</td>
			
   	  </tr>
   	  
   	  
   	  <tr align="center">
	        <td>
	        		 Email Id
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td  id="data">
					<%=emailId%>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Address
	        </td>
	        
	        <td>:</td>
	        
			<td  id="data">
					<%=address%>
			</td>
			
   	  </tr>
   	  
	  <tr align="center">
			<td colspan="3" align="center">
					<input type="submit" name="action" value="Update Profile" style="left: 275px;"/>
			</td>
	 </tr>
	
	</table>
	   
	</form><!-- form -->
	<div class="button">
		
	</div><!-- button -->
</section><!-- content -->

<div align="center" style="position:absolute;left:395px; ;top:10px;">
	<img src="<%=request.getContextPath()%>/res/Images/admin.png" width="75" height="75" alt="Home" />	
</div>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<div class="info" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Admin Profile Updated Successfully.....</p>
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