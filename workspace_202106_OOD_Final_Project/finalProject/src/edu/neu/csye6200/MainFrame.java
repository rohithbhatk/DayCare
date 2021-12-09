package edu.neu.csye6200;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Dimension;

public class MainFrame {

	private JFrame frame;	
	private JPanel panel;
	private JTextField textField;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPanel panel_5;
	private JPanel panel_4;
	private JPanel panel_3;
	private HintTextField textField_11;
	private HintTextField textField_12;
	private JButton btnRegister;
	private JPanel panel_6;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.getContentPane().setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		
		GradientPanel gradientPanel = new GradientPanel();
		frame.getContentPane().add(gradientPanel, BorderLayout.CENTER);
		frame.setBounds(100, 100, 1280, 720);
		GridBagLayout gbl_gradientPanel = new GridBagLayout();
		gbl_gradientPanel.columnWidths = new int[]{0, 0};
		gbl_gradientPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_gradientPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_gradientPanel.rowWeights = new double[]{1.0, 0.1, 0.1, 0.1, 0.1, 0.1, 1.0, Double.MIN_VALUE};
		gradientPanel.setLayout(gbl_gradientPanel);
		
		JLabel lblStudentRegistration = new JLabel("STUDENT REGISTRATION");
		lblStudentRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRegistration.setForeground(new Color(255, 255, 255));
		lblStudentRegistration.setFont(new Font("Roboto Condensed", Font.BOLD, 24));
		GridBagConstraints gbc_lblStudentRegistration = new GridBagConstraints();
		gbc_lblStudentRegistration.fill = GridBagConstraints.VERTICAL;
		gbc_lblStudentRegistration.insets = new Insets(0, 0, 5, 0);
		gbc_lblStudentRegistration.gridx = 0;
		gbc_lblStudentRegistration.gridy = 0;
		gradientPanel.add(lblStudentRegistration, gbc_lblStudentRegistration);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		gradientPanel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		gradientPanel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		gradientPanel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.VERTICAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 4;
		gradientPanel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.VERTICAL;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 5;
		gradientPanel.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField_1 = new HintTextField("First Name");
		panel_1.add(textField_1);
		
		textField_2 = new HintTextField("Last Name");
		panel_1.add(textField_2);
		
		textField_3 = new HintTextField("Gender");
		panel_2.add(textField_3);
		
		textField_4 = new HintTextField("Immunization Records");
		panel_2.add(textField_4);
		
		textField_11 = new HintTextField("Date of Birth (MM/DD/YYYY)");
		panel_3.add(textField_11);
		
		textField_12 = new HintTextField("Date of Joining (MM/DD/YYYY)");
		panel_3.add(textField_12);
		
		textField_8 = new HintTextField("Address");
		panel_5.add(textField_8);
		textField_8.setColumns(51);
	
		textField_6 = new HintTextField("Parent's First Name");
		panel_4.add(textField_6);
		
		textField_7 = new HintTextField("Parent's Last Name");
		panel_4.add(textField_7);
		
//		btnRegister = new JButton("REGISTER");
//		btnRegister.setPreferredSize(new Dimension(120, 40));
//		btnRegister.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
//		btnRegister.setForeground(Color.white);
//		btnRegister.setBorder(new RoundBtn(20));   
		
		GridBagConstraints gbc_Register = new GridBagConstraints();
		gbc_Register.gridx = 0;
		gbc_Register.gridy = 6;
		gradientPanel.add(btnRegister, gbc_Register);
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 6;
		gradientPanel.add(panel_6, gbc_panel_6);


		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
