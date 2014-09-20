package com.anas.webservices;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Json1 {

	public static void main(String[] args) {
		 System.out.println("Starting execution of program...");
		    String searchQuery = args[0];
		    JSONReader reader = new JSONReader();

		    System.out.println("Beginning HTTP request...");
		    String baseURL = "http://api.discogs.com/database/search?q=" + searchQuery + "&type=artist";

		    JSONObject json = null;
			try {
				json = reader.readJsonFromUrl(baseURL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println(json);

	}

}
