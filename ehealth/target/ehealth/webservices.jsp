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
com.anas.ehealth.dao.Patient,
com.anas.ehealth.dao.Prescription,
com.anas.ehealth.dao.Diagnosis
"%>

<%
Dao dao = new Dao();
//GET PATIENT
if(request.getParameter("type") != null && request.getParameter("type").equals("patient") && request.getParameter("method").equals("get")) {
	int id = Integer.parseInt(request.getParameter("id").toString());

	Patient patient = dao.getPatient(id);
	
	Gson gson = new Gson();
	String json = gson.toJson(patient);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	System.out.println(json);
}
//EDIT PATIENT
if(request.getParameter("type") != null && request.getParameter("type").equals("patient") && request.getParameter("method").equals("edit")) {
	String type = request.getParameter("type");
	String method = request.getParameter("method");
	
	int id = Integer.parseInt(request.getParameter("id"));
	String fullname = request.getParameter("fullname");
	String dob = request.getParameter("dob");
	String gender = request.getParameter("gender");
	String weight = request.getParameter("weight");
	String height = request.getParameter("height");
	String address = request.getParameter("address");
	String mobileno = request.getParameter("mobileno");
	
	Patient patient = new Patient();
	patient.setId(id);
	patient.setFullname(fullname);
	patient.setDob(dob);
	patient.setGender(gender);
	patient.setWeight(weight);
	patient.setHeight(height);
	patient.setAddress(address);
	patient.setMobileno(mobileno);
	
	//String datereg = request.getParameter("datereg");
	//String method = request.getParameter("method");
	dao.editPatient(patient);
}

if(request.getParameter("type") != null && request.getParameter("type").equals("prescription") && request.getParameter("method").equals("add")) {
	String type = request.getParameter("type");
	String method = request.getParameter("method");
	
	String patientid = request.getParameter("patientid");
	String patientname = request.getParameter("patientname");
	String drugname = request.getParameter("drugname");
	String dosage = request.getParameter("dosage");
	String intake = request.getParameter("intake");
	String duration = request.getParameter("duration");
	String notes = request.getParameter("notes");
	
	Prescription prs = new Prescription();
	prs.setPatientid(patientid);
	prs.setDrugname(drugname);
	prs.setDosage(dosage);
	prs.setIntake(intake);
	prs.setDuration(duration);
	prs.setNote(notes);
	
	dao.addprescription(prs);
}


if(request.getParameter("type") != null && request.getParameter("type").equals("diagnosis") && request.getParameter("method").equals("edit")) {
	if(request.getParameter("type") != null && request.getParameter("type").equals("patient") && request.getParameter("method").equals("edit")) {
		String type = request.getParameter("type");
		String method = request.getParameter("method");
		
		String patientid = (request.getParameter("patientid")).toString();
		String patientname = request.getParameter("patientname");
		String doctorid = request.getParameter("doctorid");
		String diagnosis = request.getParameter("diagnosis");
		String notes = request.getParameter("notes");
		
		Diagnosis diag = new Diagnosis();
		
		diag.setPatientid(patientid);
		diag.setPatientname(patientname);
		diag.setDoctorid(doctorid);
		diag.setDiagnosis(diagnosis);
		diag.setNotes(notes);
		
		
		dao.editDiagnosis(diag);
	}

}

/**
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

	System.out.println("i received json call");
	
}

*/
%>