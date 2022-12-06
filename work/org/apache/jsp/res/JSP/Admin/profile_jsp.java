package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.swing.CellEditor;
import com.dev.dao.AdminDAO;
import java.sql.ResultSet;
import com.dev.util.Utility;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	ResultSet rs = null;
	String username="",password="",name="",gender="",address="",mobileNumber="", phoneNumber="",emailId="";
	int adminId = 0;

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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Investigator Profile</title>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/form1.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/tcal.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
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
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/script.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/tcal.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#data \r\n");
      out.write("{\r\n");
      out.write("\t-webkit-border-radius: 3px;\r\n");
      out.write("\t-moz-border-radius: 3px;\r\n");
      out.write("\t-ms-border-radius: 3px;\r\n");
      out.write("\t-o-border-radius: 3px;\r\n");
      out.write("\tborder-radius: 3px;\r\n");
      out.write("\t-webkit-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\r\n");
      out.write("\t-moz-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\r\n");
      out.write("\t-ms-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\r\n");
      out.write("\t-o-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\r\n");
      out.write("\tbox-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\r\n");
      out.write("\t-webkit-transition: all 0.5s ease;\r\n");
      out.write("\t-moz-transition: all 0.5s ease;\r\n");
      out.write("\t-ms-transition: all 0.5s ease;\r\n");
      out.write("\t-o-transition: all 0.5s ease;\r\n");
      out.write("\ttransition: all 0.5s ease;\r\n");
      out.write("\t/*\r\n");
      out.write("\tborder: 1px solid #c8c8c8;\r\n");
      out.write("\t*/\r\n");
      out.write("\tcolor: #777;\r\n");
      out.write("\tfont: 13px Helvetica, Arial, sans-serif;\r\n");
      out.write("\tmargin: 0 0 10px;\r\n");
      out.write("\tpadding: 10px 10px 10px 10px;\r\n");
      out.write("\twidth: 200px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	 rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	 while(rs.next())
	 {
		 adminId = rs.getInt(1);
		 username = rs.getString(2);
		 password = rs.getString(3);
		 name = rs.getString(4);
		 gender = rs.getString(5);
		 mobileNumber = rs.getString(6);
		 phoneNumber = rs.getString(7);
		 emailId = rs.getString(8);
		 address = rs.getString(9);
		 
	 }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("<section id=\"content\" style=\"position: absolute;top:50;left:300px;\">\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/AdminProfile\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t<h1>Admin Profile</h1>\r\n");
      out.write("\t<table cellspacing=\"15\" style=\"width: 650px;text-align: center;\" >\r\n");
      out.write("\t\t\r\n");
      out.write("\t  <tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tUsername\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td  id=\"data\">\r\n");
      out.write("\t\t\t\t\t");
      out.print(username );
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t        \t\tPassword\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td>:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td  id=\"data\">\r\n");
      out.write("\t\t\t\t\t");
      out.print(password);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("   \t  \r\n");
      out.write("   \t  <tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tName\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td  id=\"data\">\r\n");
      out.write("\t\t\t\t\t");
      out.print(name);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t        \t\tGender\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td  id=\"data\">\r\n");
      out.write("\t\t\t\t");

					if(gender.equals("Male"))
					{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"Male\" checked=\"checked\">Male\r\n");
      out.write("   \t\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"Female\"/>Female\r\n");
      out.write("\t\t\t\t");

					}
					else
					{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"Male\">Male\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"Female\" checked=\"checked\"/>Female\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("   \t  <tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tMobile\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td  id=\"data\">\r\n");
      out.write("\t\t\t\t\t");
      out.print(mobileNumber );
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t        \t\tPhone\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td>:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td  id=\"data\">\r\n");
      out.write("\t\t\t\t\t ");
      out.print(phoneNumber);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("   \t  \r\n");
      out.write("   \t  <tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\t Email Id\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td  id=\"data\">\r\n");
      out.write("\t\t\t\t\t");
      out.print(emailId);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t        \t\tAddress\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td>:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td  id=\"data\">\r\n");
      out.write("\t\t\t\t\t");
      out.print(address);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("\t  <tr align=\"center\">\r\n");
      out.write("\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"action\" value=\"Update Profile\" style=\"left: 275px;\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t </tr>\r\n");
      out.write("\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t   \r\n");
      out.write("\t</form><!-- form -->\r\n");
      out.write("\t<div class=\"button\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div><!-- button -->\r\n");
      out.write("</section><!-- content -->\r\n");
      out.write("\r\n");
      out.write("<div align=\"center\" style=\"position:absolute;left:395px; ;top:10px;\">\r\n");
      out.write("\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/res/Images/admin.png\" width=\"75\" height=\"75\" alt=\"Home\" />\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"info\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Admin Profile Updated Successfully.....</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==2)
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
