package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import com.dev.util.Utility;
import com.dev.dao.*;

public final class edit_005fstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	ResultSet rs = null;
	int stu_code=0,landid=0;
	public String rollno="",sclass="",name="",dob="",gender="",address="",mobileNumber="",fname1="",mname="",busno="";

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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Update Student</title>\r\n");
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
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");


ResultSet rs1 = UserDAO.getBusno();

ResultSet rs2 = UserDAO.getLandmark();


	rs = (ResultSet)request.getAttribute("rs");
    if(rs != null)
    {
    	if(rs.next())
    	{
    		stu_code = rs.getInt(1);
    		rollno = rs.getString(2);
    		sclass = rs.getString(3);
	   		 name = rs.getString(4);
	   		 gender = rs.getString(5);
	   		 dob = rs.getString(6);
	   		 mobileNumber = rs.getString(7);
	   		fname1 = rs.getString(8);
	   		mname = rs.getString(9);
	   		 address = rs.getString(10);
	   		busno = rs.getString(11);
	   		landid = rs.getInt(12);
    		
    	}
    }
    
    String lmk = UserDAO.getLM(landid);
    
    String fnm = fname1;
    System.out.println("fname :"+fname1+"."+fnm);
   

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<section id=\"content\" style=\"position: absolute;top:50;left:90px;\">\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/StudentList\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t<h1>Update Customer Details</h1>\r\n");
      out.write("\t<table style=\"width: 650px;text-align: center;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t  <tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tCustomer No<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"roll_no\"  value=\"");
      out.print(rollno);
      out.write("\" class=\"easyui-validatebox\" required=\"required\"  autofocus required pattern=\"[a-zA-Z0-9_-]{5,12}\" title=\"Must be alphanumeric in 5-12 chars.\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t        \t\tAge<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td>:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"ssec\" value=\"");
      out.print(sclass);
      out.write("\" class=\"easyui-validatebox\" required=\"required\"  title=\"Must be alphanumeric and special char in 5-25 chars.\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("   \t  \r\n");
      out.write("   \t  <tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tName<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"name\" value=\"");
      out.print(name);
      out.write("\" class=\"easyui-validatebox\" required=\"required\" pattern=\"[a-zA-z ]*\" title=\"Numbers are not allowed.\" readonly=\"readonly\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t        \t\tDate Of Birth\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td>:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"dob\" class=\"tcal\" value=\"");
      out.print(dob);
      out.write("\" readonly=\"readonly\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("   \t   <tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tGender\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");

						if(gender.equals("Male"))
						{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"gender\" value=\"Male\" checked=\"checked\">Male\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"gender\" value=\"Female\"/>Female\r\n");
      out.write("\t\t\t\t\t");

						}
						else
						{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"gender\" value=\"Male\" >Male\r\n");
      out.write("\t\t\t\t\t\t    <input type=\"radio\" name=\"gender\" value=\"Female\" checked=\"checked\"/>Female\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("   \t  \r\n");
      out.write("   \t  \r\n");
      out.write("   \t  <tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\tCell No<font color=\"red\" size=\"4\">*</font>\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"cell_no\" value=\"");
      out.print(mobileNumber);
      out.write("\" class=\"easyui-numberbox\" required=\"yes\" pattern=\"[0-9]{10}\" title=\"Must be 10 digits numeric numbers. \"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t        \t\tFather Name\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t      \r\n");
      out.write("\t\t\t <td>:</td>\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t <input type=\"text\" value=\"");
      out.print(fnm);
      out.write("\" name=\"fname\"  readonly=\"readonly\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("   \t  \r\n");
      out.write("   \t  <tr align=\"center\">\r\n");
      out.write("\t        <td>\r\n");
      out.write("\t        \t\t Mother Name\r\n");
      out.write("\t        </td>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <td width=\"11px\">:</td>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"mname\" value=\"");
      out.print(mname);
      out.write("\" class=\"easyui-validatebox\" required=\"required\" data-options=\"validType:'email'\" readonly=\"readonly\"/>\r\n");
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
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"address\" value=\"");
      out.print(address);
      out.write("\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("   \t  ");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td width=\"15px\"></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("   \t  </tr>\r\n");
      out.write("   \t  \r\n");
      out.write("   \t  \r\n");
      out.write("   \t  \r\n");
      out.write("\t  <tr align=\"center\">\r\n");
      out.write("\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Update\" style=\"left: 275px;\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"action\" value=\"Edit\"></input>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"edit1\" value=\"YES\"></input>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(stu_code);
      out.write("\"></input>\r\n");
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
      out.write("<div align=\"center\" style=\"position:absolute;left:401px; ;top:10px;\">\r\n");
      out.write("\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/res/Images/user.png\" width=\"75\" height=\"75\" alt=\"User\" />\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>User Profile Updated Sucessfully.....</p>\r\n");
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
