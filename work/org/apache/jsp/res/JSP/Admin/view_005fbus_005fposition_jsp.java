package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.mail.Session;
import com.dev.dao.AdminDAO;
import java.sql.ResultSet;
import com.dev.util.Utility;

public final class view_005fbus_005fposition_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	String busRouteNumber="";

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
      out.write("<title>View Bus Position</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/form1.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery-1.8.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("var popupWindow = null;\r\n");
      out.write("function positionedPopup(url,winName,w,h,t,l,scroll)\r\n");
      out.write("{\r\n");
      out.write("\tvar val =  document.getElementById('bno').value;\r\n");
      out.write("\t\r\n");
      out.write("\tsettings ='height='+h+',width='+w+',top='+t+',left='+l+',scrollbars='+scroll+',resizable'\r\n");
      out.write("\tpopupWindow = window.open(url,winName,settings)\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function closeWin()\r\n");
      out.write("{\r\n");
      out.write("\tif(popupWindow != null)\r\n");
      out.write("\tpopupWindow.close();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	int no = Utility.parse(request.getParameter("no"));
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<section id=\"content\" style=\"position: absolute;top:35;left:350px;\">\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"frm\" action=\"");
      out.print(request.getContextPath());
      out.write("/res/JSP/Admin/view_optimal_location.jsp\" target=\"myFrame\">\r\n");
      out.write("\r\n");
      out.write(" ");
      out.write("\t\r\n");
      out.write("\t<h1>View Bus Position</h1>\r\n");
      out.write("\t<table style=\"width: 500px;text-align: center;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tBus Route <font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<select name=\"busno\" required=\"required\" id=\"bno\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"\">-Select-</option>\r\n");
      out.write("\t\t\t\t\t\t");

							ResultSet rs = AdminDAO.getRoute();
							while(rs.next())
							{
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(rs.getString(1));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t    ");

							}
						
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<input  type=\"submit\"  value=\"View Position\" style=\"left:175px;width: 175px;\" \r\n");
      out.write("\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t/>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"no\" value=\"1\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t   \r\n");
      out.write("\t</form>\r\n");
      out.write("\t<!-- form -->\r\n");
      out.write("\t\r\n");
      out.write("<!-- Displaying The Map -->\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"button\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div><!-- button -->\r\n");
      out.write("</section><!-- content -->\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
	{
		busRouteNumber = request.getParameter("busno");
		//System.out.println("Action No. : " + no);
		//System.out.println("Bus Route No. : " + busRouteNumber);
		session.setAttribute("bus_route", busRouteNumber);

      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\twindow.onload = positionedPopup('");
      out.print(request.getContextPath());
      out.write("/res/JSP/Admin/get_map.jsp','myWindow','1000','650','10','10','yes');\r\n");
      out.write("\t\t</script>\t\t\r\n");

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
      out.write("\r\n");
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
