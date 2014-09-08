package eHealth;

import java.awt.EventQueue;

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
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(530, 76, 222, 28);
		frame.getContentPane().add(textField_2);
		
		JLabel lblEnterPrescriptionDetails = new JLabel("Enter Prescription Details");
		lblEnterPrescriptionDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterPrescriptionDetails.setBounds(530, 11, 185, 28);
		frame.getContentPane().add(lblEnterPrescriptionDetails);
		
		JLabel label_6 = new JLabel("Patient ID:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(430, 78, 90, 20);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Patient Name:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(430, 126, 90, 20);
		frame.getContentPane().add(label_7);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(530, 124, 222, 28);
		frame.getContentPane().add(textField_3);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFinish.setBounds(663, 422, 89, 28);
		frame.getContentPane().add(btnFinish);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(10, 11, 404, 405);
		frame.getContentPane().add(panel_1);
		
		JLabel lblDrugName = new JLabel("Drug Name:");
		lblDrugName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDrugName.setBounds(430, 170, 90, 20);
		frame.getContentPane().add(lblDrugName);
		
		JLabel lblIntake = new JLabel("Intake:");
		lblIntake.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIntake.setBounds(430, 261, 90, 20);
		frame.getContentPane().add(lblIntake);
		
		JLabel lblDosage = new JLabel("Dosage:");
		lblDosage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDosage.setBounds(430, 216, 90, 20);
		frame.getContentPane().add(lblDosage);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuration.setBounds(430, 297, 90, 20);
		frame.getContentPane().add(lblDuration);
		
		textField_4 = new JTextField();
		textField_4.setBounds(530, 168, 222, 28);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(530, 214, 222, 28);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(530, 259, 222, 28);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(530, 295, 222, 28);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblExtraNote = new JLabel("Extra Note:");
		lblExtraNote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExtraNote.setBounds(430, 345, 90, 20);
		frame.getContentPane().add(lblExtraNote);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setTabSize(3);
		textArea_2.setWrapStyleWord(true);
		textArea_2.setRows(3);
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		textArea_2.setBounds(530, 333, 222, 56);
		frame.getContentPane().add(textArea_2);
		
		JButton btnMore = new JButton("More");
		btnMore.setBounds(430, 425, 89, 23);
		frame.getContentPane().add(btnMore);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] patid = {textField_1.getText()};

				frame.dispose();
				Main.main(patid);
			}
		});
		btnBack.setBounds(10, 425, 75, 23);
		frame.getContentPane().add(btnBack);
	}
}
