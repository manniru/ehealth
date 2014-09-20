package eHealth;

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

import com.anas.ehealth.dao.Patient;

public class Db1 {
	public String dbhost = "localhost";
	public String dbport = "3306";
	public String dbname = "Ehealth";
	public String dbuser = "admin";
	public String dbpass = "";
	public Connection cn = null;
	public String patienttable = "ADMIN.PATIENT";
	public String diagtable = "ADMIN.DIAGNOSIS";
	public String presctable = "ADMIN.PRESCRIPTION";
	public String usertable = "ADMIN.PRESCRIPTION";
	public String appointable = "ADMIN.PRESCRIPTION";
	
	private String framework = "embedded";
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby:";

	public static void main(String[] args) {
		Db1 db = new Db1();
		db.connect();
		db.createTable("patienttable");
		
		String name = "Hajiya Hauwa";
		String mobileno = "07048383738";
		String email = "hajh@yahoo.com";
		String dob = "2014-07-24";
		int age = 25000;
		int height = 25;
		int weight = 80;
		String allergies = "Unpaid";
		String password = "Gusau";
		
		Patient patient = new Patient();
		patient.setName(name);
		patient.setMobileno(mobileno);
		patient.setEmail(email);
		patient.setDob(dob);
		patient.setAge(age);
		patient.setHeight(height);
		patient.setWeight(weight);
		patient.setAllergies(allergies);
		patient.setPassword(password);
		
		db.addpatient(patient);

	}
	
	public Db1() {
		connect();
	}
	
	public Connection connect() {
		Connection con = null;
		Properties props = new Properties();
		props.put("dbuser", dbuser);
        props.put("dbpass", dbpass);
        
        try { cn = DriverManager.getConnection(protocol + dbname + ";create=true", props);
        System.out.println("Connected to and created database " + dbname);
		} catch (SQLException e) { e.printStackTrace(); }
		return con;
	}
	
	public void createTable(String name) {
		String sql1 = "CREATE TABLE "+ patienttable
				+ "(ID SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY,"
				+ "NAME VARCHAR(50),"
				+ "MOBILENO VARCHAR(20),"
				+ "EMAIL VARCHAR(50),"
				+ "DOB VARCHAR(50),"
				+ "AGE INTEGER,"
				+ "HEIGHT INTEGER(50),"
				+ "WEIGHT INTEGER(100),"
				+ "ALLERGIES VARCHAR(100),"
				+ "PASSWORD PASSWORD,"
				+ "PRIMARY KEY (ID))";
		
		String sql2 = "CREATE TABLE "+ diagtable
				+ "(ID SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY,"
				+ "DOCID VARCHAR(50),"
				+ "PATID VARCHAR(20),"
				+ "DIAGNOSIS VARCHAR(50),"
				+ "NOTES VARCHAR(50),"
				+ "PRIMARY KEY (ID))";
		
		String sql3 = "CREATE TABLE "+ presctable
				+ "(ID SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY,"
				+ "PHARMID VARCHAR(50),"
				+ "PATID VARCHAR(20),"
				+ "PATNAME VARCHAR(50),"
				+ "DRUGNAME VARCHAR(50),"
				+ "DOSAGE INTEGER,"
				+ "INTAKE VARCHAR(100),"
				+ "DURATION VARCHAR(100),"
				+ "NOTE VARCHAR(100),"
				+ "PRIMARY KEY (ID))";
		
		String sql4 = "CREATE TABLE "+ usertable
				+ "(USERID SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY,"
				+ "NAME VARCHAR(50),"
				+ "MOBILE VARCHAR(20),"
				+ "EMAIL VARCHAR(50),"
				+ "ROLE VARCHAR(50),"
				+ "PASSWORD PASSWORD,"
				+ "PRIMARY KEY (ID))";
		
		String sql5 = "CREATE TABLE "+ appointable
				+ "(ID SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY,"
				+ "DOCID VARCHAR(50),"
				+ "PATID VARCHAR(20),"
				+ "PATNAME VARCHAR(50),"
				+ "TIME VARCHAR(50),"
				+ "DATE VARCHAR(50),"
				+ "PRIMARY KEY (ID))";
		try {
			cn.createStatement().execute("DROP TABLE " + patienttable);
			cn.createStatement().execute("DROP TABLE " + diagtable);
			cn.createStatement().execute("DROP TABLE " + presctable);
			cn.createStatement().execute("DROP TABLE " + usertable);
			cn.createStatement().execute("DROP TABLE " + appointable);
			System.out.println("Tables droped!");
			cn.createStatement().execute(sql1);
			cn.createStatement().execute(sql2);
			cn.createStatement().execute(sql3);
			cn.createStatement().execute(sql4);
			cn.createStatement().execute(sql5);
			System.out.println("table created!");
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public void addpatient(Patient patient) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO "+ patient +"(FULLNAME, MOBILENO, ADDRESS, LGA, AMOUNT, BANKNAME, PHOTO, STATUS, DATEREG) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, patient.getName());
			ps.setString(2, patient.getMobileno());
			ps.setString(3, patient.getEmail());
			ps.setString(4, patient.getDob());
			ps.setInt(5, patient.getAge());
			ps.setInt(6, patient.getHeight());
			ps.setInt(7, patient.getWeight());
			ps.setString(8, patient.getAllergies());
			ps.setString(9, patient.getPassword());
			ps.executeUpdate();
			System.out.println("Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public Patient getPatient(int id) {
		Patient patient = new Patient();	
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery("SELECT * FROM "+patienttable+" WHERE ID="+id); rs.next();
			patient.setName(rs.getString("NAME"));
			patient.setMobileno(rs.getString("MOBILENO"));
			patient.setEmail(rs.getString("EMAIL"));
			patient.setDob(rs.getString("DOB"));
			patient.setAge(rs.getInt("AGE"));
			patient.setHeight(rs.getInt("HEIGHT"));
			patient.setWeight(rs.getInt("WEIGHT"));
			patient.setAllergies(rs.getString("ALLERGIES"));
			patient.setPassword(rs.getString("PASSWORD"));	
		} catch (SQLException e) { e.printStackTrace(); } 

			
		return patient;
	}
	
	public String[] getPatients(Connection cn, String fl) {
		String[] simpleArray = null;
		   try { Statement st = cn.createStatement(); 
		   	ResultSet rs = st.executeQuery("SELECT "+fl+" FROM "+patienttable+" ORDER BY id");
		   	
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
		ResultSet r3 = st2.executeQuery("SELECT * FROM "+patienttable);
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

	