package com.anas.ehealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.anas.ehealth.dao.Dao;
import com.anas.ehealth.dao.Doctor;
import com.google.gson.Gson;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class Admin {

	private JFrame frame;
	private JTextField dnametxt;
	private JTextField ddepttxt;
	private JTextField dmobilenotxt;
	private JTextField demailtxt;
	private JTextField daddrtxt;
	private JTextField dusertxt;
	private JTextField dpasstxt;
	private JTextField pnametxt;
	private JTextField pdepttxt;
	private JTextField pmobiletxt;
	private JTextField pemailtxt;
	private JTextField paddtxt;
	private JTextField pusertxt;
	private JTextField ppasstxt;
	private JTextField nnametxt;
	private JTextField ndepttxt;
	private JTextField nmobiletxt;
	private JTextField nemailtxt;
	private JTextField naddtxt;
	private JTextField nusertxt;
	private JTextField npasstxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New Doctor", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewDoctorRecord = new JLabel("New Doctor Record");
		lblNewDoctorRecord.setBackground(Color.LIGHT_GRAY);
		lblNewDoctorRecord.setEnabled(false);
		lblNewDoctorRecord.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewDoctorRecord.setBounds(477, 22, 169, 24);
		panel.add(lblNewDoctorRecord);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(362, 67, 119, 14);
		panel.add(lblName);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartment.setBounds(360, 100, 121, 14);
		panel.add(lblDepartment);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(362, 135, 119, 14);
		panel.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(362, 164, 119, 14);
		panel.add(lblEmail);
		
		JLabel lblHomeAddress = new JLabel("Home Address:");
		lblHomeAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHomeAddress.setBounds(362, 201, 119, 14);
		panel.add(lblHomeAddress);
		
		JLabel lblLoginInformation = new JLabel("Login Information");
		lblLoginInformation.setBackground(Color.LIGHT_GRAY);
		lblLoginInformation.setEnabled(false);
		lblLoginInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginInformation.setBounds(477, 236, 155, 24);
		panel.add(lblLoginInformation);
		
		JLabel lblPassword = new JLabel("Username:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(362, 282, 119, 14);
		panel.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(362, 322, 119, 14);
		panel.add(lblConfirmPassword);
		
		dnametxt = new JTextField();
		dnametxt.setBounds(491, 57, 243, 24);
		panel.add(dnametxt);
		dnametxt.setColumns(10);
		
		ddepttxt = new JTextField();
		ddepttxt.setColumns(10);
		ddepttxt.setBounds(491, 90, 243, 24);
		panel.add(ddepttxt);
		
		dmobilenotxt = new JTextField();
		dmobilenotxt.setColumns(10);
		dmobilenotxt.setBounds(491, 125, 243, 24);
		panel.add(dmobilenotxt);
		
		demailtxt = new JTextField();
		demailtxt.setColumns(10);
		demailtxt.setBounds(491, 161, 243, 24);
		panel.add(demailtxt);
		
		daddrtxt = new JTextField();
		daddrtxt.setColumns(10);
		daddrtxt.setBounds(491, 198, 243, 24);
		panel.add(daddrtxt);
		
		dusertxt = new JTextField();
		dusertxt.setColumns(10);
		dusertxt.setBounds(491, 275, 243, 24);
		panel.add(dusertxt);
		
		dpasstxt = new JTextField();
		dpasstxt.setColumns(10);
		dpasstxt.setBounds(491, 312, 243, 24);
		panel.add(dpasstxt);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor doctor = new Doctor();
				String fullname = dnametxt.getText();
				String department = ddepttxt.getText();
				String mobileno = dmobilenotxt.getText();
				String email = demailtxt.getText();
				String address = daddrtxt.getText();
				String username = dusertxt.getText();
				String password = dpasstxt.getText();
				String role = "doctor";
				/**
				doctor.setUsername(username);
				doctor.setPassword(password);
				doctor.setMobileno(mobileno);
				doctor.setEmail(email);
				doctor.setAddress(address);
				doctor.setFullname(fullname);
				doctor.setRole(role);
				//doctor.setUid(uid);
				doctor.setDepartment(department);
				
				//Gson gson = new Gson();
				
				//String json = gson.toJson(doctor);  
				
				//System.out.println(json);
				*/
				WebServices services = new WebServices();
				
				HashMap hm = new HashMap();
				hm.put("type", "doctor");
				hm.put("fullname", fullname);
				hm.put("department", department);
				hm.put("mobileno", mobileno);
				hm.put("email", email);
				hm.put("address", address);
				hm.put("username", username);
				hm.put("password", password);
				hm.put("role", role);
				services.post(hm);
				
				
				
				/**
				Users user = new Users();
				user.setUsername(duser.getText());
				user.setPassword(dpass.getText());
				user.setFullname(dname.getText());
				user.setMobileno(dmobileno.getText());
				user.setAddress(daddr.getText());
				user.setDepartment(ddept.getText());
				user.setEmail(demail.getText());
				
				Dao dao = new Dao();
				dao.addUser(user);
				*/
				JOptionPane.showMessageDialog(frame, "User Records Successfully Added!");
			}
		});
		btnSave.setBounds(665, 362, 69, 31);
		panel.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				frame.dispose();
				Main.main(null);
			}
		});
		btnBack.setBounds(362, 399, 76, 23);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New Pharmacist", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("New Pharmacist Record");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setEnabled(false);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(478, 28, 201, 24);
		panel_1.add(label_1);
		
		pnametxt = new JTextField();
		pnametxt.setColumns(10);
		pnametxt.setBounds(492, 63, 243, 24);
		panel_1.add(pnametxt);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(363, 73, 119, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Department:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(361, 106, 121, 14);
		panel_1.add(label_3);
		
		pdepttxt = new JTextField();
		pdepttxt.setColumns(10);
		pdepttxt.setBounds(492, 96, 243, 24);
		panel_1.add(pdepttxt);
		
		pmobiletxt = new JTextField();
		pmobiletxt.setColumns(10);
		pmobiletxt.setBounds(492, 131, 243, 24);
		panel_1.add(pmobiletxt);
		
		JLabel label_4 = new JLabel("Phone Number:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(363, 141, 119, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Email:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(363, 170, 119, 14);
		panel_1.add(label_5);
		
		pemailtxt = new JTextField();
		pemailtxt.setColumns(10);
		pemailtxt.setBounds(492, 167, 243, 24);
		panel_1.add(pemailtxt);
		
		paddtxt = new JTextField();
		paddtxt.setColumns(10);
		paddtxt.setBounds(492, 204, 243, 24);
		panel_1.add(paddtxt);
		
		JLabel label_6 = new JLabel("Home Address:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(363, 207, 119, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Login Information");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setEnabled(false);
		label_7.setBackground(Color.LIGHT_GRAY);
		label_7.setBounds(478, 246, 155, 24);
		panel_1.add(label_7);
		
		pusertxt = new JTextField();
		pusertxt.setColumns(10);
		pusertxt.setBounds(492, 281, 243, 24);
		panel_1.add(pusertxt);
		
		JLabel label_8 = new JLabel("Username:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(363, 288, 119, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Password:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(363, 328, 119, 14);
		panel_1.add(label_9);
		
		ppasstxt = new JTextField();
		ppasstxt.setColumns(10);
		ppasstxt.setBounds(492, 318, 243, 24);
		panel_1.add(ppasstxt);
		
		JButton button = new JButton("SAVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = pusertxt.getText();
				String password = ppasstxt.getText();
				String role = "pharmacist";
				String fullname = pnametxt.getText();
				String department = pdepttxt.getText();
				String mobileno = pmobiletxt.getText();
				String email = pemailtxt.getText();
				String address = paddtxt.getText();
				
				WebServices services = new WebServices();
				
				HashMap hm = new HashMap();
				hm.put("type", "pharmacist");
				hm.put("username", username);
				hm.put("password", password);
				hm.put("fullname", fullname);
				hm.put("department", department);
				hm.put("mobileno", mobileno);
				hm.put("email", email);
				hm.put("address", address);
				hm.put("role", role);
				services.post(hm);
				
				JOptionPane.showMessageDialog(frame, "Pharmacisr Records Record Saved!");
			}
		});
		button.setBounds(666, 368, 69, 31);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New Nurse", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_10 = new JLabel("New Nurse Record");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setEnabled(false);
		label_10.setBackground(Color.LIGHT_GRAY);
		label_10.setBounds(496, 23, 169, 24);
		panel_2.add(label_10);
		
		nnametxt = new JTextField();
		nnametxt.setColumns(10);
		nnametxt.setBounds(510, 58, 243, 24);
		panel_2.add(nnametxt);
		
		JLabel label_11 = new JLabel("Name:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(379, 61, 119, 14);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("Department:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBounds(377, 94, 121, 14);
		panel_2.add(label_12);
		
		ndepttxt = new JTextField();
		ndepttxt.setColumns(10);
		ndepttxt.setBounds(510, 91, 243, 24);
		panel_2.add(ndepttxt);
		
		nmobiletxt = new JTextField();
		nmobiletxt.setColumns(10);
		nmobiletxt.setBounds(510, 126, 243, 24);
		panel_2.add(nmobiletxt);
		
		JLabel label_13 = new JLabel("Phone Number:");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_13.setBounds(381, 136, 119, 14);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Email:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setBounds(381, 165, 119, 14);
		panel_2.add(label_14);
		
		nemailtxt = new JTextField();
		nemailtxt.setColumns(10);
		nemailtxt.setBounds(510, 162, 243, 24);
		panel_2.add(nemailtxt);
		
		naddtxt = new JTextField();
		naddtxt.setColumns(10);
		naddtxt.setBounds(510, 199, 243, 24);
		panel_2.add(naddtxt);
		
		JLabel label_15 = new JLabel("Home Address:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_15.setBounds(381, 202, 119, 14);
		panel_2.add(label_15);
		
		JLabel label_16 = new JLabel("Login Information");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_16.setEnabled(false);
		label_16.setBackground(Color.LIGHT_GRAY);
		label_16.setBounds(497, 234, 155, 24);
		panel_2.add(label_16);
		
		nusertxt = new JTextField();
		nusertxt.setColumns(10);
		nusertxt.setBounds(510, 276, 243, 24);
		panel_2.add(nusertxt);
		
		JLabel label_17 = new JLabel("Username:");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_17.setBounds(381, 283, 119, 14);
		panel_2.add(label_17);
		
		JLabel label_18 = new JLabel("Password:");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_18.setBounds(381, 323, 119, 14);
		panel_2.add(label_18);
		
		npasstxt = new JTextField();
		npasstxt.setColumns(10);
		npasstxt.setBounds(510, 313, 243, 24);
		panel_2.add(npasstxt);
		
		JButton button_1 = new JButton("SAVE");
		button_1.setBounds(684, 363, 69, 31);
		panel_2.add(button_1);
	}
}
