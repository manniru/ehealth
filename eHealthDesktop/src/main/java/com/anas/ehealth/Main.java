package com.anas.ehealth;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.Font;

public class Main {
	static String patid = "";
	static String id = "";
	static String did = "";

	static JFrame frmEhealthSystemsintegrated;
	private JTextField outtxt;
	private JTextField idtxt;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		patid = "1";// args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					Main.frmEhealthSystemsintegrated.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEhealthSystemsintegrated = new JFrame();
		frmEhealthSystemsintegrated.setTitle("eHealth Systems (Integrated with Advanced Java Web Services Technologies)");
		frmEhealthSystemsintegrated.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/icon.png")));
		frmEhealthSystemsintegrated.setBounds(100, 100, 900, 700);
		frmEhealthSystemsintegrated.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEhealthSystemsintegrated.getContentPane().setLayout(null);
		frmEhealthSystemsintegrated.setLocationRelativeTo(null);
		
		frmEhealthSystemsintegrated.getContentPane().setLayout(new BorderLayout()); 
		frmEhealthSystemsintegrated.setContentPane(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/resources/bg.jpg"))))); 
		 
		
		btnNewButton = new JButton("Test Webservices");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idtxt.getText();
				String output  ="";
				try { URL url = new URL("http://localhost:8080/eHealthWeb/webservices.jsp?type=user&id="+id);
				URLConnection conn = url.openConnection();
				
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String line = null; while ((line = in.readLine()) != null) { output=line; }
				
				
					outtxt.setText(output);
				//System.out.println(output);
				} catch(Exception e1) { System.out.println("erro1"+e1); }
			}
		});
		btnNewButton.setBounds(724, 11, 144, 23);
		frmEhealthSystemsintegrated.getContentPane().add(btnNewButton);
		
		outtxt = new JTextField();
		outtxt.setBounds(657, 105, 165, 20);
		frmEhealthSystemsintegrated.getContentPane().add(outtxt);
		outtxt.setColumns(10);
		
		idtxt = new JTextField();
		idtxt.setBounds(582, 12, 86, 20);
		frmEhealthSystemsintegrated.getContentPane().add(idtxt);
		idtxt.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		frmEhealthSystemsintegrated.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Search patient");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frmEhealthSystemsintegrated.dispose();
				Fsearch.main(null);
			}
		});
		mnFile.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Edit Record");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] pid = {id};
				Main.frmEhealthSystemsintegrated.dispose();
				EditPatient.main(pid);
			}
		});
		mnFile.add(mntmNewMenuItem);
		
		JMenuItem mntmGenerateReport = new JMenuItem("Generate Report");
		mnFile.add(mntmGenerateReport);
		
		JMenu mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);
		
		JMenuItem mntmNewDoctor = new JMenuItem("New Doctor");
		mntmNewDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frmEhealthSystemsintegrated.dispose();
				Admin.main(null);
			}
		});
		mnAdmin.add(mntmNewDoctor);
		
		JMenuItem mntmNewAccess = new JMenuItem("View Record");
		mntmNewAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frmEhealthSystemsintegrated.dispose();
				AdminView.main(null);
			}
		});
		mnAdmin.add(mntmNewAccess);
		
		JMenuItem mntmReport = new JMenuItem("Generate Report");
		mnAdmin.add(mntmReport);
		
		JMenuItem mntmManageAccess = new JMenuItem("Manage Access");
		mntmManageAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frmEhealthSystemsintegrated.dispose();
				ManageAccess.main(null);
				
			}
		});
		mnAdmin.add(mntmManageAccess);
		
		JMenuItem mntmAppointments = new JMenuItem("Appointment");
		mntmAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frmEhealthSystemsintegrated.dispose();
				AdminApp.main(null);
			}
		});
		mnAdmin.add(mntmAppointments);
		
		JMenu mnDiagnosis = new JMenu("Diagnosis");
		menuBar.add(mnDiagnosis);
		
		JMenuItem mntmNewDiagnosis = new JMenuItem("New Diagnosis");
		mntmNewDiagnosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] pid = {id};
				Main.frmEhealthSystemsintegrated.dispose();
				Ndiag.main(pid);
			}
		});
		mnDiagnosis.add(mntmNewDiagnosis);
		
		JMenuItem mntmDiagnosisHistory = new JMenuItem("Diagnosis History");
		mntmDiagnosisHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] pid = {id};
				Main.frmEhealthSystemsintegrated.dispose();
				DiagH.main(pid);
			}
		});
		mnDiagnosis.add(mntmDiagnosisHistory);
		
		JMenuItem mntmEditDiagnosis = new JMenuItem("Edit Diagnosis");
		mntmEditDiagnosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] pid = {id};
				Main.frmEhealthSystemsintegrated.dispose();
				Ediag.main(pid);
			}
		});
		mnDiagnosis.add(mntmEditDiagnosis);
		
		JMenu mnPrescription = new JMenu("Prescription");
		menuBar.add(mnPrescription);
		
		JMenuItem mntmNewPrescription = new JMenuItem("New Prescription");
		mntmNewPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] pid = {id};
				Main.frmEhealthSystemsintegrated.dispose();
				NewPrescription.main(pid);
			}
		});
		mnPrescription.add(mntmNewPrescription);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("View Prescription");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] pid = {id};
				Main.frmEhealthSystemsintegrated.dispose();
				ViewPrescription.main(pid);
			}
		});
		mnPrescription.add(mntmNewMenuItem_2);
		
		JMenuItem mntmHistory = new JMenuItem("History");
		mntmHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frmEhealthSystemsintegrated.dispose();
				PrescHistory.main(null);
			}
		});
		mnPrescription.add(mntmHistory);
		
		JMenu mnNewMenu = new JMenu("Account");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmProfile = new JMenuItem("Profile");
		mntmProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] docid = {did};
				Main.frmEhealthSystemsintegrated.dispose();
				Profile.main(docid);
			}
		});
		mnNewMenu.add(mntmProfile);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mnNewMenu.add(mntmLogOut);
		
		JMenu mnPatients = new JMenu("Patient");
		menuBar.add(mnPatients);
		
		JMenuItem mntmNew = new JMenuItem("New Patient");
		mnPatients.add(mntmNew);
		
		JMenuItem mntmPatientRecords = new JMenuItem("Patient Records");
		mntmPatientRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEhealthSystemsintegrated.setVisible(false);
				ListPatients.main(null);
			}
		});
		mnPatients.add(mntmPatientRecords);
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Main.frmEhealthSystemsintegrated.dispose();
				NewPatient.main(null);
			}
		});
	}
}
