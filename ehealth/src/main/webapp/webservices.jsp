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
com.anas.ehealth.dao.User
"%>

<%
if(request.getParameter("type") != null) {
	String type = request.getParameter("type");
	System.out.println(type);
	Dao dao = new Dao(); 	
	
	//int id = request.getParameter("id");
	if(type.equals("doctor")) {
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String fullname = request.getParameter("fullname");
	String mobileno = request.getParameter("mobileno");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String department = request.getParameter("department");
	String role = request.getParameter("role");
	String uid = request.getParameter("uid");
	
	Doctor doctor = new Doctor();		
	doctor.setUsername(username);
	doctor.setPassword(password);
	doctor.setMobileno(mobileno);
	doctor.setEmail(email);
	doctor.setAddress(address);
	doctor.setFullname(fullname);
	doctor.setRole(role);
	//doctor.setUid(uid);
	doctor.setDepartment(department);	
	
	dao.addDoctor(doctor);
	}
	
	else if(type.equals("pharmacist")) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = "pharmacist";
		String fullname = request.getParameter("fullname");
		String department = request.getParameter("department");
		String mobileno = request.getParameter("mobileno");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		user.setMobileno(mobileno);
		user.setEmail(email);
		user.setAddress(address);
		user.setFullname(fullname);
		user.setDepartment(department);
		dao.addUser(user);
	}
	
	Gson gson = new Gson();
	String json = gson.toJson(dao.doctor(1));
	System.out.println(json);
	/**
	String id = request.getParameter("id");
	String output ="";
	if(id.equals("1")) { output="Anas"; }
	if(id.equals("2")) { output="Mannir"; }
	out.println(type);
	out.println(output);
	*/
	System.out.println("i received json call");
}


%>