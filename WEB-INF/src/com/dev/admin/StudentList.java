
package com.dev.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.AdminDAO;
import com.dev.dao.UserDAO;
import com.dev.util.SendMSG;
import com.dev.util.Utility;

@SuppressWarnings("serial")
public class StudentList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean flag = false;
		int userId=0;
		String message="";
		String rollno="",password="",sclass="",sname="",sgender="",address="",scell_no="",sfa_name="",smo_name="",sdob="",sbusno="",landmark="";
		
		try
		{
			String submit=request.getParameter("action");
			
			rs=AdminDAO.getUsers();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp");
				rd.forward(request, response);
			}
			
			if(submit.equals("Add"))
			{
				if(Utility.parse1(request.getParameter("add")).equals("YES"))
				{
					
					 rollno = request.getParameter("roll_no");
					 sclass = request.getParameter("class");
					 sname = request.getParameter("name");
					 sgender = request.getParameter("gender");
					 sdob = request.getParameter("dob");
					 scell_no = request.getParameter("cell_no");
					
					 sfa_name = request.getParameter("fa_name");
					 smo_name = request.getParameter("mo_name");
					 address = request.getParameter("address");
					 sbusno = request.getParameter("busno");
					 landmark = request.getParameter("landmark");
					 password = request.getParameter("password");
					 
					 int land_id = UserDAO.getLand_id(landmark);
					
					 flag = UserDAO.checkStudentExistance(rollno);
					 if(!flag)
					 {
					
						flag = UserDAO.addStudentDetails(rollno,sclass, sname, sgender,sdob,scell_no,sfa_name,smo_name,address,sbusno,land_id);
						
						if(flag)
						{
							//Sending The Message
							message = "Your Registration Info\nName : "+sname+"\nRoll Number : "+rollno+"\nPassword : "+password;
							SendMSG.sendSMS(scell_no, message);
						
							rs=AdminDAO.getUsers();
							request.setAttribute("rs", rs);
							//rd=request.getRequestDispatcher("/res/JSP/Admin/addstudent.jsp?no=1");
							rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=1");
							rd.forward(request, response);
						}
						else
						{
							rd=request.getRequestDispatcher("/res/JSP/Admin/addstudent.jsp?no=2");
							rd.forward(request, response);
						}
					 }
					 else
					 {
						 System.out.println("Student Already Exists!!!!!");
						 rd=request.getRequestDispatcher("/res/JSP/Admin/addstudent.jsp?no=3");
						 rd.forward(request, response);
					 }
					
				}
				else
				{
					rd=request.getRequestDispatcher("/res/JSP/Admin/addstudent.jsp");
					rd.forward(request, response);
				}
			}
			
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit1")).equals("YES"))
				{
					
					String id = request.getParameter("id");
					 rollno = request.getParameter("roll_no");
					 sclass = request.getParameter("ssec");
					 sname = request.getParameter("name");
					 sgender = request.getParameter("gender");
					 sdob = request.getParameter("dob");
					 scell_no = request.getParameter("cell_no");
					
					 sfa_name = request.getParameter("fname");
					 smo_name = request.getParameter("mname");
					 address = request.getParameter("address");
					 sbusno = request.getParameter("busno");
					 landmark = request.getParameter("landmark");
					 password = request.getParameter("password");
					 
					 int landid = UserDAO.getLand_id(landmark);
					
					ArrayList<String> list = new ArrayList<String>();
					list.add(id);
					list.add(rollno);
					list.add(sclass);
					list.add(sname);
					list.add(sgender);
					list.add(sdob);
					list.add(scell_no);
					list.add(sfa_name);
					list.add(smo_name);
					list.add(address);
					list.add(sbusno);
					list.add(""+landid);
					
					flag = AdminDAO.updateUserDetails(list);
					
					if(flag)
					{
						rs=AdminDAO.getUsers();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=5");
						rd.forward(request,response);
					}
					else
					{
						rs=AdminDAO.getUser(Integer.parseInt(id));
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/edit_student.jsp?no=2");
						rd.forward(request,response);
					}
					
				}
				else if(chk==null)
				{
					rs=AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					rs=AdminDAO.getUser(Integer.parseInt(chk[0]));
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/edit_student.jsp");
					rd.forward(request,response);
				}
			}
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs=AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=2");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						userId = Integer.parseInt(chk[i]);
						AdminDAO.deleteUserDetails(userId);
					}
					rs=AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=3");
					rd.forward(request,response);
				}
			}
			
			//
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin UserList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin UserList Servlet : "+e);
		}
	}
}
