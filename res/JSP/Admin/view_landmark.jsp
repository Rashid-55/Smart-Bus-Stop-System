<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="com.dev.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>View Land Mark</title>

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
				
				jConfirm('Do You Want To Delete?\nLandMark(s) Having Sl. No. : '+selected, 'Confirmation Dialog', function(r) 
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
<%!
	String routeId = null;
	String routeName = "";
%>
<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
    int count = 0;
    routeId = (String)session.getAttribute("route_busno");
    routeName = AdminDAO.getRouteName(routeId);
    
    
%>

<body onload="startTimer()">

<section id="content">
<form name="myForm" action="<%=request.getContextPath()%>/LandMarkList">	

<h1>Land Marks For The Route  <%=routeName%></h1>

<div style="position:relative;width:600px;height:375px;">

<div style="position: relative;top: -15px;left:325px;">
	<input type="submit" name="action" value="Update LandMark"  id="button" style="width:150px; "/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Delete LandMark"  id="button" style="width:150px; " onclick="return confirm()"/>&nbsp;&nbsp;
	
	<input type="hidden" name="action" value="Delete LandMark"/>
</div>

<table id="results" class="tab" align="center">
    <tr>
    		<td colspan="5">
    				<h2>Route :  <%=routeName%></h2>
    		</td>
    </tr>
    
	<tr>
	    <th>Select</th>
		<th>Pickup No.</th>
		<th>Land Mark</th>
		<th>Latitude</th>
		<th>Longitude</th>
		<th>Message</th>
		
		
	</tr>
<%
	if(rs!=null)
		while(rs.next())
		{
			count++;
%>
			<tr align="center">
			    <td><input name="chk" type="checkbox" value="<%=rs.getInt(1)%>"></td>
				<td><%=rs.getInt(3)%></td>
		        <td><%=rs.getString(4)%></td>
				<td><%=rs.getString(5)%></td>
				<td><%=rs.getString(6)%></td>
				<td><%=rs.getString(7)%></td>
			</tr>
<%
		}
        if(count == 0)
        {
%>
             
            <tr align="center" height="25">
            </tr>
			<tr align="center" height="25">
				<td colspan="5">
				<font color="red" size="4">There is no Land Mark For This Route.</font>
				</td>
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
    		<p>Land Mark Details Added Successfully.....!</p>
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
			<p>Land Mark Details Deleted Successfully.....!</p>
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
			<p>Land Mark Details Updated Successfully....!</p>
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