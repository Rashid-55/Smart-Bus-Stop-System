package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dev.dao.AdminDAO;
import com.dev.util.Utility;
import java.sql.ResultSet;

public final class view_005flandmark_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	String routeId = null;
	String routeName = "";

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
      out.write("<title>View Land Mark</title>\r\n");
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
      out.write(" \r\n");
      out.write("<!-- Core files For jQuery Alert Dialog -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/jquery.alerts.css\" type=\"text/css\"/>\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery.alerts.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- Dependencies For jQuery Alert Dialog-->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction confirm()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar chks = document.getElementsByName(\"chk\");\r\n");
      out.write("\t\t\t//alert(\"Value : \" + chks.length)\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar hasChecked = false;\r\n");
      out.write("\t\t\tfor (var i = 0; i < chks.length; i++)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tif (chks[i].checked)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\thasChecked = true;\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (hasChecked == false)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tjAlert(\"Please Select Atleast One Record To Delete.\",'Alert Dialog');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(hasChecked == true)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar selected=\"\";\r\n");
      out.write("\t\t\t\tfor (var i = 0; i < chks.length; i++)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tif (chks[i].checked)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tselected += chks[i].value+\",\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t//Deleting The Last char\r\n");
      out.write("\t\t\t\tselected = selected.substring(0, selected.length - 1);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tjConfirm('Do You Want To Delete?\\nLandMark(s) Having Sl. No. : '+selected, 'Confirmation Dialog', function(r) \r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t//jAlert('Confirmed: ' + r, 'Delete Confirmation');\r\n");
      out.write("\t\t\t\t\t\tif(r)\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t//Submmiting The form\r\n");
      out.write("\t\t\t\t\t\t\tdocument.myForm.submit();\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t//Unchecking The Checked Check Boxes\r\n");
      out.write("\t\t\t\t\t\t\tfor (var i = 0; i < chks.length; i++)\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\tif (chks[i].checked)\r\n");
      out.write("\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\tchks[i].checked = false;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write('\r');
      out.write('\n');

	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
    int count = 0;
    routeId = (String)session.getAttribute("route_busno");
    routeName = AdminDAO.getRouteName(routeId);
    
    

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("<section id=\"content\">\r\n");
      out.write("<form name=\"myForm\" action=\"");
      out.print(request.getContextPath());
      out.write("/LandMarkList\">\t\r\n");
      out.write("\r\n");
      out.write("<h1>Land Marks For The Route  ");
      out.print(routeName);
      out.write("</h1>\r\n");
      out.write("\r\n");
      out.write("<div style=\"position:relative;width:600px;height:375px;\">\r\n");
      out.write("\r\n");
      out.write("<div style=\"position: relative;top: -15px;left:325px;\">\r\n");
      out.write("\t<input type=\"submit\" name=\"action\" value=\"Update LandMark\"  id=\"button\" style=\"width:150px; \"/>&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"submit\" name=\"action\" value=\"Delete LandMark\"  id=\"button\" style=\"width:150px; \" onclick=\"return confirm()\"/>&nbsp;&nbsp;\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"hidden\" name=\"action\" value=\"Delete LandMark\"/>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<table id=\"results\" class=\"tab\" align=\"center\">\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t\t<td colspan=\"5\">\r\n");
      out.write("    \t\t\t\t<h2>Route :  ");
      out.print(routeName);
      out.write("</h2>\r\n");
      out.write("    \t\t</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    \r\n");
      out.write("\t<tr>\r\n");
      out.write("\t    <th>Select</th>\r\n");
      out.write("\t\t<th>Pickup No.</th>\r\n");
      out.write("\t\t<th>Land Mark</th>\r\n");
      out.write("\t\t<th>Latitude</th>\r\n");
      out.write("\t\t<th>Longitude</th>\r\n");
      out.write("\t\t<th>Message</th>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</tr>\r\n");

	if(rs!=null)
		while(rs.next())
		{
			count++;

      out.write("\r\n");
      out.write("\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t    <td><input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(rs.getInt(1));
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getInt(3));
      out.write("</td>\r\n");
      out.write("\t\t        <td>");
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
      out.write("\t\t\t</tr>\r\n");

		}
        if(count == 0)
        {

      out.write("\r\n");
      out.write("             \r\n");
      out.write("            <tr align=\"center\" height=\"25\">\r\n");
      out.write("            </tr>\r\n");
      out.write("\t\t\t<tr align=\"center\" height=\"25\">\r\n");
      out.write("\t\t\t\t<td colspan=\"5\">\r\n");
      out.write("\t\t\t\t<font color=\"red\" size=\"4\">There is no Land Mark For This Route.</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");

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
      out.write("    \t\t<p>Land Mark Details Added Successfully.....!</p>\r\n");
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
      out.write("\t\t\t<p>Land Mark Details Deleted Successfully.....!</p>\r\n");
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
      out.write("\t\t\t<p>Land Mark Details Updated Successfully....!</p>\r\n");
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
