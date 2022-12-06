
package com.dev.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dev.dao.AdminDAO;

@SuppressWarnings("serial")
public class AddBuildingDetails extends HttpServlet
{
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		boolean flag = false;
		String s = "",fileName="",ext="",filePath = "",root = "",subject="";
		@SuppressWarnings("rawtypes")
		ArrayList list =  new ArrayList();
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		try 
		{
			String shortName="",buildingName="",area="",city="",address="",description="",lattitude="",longitude="",buildingPlanImage="";
			ResultSet rs = null;
			// Reading The Selected File
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart)
 			{
 				FileItemFactory factory = new DiskFileItemFactory();
 	            ServletFileUpload upload = new ServletFileUpload(factory);
 	            
 	            try 
 	            {
 	            	@SuppressWarnings("rawtypes")
					List items = upload.parseRequest(request);
  	                @SuppressWarnings("rawtypes")
					Iterator iterator = items.iterator();
  	                while (iterator.hasNext()) 
  	                {
  	                	FileItem item = (FileItem) iterator.next();
  	                	
  	                	
	                    if (item.isFormField()) 
	                    {
	                    	s = item.getString();
	                    	list.add(s);//All Form Field Values
	                    }
	                    else 
	                    {
	                    	 fileName = item.getName();
	                    	 if(fileName!="")
		                    		ext=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));
	                    	 
	                    	 root = request.getRealPath("")+"\\Files\\Upload\\";
	                    	 
	                    	 File f = new File(root);
	                    	
	                    	 if(!f.exists())
	                    	 {   System.out.println("Upload Dir Created Successfully.");
	                    		 f.mkdir();
	                    	 }
	                    	 
	                    	 filePath = root+fileName;
			  	             File f1=new File(filePath);
			  	             item.write(f1);
			  	             flag = true;
			  	             System.out.println("File Created Successfully......");
			  	             session.setAttribute("file_name",fileName);
			  	             session.setAttribute("file_ext",ext);
	                    }
	                        
  	                }
  	                
  	                System.out.println("Form Fields :\n"+list);
  	                // Adding The Building Details
  	                shortName = list.get(0).toString();
  	                buildingName = list.get(1).toString();
  	                area = list.get(2).toString();
  	                city = list.get(3).toString();
  	                address = list.get(4).toString();
  	                description = list.get(5).toString();
  	                lattitude = list.get(6).toString();
  	                longitude = list.get(7).toString();
  	                buildingPlanImage = fileName;
  	                
	  	           /* flag = AdminDAO.checkBuildingExistance(shortName);
						
					if(!flag)
					{
						flag = AdminDAO.addBuildingInfo(shortName, buildingName, area, city, address, description, lattitude, longitude, buildingPlanImage);
						
						if(flag)
						{
							
								rs=AdminDAO.getBuildings();
								request.setAttribute("rs", rs);
								rd=request.getRequestDispatcher("/res/JSP/Admin/buildings.jsp?no=1");
								rd.forward(request, response);
							
							
							response.sendRedirect(request.getContextPath()+"/UploadFile");
						}
						else
						{
							System.out.println("Opps,Something Went Wrong Try Again Latter!!!!!");
							rd=request.getRequestDispatcher("/res/JSP/Admin/add_building.jsp?no=2");
							rd.forward(request, response);
						}
					}
					else
					{
						System.out.println("Opps,The Building Already Exists,Provide Different Short Name!!!!!");
						rd=request.getRequestDispatcher("/res/JSP/Admin/add_building.jsp?no=3");
						rd.forward(request, response);
					}*/
	  	               
				}
 	            catch (Exception e)
 	            {
					System.out.println("Opps,Exception While Adding The Bulding Details : " );
					e.printStackTrace();
				}
 	            
 	           
 			}
		
		} 
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Admin==>AddBuildingDetails Servlet : ");
			e.printStackTrace();
		}
	}
}
