<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Update Investigator Profile</title>
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/tcal.css" rel="stylesheet" type="text/css" />
	
<link href="<%=request.getContextPath() %>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/tcal.js"></script>

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

<section id="content" style="position: absolute;top:50;left:110px;">
	<form action="<%=request.getContextPath()%>/AdminProfile">
			
	<h1>Update Investigator Profile</h1>
	<table style="width: 650px;text-align: center;">
		
	  <tr align="center">
	        <td>
	        		Username<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="username" value="<%=username%>" class="easyui-validatebox" required="required"  autofocus required pattern="[a-zA-Z0-9_-]{5,12}" readonly="readonly" title="Must be alphanumeric in 5-12 chars."/>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Password<font color="red" size="4">*</font>
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="password" name="password" value="<%=password%>" class="easyui-validatebox" required="required" pattern="[a-zA-Z0-9_-]{5,25}" title="Must be alphanumeric and special char in 5-25 chars."/>
			</td>
			
   	  </tr>
   	  
   	  
   	  <tr align="center">
	        <td>
	        		Name<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<%-- 
						In Name Only Characters and Space Are Allowed
						pattern="[a-zA-z ]*" //NB give one space after a-zA-Z in pattern  
					--%>
					<input type="text" name="name" value="<%=name%>" class="easyui-validatebox" required="required" pattern="[a-zA-z ]*" title="Numbers are not allowed." />
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Gender
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
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
	        		Mobile<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="mob" value="<%=mobileNumber%>" class="easyui-numberbox" required="yes" pattern="[0-9]{10}" title="Must be 10 digits numeric numbers. "/>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Phone
	        </td>
	        
	        <td>:</td>
	        
			<td>
					 <input type="text" name="phone"  value="<%=phoneNumber%>" class="easyui-numberbox" required="required" pattern="[0-9]{7,12}" title="Must be numeric numbers from 7 to 12 digits."/>
			</td>
			
   	  </tr>
   	  
   	  
   	  <tr align="center">
	        <td>
	        		 Email Id
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="email" value="<%=emailId%>" class="easyui-validatebox" required="required" data-options="validType:'email'" />
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Address
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="address" value="<%=address%>">
			</td>
			
   	  </tr>
   	  
	  <tr align="center">
			<td colspan="3" align="center">
					<input type="submit" name="action" value="Update" style="left: 275px;"/>
					<input type="hidden" name="id" value="<%=adminId%>"></input>
			</td>
	 </tr>
	
	</table>
	   
	</form><!-- form -->
	<div class="button">
		
	</div><!-- button -->
</section><!-- content -->

<div align="center" style="position:absolute;left:390px; ;top:10px;">
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