<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>

<%@page import="com.dev.dao.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Update Student</title>
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
	int stu_code=0,landid=0;
	public String rollno="",sclass="",name="",dob="",gender="",address="",mobileNumber="",fname1="",mname="",busno="";
%>

<%

ResultSet rs1 = UserDAO.getBusno();

ResultSet rs2 = UserDAO.getLandmark();


	rs = (ResultSet)request.getAttribute("rs");
    if(rs != null)
    {
    	if(rs.next())
    	{
    		stu_code = rs.getInt(1);
    		rollno = rs.getString(2);
    		sclass = rs.getString(3);
	   		 name = rs.getString(4);
	   		 gender = rs.getString(5);
	   		 dob = rs.getString(6);
	   		 mobileNumber = rs.getString(7);
	   		fname1 = rs.getString(8);
	   		mname = rs.getString(9);
	   		 address = rs.getString(10);
	   		busno = rs.getString(11);
	   		landid = rs.getInt(12);
    		
    	}
    }
    
    String lmk = UserDAO.getLM(landid);
    
    String fnm = fname1;
    System.out.println("fname :"+fname1+"."+fnm);
   
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:50;left:90px;">
	<form action="<%=request.getContextPath()%>/StudentList">
			
	<h1>Update Customer Details</h1>
	<table style="width: 650px;text-align: center;">
		
	  <tr align="center">
	        <td>
	        		Customer No<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="roll_no"  value="<%=rollno%>" class="easyui-validatebox" required="required"  autofocus required pattern="[a-zA-Z0-9_-]{5,12}" title="Must be alphanumeric in 5-12 chars."/>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Age<font color="red" size="4">*</font>
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="ssec" value="<%=sclass%>" class="easyui-validatebox" required="required"  title="Must be alphanumeric and special char in 5-25 chars."/>
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
					<input type="text" name="name" value="<%=name%>" class="easyui-validatebox" required="required" pattern="[a-zA-z ]*" title="Numbers are not allowed." readonly="readonly"/>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Date Of Birth
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="dob" class="tcal" value="<%=dob%>" readonly="readonly"/>
			</td>
			
   	  </tr>
   	  
   	   <tr align="center">
	        <td>
	        		Gender
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<%
						if(gender.equals("Male"))
						{
					%>
							<input type="radio" name="gender" value="Male" checked="checked">Male
							<input type="radio" name="gender" value="Female"/>Female
					<%
						}
						else
						{
					%>
							<input type="radio" name="gender" value="Male" >Male
						    <input type="radio" name="gender" value="Female" checked="checked"/>Female
					<%
						}
					%>
			</td>
			
   	  </tr>
   	  
   	  
   	  
   	  <tr align="center">
	        <td>
	        		Cell No<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="cell_no" value="<%=mobileNumber%>" class="easyui-numberbox" required="yes" pattern="[0-9]{10}" title="Must be 10 digits numeric numbers. "/>
			</td>
			
			
			<td width="15px"></td>
			
			
			<td>
	        		Father Name
	        </td>
	      
			 <td>:</td>
			 
			<td>
					 <input type="text" value="<%=fnm%>" name="fname"  readonly="readonly"/>
			</td>
			
   	  </tr>
   	  
   	  
   	  <tr align="center">
	        <td>
	        		 Mother Name
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="mname" value="<%=mname%>" class="easyui-validatebox" required="required" data-options="validType:'email'" readonly="readonly"/>
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
   	  
   	  <%-- <tr align="center">
	        <td>
	        		 Bus No
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<select name="busno">
					<option value="<%=busno%>"><%=busno%></option>
					<%
					while(rs1.next())
					{
						%>
						<option value="<%=rs1.getString(1)%>"><%=rs1.getString(1)%></option>
						<%
					}
					
					%>
					</select>
			
			</td> --%>
			
			
			<td width="15px"></td>
			
			
			<%-- <td>
	        		Land Mark
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<select name="landmark">
					<option value="<%=lmk%>"><%=lmk%></option>
					<%
					while(rs2.next())
					{
						%>
						<option value="<%=rs2.getString(1)%>"><%=rs2.getString(1)%></option>
						<%
					}
					
					%>
					</select>
			
			
			</td>
			 --%>
   	  </tr>
   	  
   	  
   	  
	  <tr align="center">
			<td colspan="3" align="center">
					<input type="submit" value="Update" style="left: 275px;"/>
					<input type="hidden" name="action" value="Edit"></input>
					<input type="hidden" name="edit1" value="YES"></input>
					<input type="hidden" name="id" value="<%=stu_code%>"></input>
			</td>
	 </tr>
	
	</table>
	   
	</form><!-- form -->
	<div class="button">
		
	</div><!-- button -->
</section><!-- content -->

<div align="center" style="position:absolute;left:401px; ;top:10px;">
	<img src="<%=request.getContextPath()%>/res/Images/user.png" width="75" height="75" alt="User" />	
</div>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>User Profile Updated Sucessfully.....</p>
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