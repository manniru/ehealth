package com.anas.ehealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import eHealth.NewPatient;
import sun.applet.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListPatients {

	private JFrame frame;
	private JTable table;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField patientidtxt;
	private JLabel lblName;
	private JPanel panel_2;
	private JTextField usernametxt;
	private JLabel lblPatientName;
	private JTextField passwordtxt;
	private JLabel lblPassword;
	private JTextField fullnametxt;
	private JLabel lblFullname;
	private JTextField textField_4;
	private JLabel lblDateOfBirth_1;
	private JTextField textField_5;
	private JLabel lblGender_1;
	private JTextField textField_6;
	private JLabel lblDateOfBirth;
	private JTextField textField_7;
	private JLabel lblGender;
	private JTextField textField_8;
	private JLabel lblWeight;
	private JTextField textField_9;
	private JLabel lblHeight;
	private JTextField textField_10;
	private JLabel lblDateRegister;
	private JButton btnViewMedicalRecords;
	private JButton btnDeleteRecords;
	private JButton btnBackToMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPatients window = new ListPatients();
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
	public ListPatients() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 31, 530, 579);
		frame.getContentPane().add(scrollPane);
		frame.setLocationRelativeTo(null);
		
		table = new JTable();
		Dao dao = new Dao();
		String[] columns = {"ID", "Username","Password","Fullname"};
		Object[][] data = dao.getData("patient");
		table.setModel(new DefaultTableModel(data, columns));
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
	        public void valueChanged(ListSelectionEvent event) {
	        	patientidtxt.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	        	usernametxt.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	        	passwordtxt.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	        	fullnametxt.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
	            // do some actions here, for example 
	            // print first column value from selected row 
	            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
	        } 
	    }); 
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBounds(550, 41, 224, 598);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Patient Photo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(52, 11, 134, 142);
		panel.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Patient Details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(0, 164, 224, 423);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblName = new JLabel("Patient ID");
		lblName.setBounds(10, 24, 80, 14);
		panel_2.add(lblName);
		
		patientidtxt = new JTextField();
		patientidtxt.setBounds(100, 21, 120, 20);
		panel_2.add(patientidtxt);
		patientidtxt.setColumns(10);
		
		usernametxt = new JTextField();
		usernametxt.setColumns(10);
		usernametxt.setBounds(100, 49, 120, 20);
		panel_2.add(usernametxt);
		
		lblPatientName = new JLabel("Username:");
		lblPatientName.setBounds(10, 52, 80, 14);
		panel_2.add(lblPatientName);
		
		passwordtxt = new JTextField();
		passwordtxt.setColumns(10);
		passwordtxt.setBounds(100, 77, 120, 20);
		panel_2.add(passwordtxt);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 80, 80, 14);
		panel_2.add(lblPassword);
		
		fullnametxt = new JTextField();
		fullnametxt.setColumns(10);
		fullnametxt.setBounds(100, 103, 120, 20);
		panel_2.add(fullnametxt);
		
		lblFullname = new JLabel("Fullname:");
		lblFullname.setBounds(10, 106, 80, 14);
		panel_2.add(lblFullname);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 134, 120, 20);
		panel_2.add(textField_4);
		
		lblDateOfBirth_1 = new JLabel("Date of Birth:");
		lblDateOfBirth_1.setBounds(10, 137, 80, 14);
		panel_2.add(lblDateOfBirth_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(100, 165, 120, 20);
		panel_2.add(textField_5);
		
		lblGender_1 = new JLabel("Gender:");
		lblGender_1.setBounds(10, 168, 80, 14);
		panel_2.add(lblGender_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(100, 196, 120, 20);
		panel_2.add(textField_6);
		
		lblDateOfBirth = new JLabel("Weight:");
		lblDateOfBirth.setBounds(10, 199, 80, 14);
		panel_2.add(lblDateOfBirth);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(100, 227, 120, 20);
		panel_2.add(textField_7);
		
		lblGender = new JLabel("Height:");
		lblGender.setBounds(10, 230, 80, 14);
		panel_2.add(lblGender);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(100, 258, 120, 20);
		panel_2.add(textField_8);
		
		lblWeight = new JLabel("Address:");
		lblWeight.setBounds(10, 261, 80, 14);
		panel_2.add(lblWeight);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(100, 289, 120, 20);
		panel_2.add(textField_9);
		
		lblHeight = new JLabel("Mobile No:");
		lblHeight.setBounds(10, 292, 80, 14);
		panel_2.add(lblHeight);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(100, 320, 120, 20);
		panel_2.add(textField_10);
		
		lblDateRegister = new JLabel("Date Register:");
		lblDateRegister.setBounds(10, 323, 80, 14);
		panel_2.add(lblDateRegister);
		
		JButton btnUpdateRecords = new JButton("Update Records");
		btnUpdateRecords.setBounds(62, 351, 136, 23);
		panel_2.add(btnUpdateRecords);
		
		btnDeleteRecords = new JButton("Delete Records");
		btnDeleteRecords.setBounds(62, 389, 136, 23);
		panel_2.add(btnDeleteRecords);
		
		btnViewMedicalRecords = new JButton("View Medical Records");
		btnViewMedicalRecords.setBounds(550, 7, 202, 23);
		frame.getContentPane().add(btnViewMedicalRecords);
		
		btnBackToMain = new JButton("Back to Main");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				eHealth.Main.main(null);
			}
		});
		btnBackToMain.setBounds(10, 7, 130, 23);
		frame.getContentPane().add(btnBackToMain);
	}
}
