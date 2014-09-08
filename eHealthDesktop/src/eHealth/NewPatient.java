package eHealth;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import com.anas.ehealth.Dao;
import com.anas.ehealth.Db;
import com.anas.ehealth.Patient;

import java.awt.Color;
import java.sql.Connection;

public class NewPatient {
	Db db = new Db();
	Connection cn = db.connect();
	private JFrame frame;
	private JTextField fullnametxt;
	private JTextField weighttxt;
	private JTextField dobtxt;
	private JTextField heighttxt;
	private JTextField addresstxt;
	private JTextField mobilenotxt;
	private JTextField usernametxt;
	private JTextField passwordtxt;
	private JComboBox gendercmb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPatient window = new NewPatient();
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
	public NewPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//frame.getContentPane().setLayout(new BorderLayout()); 
		//JLabel label_1 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/p4.jpg"))));
		//frame.setContentPane(label_1); 
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btnBack.setBounds(10, 11, 65, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewPatientRecord = new JLabel("New Patient Record");
		lblNewPatientRecord.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewPatientRecord.setBounds(220, 29, 167, 35);
		frame.getContentPane().add(lblNewPatientRecord);
		
		JLabel lblName = new JLabel("Fullname:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(220, 144, 73, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateOfBirth.setBounds(220, 172, 92, 29);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(220, 219, 73, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeight.setBounds(220, 255, 73, 23);
		frame.getContentPane().add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWeight.setBounds(220, 300, 73, 23);
		frame.getContentPane().add(lblWeight);
		
		JLabel label = new JLabel("Contact Details");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(220, 348, 167, 23);
		frame.getContentPane().add(label);
		
		JLabel lblHomeAddress = new JLabel("Home Address:");
		lblHomeAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHomeAddress.setBounds(220, 382, 100, 14);
		frame.getContentPane().add(lblHomeAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(226, 413, 110, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		fullnametxt = new JTextField();
		fullnametxt.setBounds(346, 141, 210, 20);
		frame.getContentPane().add(fullnametxt);
		fullnametxt.setColumns(10);
		
		weighttxt = new JTextField();
		weighttxt.setColumns(10);
		weighttxt.setBounds(346, 297, 210, 20);
		frame.getContentPane().add(weighttxt);
		
		dobtxt = new JTextField();
		dobtxt.setColumns(10);
		dobtxt.setBounds(346, 174, 210, 20);
		frame.getContentPane().add(dobtxt);
		
		heighttxt = new JTextField();
		heighttxt.setColumns(10);
		heighttxt.setBounds(346, 252, 210, 20);
		frame.getContentPane().add(heighttxt);
		
		addresstxt = new JTextField();
		addresstxt.setColumns(10);
		addresstxt.setBounds(346, 382, 210, 20);
		frame.getContentPane().add(addresstxt);
		
		mobilenotxt = new JTextField();
		mobilenotxt.setColumns(10);
		mobilenotxt.setBounds(346, 412, 210, 20);
		frame.getContentPane().add(mobilenotxt);
		
		gendercmb = new JComboBox();
		gendercmb.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gendercmb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gendercmb.setBounds(346, 216, 110, 20);
		frame.getContentPane().add(gendercmb);
		
		JButton btnSubmit = new JButton("Save");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usernametxt.getText();
				String password = passwordtxt.getText();
				String fullname = fullnametxt.getText();
				String dob = dobtxt.getText();
				String gender = gendercmb.getSelectedItem().toString();
				int weight = Integer.parseInt(weighttxt.getText());
				int height = Integer.parseInt(heighttxt.getText());
				String address = addresstxt.getText();
				String mobileno = mobilenotxt.getText();
				
				Patient patient = new Patient();
				patient.setUsername(username);
				patient.setPassword(password);
				patient.setFullname(fullname);
				patient.setDob(dob);
				patient.setGender(gender);
				patient.setHeight(height);
				patient.setWeight(weight);
				patient.setAddress(address);
				patient.setMobileno(mobileno);
				
				Dao dao = new Dao();
				dao.addPatient(patient);
				JOptionPane.showMessageDialog(frame, "Patient Record Succefull Saved!");
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(652, 403, 92, 35);
		frame.getContentPane().add(btnSubmit);
		
		usernametxt = new JTextField();
		usernametxt.setColumns(10);
		usernametxt.setBounds(346, 75, 210, 20);
		frame.getContentPane().add(usernametxt);
		
		passwordtxt = new JTextField();
		passwordtxt.setColumns(10);
		passwordtxt.setBounds(346, 106, 210, 20);
		frame.getContentPane().add(passwordtxt);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(220, 75, 73, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(220, 106, 73, 14);
		frame.getContentPane().add(lblPassword);
	}
}
