package com.anas.ehealth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

public class WebServices {

	public static void main(String[] args) {
		WebServices services = new WebServices();
		
		HashMap hm = new HashMap();
		hm.put("type", "doctor");
		hm.put("id", "1");
		services.post(hm);

	}
	
	public String post(HashMap hm) {
		HttpClient client = new HttpClient();
	    client.getParams().setParameter("http.useragent", "Client");

	    BufferedReader br = null;

	    //PostMethod method = new PostMethod("http://search.yahoo.com/search");
	    PostMethod method = new PostMethod("http://localhost:8080/ehealth/webservices.jsp");
	    String type = hm.get("type").toString();
	    System.out.println("type3="+type);
	    //method.addParameter("p", "\"java2s\"");
	    if(type.equals("doctor")) {
	    method.addParameter("type", hm.get("type").toString());
	    method.addParameter("username", hm.get("username").toString());
	    method.addParameter("password", hm.get("password").toString());
	    method.addParameter("fullname", hm.get("fullname").toString());
	    method.addParameter("mobileno", hm.get("mobileno").toString());
	    method.addParameter("email", hm.get("email").toString());
	    method.addParameter("address", hm.get("address").toString());
	    method.addParameter("department", hm.get("department").toString());
	    method.addParameter("role", hm.get("role").toString());
	    //method.addParameter("uid", hm.get("uid").toString());
	    }
	    
	    else if(type.equals("pharmacist")) {
		    System.out.println("type2="+type);

	    	method.addParameter("type", hm.get("type").toString());
	    	method.addParameter("username", hm.get("username").toString());
		    method.addParameter("password", hm.get("password").toString());
		    method.addParameter("role", hm.get("role").toString());
		    method.addParameter("mobileno", hm.get("mobileno").toString());
		    method.addParameter("email", hm.get("email").toString());
		    method.addParameter("fullname", hm.get("fullname").toString());
		    method.addParameter("address", hm.get("address").toString());
		    method.addParameter("department", hm.get("department").toString());
	    }
		System.out.println(hm.get("department").toString());


	    try{
	      int returnCode = client.executeMethod(method);

	      if(returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
	        System.err.println("The Post method is not implemented by this URI");
	        method.getResponseBodyAsString();
	      } else {
	        br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
	        String readLine;
	        while(((readLine = br.readLine()) != null)) { System.err.println(readLine); }
	      }
	    } catch (Exception e) {
	      System.err.println(e);
	    } finally { method.releaseConnection();
	      if(br != null) try { br.close(); } catch (Exception fe) {}
	    }

		
		return null;
	}

}
