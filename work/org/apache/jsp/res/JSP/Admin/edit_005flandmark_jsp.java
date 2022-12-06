package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dev.dao.AdminDAO;
import java.sql.ResultSet;
import com.dev.util.Utility;

public final class edit_005flandmark_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	ResultSet rs= null;
    int id=0,serialNumber=0;
	double latitude=0,longitude=0;
	String landMark="",instruction="",message="",routeId="";

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
      out.write("<title>Update Land Mark</title>\r\n");
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
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	if(rs!=null)
		while(rs.next())
		{
			id = rs.getInt(1);
			routeId = rs.getString(3);
			serialNumber = rs.getInt(3);
			landMark = rs.getString(4);
			
			latitude = rs.getDouble(5);
			longitude = rs.getDouble(6);
			message = rs.getString(7);
		}
		
    

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<section id=\"content\" style=\"position: absolute;top:15;left:190px;\">\r\n");
      out.write("\t<form name=\"frm\" action=\"");
      out.print(request.getContextPath());
      out.write("/LandMarkList\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t<h1>Update Route Land Mark Details</h1>\r\n");
      out.write("\t<table style=\"width: 500px;text-align: center;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tLand Mark<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"land_mark\"  value=\"");
      out.print(landMark);
      out.write("\" class=\"easyui-validatebox\" required=\"required\" autofocus required  title=\"Please,Enter The Land Mark.\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tLatitude<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t        ");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"latitude\" value=\"");
      out.print(latitude);
      out.write("\" class=\"easyui-validatebox\" required=\"required\" pattern=\"^-?([0-8]?[0-9]|90)\\.[0-9]{1,6}\"  title=\"Please,Enter The Valid Latitude(x-axis).\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tLongitude<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t        ");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"longitude\" value=\"");
      out.print(longitude);
      out.write("\" class=\"easyui-validatebox\" pattern=\"-?((1?[0-7]?|[0-9]?)[0-9]|180)\\.[0-9]{1,6}\" required=\"required\"   title=\"Please,Enter The Valid Longitude(y-axis).\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tMessage<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"inst\" value=\"");
      out.print(message);
      out.write("\" class=\"easyui-validatebox\" required=\"required\"  title=\"Please,Enter The Land Mark Instruction.\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<input  type=\"submit\" name=\"action\" value=\"Update LandMark\" style=\"left:190px;width: 150px;\"/>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"update\" value=\"YES\" />\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(id);
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"sl_no\" value=\"");
      out.print(serialNumber);
      out.write("\"></input>\r\n");
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
      out.write("\t\t\t<p>Land Mark Details Added Successfully......</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	
	if(Utility.parse(request.getParameter("no"))==2)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Opps,Something Went Wrong Try Again Latter!!!!!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==3)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Sorry,This Land Mark Already Exists!!!!!</p>\r\n");
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
