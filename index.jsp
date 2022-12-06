<%@page import="com.dev.util.Utility"%>
<html>
<head>
<title>Index Page</title>

<%-- Login Box CSS(Starts) --%>
	<link href="<%=request.getContextPath()%>/res/CSS/login-style.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/res/CSS/login-animate-custom.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/res/CSS/login-demo.css" rel="stylesheet" type="text/css">
<%-- Login Box CSS(Ends) --%>

<link href="<%=request.getContextPath()%>/res/CSS/style.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>


<script>
    history.forward();
</script>

<%-- 

<script type = "text/javascript" >
function changeHashOnLoad() 
{
 window.location.href += "#";
 setTimeout("changeHashAgain()", "50"); 
}

function changeHashAgain() 
{
 window.location.href += "1";
}

var storedHash = window.location.hash;
window.setInterval(function () 
{
	if (window.location.hash != storedHash)
    {
     	window.location.hash = storedHash;
	}
}, 50);

</script>
--%>
</head>

<body onload="startTimer();changeHashOnLoad();">
<img src="<%=request.getContextPath()%>/res/Images/title.png" width="1120" height="80"  alt=""/>
<img src="<%=request.getContextPath()%>/res/CSS/images/bus.jpg" width="1350" height="900" alt="Index">


<%-- Admin Login (Starts) --%>
	<div class="container" style="position:absolute;top:150px;left:30px;">
			 <!-- Codrops top bar -->
           
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="<%=request.getContextPath()%>/AdminLogin" method="post" autocomplete="on"> 
                                <h1>Admin Log in</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Your Username </label>
                                    <input id="username" name="username" required="required" type="text" placeholder="Enter Your Username"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Your Password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="Enter Your Password" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Are You A Member ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form  action="mysuperscript.php" autocomplete="on"> 
                                <h1> Member Sign up </h1> 
                                <p> 
                                    Members Can Register With Us By Using Our Android App.
                                </p>
                               
                                <p align="center">
                                	<img src="<%=request.getContextPath()%>/res/CSS/images/android_smartphone.jpg"  alt="Android">
                                </p>
                               
                                <p> 
                                    Download Our Android App apk File.
                                </p>
                                
                                <p> 
                                    Install The App To Android Phone and Register.
                                </p>
                                
                                <p class="change_link">  
									Are You A Member?
									<a href="#tologin" class="to_register"> Go To Admin Login </a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
	</div>
<%-- Admin Login (Ends) --%>

<%-- Developer Signature(Starts) --%>


<table width="1024" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="<%=request.getContextPath()%>/res/CSS/images/index_32.gif" width="1024" height="7" alt=""></td>
  </tr>
  
  <tr>
    <td bgcolor="#FFFFFF">
	    <table width="100%" height="25" border="0" cellspacing="0" cellpadding="15">
	      <tr>
	        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            
	          </tr>
	        </table></td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>

<%-- Developer Signature(Ends) --%>

<%
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>Invalid Username / Password ...!!</p>
			</div>
<%
		}
		if(no==2)
		{
%>
			<div class="success" id="message" style="position:absolute;top:600px;left:50px">
				<p>You Have Logged Out Successfully.....</p>
			</div>
<%
		}
		if(no==3)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>Opps,Something Went Wrong!!!!!</p>
			</div>
<%
		}
		if(no==4)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>Sorry,User Already Exists!!!!!</p>
			</div>
<%
		}
		if(no==5)
		{
%>
			<div class="success" id="message" style="position:absolute;top:600px;left:50px">
				<p>Registration Done Successfully.....</p>
			</div>
<%
		}
		if(no==6)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>Opps,Invalid User!!!!!</p>
			</div>
<%
		}
		if(no==7)
		{
%>
			<div class="success" id="message" style="position:absolute;top:600px;left:50px">
				<p>Your Password Mailed To Your Mail.</p>
			</div>
<%
		}
		if(no==8)
		{
%>
			<div class="error" id="message" style="position:absolute;top:600px;left:50px">
				<p>Opps,Mailing Process Failed,Check Internet!!!!!</p>
			</div>
<%
		}
%>

</body>
</html>