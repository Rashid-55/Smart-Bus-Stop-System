<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="com.dev.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Existing Routes</title>

<link href="<%=request.getContextPath() %>/res/CSS/list.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/list1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/pagination.js"></script>

<!-- Core files For jQuery Alert Dialog -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/jquery.alerts.css" type="text/css"/>
	<script src="<%=request.getContextPath() %>/res/JS/jquery.alerts.js" type="text/javascript"></script>
<!-- Dependencies For jQuery Alert Dialog-->

<script type="text/javascript">
		function confirm()
		{
			var chks = document.getElementsByName("chk");
			//alert("Value : " + chks.length)
			
			var hasChecked = false;
			for (var i = 0; i < chks.length; i++)
			{
				if (chks[i].checked)
				{
					hasChecked = true;
					break;
				}
			}
			if (hasChecked == false)
			{
				jAlert("Please Select Atleast One Record To Delete.",'Alert Dialog');
				return false;
			}
			
			if(hasChecked == true)
			{
				var selected="";
				for (var i = 0; i < chks.length; i++)
				{
					if (chks[i].checked)
					{
						selected += chks[i].value+",";
					}
				}
				//Deleting The Last char
				selected = selected.substring(0, selected.length - 1);
				
				jConfirm('Do You Want To Delete?\nRoute(s) Having Route BusNo   : '+selected, 'Confirmation Dialog', function(r) 
					{
						//jAlert('Confirmed: ' + r, 'Delete Confirmation');
						if(r)
						{
							//Submmiting The form
							document.myForm.submit();
						}
						else
						{
							//Unchecking The Checked Check Boxes
							for (var i = 0; i < chks.length; i++)
							{
								if (chks[i].checked)
								{
									chks[i].checked = false;
								}
							}
						}
						
					});
			}
			return false;
			
		}
</script>

</head>

<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
%>

<body onload="startTimer()">

<section id="content">
<form name="myForm" action="<%=request.getContextPath()%>/RouteList">	

<h1>View Route Details</h1>

<div style="position:relative;width:600px;height:375px;">

<div style="position: relative;top: -15px;left: 325px;">
	 
	<input type="submit" name="action" value="Add Route"  id="button" style="width:100px; "/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Edit" id="button" style="width:100px;"/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Delete" id="button" style="width:100px;" onclick="return confirm()" />&nbsp;&nbsp;
	
	<input type="hidden" name="action" value="Delete"/>
</div>

<table id="results" class="tab" align="center">
	<tr>
		<th>Select</th>
		<th>Bus No</th>
		<th>Route Name</th>
		<th>Route From</th>
		<th>Route To</th>
		<th>Bus Pwd</th>
		
		
	</tr>
<%
	if(rs!=null)
		while(rs.next())
		{
%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=rs.getString(1)%>"></td>
				
				<td><%=rs.getString(1)%></td>
		        <td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(5)%></td>
			</tr>
<%
		}
%>
</table>

</div>	
	
<div class="footer" id="pageNavPosition" style="cursor:hand"></div>
	
<script type="text/javascript"><!--
       var pager = new Pager('results',9); 
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
    		<p>Route Details Added Successfully.....!</p>
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
			<p>Route Details Deleted Successfully.....!</p>
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
			<p>Route Details Updated Successfully....!</p>
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