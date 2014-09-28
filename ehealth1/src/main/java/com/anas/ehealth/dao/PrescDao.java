package com.anas.ehealth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PrescDao {
	private String protocol = "jdbc:derby:";
	public String dbhost = "localhost";
	public String dbport = "3306";
	public String dbname = "Database";
	public String dbuser = "admin";
	public String dbpass = "13131";
	public Connection cn = null;
	public String table = "ADMIN.PRESCRIPTION";
	
	public PrescDao(Connection con) {
		Connection con1 = null;
		Properties props = new Properties();
		props.put("dbuser", dbuser);
        props.put("dbpass", dbpass);       
        try { cn = DriverManager.getConnection(protocol + dbname + ";create=true", props);
        System.out.println("Connected to and created database " + dbname);
		} catch (SQLException e) { e.printStackTrace(); }
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
	
	public Prescription getPrescription(int id) {
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
	
	public String[] getPrescriptions(Connection cn, String fl) {
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
	
	public Object[][] data() {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT * FROM "+table);
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
