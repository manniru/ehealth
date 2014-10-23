package com.anas.ehealth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.anas.ehealth.Db;
import com.anas.ehealth.dao.Diagnosis;
import com.anas.ehealth.dao.User;
import com.anas.ehealth.dao.Patient;
import com.anas.ehealth.dao.Prescription;
import com.google.gson.Gson;



public class Dao {
	Db db = new Db("jdbc:mysql://localhost/ehealth" , "root", "");
	static Connection cn = null;
	
	public Dao() {
		cn = db.cn();
	}
	
	

	public static void main(String[] args) {
		System.out.println("hi");
		
		Dao dao = new Dao();
		
		
		AppointmentDao app = dao.getApp(4);
		
		Gson gson = new Gson();
		String json = gson.toJson(app);
		System.out.println(json);
		
		
		
		//Doctor doctor = dao.doctor(1);
		//dao.addDoctor(doctor);
		
		//Patient patient = dao.patient();
		//dao.addPatient(patient);
		//System.out.println(dao.toString(patient));
		
		// test add
		/**
		Prescription prs = new Prescription();
		
		prs.setPatientid("1");
		prs.setPharmid("2");
		prs.setPatientname("test1");
		prs.setDrugname("drugname");
		prs.setDosage("dosage");
		prs.setIntake("intake");
		prs.setDuration("duration");
		prs.setNote("notes");
		
		dao.addprescription(prs);
		*/
	}

	
	public boolean validateUser(String user, String pass) {
		String user1, pass1, access;
		boolean rtn = false;
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM users WHERE `username` ='"+user+"'");
			if(rs.next()){
				 user1 = rs.getString("username");
				 pass1 = rs.getString("password");
				 access = rs.getString("access");
				 
				 if(user.equals(user1) && pass.equals(pass1) && access.equals("allowed")) { 
					 
					 rtn = true; 
					 System.out.println("true"); 
				 }
					else {
							rtn = false;
							System.out.println("false"); 
						  }
					
			}else{
					rtn = false;
				 }
			
			} catch(Exception e) { System.out.println(e); }
		
		return rtn;
	}
	/**
	public Patient patient() {
		Patient patient = new Patient();
		int id = 1;
		String username = "patient1";
		String password = "patient1";
		String fullname = "Auwal Muhammad";
		String dob = "1980-05-03";
		String gender = "Male";
		int height = 165;
		int weight = 65;
		String address = "Bukit Jalil";
		String mobileno = "60336352527";
		String datereg = "2014-09-07";
		
		patient.setUsername(username);
		patient.setPassword(password);
		patient.setFullname(fullname);
		patient.setDob(dob);
		patient.setGender(gender);
		patient.setHeight(height);
		patient.setWeight(weight);
		patient.setAddress(address);
		patient.setMobileno(mobileno);
		patient.setDatereg(datereg);
		
		return patient;
	}
	*/
	/**
	public String toString(Patient patient){
        StringBuilder sb = new StringBuilder();
        sb.append("******* User Details *******\n");
        sb.append("ID="+patient.getId()+"\n");
        sb.append("Username="+patient.getUsername()+"\n");
        sb.append("Password="+patient.getPassword()+"\n");
        sb.append("Fullname="+patient.getFullname()+"\n");
        sb.append("DOB="+patient.getDob()+"\n");
        sb.append("Gender="+patient.getGender()+"\n");
        sb.append("Height="+patient.getHeight()+"\n");
        sb.append("Weight="+patient.getWeight()+"\n");
        sb.append("Address="+patient.getAddress()+"\n");
        sb.append("Mobileno="+patient.getMobileno()+"\n");
        sb.append("DateReg="+patient.getDatereg()+"\n");
        //sb.append("Phone Numbers="+Arrays.toString(getPhoneNumbers())+"\n");
        //sb.append("Cities="+Arrays.toString(getCities().toArray())+"\n");
        sb.append("*****************************");
         
        return sb.toString();
    }
	*/
	
	public void addPatient(Patient patient) {
		System.out.println("mmm"+patient.getUsername());
		//String userid = "";
		try {
			//String sql1 = "INSERT INTO `users` (`username`, `password`, `role`, `fullname`,`email`) VALUES (?, ?, ?, ?,?)";
			String sql = "INSERT INTO `patient` (`fullname`, `dob`, `gender`, `weight`, `height`, `address`, `mobileno`, `uid`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			/*PreparedStatement ps1 = cn.prepareStatement(sql1);
			ps1.setString(1, patient.getUsername());
			ps1.setString(2, patient.getPassword());
			ps1.setString(3, "patient");
			ps1.setString(4, patient.getFullname());
			ps1.setString(5, patient.getEmail());
			ps1.executeUpdate();
			
			//getUserid();
			
			String userid = getUserid();
			System.out.println(userid);*/
			
			PreparedStatement ps = cn.prepareStatement(sql);
			//TODO CHANGE THIS ID to UID from database table
			ps.setString(1, patient.getFullname());
			ps.setString(2, patient.getDob());
			ps.setString(3, patient.getGender());
			ps.setInt(4, Integer.parseInt(patient.getWeight()));
			ps.setInt(5, Integer.parseInt(patient.getHeight()));
			ps.setString(6, patient.getAddress());
			ps.setString(7, patient.getMobileno());
			ps.setString(8, patient.getUid());
			ps.executeUpdate();
			System.out.println("Patient Record Saved!");

		} catch (SQLException e) { e.printStackTrace(); }
		
	}
	
	public void addEmployee(Employee emp) {
		System.out.println("mmm"+emp.getUsername());
		
		try {
			String sql1 = "INSERT INTO `users` (`username`, `password`, `role`, `fullname`) VALUES (?, ?, ?, ?)";
			String sql = "INSERT INTO `employee` (`name`, `email`, `mobileno`, `address`, `role`, `uid`) VALUES (?, ?, ?, ?, ?,?)";

			PreparedStatement ps1 = cn.prepareStatement(sql1);
			ps1.setString(1, emp.getUsername());
			ps1.setString(2, emp.getPassword());
			ps1.setString(3, emp.getRole());
			ps1.setString(4, emp.getFullname());
			ps1.executeUpdate();
			
			String userid = getUserid();
			System.out.println(userid);
			//String userid = "45";
			
			PreparedStatement ps = cn.prepareStatement(sql);
			//TODO CHANGE THIS ID to UID from database table
			ps.setString(1, emp.getFullname());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getMobileno());
			ps.setString(4, emp.getAddress());
			ps.setString(5, emp.getRole());
			ps.setString(6, userid);
			ps.executeUpdate();
			System.out.println("Record Saved!");

		} catch (SQLException e) { e.printStackTrace(); }
		
	}

	
	
	public String[] getColumns(String tb) {
		String[] simpleArray = null;
		   try { Statement st = cn.createStatement(); 
		   	ResultSet rs = st.executeQuery("SELECT * FROM "+tb);
		     ResultSetMetaData md = rs.getMetaData();
		     int columns = md.getColumnCount();     
		     List<String> where = new ArrayList();
		     for (int i = 1; i <= columns; i++) {where.add(md.getColumnName(i)); }
		     simpleArray = new String[where.size()];
		     where.toArray(simpleArray);
		   }
		   catch (Exception e1) { System.out.println(e1); }
		   return simpleArray;
	}
	
	public static Object[][] getData(String tb) {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT * FROM "+tb);
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getData()"+e3);
		
		}
		return oo;
	}
	
	public static Object[][] getPresc() {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT drugname,dosage,intake, duration,date,notes FROM prescription WHERE `status`='unfiled' AND patientid=");
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getData()"+e3);
		
		}
		return oo;
	}
	
	
	public static Object[][] getPatientPresc(int id) {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT id,drugname,dosage,intake, duration,notes,date FROM prescription WHERE `status`='unfiled' AND patientid="+id);
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getData()"+e3);
		
		}
		return oo;
	}
		
	
	/*public void addUser1(User user) {
		try {
			String sql = "INSERT INTO `doctor`(`username`, `password`, `fullname`, `mobileno`, `email`, `address`, `department`) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getRole());
			ps.setString(6, user.);
			ps.executeUpdate();
			System.out.println("Doctor Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
	}*/
	
	public void adddiagnosis(Diagnosis diagnosis) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO diagnosis (DOCTORID, PATIENTID, PATIENTNAME, DIAGNOSIS, NOTES) "
					+ "VALUES(?, ?, ?, ?, ?)");
			
			ps.setString(1, diagnosis.getDoctorid());
			ps.setString(2, diagnosis.getPatientid());
			ps.setString(3, diagnosis.getPatientname());
			ps.setString(4, diagnosis.getDiagnosis());
			ps.setString(5, diagnosis.getNotes());
			ps.executeUpdate();
			System.out.println("Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
}
	
	public Diagnosis getrecentdiagnosis(int id) {
		Diagnosis diagnosis = new Diagnosis();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT MAX(id), diagnosis, notes FROM diagnosis WHERE patientid="+id); rs.next();
			
			diagnosis.setDiagnosis(rs.getString("DIAGNOSIS"));
			diagnosis.setNotes(rs.getString("NOTES"));
		} catch (SQLException e) { e.printStackTrace(); } 

			
		return diagnosis;
	}
	
	public String[] getDiagnosis(Connection cn, String fl, String table) {
		String[] simpleArray = null;
		   try { Statement st = cn.createStatement(); 
		   	ResultSet rs = st.executeQuery("SELECT "+fl+" FROM "+table+" ORDER BY id");
		   	
		   	List<String> ls = new ArrayList();
		   	while(rs.next()) { ls.add(rs.getString(fl)); }
		     
		     simpleArray = new String[ls.size()];
		     ls.toArray(simpleArray);
		   }
		   catch (Exception e1) { System.out.println(e1); }
		   return simpleArray;
	}
	
	public Prescription getPatientPrescription(int id) {
		Prescription prescription = new Prescription();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM prescription WHERE PATIENTID="+id); rs.next();
			prescription.setId(rs.getInt("ID"));
			prescription.setPharmid(rs.getString("PHARMID"));
			prescription.setPatientid(rs.getString("PATID"));
			prescription.setPatientname(rs.getString("PATNAME"));
			prescription.setDrugname(rs.getString("DRUGNAME"));
			prescription.setDosage(rs.getString("DOSAGE"));
			prescription.setIntake(rs.getString("INTAKE"));
			prescription.setDuration(rs.getString("DURATION"));
			prescription.setNote(rs.getString("NOTE"));	
		} catch (SQLException e) { e.printStackTrace(); } 

			
		return prescription;
	}
	
	public String[] getPrescriptions(Connection cn, String fl, String table) {
		String[] simpleArray = null;
		   try { Statement st = cn.createStatement(); 
		   	ResultSet rs = st.executeQuery("SELECT "+fl+" FROM "+table+" ORDER BY id");
		   	
		   	List<String> ls = new ArrayList();
		   	while(rs.next()) { ls.add(rs.getString(fl)); }
		     
		     simpleArray = new String[ls.size()];
		     ls.toArray(simpleArray);
		   }
		   catch (Exception e1) { System.out.println(e1); }
		   return simpleArray;
	}
	/**
	public User user(int id) {
		User user = new User();
		String username = "user1";
		String password = "pass1";
		String role = "nurse";
		String fullname = "Auwal Ismail";
		
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		user.setFullname(fullname);
		
		return user;
	}
	*/
	
	public void addDoctor(Doctor doctor) {
		int uid = 0;
		
		try {
			String sql1 = "INSERT INTO `users`(`username`, `password`, `role`, `fullname`) VALUES (?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql1);
			ps.setString(1, doctor.getUsername());
			ps.setString(2, doctor.getPassword());
			ps.setString(3, doctor.getRole());
			ps.setString(4, doctor.getFullname());
			ps.executeUpdate();
			System.out.println("User Added!");
		} catch(Exception e) { System.out.println(e); }
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT id FROM users ORDER BY id DESC LIMIT 1"); rs.next();
			uid = Integer.parseInt(rs.getString("id"));
			System.out.println(uid);
		} catch(Exception e) { System.out.println(e); }

		try {
			
			String sql2 = "INSERT INTO `doctor`(`fullname`, `address`, `mobile`, `department`, `uid`) VALUES (?,?,?,?,?)";
			PreparedStatement ps2 = cn.prepareStatement(sql2);
			ps2.setString(1, doctor.getFullname());
			ps2.setString(2, doctor.getAddress());
			ps2.setString(3, doctor.getMobileno());
			ps2.setString(4, doctor.getDepartment());
			ps2.setInt(5, uid);
			
			ps2.executeUpdate();
			System.out.println("Doctor Record Added!");
			
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public void addUser(User user) {
			
		try {
			String sql = "INSERT INTO `users`(`username`, `password`, `fullname`, `email`, `role`,  `access`) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getRole());
			ps.setString(6, user.getAccess());
			
			ps.executeUpdate();
			System.out.println("Pharmacist Added!");
		} catch(Exception e) { System.out.println(e); }
		
	}
	
	public Patient getPatient(int id) {
		Patient patient = new Patient();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM patient WHERE id="+id); rs.next();
			//int id = Integer.parseInt(rs.getString("id"));
			String fullname = rs.getString("fullname");
			String dob = rs.getString("dob");
			String gender = rs.getString("gender");
			String weight = rs.getString("weight");
			String height = rs.getString("height");
			String address = rs.getString("address");
			String mobileno = rs.getString("mobileno");
			String datereg = rs.getString("datereg");
			String uid = rs.getString("uid");
			
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
			//patient.setUsername(username);
			//patient.setPassword(password);
			
		} catch (SQLException e) { e.printStackTrace(); } 			
		return patient;
	}
	
	public void editPatient(Patient patient) {
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE patient SET fullname=?, dob=?, gender=?, weight=?, height=?, address=?, mobileno=? WHERE id = ?");
			ps.setString(1, patient.getFullname());
			ps.setString(2, patient.getDob());
			ps.setString(3, patient.getGender());
			ps.setString(4, patient.getWeight());
			ps.setString(5, patient.getWeight());
			ps.setString(6, patient.getAddress());
			ps.setString(7, patient.getMobileno());
			ps.setInt(8, patient.getId());
			ps.executeUpdate(); 
			System.out.println("Record updated!");
			
		} catch(Exception e) { System.out.println(e); }
	}
	
	public void addprescription(Prescription prescription) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO prescription (PHARMID, PATIENTID, PATIENTNAME, DRUGNAME, DOSAGE, INTAKE, DURATION, NOTES) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			//ps.setInt(1, prescription.getId());
			ps.setString(1, prescription.getPharmid());
			ps.setString(2, prescription.getPatientid());
			ps.setString(3, prescription.getPatientname());
			ps.setString(4, prescription.getDrugname());
			ps.setString(5, prescription.getDosage());
			ps.setString(6, prescription.getIntake());
			ps.setString(7, prescription.getDuration());
			ps.setString(8, prescription.getNote());
			ps.executeUpdate();
			System.out.println("Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
		
	}
	
	public Prescription getPrescription(int id) {
		Prescription prescription = new Prescription();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM prescription WHERE ID="+id); rs.next();
			prescription.setId(rs.getInt("ID"));
			prescription.setPharmid(rs.getString("PHARMID"));
			prescription.setPatientid(rs.getString("PATID"));
			prescription.setPatientname(rs.getString("PATNAME"));
			prescription.setDrugname(rs.getString("DRUGNAME"));
			prescription.setDosage(rs.getString("DOSAGE"));
			prescription.setIntake(rs.getString("INTAKE"));
			prescription.setDuration(rs.getString("DURATION"));
			prescription.setNote(rs.getString("NOTE"));	
		} catch (SQLException e) { e.printStackTrace(); } 

			
		return prescription;
	}
	
	public String[] getPrescriptions(Connection cn, String fl) {
		String[] simpleArray = null;
		   try { Statement st = cn.createStatement(); 
		   	ResultSet rs = st.executeQuery("SELECT "+fl+" FROM prescription ORDER BY id");
		   	
		   	List<String> ls = new ArrayList();
		   	while(rs.next()) { ls.add(rs.getString(fl)); }
		     
		     simpleArray = new String[ls.size()];
		     ls.toArray(simpleArray);
		   }
		   catch (Exception e1) { System.out.println(e1); }
		   return simpleArray;
	}
	
	public void editPrescription(Prescription prescription) {
	
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE prescription SET drugname=?, dosage=?, intake=?, duration=?, notes=? WHERE id = ?");
			ps.setString(1, prescription.getDrugname());
			ps.setString(2, prescription.getDosage());
			ps.setString(3, prescription.getIntake());
			ps.setString(4, prescription.getDuration());
			ps.setString(5, prescription.getNote());
			ps.setInt(6, prescription.getId());
			ps.executeUpdate();
			
			System.out.println("Record updated!");
			
		} catch(Exception e) { System.out.println(e); }}
	
	public void filePrescription(Prescription prescription) {
		
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE prescription SET pharmid=?, status=? WHERE id = ?");
			ps.setString(1, prescription.getPharmid());
			ps.setString(2, prescription.getStatus());
			ps.setInt(3, prescription.getId());
			ps.executeUpdate();
			
			System.out.println("Record updated!");
			
		} catch(Exception e) { System.out.println(e); }}
	
	public Object[][] data() {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT * FROM prescription");
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount-1; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("regData()"+e3);
		
		}
		return oo;
	}
	
	public Diagnosis getdiagnosis(int id) {
		Diagnosis diagnosis = new Diagnosis();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM diagnosis WHERE patientid="+id); rs.next();
			diagnosis.setId(rs.getInt("ID"));
			diagnosis.setDoctorid(rs.getString("DOCID"));
			diagnosis.setPatientid(rs.getString("PATID"));
			diagnosis.setPatientname(rs.getString("PATNAME"));
			diagnosis.setDiagnosis(rs.getString("DIAGNOSIS"));
			diagnosis.setNotes(rs.getString("NOTES"));
		} catch (SQLException e) { e.printStackTrace(); } 

			
		return diagnosis;
	}
	
	public String[] getDiagnosis(Connection cn, String fl) {
		String[] simpleArray = null;
		   try { Statement st = cn.createStatement(); 
		   	ResultSet rs = st.executeQuery("SELECT "+fl+" FROM diagnosis ORDER BY id");
		   	
		   	List<String> ls = new ArrayList();
		   	while(rs.next()) { ls.add(rs.getString(fl)); }
		     
		     simpleArray = new String[ls.size()];
		     ls.toArray(simpleArray);
		   }
		   catch (Exception e1) { System.out.println(e1); }
		   return simpleArray;
	}
	
	public Object[][] data1() {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT * FROM diagnosis");
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount-1; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("regData()"+e3);
		
		}
		return oo;
	}
	public void editDiagnosis(Diagnosis diagnosis) {
		int pid = 0;
		try { pid = Integer.parseInt(diagnosis.getPatientid()); } catch(Exception e) { System.out.println(e); }
		
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE `diagnosis` SET `doctorid`=?,`patientname`=?,`diagnosis`=?,`notes`=? WHERE patientid=?");
			ps.setString(1, diagnosis.getDoctorid());
			ps.setString(2, diagnosis.getPatientname());
			ps.setString(3, diagnosis.getDiagnosis());
			ps.setString(4, diagnosis.getNotes());
			ps.setInt(5, pid);
			ps.executeUpdate(); 
			System.out.println("Diagnosis updated!");
			
		} catch(Exception e) { System.out.println(e); }
	}
	
	public void editUser(User user) {
		int uid = 0;
		try { uid = (user.getId()); } catch(Exception e) { System.out.println(e); }
		
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE `users` SET `username`=?,`password`=?,`email`=? WHERE id=?");//,`mobile`=?
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, uid);
			ps.executeUpdate(); 
			System.out.println("Diagnosis updated!");
			
		} catch(Exception e) { System.out.println(e); }
	}
	public User getUser(int id) {
		User user = new User();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM users WHERE id="+id); rs.next();
			
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setFullname(rs.getString("fullname"));
			user.setRole("role");
			
		} catch (SQLException e) { e.printStackTrace(); } 
			
		return user;
	} 
	public void addWaiting(Waiting waiting) {
		try{
			
			String id = waiting.getPatientid();
			
			Statement st = cn.createStatement(); 
		   	ResultSet rs = st.executeQuery("SELECT * FROM waiting where patientid ="+id);
		
		   	if (rs.next()==false){
		   		
		   	PreparedStatement ps = cn.prepareStatement("INSERT INTO waiting (PATIENTID, PATIENTNAME, DATE, TIME) "
					+ "VALUES(?, ?, ?, ?)");
			
			ps.setString(1, waiting.getPatientid());
			ps.setString(2,waiting.getFullname());
			ps.setString(3,waiting.getDate());
			ps.setString(4,waiting.getTime());
			ps.executeUpdate();
			System.out.println("Record Saved!");
		   	}
		
		} catch (SQLException e) { e.printStackTrace(); }
}
	
	public void cancelAppointment(AppointmentDao appointment){
		
	int appid = appointment.getId();
	String pid = appointment.getPatientid();
	
	try {
		
		cn.prepareStatement("UPDATE appointment SET (SELECT slotnumber FROM patappointment where pid ="+pid+") = ''  WHERE id ="+appid).executeUpdate();
		System.out.println("Record updated!");
		
	} catch(Exception e) { System.out.println(e); }
	
	try {
		cn.prepareStatement("DELETE * FROM patappointment  where pid ="+pid+" AND status = 'waiting'").executeUpdate();
	} catch(Exception e) { System.out.println(e); }
	}

	public static Object[][] getAllowedUsers() {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT id,username,fullname FROM users WHERE `access`='allowed'");
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getData()"+e3);
		
		}
		return oo;
	}
	
	public static Object[][] getUsers() {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT * FROM users WHERE `access`='allowed'");
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getData()"+e3);
		
		}
		return oo;
	}
	public static Object[][] getRevokedUsers() {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT id,username,fullname FROM users WHERE `access`='revoked'");
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getData()"+e3);
		
		}
		return oo;
	}
	
	public void allowAccess(int id){
		
		try {
		cn.prepareStatement("UPDATE users SET access = 'allowed' WHERE id ="+id).executeUpdate();
		} catch(Exception e3) { System.out.println(e3);}
	}
	public void revokeAccess(int id){
		
		try {
			cn.prepareStatement("UPDATE users SET access = 'revoked' WHERE id ="+id).executeUpdate();
			} catch(Exception e3) { System.out.println(e3);}
	}
	
	public Object[][] getPatient() {
		Object[][] oo = null;
		
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT * FROM patient");
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
		row = new Object[colCount];
		for (int a = 0; a < colCount; a++) {
		row[a] = r3.getObject(a + 1);
		}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getData()"+e3);
		
		}
		return oo;

	}
	public String getDate() {
		
			String rt = "";
			Date d = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			rt = ft.format(d);
			
			return rt;
		}
	
	public String getTime(String n, String m) {
		
		String rt = "";
		
		try { Statement st = cn.createStatement(); 
	   	ResultSet rs = st.executeQuery("SELECT slot"+n+" FROM appointmenttime WHERE doctorid="+m);rs.next();
		rt = rs.getString(1);
		} catch(Exception e) { System.out.println(e); }
		
		return rt;
	}
	
	public AppointmentDao getApp(int id) {
		AppointmentDao app = new AppointmentDao();
		
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT ID, DNAME, TIME, DATE FROM patappointment WHERE pid="+id); rs.next();
			app.setId(rs.getInt("id"));
			app.setDoctorname(rs.getString("dname"));
			app.setTime(rs.getString("time"));
			app.setDate(rs.getString("date"));
			
		} catch(Exception e) { System.out.println(e); }
		
		return app;
	}
	
	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM patient");
			while(rs.next()) {
				Patient patient = new Patient();
				int id = Integer.parseInt(rs.getString("id"));
				String fullname = rs.getString("fullname");
				String dob = rs.getString("dob");
				String gender = rs.getString("gender");
				String weight = rs.getString("weight");
				String height = rs.getString("height");
				String address = rs.getString("address");
				String mobileno = rs.getString("mobileno");
				String datereg = rs.getString("datereg");
				String uid = rs.getString("uid");
				
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
				
				
				patients.add(patient);
				System.out.println("All  "+patients);
			}
		} catch(Exception e) { System.out.println(e); }
		
		
		return patients;
		
	}
	
	public List<Prescription> getPatPresc(int id) {
		List<Prescription> prs = new ArrayList<Prescription>();
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM prescription WHERE ID="+id);
			while(rs.next()) {
				Prescription ps = new Prescription();
				
				
				ps.setId(rs.getInt("ID"));
				ps.setPharmid(rs.getString("PHARMID"));
				ps.setPatientid(rs.getString("PATID"));
				ps.setPatientname(rs.getString("PATNAME"));
				ps.setDrugname(rs.getString("DRUGNAME"));
				ps.setDosage(rs.getString("DOSAGE"));
				ps.setIntake(rs.getString("INTAKE"));
				ps.setDuration(rs.getString("DURATION"));
				ps.setNote(rs.getString("NOTE"));	

				
				prs.add(ps);
				System.out.println(prs);
			}
		} catch(Exception e) { System.out.println(e); }
		
		
		return prs;
		
	}
	
	public List<Diagnosis> getPatDiag(int id) {
		List<Diagnosis> diags = new ArrayList<Diagnosis>();
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM diagnosis WHERE patientid="+id); rs.next();
			while(rs.next()) {
				Diagnosis diag = new Diagnosis();
				
				
				diag.setId(rs.getInt("ID"));
				diag.setDoctorid(rs.getString("DOCID"));
				diag.setPatientid(rs.getString("PATID"));
				diag.setPatientname(rs.getString("PATNAME"));
				diag.setDiagnosis(rs.getString("DIAGNOSIS"));
				diag.setNotes(rs.getString("NOTES"));
				
				diags.add(diag);
				System.out.println(diags);
			}
		} catch(Exception e) { System.out.println(e); }
		
		
		return diags;
		
	}
	public String getUserid(){
		String userid = "";
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT id FROM users ORDER BY id DESC LIMIT 1"); rs.next();
			userid = rs.getString("id");
			System.out.println(userid);
		} catch(Exception e) { System.out.println(e); }
		return userid;
	}
}


