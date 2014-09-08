package eHealth;

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

public class Ndiag {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 11, 405, 439);
		frame.getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(536, 132, 222, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Save");
		button.setBounds(669, 422, 89, 28);
		frame.getContentPane().add(button);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setBounds(436, 134, 90, 20);
		frame.getContentPane().add(lblPatientName);
		lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDiagnosis = new JLabel("Diagnosis:");
		lblDiagnosis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiagnosis.setBounds(436, 225, 90, 20);
		frame.getContentPane().add(lblDiagnosis);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNotes.setBounds(436, 351, 90, 14);
		frame.getContentPane().add(lblNotes);
		
		JTextArea textArea = new JTextArea();
		textArea.setTabSize(4);
		textArea.setRows(4);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(536, 198, 222, 82);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setTabSize(4);
		textArea_1.setRows(4);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(536, 317, 222, 82);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblEnterDiagnosisDetails = new JLabel("Enter Diagnosis Details");
		lblEnterDiagnosisDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterDiagnosisDetails.setBounds(536, 11, 169, 28);
		frame.getContentPane().add(lblEnterDiagnosisDetails);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(536, 76, 222, 28);
		frame.getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel("Patient ID:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(436, 78, 90, 20);
		frame.getContentPane().add(label_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String[] patid = {textField_1.getText()};

				frame.dispose();
				Main.main(patid);
			}
		});
		btnBack.setBounds(436, 425, 73, 23);
		frame.getContentPane().add(btnBack);
	}
}
