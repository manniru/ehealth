<%@page import="java.awt.EventQueue,
java.awt.event.ActionListener,
java.awt.event.ActionEvent,
java.util.Date,
java.util.*,
java.io.IOException,
java.io.BufferedReader,
java.io.InputStream,
java.io.InputStreamReader,
java.net.URL,
java.net.URLConnection,
java.net.HttpURLConnection,
java.util.Date,
java.text.DateFormat,
java.text.SimpleDateFormat,
java.util.Calendar,
com.anas.ehealth.dao.Doctor,
com.google.gson.Gson,
com.anas.ehealth.dao.Dao,
com.anas.ehealth.dao.User,
com.anas.ehealth.dao.Employee,
com.anas.ehealth.dao.Patient,
com.anas.ehealth.dao.Prescription,
com.anas.ehealth.dao.AppointmentDao,
com.anas.ehealth.dao.Waiting,
com.anas.ehealth.dao.Diagnosis
"%>
<%
String tp = request.getParameter("type");
String mt = request.getParameter("method");
System.out.println(tp+"=="+mt);
%>

<%
Dao dao = new Dao();

if(request.getParameter("type") != null && request.getParameter("type").equals("viewapp")) {
	int id =Integer.parseInt(request.getParameter("id"));
	
	AppointmentDao app = dao.getApp(id);

	
	Gson gson = new Gson();
	String json = gson.toJson(app);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	System.out.println(json);
}

if(request.getParameter("type") != null && request.getParameter("type").equals("viewpat")) {
	
	Gson gson = new Gson();
	Collection<Patient> patients = dao.getAllPatients();
	
	
	Object[][] pat = dao.getPatient();

	
	String json = gson.toJson(pat);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	//System.out.println(""+json);
}


if(request.getParameter("type") != null && request.getParameter("type").equals("viewuser")) {
	int id =Integer.parseInt(request.getParameter("id"));
	
	User user = dao.getUser(id);

	
	Gson gson = new Gson();
	String json = gson.toJson(user);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	System.out.println(json);
}

%>