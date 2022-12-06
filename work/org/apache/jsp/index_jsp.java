package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dev.util.Utility;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Index Page</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/login-style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/login-animate-custom.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/login-demo.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery-1.8.0.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/script.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    history.forward();\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body onload=\"startTimer();changeHashOnLoad();\">\n");
      out.write("<img src=\"");
      out.print(request.getContextPath());
      out.write("/res/Images/title.png\" width=\"1120\" height=\"80\"  alt=\"\"/>\n");
      out.write("<img src=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/images/bus.jpg\" width=\"1350\" height=\"900\" alt=\"Index\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<div class=\"container\" style=\"position:absolute;top:150px;left:30px;\">\n");
      out.write("\t\t\t <!-- Codrops top bar -->\n");
      out.write("           \n");
      out.write("            <section>\t\t\t\t\n");
      out.write("                <div id=\"container_demo\" >\n");
      out.write("                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->\n");
      out.write("                    <a class=\"hiddenanchor\" id=\"toregister\"></a>\n");
      out.write("                    <a class=\"hiddenanchor\" id=\"tologin\"></a>\n");
      out.write("                    <div id=\"wrapper\">\n");
      out.write("                        <div id=\"login\" class=\"animate form\">\n");
      out.write("                            <form  action=\"");
      out.print(request.getContextPath());
      out.write("/AdminLogin\" method=\"post\" autocomplete=\"on\"> \n");
      out.write("                                <h1>Admin Log in</h1> \n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"username\" class=\"uname\" data-icon=\"u\" > Your Username </label>\n");
      out.write("                                    <input id=\"username\" name=\"username\" required=\"required\" type=\"text\" placeholder=\"Enter Your Username\"/>\n");
      out.write("                                </p>\n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"password\" class=\"youpasswd\" data-icon=\"p\"> Your Password </label>\n");
      out.write("                                    <input id=\"password\" name=\"password\" required=\"required\" type=\"password\" placeholder=\"Enter Your Password\" /> \n");
      out.write("                                </p>\n");
      out.write("                                <p class=\"keeplogin\"> \n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"loginkeeping\" id=\"loginkeeping\" value=\"loginkeeping\" /> \n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"loginkeeping\">Keep me logged in</label>\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("                                <p class=\"login button\"> \n");
      out.write("                                    <input type=\"submit\" value=\"Login\" /> \n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("                                <p class=\"change_link\">\n");
      out.write("\t\t\t\t\t\t\t\t\tAre You A Member ?\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#toregister\" class=\"to_register\">Join us</a>\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div id=\"register\" class=\"animate form\">\n");
      out.write("                            <form  action=\"mysuperscript.php\" autocomplete=\"on\"> \n");
      out.write("                                <h1> Member Sign up </h1> \n");
      out.write("                                <p> \n");
      out.write("                                    Members Can Register With Us By Using Our Android App.\n");
      out.write("                                </p>\n");
      out.write("                               \n");
      out.write("                                <p align=\"center\">\n");
      out.write("                                \t<img src=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/images/android_smartphone.jpg\"  alt=\"Android\">\n");
      out.write("                                </p>\n");
      out.write("                               \n");
      out.write("                                <p> \n");
      out.write("                                    Download Our Android App apk File.\n");
      out.write("                                </p>\n");
      out.write("                                \n");
      out.write("                                <p> \n");
      out.write("                                    Install The App To Android Phone and Register.\n");
      out.write("                                </p>\n");
      out.write("                                \n");
      out.write("                                <p class=\"change_link\">  \n");
      out.write("\t\t\t\t\t\t\t\t\tAre You A Member?\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#tologin\" class=\"to_register\"> Go To Admin Login </a>\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("                    </div>\n");
      out.write("                </div>  \n");
      out.write("            </section>\n");
      out.write("\t</div>\n");
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<table width=\"1024\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("  <tr>\n");
      out.write("    <td><img src=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/images/index_32.gif\" width=\"1024\" height=\"7\" alt=\"\"></td>\n");
      out.write("  </tr>\n");
      out.write("  \n");
      out.write("  <tr>\n");
      out.write("    <td bgcolor=\"#FFFFFF\">\n");
      out.write("\t    <table width=\"100%\" height=\"25\" border=\"0\" cellspacing=\"0\" cellpadding=\"15\">\n");
      out.write("\t      <tr>\n");
      out.write("\t        <td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("\t          <tr>\n");
      out.write("\t            \n");
      out.write("\t          </tr>\n");
      out.write("\t        </table></td>\n");
      out.write("\t      </tr>\n");
      out.write("\t    </table>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Invalid Username / Password ...!!</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==2)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>You Have Logged Out Successfully.....</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==3)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Opps,Something Went Wrong!!!!!</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==4)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Sorry,User Already Exists!!!!!</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==5)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Registration Done Successfully.....</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==6)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Opps,Invalid User!!!!!</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==7)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Your Password Mailed To Your Mail.</p>\n");
      out.write("\t\t\t</div>\n");

		}
		if(no==8)
		{

      out.write("\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:600px;left:50px\">\n");
      out.write("\t\t\t\t<p>Opps,Mailing Process Failed,Check Internet!!!!!</p>\n");
      out.write("\t\t\t</div>\n");

		}

      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
