package com.anas.webservices;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ReadJSON {
 
public static void main(String[] args) {
 
JSONParser parser = new JSONParser();
 
try {
 
Object obj = parser.parse(new FileReader("D:\\earth.json"));
 
JSONObject jsonObject = (JSONObject) obj;
 
String planetname = (String) jsonObject.get("planet");
 System.out.println(planetname);
 
Double diameter = (Double) jsonObject.get("diameter");
 System.out.println(diameter);
 
// loop array
 JSONArray msg = (JSONArray) jsonObject.get("facts");
 Iterator<JSONObject> iterator = msg.iterator();
 while (iterator.hasNext()) {
 JSONObject factObj = (JSONObject) iterator.next();
 String water = (String) factObj.get("water");
 System.out.println(water);
 }
 
} catch (FileNotFoundException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 } catch (ParseException e) {
 e.printStackTrace();
 }
 
}
 
}