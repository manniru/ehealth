package com.anas.webservices;

import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONParser {

	public static void main(String[] args) {
		JSONParser parser=new JSONParser();

		  System.out.println("=======decode=======");
		                
		  String s="[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		  Object obj=parser.parse(s);
		  JSONArray array=(JSONArray)obj;
		  System.out.println("======the 2nd element of array======");
		  System.out.println(array.get(1));
		  System.out.println();
		                
		  JSONObject obj2=(JSONObject)array.get(1);
		  System.out.println("======field \"1\"==========");
		  System.out.println(obj2.get("1"));    

		                
		  s="{}";
		  obj=parser.parse(s);
		  System.out.println(obj);
		                
		  s="[5,]";
		  obj=parser.parse(s);
		  System.out.println(obj);
		                
		  s="[5,,2]";
		  obj=parser.parse(s);
		  System.out.println(obj);

	}

}
