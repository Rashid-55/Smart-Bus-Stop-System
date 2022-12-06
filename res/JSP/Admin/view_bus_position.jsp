<%@page import="javax.mail.Session"%>
<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dev.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>View Bus Position</title>

<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>


<script language="javascript">
var popupWindow = null;
function positionedPopup(url,winName,w,h,t,l,scroll)
{
	var val =  document.getElementById('bno').value;
	
	settings ='height='+h+',width='+w+',top='+t+',left='+l+',scrollbars='+scroll+',resizable'
	popupWindow = window.open(url,winName,settings)
}

function closeWin()
{
	if(popupWindow != null)
	popupWindow.close();
}

<%-- Calling The PopUP 
<a href="http://localhost:8080/ContactImporter?user_id=<%=id%>" onclick="positionedPopup(this.href,'myWindow','1000','650','10','10','yes');return false">Positioned Popup</a>
--%>

</script>



</head>

<%!
	String busRouteNumber="";
%>
<%
	int no = Utility.parse(request.getParameter("no"));
	
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:350px;">

	<form name="frm" action="<%=request.getContextPath()%>/res/JSP/Admin/view_optimal_location.jsp" target="myFrame">

 <%--
	<form name="frm"  action="<%=request.getContextPath()%>/res/JSP/Admin/view_bus_position.jsp">
		 --%>	
	<h1>View Bus Position</h1>
	<table style="width: 500px;text-align: center;">
		
		<tr align="center">
	        <td>
	        		Bus Route <font color="red" size="4">*</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<select name="busno" required="required" id="bno">
						<option value="">-Select-</option>
						<%
							ResultSet rs = AdminDAO.getRoute();
							while(rs.next())
							{
						%>
								<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
					    <%
							}
						
						%>
						
					</select>
			</td>
			
			
			<td width="15px"></td>
		<tr>	
		
		
		
		<tr align="center">
				<td colspan="3" align="center">
						<input  type="submit"  value="View Position" style="left:175px;width: 175px;" 
						<%-- 
							<a href="http://localhost:8080/ContactImporter?user_id=<%=id%>" onclick="positionedPopup(this.href,'myWindow','1000','650','10','10','yes');return false">Positioned Popup</a>
						--%>
						<%-- 
						onclick="positionedPopup('<%=request.getContextPath()%>/res/JSP/Admin/get_map.jsp','myWindow','1000','650','10','10','yes');return false"
						--%>
						/>
						<input type="hidden" name="no" value="1"/>
				</td>
		</tr>
	</table>
	   
	</form>
	<!-- form -->
	
<!-- Displaying The Map -->	

<%--
	<div  style="position: relative;top: 25px;left: 150px;width:600px;height:400px;">
			<iframe src="<%=request.getContextPath()%>/res/JSP/Admin/get_map.jsp"  width="600" height="400" scrolling="auto">
			</iframe>
	</div>
	
	 --%>
	
	<div class="button">
		
	</div><!-- button -->
</section><!-- content -->

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
		busRouteNumber = request.getParameter("busno");
		//System.out.println("Action No. : " + no);
		//System.out.println("Bus Route No. : " + busRouteNumber);
		session.setAttribute("bus_route", busRouteNumber);
%>
		<script type="text/javascript">
			window.onload = positionedPopup('<%=request.getContextPath()%>/res/JSP/Admin/get_map.jsp','myWindow','1000','650','10','10','yes');
		</script>		
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