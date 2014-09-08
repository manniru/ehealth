package eHealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.BevelBorder;

import java.awt.SystemColor;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fsearch {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fsearch window = new Fsearch();
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
	public Fsearch() {
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
		panel.setBounds(10, 11, 378, 439);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		panel.setBackground(SystemColor.menu);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPatientRecord = new JLabel("Patient Record");
		lblPatientRecord.setBounds(546, 11, 111, 14);
		lblPatientRecord.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblPatientRecord);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(424, 90, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(424, 205, 85, 14);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGender.setBounds(636, 205, 46, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeight.setBounds(424, 243, 46, 14);
		frame.getContentPane().add(lblWeight);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHeight.setBounds(636, 243, 46, 14);
		frame.getContentPane().add(lblHeight);
		
		JLabel lblRecentDiagnosis = new JLabel("Recent Diagnosis:");
		lblRecentDiagnosis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRecentDiagnosis.setBounds(424, 289, 105, 27);
		frame.getContentPane().add(lblRecentDiagnosis);
		
		JLabel lblCurrentPrescription = new JLabel("Current Prescription:");
		lblCurrentPrescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCurrentPrescription.setBounds(424, 362, 119, 14);
		frame.getContentPane().add(lblCurrentPrescription);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(468, 85, 306, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(503, 200, 111, 27);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(689, 200, 85, 27);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(503, 238, 111, 27);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(689, 238, 85, 27);
		frame.getContentPane().add(textField_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setRows(2);
		textArea.setBounds(543, 285, 231, 49);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setRows(2);
		textArea_1.setBounds(543, 357, 231, 43);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(424, 130, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(468, 125, 306, 27);
		frame.getContentPane().add(textField_6);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhone.setBounds(424, 167, 46, 14);
		frame.getContentPane().add(lblPhone);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(468, 161, 111, 27);
		frame.getContentPane().add(textField_7);
		
		JLabel lblPatientId = new JLabel("ID:");
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPatientId.setBounds(424, 50, 76, 14);
		frame.getContentPane().add(lblPatientId);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(468, 47, 111, 27);
		frame.getContentPane().add(textField_8);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDone.setBounds(713, 419, 61, 23);
		frame.getContentPane().add(btnDone);
		
		JButton btnNewButton = new JButton("Appointment");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(424, 419, 119, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setBounds(642, 419, 61, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnNewButton_1 = new JButton("Waiting");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(553, 419, 79, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
