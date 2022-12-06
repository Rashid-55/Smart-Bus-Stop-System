<%@page import="com.dev.dao.UserDAO"%>
<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Add Student</title>
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/tcal.css" rel="stylesheet" type="text/css" />
	
<link href="<%=request.getContextPath()%>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/tcal.js"></script>

<%-- 
 <!-- Core files For jQuery Alert Dialog -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/jquery.alerts.css" type="text/css"/>
	<script src="<%=request.getContextPath() %>/res/JS/jquery.alerts.js" type="text/javascript"></script>
<!-- Dependencies For jQuery Alert Dialog-->

<script type="text/javascript">
	
	$(document).ready( function() {
		
		$("#alert_button").click( function()
			{
			    var f = document.frm.file.value;
			    if(f==null || f=="")
			  	{
			    	jAlert('Please,Browse File To Upload.', 'Alert Dialog');
			    	return false;
			    }
				return true;
			}
		);
		
		$("#confirm_button").click( function() {
			jConfirm('Can you confirm this?', 'Confirmation Dialog', function(r) {
				jAlert('Confirmed: ' + r, 'Confirmation Results');
			});
		});
		
		$("#prompt_button").click( function() {
			jPrompt('Type something:', 'Prefilled value', 'Prompt Dialog', function(r) {
				if( r ) alert('You entered ' + r);
			});
		});
		
		$("#alert_button_with_html").click( function() {
			jAlert('You can use HTML, such as <strong>bold</strong>, <em>italics</em>, and <u>underline</u>!');
		});
		
		$(".alert_style_example").click( function() {
			$.alerts.dialogClass = $(this).attr('id'); // set custom style class
			jAlert('This is the custom class called &ldquo;style_1&rdquo;', 'Custom Styles', function() {
				$.alerts.dialogClass = null; // reset to default
			});
		});
		
	}
	);
	
</script>
--%>

<%
ResultSet rs = UserDAO.getBusno();

ResultSet rs1 = UserDAO.getLandmark();




%>
</head>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:100px;">
	<form name="frm" action="<%=request.getContextPath()%>/StudentList">
			
	<h1>Add Customer Details</h1>
	<table style="width: 700px;text-align: center;">
		
		<tr align="center">
	        <td>
	        		Customer No<font color="red" size="3">*</font>
	        </td>
	        
	        <td width="5px">:</td>
	        
			<td>
					<input type="text" name="roll_no"  class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Roll Number."/>
			</td>
			
			
			<td width="5px"></td>
			
			<td>
	        		Age<font color="red" size="3">*</font>
	        </td>
	        
	        <td width="5px">:</td>
	        
			<td>
					<input type="text" name="class"  class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Section of Class."/>
			</td>
			
			
			<td width="5px"></td>
		<tr>	
		<tr align="center">
	        <td>
	        		Name<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="name"  class="easyui-validatebox" required="required" autofocus required  title="Please,Enter The Name."/>
			</td>
			
			
			<td width="15px"></td>
			
			<td>
	        		Gender<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	       <td>
					
					<select name="gender">
					<option value="Select">-Select-</option>
					<option value="Male">Male</option>
					<option value="Female">Female</option>
					</select>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		<tr align="center">
	       
	        <td>
	        		Date of Birth<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="dob" class="tcal" />
			</td>
			
			
			<td width="15px"></td>
			
			 <td>
	        		Cell No<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="cell_no"  class="easyui-validatebox" required="required"  title="Please,Enter The Cell Number."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		
		<tr align="center">
	        
	         <td>
	        		Father Name<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="fa_name"  class="easyui-validatebox" required="required"  title="Please,Enter The Father Name."/>
			</td>
			
			
			<td width="15px"></td>
			
			 <td>
	        		Mother Name<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="mo_name"  class="easyui-validatebox" required="required"  title="Please,Enter The Mother Name."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		<%-- <tr align="center">
	       
	       <td>
	        		Bus No<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        <td>
			<select name="busno">
					<option value="Select">-Select-</option>
					<%
					while(rs.next())
					{
						%>
						<option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
						<%
					}
					
					%>
					</select></td>
			
			<td width="15px"></td>
			 <td>
	        		Land Mark <font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<select name="landmark">
					<option value="Select">-Select-</option>
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
		<tr>
		
		<tr align="center">
	       
	       <td>
	        		Address<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        <td>
	        <textarea name="address"></textarea>
			</td>
			
			<td width="15px"></td>
			
			<!-- <td>
	        		Password<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td> -->
	        
			<!-- <td>
					<input type="password" name="password"  class="easyui-validatebox" required="required"  title="Please,Enter Student Password."/>
			</td> -->
			 
		<tr>	
		
		<tr align="center">
				<td colspan="5" align="center">
						<input  type="submit" name="action" value="Add" style="left:250px;width: 100px;"/>
						<input type="hidden" name="add" value="YES" />
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
			<p>Student Details Added Successfully......</p>
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
			<p>Sorry,This Student Already Exists!!!!!</p>
		</div>			
<%
	}
%>

</body>
</html>