package com.anas.ehealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ediag {
	static String id = "";
	private JFrame frame;
	private JTextField textField_1;
	private JTextField pid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		id = args [0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ediag window = new Ediag();
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
	public Ediag() {
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
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 11, 378, 439);
		frame.getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("Enter Diagnosis Details");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(525, 11, 169, 28);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(435, 116, 80, 20);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(525, 114, 222, 28);
		frame.getContentPane().add(textField_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(525, 153, 222, 82);
		frame.getContentPane().add(textArea);
		
		JLabel label_3 = new JLabel("Diagnosis:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(435, 177, 73, 20);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Notes:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(435, 274, 46, 14);
		frame.getContentPane().add(label_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(525, 246, 222, 82);
		frame.getContentPane().add(textArea_1);
		
		JButton button_1 = new JButton("Save");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(658, 422, 89, 28);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton = new JButton("Show Existing Prescription");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(525, 357, 222, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientId.setBounds(435, 74, 80, 14);
		frame.getContentPane().add(lblPatientId);
		
		pid = new JTextField();
		pid.setEditable(false);
		pid.setBounds(525, 73, 222, 30);
		frame.getContentPane().add(pid);
		pid.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String[] id = {pid.getText()};

				 frame.dispose();
				 Main.main(id);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(435, 427, 73, 23);
		frame.getContentPane().add(btnBack);
	}
}
