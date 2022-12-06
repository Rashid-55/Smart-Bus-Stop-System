package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dev.dao.AdminDAO;
import java.sql.ResultSet;
import com.dev.util.Utility;

public final class change_005fpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	String username = "";

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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Change Password</title>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/form1.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/easyui.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/icon.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery-1.8.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write(" <!-- Core files For jQuery Alert Dialog -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/jquery.alerts.css\" type=\"text/css\"/>\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery.alerts.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- Dependencies For jQuery Alert Dialog-->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready( function() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#alert_button\").click( function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t    var f = document.frm.file.value;\r\n");
      out.write("\t\t\t    if(f==null || f==\"\")\r\n");
      out.write("\t\t\t  \t{\r\n");
      out.write("\t\t\t    \tjAlert('Please,Browse File To Upload.', 'Alert Dialog');\r\n");
      out.write("\t\t\t    \treturn false;\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#confirm_button\").click( function() {\r\n");
      out.write("\t\t\tjConfirm('Can you confirm this?', 'Confirmation Dialog', function(r) {\r\n");
      out.write("\t\t\t\tjAlert('Confirmed: ' + r, 'Confirmation Results');\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#prompt_button\").click( function() {\r\n");
      out.write("\t\t\tjPrompt('Type something:', 'Prefilled value', 'Prompt Dialog', function(r) {\r\n");
      out.write("\t\t\t\tif( r ) alert('You entered ' + r);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#alert_button_with_html\").click( function() {\r\n");
      out.write("\t\t\tjAlert('You can use HTML, such as <strong>bold</strong>, <em>italics</em>, and <u>underline</u>!');\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".alert_style_example\").click( function() {\r\n");
      out.write("\t\t\t$.alerts.dialogClass = $(this).attr('id'); // set custom style class\r\n");
      out.write("\t\t\tjAlert('This is the custom class called &ldquo;style_1&rdquo;', 'Custom Styles', function() {\r\n");
      out.write("\t\t\t\t$.alerts.dialogClass = null; // reset to default\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t);\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	username = (String)session.getAttribute("username");		

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<section id=\"content\" style=\"position: absolute;top:35;left:350px;\">\r\n");
      out.write("\t<form name=\"frm\" action=\"");
      out.print(request.getContextPath());
      out.write("/ChangePassword\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t<h1>Change Password</h1>\r\n");
      out.write("\t<table style=\"width: 500px;text-align: center;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tUsername<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"username\" value=\"");
      out.print(username);
      out.write("\" class=\"easyui-validatebox\" required=\"required\" readonly=\"readonly\" autofocus required pattern=\"[a-zA-Z0-9_-]{5,12}\" title=\"Must be alphanumeric in 5-12 chars.\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t        \t\tNew Password<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td>:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"npass\" placeholder=\"Enter Your Password\" class=\"easyui-validatebox\" required=\"required\" pattern=\"[a-zA-Z0-9_-]{5,25}\" title=\"Must be alphanumeric and special char in 5-25 chars.\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t    </tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t        \t\tConfirm Password<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td>:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"cpass\" placeholder=\"Enter Your Confirm Password\" class=\"easyui-validatebox\" required=\"required\" pattern=\"[a-zA-Z0-9_-]{5,25}\" title=\"Confirm Password Must be alphanumeric and special char in 5-25 chars.\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t    </tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<input  type=\"submit\"  value=\"Change Password\" style=\"left:175px;width: 175px;\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t   \r\n");
      out.write("\t</form><!-- form -->\r\n");
      out.write("\t<div class=\"button\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div><!-- button -->\r\n");
      out.write("</section><!-- content -->\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"info\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Password Changed Successfully......</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==2)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>New and Confirm Password Must be Same!!!!!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==3)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Opps,Something Went Wrong Try Again Latter!!!!!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
