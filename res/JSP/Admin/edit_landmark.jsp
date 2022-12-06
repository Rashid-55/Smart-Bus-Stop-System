<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Update Land Mark</title>
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
	ResultSet rs= null;
    int id=0,serialNumber=0;
	double latitude=0,longitude=0;
	String landMark="",instruction="",message="",routeId="";
%>
<%
	rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	if(rs!=null)
		while(rs.next())
		{
			id = rs.getInt(1);
			routeId = rs.getString(3);
			serialNumber = rs.getInt(3);
			landMark = rs.getString(4);
			
			latitude = rs.getDouble(5);
			longitude = rs.getDouble(6);
			message = rs.getString(7);
		}
		
    
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:15;left:190px;">
	<form name="frm" action="<%=request.getContextPath()%>/LandMarkList">
			
	<h1>Update Route Land Mark Details</h1>
	<table style="width: 500px;text-align: center;">
		
		<tr align="center">
	        <td>
	        		Land Mark<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="land_mark"  value="<%=landMark%>" class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Land Mark."/>
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
					<input type="text" name="latitude" value="<%=latitude%>" class="easyui-validatebox" required="required" pattern="^-?([0-8]?[0-9]|90)\.[0-9]{1,6}"  title="Please,Enter The Valid Latitude(x-axis)."/>
			</td>
			
			
			<td width="15px"></td>
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
					<input type="text" name="longitude" value="<%=longitude%>" class="easyui-validatebox" pattern="-?((1?[0-7]?|[0-9]?)[0-9]|180)\.[0-9]{1,6}" required="required"   title="Please,Enter The Valid Longitude(y-axis)."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		
		<tr align="center">
	        <td>
	        		Message<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="inst" value="<%=message%>" class="easyui-validatebox" required="required"  title="Please,Enter The Land Mark Instruction."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		<tr align="center">
				<td colspan="3" align="center">
						<input  type="submit" name="action" value="Update LandMark" style="left:190px;width: 150px;"/>
						<input type="hidden" name="update" value="YES" />
						<input type="hidden" name="id" value="<%=id%>"></input>
						<input type="hidden" name="sl_no" value="<%=serialNumber%>"></input>
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