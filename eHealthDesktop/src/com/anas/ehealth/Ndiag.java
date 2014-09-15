package com.anas.ehealth;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ndiag {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * @wbp.nonvisual location=71,119
	 */
	private final JLabel label = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ndiag window = new Ndiag();
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
	public Ndiag() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		label.setIcon(new ImageIcon(Ndiag.class.getResource("/com/resources/logo.fw.png")));
		frame = new JFrame();
		frame.setTitle("eHealth Systems (Integrated with Advanced Java Web Services Technologies)");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/icon.png")));
		frame.setBounds(100, 100, 900, 700);
		frame.setContentPane(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/bg.jpg")))));		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(381, 161, 222, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(514, 451, 89, 50);
		frame.getContentPane().add(button);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setBounds(281, 163, 90, 20);
		frame.getContentPane().add(lblPatientName);
		lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDiagnosis = new JLabel("Diagnosis:");
		lblDiagnosis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiagnosis.setBounds(281, 254, 90, 20);
		frame.getContentPane().add(lblDiagnosis);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNotes.setBounds(281, 380, 90, 14);
		frame.getContentPane().add(lblNotes);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.controlHighlight);
		textArea.setTabSize(4);
		textArea.setRows(4);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(381, 227, 222, 82);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(SystemColor.controlHighlight);
		textArea_1.setTabSize(4);
		textArea_1.setRows(4);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(381, 346, 222, 82);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblEnterDiagnosisDetails = new JLabel("Enter Diagnosis Details");
		lblEnterDiagnosisDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterDiagnosisDetails.setBounds(381, 40, 169, 28);
		frame.getContentPane().add(lblEnterDiagnosisDetails);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(381, 105, 222, 28);
		frame.getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel("Patient ID:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(281, 107, 90, 20);
		frame.getContentPane().add(label_1);
	}
}
