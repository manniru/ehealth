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

if(request.getParameter("type") != null && request.getParameter("type").equals("user") && request.getParameter("method").equals("login")) {

	String type = request.getParameter("type");
	String method = request.getParameter("method");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	System.out.println("userlogin detaiils:"+username+"=="+password);
	
	boolean value = dao.validateUser(username, password);
	out.println(value);
	

	
}


//ADD PATIENT
if(request.getParameter("type") != null && request.getParameter("type").equals("patient") && request.getParameter("method").equals("add")) {
	System.out.println("hello from add patient ws");
	String pname = request.getParameter("fullname");
	String dob = request.getParameter("dob");
	String gender = request.getParameter("gender");
	String weight = request.getParameter ("weight");
	String height = request.getParameter ("height");
	String address = request.getParameter ("address");
	String mobileno = request.getParameter ("mobileno");
	String username = request.getParameter ("username");
	String password = request.getParameter ("password");
	String email = request.getParameter ("email");
	
	
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
	user.setFullname(pname);
	user.setEmail(email);
	user.setRole("patient");
	user.setAccess("allowed");
	dao.addUser(user);
	
	String uid = dao.getUserid();
	
	Patient patient = new Patient();
	patient.setFullname(pname);
	patient.setDob(dob);
	patient.setGender(gender);
	patient.setHeight(height);
	patient.setWeight(weight);
	patient.setAddress(address);
	patient.setMobileno(mobileno);
	patient.setUid(uid);
	System.out.println("patient add at ws"+username);
	dao.addPatient(patient);
}

//ADD DIAGNOSIS
if(request.getParameter("type") != null && request.getParameter("type").equals("diagnosis") && request.getParameter("method").equals("add")) {
	
	String id = request.getParameter("patientid");
	String pname = request.getParameter("patientname");
	String docid = request.getParameter("doctorid");
	String diagnosis = request.getParameter("diagnosis");
	String notes = request.getParameter ("notes");
	
	Diagnosis diag = new Diagnosis();
	
	diag.setPatientid(id);
	diag.setPatientname(pname);
	diag.setDoctorid(docid);
	diag.setDiagnosis(diagnosis);
	diag.setNotes(notes);
	
	dao.adddiagnosis(diag);
	System.out.println("we are at webservice jsp with "+id);
	
}

//ADD PRESCRIPTION
if(request.getParameter("type") != null && request.getParameter("type").equals("prescription") && request.getParameter("method").equals("add")) {
	
	String id = request.getParameter("patientid");
	String pname = request.getParameter("patientname");
	String pharmid = request.getParameter("pharmid");
	String dname = request.getParameter("drugname");
	String dosage = request.getParameter("dosage");
	String intake = request.getParameter("intake");
	String duration = request.getParameter("duration");
	String notes = request.getParameter("notes");
	
	Prescription prs = new Prescription();
	
	prs.setPatientid(id);
	prs.setPatientname(pname);
	prs.setDrugname(dname);
	prs.setDosage(dosage);
	prs.setIntake(intake);
	prs.setDuration(duration);
	prs.setNote(notes);
	
	dao.addprescription(prs);
}
//ADD WAITING
if(request.getParameter("type") != null && request.getParameter("type").equals("waiting") && request.getParameter("method").equals("add")) {
	
	String id = request.getParameter("id");
	String pname = request.getParameter("fullname");
	String date = request.getParameter("date");
	String time = request.getParameter("time");
	
	System.out.print(id+pname+date+time);
	
	Waiting wait = new Waiting();
	
	wait.setPatientid(id);
	wait.setFullname(pname);
	wait.setDate(date);
	wait.setTime(time);
	
	dao.addWaiting(wait);
	
	
	
}

//ADD EMPLOYEE
if(request.getParameter("type") != null && request.getParameter("type").equals("employee") && request.getParameter("method").equals("add")) {
	
	System.out.println("hello from add patient ws");
	
	String fullname = request.getParameter("fullname");
	String mobileno = request.getParameter("mobileno");
	String email = request.getParameter("email");
	String dept = request.getParameter ("dept");
	String address = request.getParameter ("address");
	String role = request.getParameter ("role");
	String username = request.getParameter ("username");
	String password = request.getParameter ("password");
	
	Employee emp = new Employee();
	
	emp.setFullname(fullname);
	emp.setDepartment(dept);
	emp.setEmail(email);
	emp.setMobileno(mobileno);
	emp.setAddress(address);
	emp.setRole(role);
	emp.setUsername(username);
	emp.setPassword(password);
	
	System.out.println("patient add at ws"+username);
	dao.addEmployee(emp);
}
//GET PATIENT
if(request.getParameter("type") != null && request.getParameter("type").equals("patient") && request.getParameter("method").equals("get")) {
	String pid = request.getParameter("id").toString();
	
	int id = Integer.parseInt(pid);
	Patient patient = dao.getPatient(id);
	
	Gson gson = new Gson();
	String json = gson.toJson(patient);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
}
//GET USER
if(request.getParameter("type") != null && request.getParameter("type").equals("user") && request.getParameter("method").equals("get")) {
	String pid = request.getParameter("id").toString();
	int id = Integer.parseInt(pid);
	
	User user = dao.getUser(id);

	
	Gson gson = new Gson();
	String json = gson.toJson(user);
	System.out.println(json);

	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	}
//GET PRESC
if(request.getParameter("type") != null && request.getParameter("type").equals("prescription") && request.getParameter("method").equals("get")) {
	String pid = request.getParameter("id").toString();
	
	int id = Integer.parseInt(pid);
	
	Prescription prescription = dao.getPrescription(id);
	
	Gson gson = new Gson();
	String json = gson.toJson(prescription);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	System.out.println(json);
}
//GET DIAG
if(request.getParameter("type") != null && request.getParameter("type").equals("diagnosis") && request.getParameter("method").equals("get")) {
	String pid = request.getParameter("id");//.toString();
	
	int id = Integer.parseInt(pid);
	
	Diagnosis diagnosis = dao.getdiagnosis(id);
	
	Gson gson = new Gson();
	String json = gson.toJson(diagnosis);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	System.out.println(json);
}
/* //GET USER
if(request.getParameter("type") != null && request.getParameter("type").equals("user") && request.getParameter("method").equals("get")) {
	String uid = request.getParameter("id");//.toString();
	
	int id = Integer.parseInt(uid);
	
	User user = dao.getUser(id);
	
	Gson gson = new Gson();
	String json = gson.toJson(user);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	System.out.println(json); 
}*/
//GET RECENT DIAG
if(request.getParameter("type") != null && request.getParameter("type").equals("diagnosis") && request.getParameter("method").equals("get2")) {
	String pid = request.getParameter("id");//.toString();
	
	int id = Integer.parseInt(pid);
	System.out.println("diag id = "+id);
	
	Diagnosis diagnosis = dao.getrecentdiagnosis(id);
	
	Gson gson = new Gson();
	String json = gson.toJson(diagnosis);
	
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
// EDIT PRESCRIPTION
if(request.getParameter("type") != null && request.getParameter("type").equals("prescription") && request.getParameter("method").equals("edit")) {
	String type = request.getParameter("type");
	String method = request.getParameter("method");

	String patientid = request.getParameter("patientid");
	String patientname = request.getParameter("patientname");
	String pharmid = request.getParameter("pharmid");
	int prescid = Integer.parseInt(request.getParameter("prescid"));
	String drugname = request.getParameter("drugname");
	String dosage = request.getParameter("dosage");
	String intake = request.getParameter("intake");
	String duration = request.getParameter("duration");
	String notes = request.getParameter("notes");
	
	Prescription prs = new Prescription();
	
	prs.setId(prescid);
	prs.setPatientid(patientid);
	prs.setPatientname(patientname);
	prs.setPharmid(pharmid);
	prs.setDrugname(drugname);
	prs.setDosage(dosage);
	prs.setIntake(intake);
	prs.setDuration(duration);
	prs.setNote(notes);

	dao.editPrescription(prs);
}

// EDIT DIAGNOSIS
if(request.getParameter("type") != null && request.getParameter("type").equals("diagnosis") && request.getParameter("method").equals("edit")) {
		String type = request.getParameter("type");
		String method = request.getParameter("method");
		
		String pid = (request.getParameter("pid"));//.toString();
		String pname = request.getParameter("pname");
		String doctorid = request.getParameter("did");
		String diagnosis = request.getParameter("diagnosis");
		String notes = request.getParameter("notes");
		
		
		Diagnosis diag = new Diagnosis();
		
		diag.setPatientid(pid);
		diag.setPatientname(pname);
		diag.setDoctorid(doctorid);
		diag.setDiagnosis(diagnosis);
		diag.setNotes(notes);
		
		
		dao.editDiagnosis(diag);
		

}

//EDIT USER
if(request.getParameter("type") != null && request.getParameter("type").equals("user") && request.getParameter("method").equals("edit")) {
		String type = request.getParameter("type");
		String method = request.getParameter("method");
		
		int uid = Integer.parseInt(request.getParameter("userid"));
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setEmail(email);
		user.setUsername(uname);
		user.setPassword(pass);
		user.setId(uid);
		
		
		dao.editUser(user);	
}


//FILE PRESCRIPTION
if(request.getParameter("type") != null && request.getParameter("type").equals("prescription") && request.getParameter("method").equals("file")) {
	
	String type = request.getParameter("type");
	String method = request.getParameter("method");
	String pharmid = request.getParameter("pharmid");
	String status = request.getParameter("status");
	int prescid = Integer.parseInt(request.getParameter("prescid"));
	
	
	Prescription prs = new Prescription();
	
	prs.setId(prescid);
	prs.setPharmid(pharmid);
	prs.setStatus(status);

	dao.filePrescription(prs);
}


//GET PATIENT PRESC
if(request.getParameter("type") != null && request.getParameter("type").equals("prescription") && request.getParameter("method").equals("get1")) {
	int id = Integer.parseInt(request.getParameter("id"));//.toString());

	Prescription prescription = dao.getPrescription(id);
	
	Gson gson = new Gson();
	String json = gson.toJson(prescription);
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	System.out.println(json);
}

//FILE PRESCRIPTION
if(request.getParameter("type") != null && request.getParameter("type").equals("app") && request.getParameter("method").equals("cancel")) {
	
	String type = request.getParameter("type");
	String method = request.getParameter("method");
	String appid = request.getParameter("appid");
	String pid = request.getParameter("pid");
	
	AppointmentDao app = new AppointmentDao();
	
	app.setId(Integer.parseInt(appid));
	app.setPatientid(pid);

	dao.cancelAppointment(app);
}

//ALLOW ACCESS
if(request.getParameter("type") != null && request.getParameter("type").equals("user") && request.getParameter("method").equals("allow")) {
	
	String type = request.getParameter("type");
	String method = request.getParameter("method");
	String id = request.getParameter("id");
	int uid = Integer.parseInt(id);
	System.out.println(uid);
	dao.allowAccess(uid);
	
}

//REVOKE ACCESS
if(request.getParameter("type") != null && request.getParameter("type").equals("user") && request.getParameter("method").equals("revoke")) {
	
	String type = request.getParameter("type");
	String method = request.getParameter("method");
	String id = request.getParameter("id");
	int uid = Integer.parseInt(id);
	System.out.println(uid);
	dao.revokeAccess(uid);
	
}

//LOGIN


/**if(request.getParameter("type") != null) {
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