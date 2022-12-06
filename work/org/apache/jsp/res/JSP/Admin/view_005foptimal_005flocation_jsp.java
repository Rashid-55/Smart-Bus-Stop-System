package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dev.dao.UserDAO;
import com.dev.dao.AdminDAO;
import java.sql.ResultSet;
import java.util.ArrayList;

public final class view_005foptimal_005flocation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        ResultSet rs = null;
		String busRouteNumber="";
		double latitude=0,longitude=0;

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

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns='http://www.w3.org/1999/xhtml'>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Google Maps Latitude and Longitude Picker jQuery plugin</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/demo.css\"/>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Dependencies: JQuery and GMaps API should be loaded first -->\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath());
      out.write("/res/JS/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("\t<script src=\"http://maps.googleapis.com/maps/api/js?sensor=false\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- CSS and JS for our code -->\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/jquery-gmaps-latlon-picker.css\"/>\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath());
      out.write("/res/JS/jquery-gmaps-latlon-picker.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

		String bno = request.getParameter("busno");

		System.out.println("Bus Route No. : " + bno);

		
		latitude = UserDAO.getBusLatitude(bno);
		longitude = UserDAO.getBusLongitude(bno);
        System.out.println("---------------- Bus Location Info ----------------");
        System.out.println("Bus Route No. : " + bno);
        System.out.println("Latitude : " + latitude);
        System.out.println("Longitude : " + longitude);
        // Assigning The Default Value For Location Jayanagar
        if(latitude == 0)
        {
        	latitude = 12.931288;
        	System.out.println("Default Latitude : " + latitude);
        }
        if(longitude == 0)
        {
        	longitude = 77.587582;
        	System.out.println("Default Longitude : " + longitude);
        }
        
        
        System.out.println("----------------------------------------------------");
        

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<H2 style=\"position: absolute;top: -30px;color: #DB7093;\">View Location</H2>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<fieldset class=\"gllpLatlonPicker\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!--  <input type=\"text\" class=\"gllpSearchField\">\r\n");
      out.write("\t\t<input type=\"button\" class=\"gllpSearchButton\" value=\"search\">\r\n");
      out.write("\t\t!-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"gllpMap\" style=\"position: relative;width: 800px;height: 400px;\">Google Maps</div>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<font style=\"color: #DB7093;\"></font>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"lat\" class=\"gllpLatitude\" value=\"");
      out.print(latitude);
      out.write("\"/>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"lon\" class=\"gllpLongitude\" value=\"");
      out.print(longitude );
      out.write("\"/>\r\n");
      out.write("\t\t<input type=\"hidden\" class=\"gllpZoom\" value=\"5\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t</fieldset>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
