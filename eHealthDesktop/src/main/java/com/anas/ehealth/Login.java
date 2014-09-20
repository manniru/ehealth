package com.anas.ehealth;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.anas.ehealth.dao.Dao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {
	private static JTextField usernametxt;
	private static JPasswordField passwordtxt;
	private static JFrame frame;

	public static void main(String[] args) {
		frame = new JFrame("eHealth System Login");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		usernametxt = new JTextField(20);
		usernametxt.setBounds(100, 10, 160, 25);
		panel.add(usernametxt);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordtxt = new JPasswordField(20);
		passwordtxt.setBounds(100, 40, 160, 25);
		panel.add(passwordtxt);

		JButton loginButton = new JButton("login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = usernametxt.getText();
				String pass = passwordtxt.getText();
				
				Dao dao = new Dao();
				if(dao.validateUser(user, pass)) {
					frame.setVisible(false);
					new Main().main(null);; 
				}
				else {
					//
				}
				System.out.println(user+"="+pass);
			}
		});
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
	}

}