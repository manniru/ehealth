
package com.anas.ehealth.dao;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class PatientDeserializer implements JsonDeserializer<Patient> {

  public Patient deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
      throws JsonParseException {
    final JsonObject jsonObject = json.getAsJsonObject();
    
    int id = Integer.parseInt(jsonObject.get("id").getAsString());
    String fullname = jsonObject.get("fullname").getAsString();
	String dob = jsonObject.get("dob").getAsString();;
	String gender = jsonObject.get("gender").getAsString();
	String weight = jsonObject.get("weight").getAsString();
	String height = jsonObject.get("height").getAsString();
	String address = jsonObject.get("address").getAsString();
	String mobileno = jsonObject.get("mobileno").getAsString();
	String datereg = jsonObject.get("datereg").getAsString();
	String uid = jsonObject.get("uid").getAsString();

    final Patient patient = new Patient();
    patient.setId(id);
	patient.setFullname(fullname);
	patient.setDob(dob);
	patient.setGender(gender);
	patient.setWeight(weight);
	patient.setHeight(height);
	patient.setAddress(address);
	patient.setMobileno(mobileno);
	patient.setDatereg(datereg);
	patient.setUid(uid);

    return patient;
  }
}
