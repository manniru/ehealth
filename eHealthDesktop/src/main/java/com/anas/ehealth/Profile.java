package com.anas.ehealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile {

	static String did;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 did = args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
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
	public Profile() {
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
		panel.setBounds(369, 11, 405, 292);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 67, 119, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setColumns(10);
		textField.setBounds(141, 64, 243, 24);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Department:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 100, 121, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setColumns(10);
		textField_1.setBounds(141, 97, 243, 24);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("Phone Number:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 135, 119, 14);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBackground(UIManager.getColor("Button.background"));
		textField_2.setColumns(10);
		textField_2.setBounds(141, 132, 243, 24);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(UIManager.getColor("Button.background"));
		textField_3.setColumns(10);
		textField_3.setBounds(141, 168, 243, 24);
		panel.add(textField_3);
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 171, 119, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Home Address:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(12, 208, 119, 14);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBackground(UIManager.getColor("Button.background"));
		textField_4.setColumns(10);
		textField_4.setBounds(141, 205, 243, 24);
		panel.add(textField_4);
		
		JLabel lblMyId = new JLabel("My ID:");
		lblMyId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMyId.setBounds(10, 24, 119, 24);
		panel.add(lblMyId);
		
		textField_5 = new JTextField();
		textField_5.setBackground(UIManager.getColor("Button.background"));
		textField_5.setColumns(10);
		textField_5.setBounds(141, 26, 243, 24);
		panel.add(textField_5);
		
		JLabel lblPatientsChecked = new JLabel("Patients checked");
		lblPatientsChecked.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientsChecked.setBounds(10, 247, 108, 14);
		panel.add(lblPatientsChecked);
		
		textField_6 = new JTextField();
		textField_6.setBackground(UIManager.getColor("Button.background"));
		textField_6.setBounds(141, 243, 243, 26);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Appointment", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(369, 308, 405, 129);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSlot = new JLabel("Slot 1:");
		lblSlot.setBounds(10, 29, 46, 14);
		panel_1.add(lblSlot);
		
		JLabel lblSlot_1 = new JLabel("Slot 2:");
		lblSlot_1.setBounds(10, 60, 46, 14);
		panel_1.add(lblSlot_1);
		
		JLabel lblSlot_2 = new JLabel("Slot 3:");
		lblSlot_2.setBounds(10, 91, 46, 14);
		panel_1.add(lblSlot_2);
		
		textField_7 = new JTextField();
		textField_7.setBounds(66, 24, 200, 25);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(66, 55, 200, 25);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(66, 86, 200, 25);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(303, 54, 78, 23);
		panel_1.add(btnUpdate);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnView.setBounds(303, 87, 78, 23);
		panel_1.add(btnView);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 349, 400);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] patid = {textField_1.getText(),textField_5.getText()};

				frame.dispose();
				Main.main(patid);
			}
		});
		btnNewButton.setBounds(10, 427, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
