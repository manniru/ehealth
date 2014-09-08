package eHealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JScrollBar;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.MatteBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrescHistory {

	static String id = "";
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		id = args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrescHistory window = new PrescHistory();
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
	public PrescHistory() {
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
		panel.setBounds(10, 11, 378, 407);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(398, 11, 376, 439);
		frame.getContentPane().add(panel_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(359, 0, 17, 439);
		panel_1.add(scrollBar);
		
		JLabel lblPrescriptionHistory = new JLabel("Prescription History");
		lblPrescriptionHistory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrescriptionHistory.setBounds(127, 11, 144, 26);
		panel_1.add(lblPrescriptionHistory);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btnBack.setBounds(10, 429, 72, 23);
		frame.getContentPane().add(btnBack);
	}

}
