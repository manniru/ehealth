package com.anas.webservices;

import org.json.simple.parser.ParseException;
import org.json.simple.

public class JsonDecode {

	public static void main(String[] args) {
		 System.out.println("Starting execution of program...");
		    String searchQuery = args[0];
		    JSONReader reader = new JSONReader();

		    System.out.println("Beginning HTTP request...");
		    String baseURL = "http://api.discogs.com/database/search?q=" + searchQuery + "&type=artist";

		    JSONObject json = reader.readJsonFromUrl(baseURL);
		    System.out.println(json);

	}

}
