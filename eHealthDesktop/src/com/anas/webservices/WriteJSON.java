package com.anas.webservices;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
import java.io.FileWriter;
import java.io.IOException;
 
public class WriteJSON {
 
 /**
 * @param args
 */
 public static void main(String[] args) {
 
 JSONObject obj = new JSONObject();
 obj.put("planet", "earth");
 obj.put("diameter", new Double(12756.2));
 
 JSONArray list = new JSONArray();
 JSONObject info= new JSONObject();
 info.put("age", "4.6 billion years");
 info.put("water", "70.8%");
 info.put("land", "29.2%");
 list.add(info);
 obj.put("facts", list);
 
 try {
 
 FileWriter file = new FileWriter("D:\\earth.json");
 file.write(obj.toJSONString());
 file.flush();
 file.close();
 
 } catch (IOException e) {
 e.printStackTrace();
 }
 
 System.out.print(obj);
 
 }
 
}