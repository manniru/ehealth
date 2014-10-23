<%@page import="java.awt.EventQueue,
java.awt.event.ActionListener,
java.awt.event.ActionEvent,
java.util.Date,
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
	String json = gson.toJson(prescription);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	out.println(json);
}


%>