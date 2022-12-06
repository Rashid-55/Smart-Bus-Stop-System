package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dev.dao.UserDAO;
import com.dev.dao.AdminDAO;
import java.sql.ResultSet;

public final class get_005fmap_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>View Map</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyByHt0Rn3cnw6t-IIWO18CR0Wv0QX1v6tk&sensor=false\">\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");

		String bno = request.getParameter("busno");

		System.out.println("Bus Route No. : " + bno);

		busRouteNumber = (String)request.getAttribute("bno");
		latitude = UserDAO.getBusLatitude(busRouteNumber);
		longitude = UserDAO.getBusLongitude(busRouteNumber);
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function getMap()\r\n");
      out.write("{\r\n");
      out.write("      //var latitude = 12.931288;\r\n");
      out.write("      //var longitude = 77.587582;\r\n");
      out.write("      \r\n");
      out.write("      var latitude = '");
      out.print(latitude);
      out.write("';\r\n");
      out.write("      var longitude = '");
      out.print(longitude);
      out.write("';\r\n");
      out.write("      \r\n");
      out.write("         //alert(\"Lat : \" +latitude+\"\\nLog : \" + longitude);\r\n");
      out.write("      if((latitude == null || latitude == \"\") && (longitude == null || longitude == \"\"))\r\n");
      out.write("      {\r\n");
      out.write("    \t  alert(\"Please,Enter The Latatude and Longitude.\");\r\n");
      out.write("\t  }\r\n");
      out.write("\t  else\r\n");
      out.write("\t  {\r\n");
      out.write("\t\t     // Getting The Address Based On Latitude And Longitude(Starts)\r\n");
      out.write("\t\t     \tvar latlng = new google.maps.LatLng(latitude,longitude);\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t     \tvar geo = new google.maps.Geocoder;\r\n");
      out.write("\t\t\t\tgeo.geocode({'latLng': latlng},function(results, status){\r\n");
      out.write("\t\t\t    if (status == google.maps.GeocoderStatus.OK) \r\n");
      out.write("\t\t\t    {              \r\n");
      out.write("\t\t\t    \t var address = results[0].formatted_address;\r\n");
      out.write("\t\t\t    \t //alert(\"Address : \" + address);\r\n");
      out.write("\t\t\t    \t \r\n");
      out.write("\t\t\t    \t //View Map\r\n");
      out.write("\t\t\t    \t initialize(latitude,longitude,address);\r\n");
      out.write("\t\t\t    \t \r\n");
      out.write("\t\t\t    \t /*\r\n");
      out.write("\t\t\t    \t var address1 = results[1].formatted_address;\r\n");
      out.write("\t\t\t    \t var address2 = results[2].formatted_address;\r\n");
      out.write("\t\t\t    \t var address3 = results[3].formatted_address;\r\n");
      out.write("\t\t\t    \t var address4 = results[4].formatted_address;\r\n");
      out.write("\t\t\t    \t var address5 = results[5].formatted_address;\r\n");
      out.write("\t\t\t    \t var address6 = results[6].formatted_address;\r\n");
      out.write("\t\t\t    \t var address7 = results[7].formatted_address;\r\n");
      out.write("\t\t\t\t     alert(\"Address : \" + address+\"\\n\"+address1+\"\\n\"+address2+\"\\n\"+address3+\"\\n\"+address4+\"\\n\"+address5+\"\\n\"+address6+\"\\n\"+address7);\r\n");
      out.write("\t\t\t\t     */\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    else\r\n");
      out.write("\t\t\t    {\r\n");
      out.write("\t\t\t        alert(\"Geocode was not successful for the following reason: \" + status);\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t     // Getting The Address Based On Latitude And Longitude(Ends)\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t    \r\n");
      out.write("\t       \r\n");
      out.write("\t  }\r\n");
      out.write("\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//Displaying The Map\t\r\n");
      out.write("function initialize(lat,lng,address)\r\n");
      out.write("{\r\n");
      out.write("    //var lat = 12.931288;\r\n");
      out.write("    //var lng = 77.587582;\r\n");
      out.write("    \r\n");
      out.write("    var myCenter=new google.maps.LatLng(lat,lng);\r\n");
      out.write("\t\r\n");
      out.write("    var mapProp = \r\n");
      out.write("    {\r\n");
      out.write(" \t\t center:myCenter,\r\n");
      out.write(" \t\t //zoom:5,\r\n");
      out.write("  \t\t zoom:12,\r\n");
      out.write("  \t\t mapTypeId:google.maps.MapTypeId.ROADMAP\r\n");
      out.write("  \t};\r\n");
      out.write("\r\n");
      out.write("\tvar map=new google.maps.Map(document.getElementById(\"googleMap\"),mapProp);\r\n");
      out.write("\r\n");
      out.write("\tvar marker=new google.maps.Marker({position:myCenter,});\r\n");
      out.write("\tmarker.setMap(map);\r\n");
      out.write("\t\r\n");
      out.write("\tvar infowindow = new google.maps.InfoWindow({content:\"Address :<br>\"+address});\r\n");
      out.write("\tgoogle.maps.event.addListener(marker, 'click', function()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tinfowindow.open(map,marker);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"getMap()\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"googleMap\" style=\"width:965px;height:640px;top:0px;left:0px;\"></div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
