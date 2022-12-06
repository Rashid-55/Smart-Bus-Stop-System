package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dev.dao.AdminDAO;
import com.dev.util.Utility;
import java.sql.ResultSet;

public final class users_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>View Student</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/list.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/list1.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery-1.8.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/script.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/pagination.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("<section id=\"content\">\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/StudentList\">\t\r\n");
      out.write("\r\n");
      out.write("<h1>View Customer Details</h1>\r\n");
      out.write("\r\n");
      out.write("<div style=\"position:relative;width:800px;height:375px;\">\r\n");
      out.write("\r\n");
      out.write("<div style=\"position: relative;top: -15px;left: 200px;\">\r\n");
      out.write("\t");
      out.write("\t\r\n");
      out.write("\t<input type=\"submit\" name=\"action\" value=\"Add\" id=\"button\" style=\"width:100px;\"/>&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"submit\" name=\"action\" value=\"Edit\" id=\"button\" style=\"width:100px;\"/>&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"submit\" name=\"action\" value=\"Delete\" id=\"button\" style=\"width:100px;\"/>&nbsp;&nbsp;\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<table id=\"results\" class=\"tab\" align=\"center\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>Select</th>\r\n");
      out.write("\t\t<th> Customer No</th>\r\n");
      out.write("\t\t<th> Age</th>\r\n");
      out.write("\t\t<th>Name</th>\r\n");
      out.write("\t\t<th>Gender</th>\r\n");
      out.write("\t\t<th>DOB</th>\r\n");
      out.write("\t\t<th>Cell No</th>\r\n");
      out.write("\t\t<th>Father Name</th>\r\n");
      out.write("\t\t<th>Mother Name</th>\r\n");
      out.write("\t\t<th>Address</th>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	if(rs!=null)
		while(rs.next())
		{
      out.write("\r\n");
      out.write("\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t<td><input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(rs.getInt(1));
      out.write("\"></td>\r\n");
      out.write("\t\t        <td>");
      out.print(rs.getString(2));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(3));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(4));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(5));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(6));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(7));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(8));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(9));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString(10));
      out.write("</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
}
	
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</div>\t\r\n");
      out.write("\t\r\n");
      out.write("<div class=\"footer\" id=\"pageNavPosition\" style=\"cursor:hand\"></div>\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("       var pager = new Pager('results',9); \r\n");
      out.write("       pager.init(); \r\n");
      out.write("       pager.showPageNav('pager', 'pageNavPosition'); \r\n");
      out.write("       pager.showPage(1);\r\n");
      out.write("   //--></script>\r\n");
      out.write("   \r\n");
      out.write("</form><!-- form -->   \r\n");
      out.write("</section>\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
    {

      out.write("\r\n");
      out.write("    \t<div class=\"success\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("    \t\t<p>Student Details Added Successfully.....!</p>\r\n");
      out.write("    \t</div>\t\t\t\r\n");

    }
	if(Utility.parse(request.getParameter("no"))==-1)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Opp's something went wrong.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==2)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Opp's select atleast one record ....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");

	}
	if(Utility.parse(request.getParameter("no"))==3)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Student Details Deleted Successfully.....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==4)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Opp's Select only one record ....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==5)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Student Details Updated Successfully....!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==6)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Opp's Something Went Wrong!!!!!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}

      out.write("\t\t\r\n");
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
