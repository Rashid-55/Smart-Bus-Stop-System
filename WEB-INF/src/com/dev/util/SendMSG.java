package com.dev.util;

import java.io.*;
	import java.net.*;

public class SendMSG
{
	
    public SendMSG()
	    {
	    }

	    public static boolean sendSMS(String mobilenumber, String message)
	    {
	        boolean flag = true;
	        try
	        {
	            String postData = "";
	            String retval = "";
	            String User = "dhs";
	            String passwd = "noteasy";
	            String sid = "dhs";
	            String mtype = "N";
	            String DR = "Y";
	            postData = (new StringBuilder(String.valueOf(postData))).append("User=").append(URLEncoder.encode(User, "UTF-8")).append("&passwd=").append(passwd).append("&mobilenumber=").append(mobilenumber).append("&message=").append(URLEncoder.encode(message, "UTF-8")).append("&sid=").append(sid).append("&mtype=").append(mtype).append("&DR=").append(DR).toString();
	            URL url = new URL("http://smscountry.com/SMSCwebservice.asp");
	            HttpURLConnection urlconnection = (HttpURLConnection)url.openConnection();
	            urlconnection.setRequestMethod("POST");
	            urlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            urlconnection.setDoOutput(true);
	            OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());
	            out.write(postData);
	            out.close();
	            BufferedReader in = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
	            String decodedString;
	            while((decodedString = in.readLine()) != null) 
	                retval = (new StringBuilder(String.valueOf(retval))).append(decodedString).toString();
	            in.close();
	            System.out.println("*********** Send Message Acknowledgement *********");
	            System.out.println("NB : If Response is Some Integer Number i.e Message Sent Successfully....");
	            System.out.println("Response : "+retval);
	        }
	        catch(Exception e)
	        {
	            System.out.println("Opps,Exception In Util==>SendMSG : ");
	            e.printStackTrace();
	            flag = false;
	        }
	        return flag;
	    }
	   
	}

