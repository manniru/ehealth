
package com.anas.ehealth.dao;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class UserDeserializer implements JsonDeserializer<User> {

  public User deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
      throws JsonParseException {
    final JsonObject jsonObject = json.getAsJsonObject();
	
    int id = Integer.parseInt(jsonObject.get("id").getAsString());
    String username = jsonObject.get("username").getAsString();
	String password = jsonObject.get("password").getAsString();
	String email = jsonObject.get("email").getAsString();;
	String role = jsonObject.get("role").getAsString();
	String fullname = jsonObject.get("fullname").getAsString();
	String access = jsonObject.get("access").getAsString();
	
    final User User = new User();
    User.setId(id);
    User.setUsername(username);
    User.setPassword(password);
    User.setEmail(email);
    User.setFullname(fullname);
    User.setRole(role);
    User.setAccess(access);
    return User;
  }
}
