package com.anas.ehealth.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestJson {

	public static void main(String[] args) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMDD.hhmmss");
		GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.registerTypeAdapter(Patient.class, new PatientDeserializer());
		Gson gson = gsonBuilder.create();
				
		try {
			String patientid = "2";
			URL url = new URL("http://localhost:8080/ehealth/webservices.jsp?type=patient&id="+patientid );
			URLConnection conn = url.openConnection();
			
			BufferedReader data = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			Patient patient = gson.fromJson(data, Patient.class);
			
			System.out.println(patient.getFullname());
				
		} catch(Exception e) { System.out.println(e); }


		}



}
