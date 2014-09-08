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

import eHealth.Diagnosis;

public class DiagDao {
	private String protocol = "jdbc:derby:";
	public String dbhost = "localhost";
	public String dbport = "3306";
	public String dbname = "Database";
	public String dbdiagnosis = "admin";
	public String dbpass = "13131";
	public Connection cn = null;
	public String table = "ADMIN.DIAGNOSIS";
	
	public DiagDao(Connection con) {
		Connection con1 = null;
		Properties props = new Properties();
		props.put("dbdiagnosis", dbdiagnosis);
        props.put("dbpass", dbpass);       
        try { cn = DriverManager.getConnection(protocol + dbname + ";create=true", props);
        System.out.println("Connected to and created database " + dbname);
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
	
	public Diagnosis getdiagnosis(int id) {
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
	
	public String[] getDiagnosis(Connection cn, String fl) {
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
