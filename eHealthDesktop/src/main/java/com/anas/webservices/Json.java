package com.anas.webservices;

import java.io.StringWriter;

import org.json.JSONObject;


public class Json {

	public static void main(String[] args) {
		 JSONObject obj=new JSONObject();
		  obj.put("name","Ali");
		  obj.put("mobile","603737336");
		  obj.put("username","ali");
		  obj.put("password","123");
		  StringWriter out = new StringWriter();
		  try {
		  obj.write(out);
		  } catch(Exception e) { System.out.println(e); }
		  String jsonText = out.toString();
		  System.out.print(jsonText);

	}

}
