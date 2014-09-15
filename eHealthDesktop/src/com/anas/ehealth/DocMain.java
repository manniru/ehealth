package com.anas.ehealth;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.UIManager;

public class DocMain {

	private JFrame frame;
	private JTextField param;
	private JTextField did;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocMain window = new DocMain();
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
	public DocMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("eHealth Systems (Integrated with Advanced Java Web Services Technologies)");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/icon.png")));
		frame.setBounds(100, 100, 900, 700);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/icon.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setContentPane(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/bg.jpg")))));
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatientId.setBounds(205, 388, 84, 14);
		frame.getContentPane().add(lblPatientId);
		
		param = new JTextField();
		param.setFont(new Font("Tahoma", Font.PLAIN, 15));
		param.setBounds(299, 383, 200, 29);
		frame.getContentPane().add(param);
		param.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String[] patid = { param.getText(),did.getText() };
				 Main.main(patid);
			}
		});
		btnNewButton.setBounds(526, 365, 89, 64);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblWelcomeDr = new JLabel("Welcome Dr.");
		lblWelcomeDr.setBackground(UIManager.getColor("Button.light"));
		lblWelcomeDr.setBounds(596, 11, 67, 14);
		frame.getContentPane().add(lblWelcomeDr);
		
		did = new JTextField();
		did.setEditable(false);
		did.setBackground(UIManager.getColor("Button.light"));
		did.setBounds(677, 8, 84, 20);
		frame.getContentPane().add(did);
		did.setColumns(10);
	}
}
