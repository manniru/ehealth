
package com.anas.ehealth.dao;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class PrescriptionDeserializer implements JsonDeserializer<Prescription> {

  public Prescription deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
      throws JsonParseException {
    final JsonObject jsonObject = json.getAsJsonObject();
    
    
    int id = Integer.parseInt(jsonObject.get("id").getAsString());
    String pharmid = jsonObject.get("fullname").getAsString();
	String patientid = jsonObject.get("dob").getAsString();;
	String patientname = jsonObject.get("gender").getAsString();
	String drugname = jsonObject.get("weight").getAsString();
	String dosage = jsonObject.get("height").getAsString();
	String intake = jsonObject.get("address").getAsString();
	String duration = jsonObject.get("mobileno").getAsString();
	String note = jsonObject.get("datereg").getAsString();

    final Prescription Prescription = new Prescription();
    Prescription.setId(id);
	Prescription.setPharmid(pharmid);
	Prescription.setPatientid(patientid);;
	Prescription.setPatientname(patientname);
	Prescription.setDrugname(drugname);
	Prescription.setDosage(dosage);
	Prescription.setIntake(intake);
	Prescription.setDuration(duration);
	Prescription.setNote(note);

    return Prescription;
  }
}
