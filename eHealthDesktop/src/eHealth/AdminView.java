package eHealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;

import com.anas.ehealth.Dao;

public class AdminView {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
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
	public AdminView() {
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
		tabbedPane.addTab("Doctor Record", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 779, 433);
		panel.add(panel_4);
		panel_4.setLayout(null);
		Dao dao = new Dao();
		Object[][] doctors = dao.getData("doctor");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(10, 399, 89, 23);
		panel_4.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 558, 362);
		panel_4.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(doctors, new String[] {
				"ID", "Username", "Password", "Fullname"
			}
		));
		table.setCellSelectionEnabled(true);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Pharmacist Record", null, panel_1, null);
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setCellSelectionEnabled(true);
		table_1.setBounds(0, 0, 779, 365);
		panel_1.add(table_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Patient Record", null, panel_2, null);
		panel_2.setLayout(null);
		
		table_2 = new JTable();
		table_2.setCellSelectionEnabled(true);
		table_2.setBounds(0, 0, 779, 365);
		panel_2.add(table_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Nurse Record", null, panel_3, null);
		panel_3.setLayout(null);
		
		table_3 = new JTable();
		table_3.setCellSelectionEnabled(true);
		table_3.setBounds(0, 0, 779, 365);
		panel_3.add(table_3);
	}
}
