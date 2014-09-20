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

import com.anas.ehealth.User;

public class UserDao {
	private String protocol = "jdbc:derby:";
	public String dbhost = "localhost";
	public String dbport = "3306";
	public String dbname = "Database";
	public String dbuser = "admin";
	public String dbpass = "13131";
	public Connection cn = null;
	public String table = "ADMIN.USER";
	
	public UserDao(Connection con) {
		Connection con1 = null;
		Properties props = new Properties();
		props.put("dbuser", dbuser);
        props.put("dbpass", dbpass);       
        try { cn = DriverManager.getConnection(protocol + dbname + ";create=true", props);
        System.out.println("Connected to and created database " + dbname);
		} catch (SQLException e) { e.printStackTrace(); }
	}
	public void addUser(User user) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO "+ table +"(ID, NAME, MOBILE, EMAIL, PASSWORD) "
					+ "VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getName());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			ps.executeUpdate();
			System.out.println("Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public User getPatient(int id) {
		User user = new User();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM "+table+" WHERE ID="+id); rs.next();
			user.setUserid(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setMobile(rs.getString("MOBILE"));
			user.setEmail(rs.getString("EMAIL"));
			user.setPassword(rs.getString("PASSWORD"));
		} catch (SQLException e) { e.printStackTrace(); } 

			
		return user;
	}
	
	public String[] getPatients(Connection cn, String fl) {
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
