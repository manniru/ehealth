package com.anas.ehealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JComboBox;

import com.anas.ehealth.dao.Patient;
import com.anas.ehealth.dao.PatientDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;

public class EditPatient {
	
	//static String id = "";
	private JFrame frame;
	private JTextField pidtxt;
	private JTextField pnametxt;
	private JTextField paddrtxt;
	private JTextField pmobilenotxt;
	private JTextField pdobtxt;
	private JTextField pweighttxt;
	private JTextField pheighttxt;
	static String patientid = "";
	Patient patient;
	
	public static int id;
	public static String uid;
	public static String username;
	public static String password;
	public static String role;
	public static String fullname;
	public static String dob;
	public static String gender;
	public static String weight;
	public static String height;
	public static String address;
	public static String mobileno;
	public static String datereg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		patientid = JOptionPane.showInputDialog(null, "Enter Patient ID");
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.registerTypeAdapter(Patient.class, new PatientDeserializer());
		Gson gson = gsonBuilder.create();
				
		try {
			//String patientid = "2";
			URL url = new URL("http://localhost:8080/ehealth/webservices.jsp?type=patient&method=get&id="+patientid );
			URLConnection conn = url.openConnection();
			
			BufferedReader data = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			Patient patient = gson.fromJson(data, Patient.class);
			
			id = patient.getId();
			uid = patient.getUid();
			username =patient.getUsername();
			password = patient.getPassword();
			role = patient.getRole();
			fullname = patient.getFullname();
			dob = patient.getDob();
			gender = patient.getGender();
			weight = patient.getWeight();
			height = patient.getHeight();
			address = patient.getAddress();
			mobileno = patient.getMobileno();
			datereg = patient.getDatereg();
			
			System.out.println(patient.getFullname());
				
		} catch(Exception e) { System.out.println(e); }

		//System.exit(0);
		//id = args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPatient window = new EditPatient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Patient Record");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(354, 11, 111, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(232, 50, 76, 14);
		frame.getContentPane().add(label_1);
		
		pidtxt = new JTextField();
		pidtxt.setEnabled(false);
		pidtxt.setColumns(10);
		pidtxt.setBounds(310, 47, 156, 27);
		pidtxt.setText(id+"");
		frame.getContentPane().add(pidtxt);
		
		pnametxt = new JTextField();
		pnametxt.setColumns(10);
		pnametxt.setBounds(310, 85, 272, 27);
		pnametxt.setText(fullname);
		frame.getContentPane().add(pnametxt);
		
		paddrtxt = new JTextField();
		paddrtxt.setColumns(10);
		paddrtxt.setBounds(313, 321, 269, 27);
		//pemailtxt.setText(patient);
		frame.getContentPane().add(paddrtxt);
		
		JLabel label_2 = new JLabel("Email:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(233, 328, 46, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Name:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(232, 90, 46, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Phone:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(234, 288, 46, 14);
		frame.getContentPane().add(label_4);
		
		pmobilenotxt = new JTextField();
		pmobilenotxt.setColumns(10);
		pmobilenotxt.setBounds(313, 283, 153, 27);
		pmobilenotxt.setText(mobileno);
		frame.getContentPane().add(pmobilenotxt);
		
		pdobtxt = new JTextField();
		pdobtxt.setColumns(10);
		pdobtxt.setBounds(311, 126, 155, 27);
		pdobtxt.setText(dob);
		frame.getContentPane().add(pdobtxt);
		
		JLabel label_5 = new JLabel("Date of Birth:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(232, 131, 85, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Weight:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(232, 173, 46, 14);
		frame.getContentPane().add(label_6);
		
		pweighttxt = new JTextField();
		pweighttxt.setColumns(10);
		pweighttxt.setBounds(310, 166, 156, 27);
		pweighttxt.setText(weight);
		frame.getContentPane().add(pweighttxt);
		
		JLabel label_7 = new JLabel("Gender:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(231, 208, 46, 14);
		frame.getContentPane().add(label_7);
		
		pheighttxt = new JTextField();
		pheighttxt.setColumns(10);
		pheighttxt.setBounds(312, 243, 154, 27);
		pheighttxt.setText(height);
		frame.getContentPane().add(pheighttxt);
		
		JLabel label_8 = new JLabel("Height:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(233, 248, 46, 14);
		frame.getContentPane().add(label_8);
		
		JButton button = new JButton("Done");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = Integer.parseInt(pidtxt.getText());
				fullname = pnametxt.getText();
				dob = pdobtxt.getText();
				//gender = 
				weight = pweighttxt.getText();
				height = pheighttxt.getText();
				address = paddrtxt.getText();
				mobileno = pmobilenotxt.getText();
				//datereg
				//uid
				/**
				Patient pt = new Patient();
				patient.setId(3);
				patient.setFullname(fullname);
				patient.setDob(dob);
				patient.setGender(gender);
				patient.setWeight(weight);
				patient.setHeight(height);
				patient.setAddress(address);
				patient.setMobileno(mobileno);
				patient.setDatereg(datereg);
				patient.setUid(uid);
				*/
				//patient.setUsername(username);
				//patient.setPassword(password);

							
				HashMap hm = new HashMap();
				hm.put("type", "patient");
				hm.put("method", "edit");
				hm.put("id", id);
				hm.put("fullname", fullname);
				hm.put("gender", gender);
				hm.put("mobileno", mobileno);
				hm.put("dob", dob);
				hm.put("weight", weight);
				hm.put("height", height);
				hm.put("address", address);
				hm.put("id", id);
				hm.put("datereg", datereg);
				
				WebServices services = new WebServices();
				services.post(hm);
				JOptionPane.showMessageDialog(frame, "Records Updated");
				/**
				try {
					//String patientid = "2";
					URL url = new URL("http://localhost:8080/ehealth/webservices.jsp?type=patientedit&id="+patientid );
					URLConnection conn = url.openConnection();
					
					BufferedReader data = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					//Patient patient = gson.fromJson(data, Patient.class);

					
					System.out.println(patient.getFullname());
						
				} catch(Exception e1) { System.out.println(e1); }
				*/
			}
		});
		button.setBounds(506, 411, 76, 39);
		frame.getContentPane().add(button);
		
		JComboBox pgendertxt = new JComboBox();
		pgendertxt.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		pgendertxt.setBounds(311, 205, 155, 28);
		frame.getContentPane().add(pgendertxt);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btnBack.setBounds(219, 411, 65, 39);
		frame.getContentPane().add(btnBack);
	}

}
