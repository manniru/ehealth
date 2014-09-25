package com.anas.ehealth;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewPrescription {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-41,239
	 */
	static String id = "";
	private final JFrame frame_1 = new JFrame();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField pidtxt;
	private JTextField pnametxt;
	private JTextField drugtxt;
	private JTextField dosagetxt;
	private JTextField intaketxt;
	private JTextField durationtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		id = args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPrescription window = new NewPrescription();
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
	public NewPrescription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame_1.getContentPane().setLayout(null);
		frame.setTitle("eHealth Systems (Integrated with Advanced Java Web Services Technologies)");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/icon.png")));
		frame.setBounds(100, 100, 900, 700);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/icon.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 11, 406, 439);
		frame_1.getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(536, 132, 222, 28);
		frame_1.getContentPane().add(textField);
		
		JButton button = new JButton("Save");
		button.setBounds(669, 422, 89, 28);
		frame_1.getContentPane().add(button);
		
		JLabel label = new JLabel("Patient Name:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(436, 134, 90, 20);
		frame_1.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Diagnosis:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(436, 225, 90, 20);
		frame_1.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Notes:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(436, 351, 90, 14);
		frame_1.getContentPane().add(label_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(536, 198, 222, 82);
		frame_1.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(536, 317, 222, 82);
		frame_1.getContentPane().add(textArea_1);
		
		JLabel label_3 = new JLabel("Enter Diagnosis Details");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(536, 11, 169, 28);
		frame_1.getContentPane().add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(536, 76, 222, 28);
		frame_1.getContentPane().add(textField_1);
		
		JLabel label_4 = new JLabel("Patient ID:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(436, 78, 90, 20);
		frame_1.getContentPane().add(label_4);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pidtxt = new JTextField();
		pidtxt.setEditable(false);
		pidtxt.setColumns(10);
		pidtxt.setBounds(324, 76, 222, 28);
		frame.getContentPane().add(pidtxt);
		
		JLabel lblEnterPrescriptionDetails = new JLabel("Enter Prescription Details");
		lblEnterPrescriptionDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterPrescriptionDetails.setBounds(324, 11, 185, 28);
		frame.getContentPane().add(lblEnterPrescriptionDetails);
		
		JLabel label_6 = new JLabel("Patient ID:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(224, 78, 90, 20);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Patient Name:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(224, 126, 90, 20);
		frame.getContentPane().add(label_7);
		
		pnametxt = new JTextField();
		pnametxt.setEditable(false);
		pnametxt.setColumns(10);
		pnametxt.setBounds(324, 124, 222, 28);
		frame.getContentPane().add(pnametxt);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFinish.setBounds(457, 408, 89, 42);
		frame.getContentPane().add(btnFinish);
		
		JLabel lblDrugName = new JLabel("Drug Name:");
		lblDrugName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDrugName.setBounds(224, 170, 90, 20);
		frame.getContentPane().add(lblDrugName);
		
		JLabel lblIntake = new JLabel("Intake:");
		lblIntake.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIntake.setBounds(224, 261, 90, 20);
		frame.getContentPane().add(lblIntake);
		
		JLabel lblDosage = new JLabel("Dosage:");
		lblDosage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDosage.setBounds(224, 216, 90, 20);
		frame.getContentPane().add(lblDosage);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuration.setBounds(224, 297, 90, 20);
		frame.getContentPane().add(lblDuration);
		
		drugtxt = new JTextField();
		drugtxt.setBounds(324, 168, 222, 28);
		frame.getContentPane().add(drugtxt);
		drugtxt.setColumns(10);
		
		dosagetxt = new JTextField();
		dosagetxt.setBounds(324, 214, 222, 28);
		frame.getContentPane().add(dosagetxt);
		dosagetxt.setColumns(10);
		
		intaketxt = new JTextField();
		intaketxt.setBounds(324, 259, 222, 28);
		frame.getContentPane().add(intaketxt);
		intaketxt.setColumns(10);
		
		durationtxt = new JTextField();
		durationtxt.setBounds(324, 295, 222, 28);
		frame.getContentPane().add(durationtxt);
		durationtxt.setColumns(10);
		
		JLabel lblExtraNote = new JLabel("Extra Note:");
		lblExtraNote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExtraNote.setBounds(224, 345, 90, 20);
		frame.getContentPane().add(lblExtraNote);
		
		JTextArea notestxt = new JTextArea();
		notestxt.setBackground(SystemColor.control);
		notestxt.setTabSize(3);
		notestxt.setWrapStyleWord(true);
		notestxt.setRows(3);
		notestxt.setLineWrap(true);
		notestxt.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		notestxt.setBounds(324, 334, 222, 56);
		frame.getContentPane().add(notestxt);
		
		JButton btnMore = new JButton("More");
		btnMore.setBounds(224, 408, 89, 42);
		frame.getContentPane().add(btnMore);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] patid = {textField_1.getText()};

				frame.dispose();
				Main.main(patid);
			}
		});
		btnBack.setBounds(10, 408, 75, 42);
		frame.getContentPane().add(btnBack);
	}
}
