package com.anas.ehealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminApp {

	private JFrame frame;
	private JTable table;
	private JScrollBar scrollBar;
	private JScrollPane scrollPane;
	private JLabel lblAppointmentNo;
	private JLabel lblPatientId;
	private JLabel lblDoctorId;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JLabel lblDate;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnCancel;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminApp window = new AdminApp();
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
	public AdminApp() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 764, 324);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 764, 321);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(747, 0, 17, 363);
		panel.add(scrollBar);
		
		lblAppointmentNo = new JLabel("Appointment No.:");
		lblAppointmentNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAppointmentNo.setBounds(10, 347, 119, 20);
		frame.getContentPane().add(lblAppointmentNo);
		
		lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientId.setBounds(10, 388, 69, 14);
		frame.getContentPane().add(lblPatientId);
		
		lblDoctorId = new JLabel("Doctor ID:");
		lblDoctorId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoctorId.setBounds(10, 426, 90, 14);
		frame.getContentPane().add(lblDoctorId);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(139, 346, 151, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(139, 384, 151, 27);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(139, 422, 151, 28);
		frame.getContentPane().add(textField_2);
		
		lblNewLabel = new JLabel("Time:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(418, 352, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(418, 390, 46, 14);
		frame.getContentPane().add(lblDate);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(470, 345, 151, 28);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(470, 388, 151, 28);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(685, 350, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(685, 386, 89, 23);
		frame.getContentPane().add(btnBack);
	}

}
