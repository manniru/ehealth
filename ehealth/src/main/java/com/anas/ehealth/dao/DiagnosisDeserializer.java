
package com.anas.ehealth.dao;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class DiagnosisDeserializer implements JsonDeserializer<Diagnosis> {

  public Diagnosis deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
      throws JsonParseException {
    final JsonObject jsonObject = json.getAsJsonObject();
    
    int id = Integer.parseInt(jsonObject.get("id").getAsString());
    String doctorid = jsonObject.get("doctorid").getAsString();
	String patientid = jsonObject.get("patientid").getAsString();;
	String patientname = jsonObject.get("patientname").getAsString();
	String diagnosis = jsonObject.get("diagnosis").getAsString();
	String notes = jsonObject.get("notes").getAsString();

    final Diagnosis Diagnosis = new Diagnosis();
    Diagnosis.setId(id);
	Diagnosis.setDoctorid(doctorid);
	Diagnosis.setPatientid(patientid);
	Diagnosis.setPatientname(patientname);
	Diagnosis.setNotes(notes);

    return Diagnosis;
  }
}
