package com.anas.ehealth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

public class ViewPrescription {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrescription window = new ViewPrescription();
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
	public ViewPrescription() {
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
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("All Record", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.menu);
		panel_4.setBounds(0, 0, 345, 433);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(172, 5, 0, 0);
		panel_4.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\random\\WhatsApp\\nfcQ2ajoAVrA9fIu5ARzSCzxc=.jpg_large.png"));
		label_3.setBounds(0, 0, 345, 433);
		panel_4.add(label_3);
		
		JLabel lblATableShowing_1 = new JLabel("a table showing all presc");
		lblATableShowing_1.setBounds(453, 21, 159, 14);
		panel_1.add(lblATableShowing_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Search", null, panel_2, null);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnByDate = new JRadioButton("By Date");
		rdbtnByDate.setBounds(6, 7, 74, 23);
		panel_2.add(rdbtnByDate);
		
		JRadioButton rdbtnByPatient = new JRadioButton("By Patient");
		rdbtnByPatient.setBounds(218, 7, 109, 23);
		panel_2.add(rdbtnByPatient);
		
		JRadioButton rdbtnByDoctor = new JRadioButton("By Doctor");
		rdbtnByDoctor.setBounds(425, 7, 109, 23);
		panel_2.add(rdbtnByDoctor);
		
		JRadioButton rdbtnByDrugName = new JRadioButton("By Drug Name");
		rdbtnByDrugName.setBounds(610, 7, 109, 23);
		panel_2.add(rdbtnByDrugName);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		layeredPane.setBounds(753, 69, -735, 353);
		panel_2.add(layeredPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		layeredPane_1.setBounds(764, 69, -735, 353);
		panel_2.add(layeredPane_1);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		layeredPane_2.setBounds(753, 69, -735, 353);
		panel_2.add(layeredPane_2);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		layeredPane_3.setBounds(753, 69, -735, 353);
		panel_2.add(layeredPane_3);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Today", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 240, 240));
		panel_3.setBounds(0, 0, 345, 433);
		panel.add(panel_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\random\\WhatsApp\\\u01A0\u0361\u0334\u0334.\u032E\u01A0\u0361\u0334\u0334\u0334 \u015E\u0127\u0101\u264F\u00F4\u00AE\u01A0\u0361\u0334\u0334.\u032E\u01A0\u0361\u0334\u0334\u0334.jpg"));
		panel_3.add(label);
		
		JLabel lblATableShowing = new JLabel("a table showing today's presc");
		lblATableShowing.setBounds(453, 21, 159, 14);
		panel.add(lblATableShowing);
	}
}
