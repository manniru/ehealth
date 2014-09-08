package eHealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.anas.ehealth.Dao;
import com.anas.ehealth.dao.Users;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin {

	private JFrame frame;
	private JTextField dname;
	private JTextField ddept;
	private JTextField dmobileno;
	private JTextField demail;
	private JTextField daddr;
	private JTextField duser;
	private JTextField dpass;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New Doctor", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewDoctorRecord = new JLabel("New Doctor Record");
		lblNewDoctorRecord.setBackground(Color.LIGHT_GRAY);
		lblNewDoctorRecord.setEnabled(false);
		lblNewDoctorRecord.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewDoctorRecord.setBounds(477, 22, 169, 24);
		panel.add(lblNewDoctorRecord);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(362, 67, 119, 14);
		panel.add(lblName);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartment.setBounds(360, 100, 121, 14);
		panel.add(lblDepartment);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(362, 135, 119, 14);
		panel.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(362, 164, 119, 14);
		panel.add(lblEmail);
		
		JLabel lblHomeAddress = new JLabel("Home Address:");
		lblHomeAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHomeAddress.setBounds(362, 201, 119, 14);
		panel.add(lblHomeAddress);
		
		JLabel lblLoginInformation = new JLabel("Login Information");
		lblLoginInformation.setBackground(Color.LIGHT_GRAY);
		lblLoginInformation.setEnabled(false);
		lblLoginInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginInformation.setBounds(477, 236, 155, 24);
		panel.add(lblLoginInformation);
		
		JLabel lblPassword = new JLabel("Username:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(362, 282, 119, 14);
		panel.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(362, 322, 119, 14);
		panel.add(lblConfirmPassword);
		
		dname = new JTextField();
		dname.setBounds(491, 57, 243, 24);
		panel.add(dname);
		dname.setColumns(10);
		
		ddept = new JTextField();
		ddept.setColumns(10);
		ddept.setBounds(491, 90, 243, 24);
		panel.add(ddept);
		
		dmobileno = new JTextField();
		dmobileno.setColumns(10);
		dmobileno.setBounds(491, 125, 243, 24);
		panel.add(dmobileno);
		
		demail = new JTextField();
		demail.setColumns(10);
		demail.setBounds(491, 161, 243, 24);
		panel.add(demail);
		
		daddr = new JTextField();
		daddr.setColumns(10);
		daddr.setBounds(491, 198, 243, 24);
		panel.add(daddr);
		
		duser = new JTextField();
		duser.setColumns(10);
		duser.setBounds(491, 275, 243, 24);
		panel.add(duser);
		
		dpass = new JTextField();
		dpass.setColumns(10);
		dpass.setBounds(491, 312, 243, 24);
		panel.add(dpass);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users user = new Users();
				user.setUsername(duser.getText());
				user.setPassword(dpass.getText());
				user.setFullname(dname.getText());
				user.setMobileno(dmobileno.getText());
				user.setAddress(daddr.getText());
				user.setDepartment(ddept.getText());
				user.setEmail(demail.getText());
				
				Dao dao = new Dao();
				dao.addUser(user);
				JOptionPane.showMessageDialog(frame, "User Records Successfully Added!");
			}
		});
		btnSave.setBounds(665, 362, 69, 31);
		panel.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				frame.dispose();
				Main.main(null);
			}
		});
		btnBack.setBounds(362, 399, 76, 23);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New Pharmacist", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("New Pharmacist Record");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setEnabled(false);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(478, 28, 201, 24);
		panel_1.add(label_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(492, 63, 243, 24);
		panel_1.add(textField_7);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(363, 73, 119, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Department:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(361, 106, 121, 14);
		panel_1.add(label_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(492, 96, 243, 24);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(492, 131, 243, 24);
		panel_1.add(textField_9);
		
		JLabel label_4 = new JLabel("Phone Number:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(363, 141, 119, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Email:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(363, 170, 119, 14);
		panel_1.add(label_5);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(492, 167, 243, 24);
		panel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(492, 204, 243, 24);
		panel_1.add(textField_11);
		
		JLabel label_6 = new JLabel("Home Address:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(363, 207, 119, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Login Information");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setEnabled(false);
		label_7.setBackground(Color.LIGHT_GRAY);
		label_7.setBounds(478, 246, 155, 24);
		panel_1.add(label_7);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(492, 281, 243, 24);
		panel_1.add(textField_12);
		
		JLabel label_8 = new JLabel("Password:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(363, 288, 119, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Confirm Password:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(363, 328, 119, 14);
		panel_1.add(label_9);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(492, 318, 243, 24);
		panel_1.add(textField_13);
		
		JButton button = new JButton("SAVE");
		button.setBounds(666, 368, 69, 31);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New Nurse", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_10 = new JLabel("New Nurse Record");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setEnabled(false);
		label_10.setBackground(Color.LIGHT_GRAY);
		label_10.setBounds(496, 23, 169, 24);
		panel_2.add(label_10);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(510, 58, 243, 24);
		panel_2.add(textField_14);
		
		JLabel label_11 = new JLabel("Name:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(379, 61, 119, 14);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("Department:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBounds(377, 94, 121, 14);
		panel_2.add(label_12);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(510, 91, 243, 24);
		panel_2.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(510, 126, 243, 24);
		panel_2.add(textField_16);
		
		JLabel label_13 = new JLabel("Phone Number:");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_13.setBounds(381, 136, 119, 14);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Email:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setBounds(381, 165, 119, 14);
		panel_2.add(label_14);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(510, 162, 243, 24);
		panel_2.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(510, 199, 243, 24);
		panel_2.add(textField_18);
		
		JLabel label_15 = new JLabel("Home Address:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_15.setBounds(381, 202, 119, 14);
		panel_2.add(label_15);
		
		JLabel label_16 = new JLabel("Login Information");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_16.setEnabled(false);
		label_16.setBackground(Color.LIGHT_GRAY);
		label_16.setBounds(497, 234, 155, 24);
		panel_2.add(label_16);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(510, 276, 243, 24);
		panel_2.add(textField_19);
		
		JLabel label_17 = new JLabel("Password:");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_17.setBounds(381, 283, 119, 14);
		panel_2.add(label_17);
		
		JLabel label_18 = new JLabel("Confirm Password:");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_18.setBounds(381, 323, 119, 14);
		panel_2.add(label_18);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(510, 313, 243, 24);
		panel_2.add(textField_20);
		
		JButton button_1 = new JButton("SAVE");
		button_1.setBounds(684, 363, 69, 31);
		panel_2.add(button_1);
	}
}
