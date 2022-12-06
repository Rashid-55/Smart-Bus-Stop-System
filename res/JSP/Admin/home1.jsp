<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.dev.dao.AdminDAO"%>
<%@page import="com.dev.util.Utility"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Admin Home</title>

<link href="<%=request.getContextPath()%>/res/CSS/navmenu.css" rel="stylesheet" type="text/css"/>

<%-- Nav Menu (Starts) --%>
<link href="<%=request.getContextPath()%>/res/CSS/reset.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/res/CSS/message.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="<%=request.getContextPath()%>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/JS/script.js"></script>

<script>
    history.forward();
</script>

</head>

<body onload="startTimer()">
<img src="<%=request.getContextPath()%>/res/Images/header.jpg" width="1024" height="80"  alt=""/>

<div class="Content" style="position: absolute;">
<iframe src="<%=request.getContextPath()%>/res/JSP/Admin/default.jsp" name="myFrame" height="590" width="918"></iframe>
</div>


<%-- Nevigation Menu(Starts) --%>
<div id="main" style="position:absolute;left: 10px;">

<ul id="navigationMenu">
    <li>
	    <a class="home" href="<%=request.getContextPath()%>/res/JSP/Admin/default.jsp" target="myFrame">
            <span>Home</span>
        </a>
    </li>
    
    
     <li>
    	<a class="user" href="<%=request.getContextPath()%>/AdminProfile?action=get" target="myFrame">
            <span>Admin Profile</span>
        </a>
     </li>
    
    <li>
    	<a class="user" href="<%=request.getContextPath()%>/UserList?action=get" target="myFrame">
            <span>User List</span>
        </a>
    </li>
    
    <li>
    	<a class="cloud" href="<%=request.getContextPath()%>/CloudList?action=get" target="myFrame">
            <span>Cloud Details</span>
        </a>
    </li>
    
    <li>
    	<a class="building" href="<%=request.getContextPath()%>/BuildingList?action=get" target="myFrame">
            <span>Building Details</span>
        </a>
    </li>
    
   
    <li>
	     <a class="settings" href="<%=request.getContextPath()%>/res/JSP/Admin/change_password.jsp" target="myFrame">
            <span>Change Password</span>
         </a>
    </li>
    
    <li>
    	<a class="logout" href="<%=request.getContextPath()%>/index.jsp?no=2">
            <span>Sign Out</span>
        </a>
    </li>
    
</ul>
    
</div>
<%-- Nevigation Menu(Ends) --%>

<%
	int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{
%>
			<div class="info" id="message" style="position:absolute;top:600px;left:50px">
				<p>Welcome! <%=AdminDAO.getAdminName((String)session.getAttribute("username"))%></p>
			</div>
		<%}
%>

</body>
</html>
