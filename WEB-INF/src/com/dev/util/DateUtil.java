

package com.dev.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil 
{
	    
// Validation Process(STARTS)	
	
	public static boolean validateAlarmExpiryDate(String alarmDate,int alarmValidity)
	{
	    boolean	flag = false;
		String today="",alarmDateWithValidity="";
	    try
	    {
	    	
	    	alarmDateWithValidity = addDaysToDate(alarmDate,alarmValidity);
	    	today = getCurrentDate();
	    	
	    	//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        	Date date1 = sdf.parse(alarmDateWithValidity);
        	Date date2 = sdf.parse(today);
        	
        	System.out.println("Alarm Date : "+alarmDate);
        	System.out.println("Validity [Validity Days : "+alarmValidity+"] : "+alarmDateWithValidity);
        	System.out.println("Today : " + today);
 
/*        	if(date1.after(date2))
        	{
        		System.out.println("Date1 is after Date2");
        	}
 
        	if(date1.before(date2))
        	{
        		System.out.println("Date1 is before Date2");
        	}
 
        	if(date1.equals(date2))
        	{
        		System.out.println("Date1 is equal Date2");
        	}
*/ 
        	if( date1.equals(date2)|| date1.after(date2))
        	{
        		System.out.println(alarmDateWithValidity+" >= " +today+" [i.e Alarma Date >= Today Date] i.e Valid");
        		flag = true;
        	}
        	else
        	{
        		System.out.println(alarmDateWithValidity+" <= " +today+" [i.e Alarma Date <= Today Date] i.e Expired");
        	}
    	}
	    catch(ParseException ex)
	    {
    		ex.printStackTrace();
    	}
	    
		return flag;
	}
	    
	    public static String addDaysToDate(String date,int daysToAdd)
	    {
	    	String resDate = null;
	    	try 
	    	{
	    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date d = sdf.parse(date);
	    		
	    		Calendar c = Calendar.getInstance();
		    	//c.setTime(new Date()); // Now use today date.
	    		c.setTime(d); // Provided date
		    	c.add(Calendar.DATE,daysToAdd); // Adding 5 days
		    	resDate = sdf.format(c.getTime());
			} 
	    	catch (Exception e) 
	    	{
				System.out.println("Opps,Exception In DateUtil=>addDaysToDate(Date date,int daysToAdd) : ");
				e.printStackTrace();
			}
	    	
	    	return resDate;
	    }
	    
	    
	    public static void addDaysToDate()
	    {
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    	Calendar c = Calendar.getInstance();
	    	c.setTime(new Date()); // Now use today date.
	    	c.add(Calendar.DATE, 5); // Adding 5 days
	    	String output = sdf.format(c.getTime());
	    	System.out.println(output);
	    }
	    
	    public static String getCurrentDate()
	    {
	    	String date = "";
	    	
	    	try 
	    	{
				Date d = new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				date = sdf.format(d);
				
			}
	    	catch (Exception e)
	    	{
				System.out.println("Opps,Exception In DateUtil-getCurrentDate() : ");
			}
	    	
	    	return date;
	    }
	    
// Validation Process(STARTS)	
	    
	    public static String getCurrentDate1()
	    {
	    	String date = "";
	    	
	    	try 
	    	{
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				date = sdf.format(d);
				
			}
	    	catch (Exception e)
	    	{
				System.out.println("Opps,Exception In DateUtil-getCurrentDate() : ");
			}
	    	
	    	return date;
	    }
	    
		public static boolean checkDate()
		{
		    boolean	flag = false;
			
		    try
		    {
		    	 
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        	Date date1 = sdf.parse("2009-12-31");
	        	Date date2 = sdf.parse("2010-01-31");
	 
	        	System.out.println(sdf.format(date1));
	        	System.out.println(sdf.format(date2));
	 
	        	if(date1.after(date2))
	        	{
	        		System.out.println("Date1 is after Date2");
	        	}
	 
	        	if(date1.before(date2))
	        	{
	        		System.out.println("Date1 is before Date2");
	        	}
	 
	        	if(date1.equals(date2))
	        	{
	        		System.out.println("Date1 is equal Date2");
	        	}
	 
	    	}
		    catch(ParseException ex)
		    {
	    		ex.printStackTrace();
	    	}
		    
			return flag;
		}

// Checking The Date By 2nd Type	
	
		public static boolean checkDate1()
		{
			/*
			    - Return value is 0 if both dates are equal.
				- Return value is greater than 0 , if Date is after the date argument.
				- Return value is less than 0, if Date is before the date argument.
			 */
			boolean flag = false ;
			
			try
			{
				 
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        	Date date1 = sdf.parse("2009-12-31");
	        	Date date2 = sdf.parse("2010-01-31");
	        	//Date date2 = sdf.parse("2009-12-31");
	 
	        	System.out.println(sdf.format(date1));
	        	System.out.println(sdf.format(date2));
	 
	        	if(date1.compareTo(date2)>0)
	        	{
	        		System.out.println("Date1 is after Date2");
	        	}
	        	else if(date1.compareTo(date2)<0)
	        	{
	        		System.out.println("Date1 is before Date2");
	        	}
	        	else if(date1.compareTo(date2)==0)
	        	{
	        		System.out.println("Date1 is equal to Date2");
	        	}
	        	else
	        	{
	        		System.out.println("How to get here?");
	        	}
	 
	    	}
			catch(ParseException ex)
	    	{
	    		ex.printStackTrace();
	    	}
			
			return flag;
		}

		
// Checking The Date By 3rd Type

		public static boolean checkDate2()
		{
		    boolean	flag = false;
		    
		    try
		    {
		    	 
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        	Date date1 = sdf.parse("2009-12-31");
	        	Date date2 = sdf.parse("2010-01-31");
	 
	        	System.out.println(sdf.format(date1));
	        	System.out.println(sdf.format(date2));
	 
	        	Calendar cal1 = Calendar.getInstance();
	        	Calendar cal2 = Calendar.getInstance();
	        	cal1.setTime(date1);
	        	cal2.setTime(date2);
	 
	        	if(cal1.after(cal2))
	        	{
	        		System.out.println("Date1 is after Date2");
	        	}
	 
	        	if(cal1.before(cal2))
	        	{
	        		System.out.println("Date1 is before Date2");
	        	}
	 
	        	if(cal1.equals(cal2))
	        	{
	        		System.out.println("Date1 is equal Date2");
	        	}
	 
	    	}
		    catch(ParseException ex)
		    {
	    		ex.printStackTrace();
	    	}
		    
		    return flag;
		}
		
		public static String getDate()
		{
			String date="";
			try
			{
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
				date = formatter1.format(currentDate.getTime());
			}
			catch(Exception e)
			{
				System.out.println("Exception in UserDAO-->getDate( ): "+ e);
			}
			return date;
		}
		
		public static String getTime()
		{
			String time="";
			try
			{
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
				time = formatter1.format(currentDate.getTime());
			}
			catch(Exception e)
			{
				System.out.println("Exception in UserDAO-->getTime( ): "+ e);
			}
			return time;
		}
		public static String getDate1()
		{
			String date="";
			try
			{
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
				date = formatter1.format(currentDate.getTime());
			}
			catch(Exception e)
			{
				System.out.println("Exception in UserDAO-->getDate( ): "+ e);
			}
			return date;
		}
		
		public static String getDateTime()
		{
			String date="";
			try
			{
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				date = formatter1.format(currentDate.getTime());
			}
			catch(Exception e)
			{
				System.out.println("Exception in UserDAO-->getDateTime(): ");
				e.printStackTrace();
			}
			return date;
		}
		
		public static String getDay()
		{
			String day="";
			try
			{
				Calendar currentDate = Calendar.getInstance();
				int no=currentDate.get(Calendar.DAY_OF_WEEK);
				if(no==1)
					day="Sunday";
				else if(no==2)
					day="Monday";
				else if(no==3)
					day="TUESDAY";
				else if(no==4)
					day="WEDNESDAY";
				else if(no==5)
					day="THURSDAY";
				else if(no==6)
					day="FRIDAY";
				else if(no==7)
					day="SATURDAY";
			}
			catch(Exception e)
			{
				System.out.println("Exception in UserDAO-->getDay( ): "+ e);
			}
			return day;
		}
/* Testing The Development */		
		
		public static void main(String[] args) 
		{
			//String date = addDaysToDate("2014-02-12", 17);
			//String date = addDaysToDate("2014-02-12 16:50:16", 17);
			boolean flag = false;
			String date = "";
			date = "2014-02-11 16:50:16";
			flag = validateAlarmExpiryDate(date,1);
			
			System.out.println("Alarm Validation Status : "+flag);
			
		}
}
