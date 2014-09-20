package com.anas.ehealth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PersonDao {
	private String protocol = "jdbc:derby:";
	public String dbhost = "localhost";
	public String dbport = "3306";
	public String dbname = "Database";
	public String dbuser = "admin";
	public String dbpass = "13131";
	public Connection cn = null;
	public String persontable = "ADMIN.PERSON";

	public PersonDao(Connection con) {
		Connection con1 = null;
		Properties props = new Properties();
		props.put("dbuser", dbuser);
        props.put("dbpass", dbpass);       
        try { cn = DriverManager.getConnection(protocol + dbname + ";create=true", props);
        System.out.println("Connected to and created database " + dbname);
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public void addPerson(Person person) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO "+ persontable +"(FULLNAME, MOBILENO, ADDRESS, LGA, AMOUNT, BANKNAME, PHOTO, STATUS, DATEREG) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, person.getFullname());
			ps.setString(2, person.getMobileno());
			ps.setString(3, person.getMobileno());
			ps.setString(4, person.getLga());
			ps.setInt(5, person.getAmount());
			ps.setString(6, person.getBankname());
			ps.setString(7, person.getPhoto());
			ps.setString(8, person.getStatus());
			ps.setString(9, person.getDatereg());
			ps.executeUpdate();
			System.out.println("Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public Person getPerson(int id) {
		Person person = new Person();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM "+persontable+" WHERE ID="+id); rs.next();
			person.setFullname(rs.getString("FULLNAME"));
			person.setMobileno(rs.getString("MOBILENO"));
			person.setAddress(rs.getString("ADDRESS"));
			person.setLga(rs.getString("LGA"));
			person.setAmount(rs.getInt("AMOUNT"));
			person.setBankname(rs.getString("BANKNAME"));
			person.setPhoto(rs.getString("PHOTO"));
			person.setStatus(rs.getString("STATUS"));
			person.setDatereg(rs.getString("DATEREG"));	
		} catch (SQLException e) { e.printStackTrace(); } 

			
		return person;
	}
	
	public void update(Person person) {
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE ADMIN.PERSON SET FULLNAME=?, MOBILENO=?, ADDRESS=?, LGA=?, "
					+ "AMOUNT=?, BANKNAME=?, PHOTO=?, STATUS=?, DATEREG=? where ID=?");
			ps.setString(1, person.getFullname());
			ps.setString(2, person.getMobileno());
			ps.setString(3, person.getMobileno());
			ps.setString(4, person.getLga());
			ps.setInt(5, person.getAmount());
			ps.setString(6, person.getBankname());
			ps.setString(7, person.getPhoto());
			ps.setString(8, person.getStatus());
			ps.setString(9, person.getDatereg());
			ps.setInt(10, person.getId());
			ps.executeUpdate();
			System.out.println("Record Updated!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public void delete(Person person) {
		try { cn.createStatement().executeUpdate("DELETE FROM "+persontable+" WHERE ID=" + person.getId());
		} catch (SQLException e) { e.printStackTrace(); }
	}

}
