package eHealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageAccess {

	private JFrame frame;
	private JTable revoked;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAccess window = new ManageAccess();
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
	public ManageAccess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Revoke Access", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(290, 51, 243, 173);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterUserId = new JLabel("Enter User ID");
		lblEnterUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterUserId.setBounds(72, 31, 94, 14);
		panel.add(lblEnterUserId);
		
		textField = new JTextField();
		textField.setBounds(22, 77, 200, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnRevoke = new JButton("Revoke");
		btnRevoke.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRevoke.setBounds(133, 128, 89, 23);
		panel.add(btnRevoke);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Allow Access", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(290, 250, 243, 173);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEnterUserId_1 = new JLabel("Enter User ID");
		lblEnterUserId_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterUserId_1.setBounds(78, 30, 88, 14);
		panel_1.add(lblEnterUserId_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(21, 77, 200, 29);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAllow = new JButton("Allow");
		btnAllow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAllow.setBounds(132, 125, 89, 23);
		panel_1.add(btnAllow);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 51, 270, 361);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 270, 371);
		panel_2.add(scrollPane);
		
		revoked = new JTable();
		scrollPane.setViewportView(revoked);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(543, 51, 230, 374);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btnNewButton.setBounds(10, 427, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
