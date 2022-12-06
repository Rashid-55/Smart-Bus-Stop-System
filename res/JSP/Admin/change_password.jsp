<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Change Password</title>
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<%-- Easy UI Validation (Starts) --%>	
<link href="<%=request.getContextPath() %>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>
<%-- Easy UI Validation (Ends) --%>	

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>

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
</head>

<%!
	String username = "";
%>

<%
	username = (String)session.getAttribute("username");		
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:350px;">
	<form name="frm" action="<%=request.getContextPath()%>/ChangePassword">
			
	<h1>Change Password</h1>
	<table style="width: 500px;text-align: center;">
		
		<tr align="center">
	        <td>
	        		Username<font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="username" value="<%=username%>" class="easyui-validatebox" required="required" readonly="readonly" autofocus required pattern="[a-zA-Z0-9_-]{5,12}" title="Must be alphanumeric in 5-12 chars."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		<tr>	
			<td>
	        		New Password<font color="red" size="4">*</font>
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="password" name="npass" placeholder="Enter Your Password" class="easyui-validatebox" required="required" pattern="[a-zA-Z0-9_-]{5,25}" title="Must be alphanumeric and special char in 5-25 chars."/>
			</td>
			
   	    </tr>
		
		
		<tr>	
			<td>
	        		Confirm Password<font color="red" size="4">*</font>
	        </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="password" name="cpass" placeholder="Enter Your Confirm Password" class="easyui-validatebox" required="required" pattern="[a-zA-Z0-9_-]{5,25}" title="Confirm Password Must be alphanumeric and special char in 5-25 chars."/>
			</td>
			
   	    </tr>
		
		
		<tr align="center">
				<td colspan="3" align="center">
						<input  type="submit"  value="Change Password" style="left:175px;width: 175px;"/>
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
			<p>Password Changed Successfully......</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>
		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>New and Confirm Password Must be Same!!!!!</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
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