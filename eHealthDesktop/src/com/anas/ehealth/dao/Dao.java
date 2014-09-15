package com.anas.ehealth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anas.ehealth.Db;
import com.anas.ehealth.Diagnosis;
import com.anas.ehealth.Patient;
import com.anas.ehealth.Prescription;
import com.anas.ehealth.User;

public class Dao {
	Db db = new Db("jdbc:mysql://localhost/ehealth" , "root", "");
	static Connection cn = null;
	
	public Dao() {
		cn = db.cn();
	}

	public static void main(String[] args) {
		
		//cn = db.cn();
		Dao dao = new Dao();
		
		Patient patient = dao.patient();
		dao.addPatient(patient);
		System.out.println(dao.toString(patient));

	}
	
	public void addUser(User user) {
		//
	}
	
	public User getUser(int id) {
		User user = new User();
		
		return user;
	}
	
	public void editUser(User user) {
		//
	}
	
	public List listUsers() {
		List<User> users = new ArrayList();
		
		return users;
	}

	public void deleteUser(int id) {
		//
	}
	
	public boolean validateUser(String user, String pass) {
		boolean rtn = false;
		if(user.equals(pass)) { rtn = true; System.out.println("true"); }
		else { System.out.println("false"); }
		
		return rtn;
	}
	
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
	
	public void addPatient(Patient patient) {
		try {
			String sql = "INSERT INTO `patient`(`username`, `password`, `fullname`, `dob`, `gender`, `weight`, `height`, `address`, `mobileno`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, patient.getUsername());
			ps.setString(2, patient.getPassword());
			ps.setString(3, patient.getFullname());
			ps.setString(4, patient.getDob());
			ps.setString(5, patient.getGender());
			ps.setInt(6, patient.getWeight());
			ps.setInt(7, patient.getHeight());
			ps.setString(8, patient.getAddress());
			ps.setString(9, patient.getMobileno());
			ps.executeUpdate();
			System.out.println("Patient Record Saved!");
			//cn.close();
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
	
	public void addUser(Users user) {
		try {
			String sql = "INSERT INTO `doctor`(`username`, `password`, `fullname`, `mobileno`, `email`, `address`, `department`) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getMobileno());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getDepartment());
			ps.setString(8, user.getRole());
			ps.executeUpdate();
			System.out.println("Doctor Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public void adddiagnosis(Diagnosis diagnosis) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO "+ diagnosis +"(ID, DOCID, PATID, PATNAME, DIAGNOSIS, NOTES) "
					+ "VALUES(?, ?, ?, ?, ?, ?)");
			ps.setInt(1, diagnosis.getId());
			ps.setString(2, diagnosis.getDoctorid());
			ps.setString(3, diagnosis.getPatientid());
			ps.setString(4, diagnosis.getPatientname());
			ps.setString(5, diagnosis.getDiagnosis());
			ps.setString(5, diagnosis.getNotes());
			ps.executeUpdate();
			System.out.println("Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
}
	
	public Diagnosis getdiagnosis(int id, String table) {
		Diagnosis diagnosis = new Diagnosis();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM "+table+" WHERE ID="+id); rs.next();
			diagnosis.setId(rs.getInt("ID"));
			diagnosis.setDoctorid(rs.getString("DOCID"));
			diagnosis.setPatientid(rs.getString("PATID"));
			diagnosis.setPatientname(rs.getString("PATNAME"));
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
	
	public void addprescription(Prescription prescription) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO "+ prescription +"(ID, PHARMID, PATID, PATNAME, DRUGNAME, DOSAGE, INTAKE, DURATION, NOTE) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, prescription.getId());
			ps.setString(2, prescription.getPharmid());
			ps.setString(3, prescription.getPatientid());
			ps.setString(4, prescription.getPatientname());
			ps.setString(5, prescription.getDrugname());
			ps.setString(6, prescription.getDosage());
			ps.setString(7, prescription.getIntake());
			ps.setString(8, prescription.getDuration());
			ps.setString(9, prescription.getNote());
			ps.executeUpdate();
			System.out.println("Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public Prescription getPrescription(int id, String table) {
		Prescription prescription = new Prescription();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM "+table+" WHERE ID="+id); rs.next();
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
}


