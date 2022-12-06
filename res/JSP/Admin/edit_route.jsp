<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Add Route</title>
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<%-- Easy UI Validation (Starts) --%>	
<link href="<%=request.getContextPath() %>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>
<%-- Easy UI Validation (Ends) --%>	

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>

</head>

<%!
	ResultSet rs = null;
	String busno=null;
	String routeName="",routeFrom="",routeTo="",buspwd="";
%>

<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	if(rs != null)
	{
		if(rs.next())
		{
			busno = rs.getString(1);
	   		 routeName = rs.getString(2);
	   		 routeFrom = rs.getString(3);
	   		 routeTo = rs.getString(4);
	   		buspwd = rs.getString(5);
	   		
		}
	}
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:190px;">
	<form name="frm" action="<%=request.getContextPath()%>/RouteList">
			
	<h1>Update Route Details</h1>
	<table style="width: 500px;text-align: center;">
		
		
		<tr align="center">
	        <td>
	        		Route Bus No<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="bus_no" value="<%=busno%>"  class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Route Name." readonly="readonly"/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		<tr align="center">
	        <td>
	        		Route Name<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="route_name" value="<%=routeName%>"  class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Route Name."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		<tr align="center">
	        <td>
	        		Route From<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="route_from" value="<%=routeFrom%>" class="easyui-validatebox" required="required"  title="Please,Enter The Route Starting Point."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		
		<tr align="center">
	        <td>
	        		Route To<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="route_to" value="<%=routeTo%>"  class="easyui-validatebox" required="required"  title="Please,Enter The Route Ending Point."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		<tr align="center">
	        <td>
	        		Route Bus Pwd<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="bus_pwd" value="<%=buspwd%>"  class="easyui-validatebox" required="required"  title="Please,Enter The Route Ending Point."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		
		<tr align="center">
				<td colspan="3" align="center">
						<input type="submit" value="Update" style="left: 201px;"/>
					    <input type="hidden" name="action" value="Edit"></input>
					    <input type="hidden" name="edit" value="YES"></input>
					    <input type="hidden" name="id" value="<%=busno%>"></input>
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
			<p>Route Details Updated Successfully......</p>
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