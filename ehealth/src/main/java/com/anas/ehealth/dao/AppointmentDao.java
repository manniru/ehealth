package com.anas.ehealth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
	private String protocol = "jdbc:derby:";
	public String dbhost = "localhost";
	public String dbport = "3306";
	public String dbname = "Database";
	public String dbuser = "admin";
	public String dbpass = "13131";
	public Connection cn = null;
	public String appointable = "ADMIN.APPOINTMENT";
	public int id;
	public String doctorid;
	public String patientid;
	public String patientname;
	public String date;
	public String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public void addappointment(AppointmentDao appointment) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO "+ appointable +"(ID, PATID, DOCID, PATNAME, DATE, TIME) "
					+ "VALUES(?, ?, ?, ?, ?, ?)");
			ps.setInt(1, getId());
			ps.setString(2, getDoctorid());
			ps.setString(3, getPatientid());
			ps.setString(4, getPatientname());
			ps.setString(5, getDate());
			ps.setString(6, getTime());
			ps.executeUpdate();
			System.out.println("Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public AppointmentDao getAppointment(int id) {
		AppointmentDao appointmentdao = new AppointmentDao();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM "+appointable+" WHERE ID="+id); rs.next();
			appointmentdao.setId(rs.getInt("ID"));
			appointmentdao.setDoctorid(rs.getString("DOCID"));
			appointmentdao.setPatientid(rs.getString("PATID"));
			appointmentdao.setPatientname(rs.getString("DOB"));
			appointmentdao.setDate(rs.getString("AGE"));
			appointmentdao.setTime(rs.getString("HEIGHT"));
			} catch (SQLException e) { e.printStackTrace(); } 

			
		return appointmentdao;
	}
	
	public String[] getAppointments(Connection cn, String fl) {
		String[] simpleArray = null;
		   try { Statement st = cn.createStatement(); 
		   	ResultSet rs = st.executeQuery("SELECT "+fl+" FROM "+appointable+" ORDER BY id");
		   	
		   	List<String> ls = new ArrayList();
		   	while(rs.next()) { ls.add(rs.getString(fl)); }
		     
		     simpleArray = new String[ls.size()];
		     ls.toArray(simpleArray);
		   }
		   catch (Exception e1) { System.out.println(e1); }
		   return simpleArray;
	}
	
	public Object[][] data() {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT * FROM "+appointable);
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


}
