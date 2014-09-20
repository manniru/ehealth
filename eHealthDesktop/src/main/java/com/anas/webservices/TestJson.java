package com.anas.webservices;

import com.anas.ehealth.User;
import com.anas.ehealth.dao.Dao;
import com.anas.ehealth.dao.Doctor;
import com.google.gson.Gson;

public class TestJson {

	public static void main(String[] args) {
		Dao dao = new Dao();
		Doctor doctor = dao.doctor(1);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(doctor);  
		
		System.out.println(json);
		

	}

}
