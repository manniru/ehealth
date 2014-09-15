package com.anas.ehealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPatient {
	
	static String id = "";
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		id = args[0];
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
		label.setBounds(543, 11, 111, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(421, 50, 76, 14);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(499, 47, 156, 27);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(499, 85, 272, 27);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(501, 352, 269, 27);
		frame.getContentPane().add(textField_2);
		
		JLabel label_2 = new JLabel("Email:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(421, 359, 46, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Name:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(421, 90, 46, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Phone:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(423, 288, 46, 14);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(502, 283, 153, 27);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(500, 126, 155, 27);
		frame.getContentPane().add(textField_4);
		
		JLabel label_5 = new JLabel("Date of Birth:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(421, 131, 85, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Weight:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(421, 173, 46, 14);
		frame.getContentPane().add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(499, 166, 156, 27);
		frame.getContentPane().add(textField_5);
		
		JLabel label_7 = new JLabel("Gender:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(420, 208, 46, 14);
		frame.getContentPane().add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(501, 243, 154, 27);
		frame.getContentPane().add(textField_7);
		
		JLabel label_8 = new JLabel("Height:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(422, 248, 46, 14);
		frame.getContentPane().add(label_8);
		
		JButton button = new JButton("Done");
		button.setBounds(695, 411, 76, 39);
		frame.getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 11, 378, 439);
		frame.getContentPane().add(panel);
		
		JLabel lblPhone = new JLabel("Phone2:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhone.setBounds(421, 324, 52, 14);
		frame.getContentPane().add(lblPhone);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(500, 317, 155, 27);
		frame.getContentPane().add(textField_9);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(500, 205, 155, 28);
		frame.getContentPane().add(comboBox);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btnBack.setBounds(408, 419, 65, 23);
		frame.getContentPane().add(btnBack);
	}

}
