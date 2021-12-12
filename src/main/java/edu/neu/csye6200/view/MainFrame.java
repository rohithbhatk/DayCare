package edu.neu.csye6200.view;

import edu.neu.csye6200.controller.School;
import edu.neu.csye6200.controller.SchoolHelper;
import edu.neu.csye6200.controller.Vaccination;
import edu.neu.csye6200.models.Student;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;

import java.awt.Color;
;
import javax.swing.border.LineBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainFrame {

	private JFrame frame;	
	private GradientPanel gradientPanel;

	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_Gender;
	private JTextField textField_ParentFirstName;
	private JTextField textField_ParentLastName;
	private JTextField textField_Address;
	private JTextField textField_DOB;
	private JTextField textField_DOJ;
	private JTextField textField_Varicella;
	private JTextField textField_Hepatitis_B;
	private JTextField textField_MMR;
	private JTextField textField_DtaP;
	private JTextField textField_Polio;
	private JTextField textField_Age;
	private JTextField textField_Hib;
	
	private JButton btnRegister;
	private JButton btnView;
	private JButton btnCreate;
	
	private String getFirstName;
	private String getLastName;
	private String getGender;
	private String getVaricella;
	private String getDOB;
	private String getDOJ;
	private String getParentFirstName;
	private String getParentLastName;
	private String getAddress;
	private String getHib;
	private String getDtaP;
	private String getPolio;
	private String getHepatitis_B;
	private String getMMR;
	private String getAge;

	private ViewingPage viewingPage;

	private int age;
	private SimpleDateFormat formatter;

	private Date DOB;
	private Date DOJ;

	private List<Date> Hib;
	private List<Date> DtaP;
	private List<Date> Polio;
	private List<Date> Hepatitis_B;
	private List<Date> MMR;
	private List<Date> Varicella;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		// read default data from CSV (students, teachers)
		SchoolHelper.demo();

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
		
		gradientPanel = new GradientPanel();
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
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		gradientPanel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		gradientPanel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.VERTICAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 4;
		gradientPanel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.VERTICAL;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 5;
		gradientPanel.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));
		
		textField_FirstName = new HintTextField("First Name");
		panel_1.add(textField_FirstName);
		
		textField_LastName = new HintTextField("Last Name");
		panel_1.add(textField_LastName);
		
		textField_Gender = new HintTextField("Gender");
		panel_1.add(textField_Gender);

		textField_ParentFirstName = new HintTextField("Parent's First Name");
		panel_2.add(textField_ParentFirstName);

		textField_ParentLastName = new HintTextField("Parent's Last Name");
		panel_2.add(textField_ParentLastName);

		textField_Age = new HintTextField("Age (Months)");
		panel_2.add(textField_Age);
		
		textField_DOB = new HintTextField("Date of Birth (MM/DD/YYYY)");
		panel_3.add(textField_DOB);
		
		textField_DOJ = new HintTextField("Date of Joining (MM/DD/YYYY)");
		panel_3.add(textField_DOJ);
		
		textField_Address = new HintTextField("Address");
		panel_3.add(textField_Address);

		textField_Hib = new HintTextField("Hib");
		panel_4.add(textField_Hib);

		textField_DtaP = new HintTextField("DtaP");
		panel_4.add(textField_DtaP);

		textField_Polio = new HintTextField("Polio");
		panel_4.add(textField_Polio);

		textField_Hepatitis_B = new HintTextField("Hepatitis_B");
		panel_5.add(textField_Hepatitis_B);

		textField_MMR = new HintTextField("MMR");
		panel_5.add(textField_MMR);

		textField_Varicella = new HintTextField("Varicella");
		panel_5.add(textField_Varicella);
		  
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 6;
		gradientPanel.add(panel_6, gbc_panel_6);
		
		btnRegister = new JButton("REGISTER");
		btnRegister.setPreferredSize(new Dimension(160, 40));
		btnRegister.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		btnRegister.setForeground(Color.white);
		btnRegister.setBorder(new RoundBtn(20)); 
		panel_6.add(btnRegister);

		btnCreate = new JButton("CREATE CLASSROOMS");
		btnCreate.setPreferredSize(new Dimension(240, 40));
		btnCreate.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		btnCreate.setForeground(Color.white);
		btnCreate.setBorder(new RoundBtn(20));
		panel_6.add(btnCreate);
		
		btnView = new JButton("VIEW RECORDS");
		btnView.setPreferredSize(new Dimension(160, 40));
		btnView.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		btnView.setForeground(Color.white);
		btnView.setBorder(new LineBorder(Color.white));
		btnView.setBorder(new RoundBtn(20));  
		panel_6.add(btnView);
		
		btnRegister.addActionListener(e -> registerButtonPressed());
		btnView.addActionListener(e -> viewButtonPressed());
		btnCreate.addActionListener(e -> createButtonPressed());

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void registerButtonPressed() {
		formatter=new SimpleDateFormat("MM/dd/yyyy");
		getFirstName = textField_FirstName.getText();
		if(getFirstName.isEmpty()){
			errorMessage("Invalid Input","Please enter First Name");
			return;
		}
		getLastName = textField_LastName.getText();
		if(getLastName.isEmpty()){
			errorMessage("Invalid Input","Please enter Last Name");
			return;
		}
		getGender = textField_Gender.getText();
		if(getGender.isEmpty()){
			errorMessage("Invalid Input","Please enter Gender");
			return;
		}
		getParentFirstName = textField_ParentFirstName.getText();
		if(getParentFirstName.isEmpty()){
			errorMessage("Invalid Input","Please enter Parent's First Name");
			return;
		}
		getParentLastName = textField_ParentLastName.getText();
		if(getParentLastName.isEmpty()){
			errorMessage("Invalid Input","Please enter Parent's Last Name");
			return;
		}

		try {
			getAge = textField_Age.getText();
			age = Integer.parseInt(getAge);
		}
		catch(Exception e) {
			errorMessage("Invalid Input","Please enter valid Age");
			return;
		}

		getDOB = textField_DOB.getText();
		try {
			DOB=formatter.parse(getDOB);
		} catch (ParseException e) {
			errorMessage("Invalid Input","Please enter valid Date of Birth");
			return;
		}

		getDOJ = textField_DOJ.getText();
		try {
			DOJ=formatter.parse(getDOJ);
		} catch (ParseException e) {
			errorMessage("Invalid Input","Please enter valid Date of Joining");
			return;
		}

		getAddress = textField_Address.getText();
		if(getAddress.isEmpty()){
			errorMessage("Invalid Input","Please enter Address");
			return;
		}

		getHib = textField_Hib.getText();
		try{
			String[] tokens=getHib.split(",");
			Hib = new ArrayList<>();
			for(String s: tokens) {
				Hib.add(formatter.parse(s));
			}
		} catch(ParseException e){
			errorMessage("Invalid Input","Please enter valid Hib dates");
			return;
		}

		getDtaP = textField_DtaP.getText();
		try{
			String[] tokens=getDtaP.split(",");
			DtaP = new ArrayList<>();
			for(String s: tokens) {
				DtaP.add(formatter.parse(s));
			}
		} catch(ParseException e){
			errorMessage("Invalid Input","Please enter valid DtaP dates");
			return;
		}
		getPolio = textField_Polio.getText();
		try{
			String[] tokens=getPolio.split(",");
			Polio = new ArrayList<>();
			for(String s: tokens) {
				Polio.add(formatter.parse(s));
			}
		} catch(ParseException e){
			errorMessage("Invalid Input","Please enter valid Polio dates");
			return;
		}
		getHepatitis_B = textField_Hepatitis_B.getText();
		try{
			String[] tokens=getHepatitis_B.split(",");
			Hepatitis_B = new ArrayList<>();
			for(String s: tokens) {
				Hepatitis_B.add(formatter.parse(s));
			}
		} catch(ParseException e){
			errorMessage( "Invalid Input","Please enter valid Hepatitis B dates");
			return;
		}
		getMMR = textField_MMR.getText();
		try{
			String[] tokens=getMMR.split(",");
			MMR = new ArrayList<>();
			for(String s: tokens) {
				MMR.add(formatter.parse(s));
			}
		} catch(ParseException e){
			errorMessage("Invalid Input", "Please enter valid MMR dates");
			return;
		}
		getVaricella = textField_Varicella.getText();
		try{
			String[] tokens=getVaricella.split(",");
			Varicella = new ArrayList<>();
			for(String s: tokens) {
				Varicella.add(formatter.parse(s));
			}
		} catch(ParseException e){
			errorMessage("Invalid Input", "Please enter valid Varicella dates");
			return;
		}

		System.out.println(getFirstName);
		System.out.println(getLastName);
		System.out.println(getGender);
		System.out.println(getParentFirstName);
		System.out.println(getParentLastName);
		System.out.println(getAge);
		System.out.println(getDOB);
		System.out.println(getDOJ);
		System.out.println(getAddress);
		System.out.println(getHib);
		System.out.println(getDtaP);
		System.out.println(getPolio);
		System.out.println(getHepatitis_B);
		System.out.println(getMMR);
		System.out.println(getVaricella);

		// int id, int age, String first_Name, String last_name, String date, String gender, Vaccination immunization_Records,
		//				   int grade, int groupId, String parents_first_name, String parents_last_name, String address,String date_of_joining
		//private List<Date> Hib;
		//	private List<Date> DtaP;
		//	private List<Date> Polio;
		//	private List<Date> Hepatitis_B;
		//	private List<Date> MMR;
		//	private List<Date> Varicella;

		int id = School.studentRoster.size();
		Vaccination vaccination = new Vaccination();
		vaccination.setHib(Hib);
		vaccination.setPolio(Polio);
		vaccination.setdTaP(DtaP);
		vaccination.setHepatitis_B(Hepatitis_B);
		vaccination.setmMR(MMR);
		vaccination.setVaricella(Varicella);
		System.out.println("vaccination size: " + vaccination.getdTaP().size());
		Student student = new Student(id, age, getFirstName, getLastName, getDOB, getGender, vaccination, "1", getParentFirstName, getParentLastName, getAddress, getDOJ);
		School.addStudent(student);

	}


	private void viewButtonPressed() {
		if(!ViewingPage.isInitialized()) {
			viewingPage = ViewingPage.getInstance();
			viewingPage.initialize();
			viewingPage.addBtnListener(frame, gradientPanel);
		} else {
			viewingPage.rerender();
		}
		
		viewingPage.setVisible(true);
		gradientPanel.setVisible(false);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(viewingPage, BorderLayout.CENTER);
	}

	private void createButtonPressed() {
		try {
			SchoolHelper.setClassrooms();
			System.out.println(SchoolHelper.getClassrooms());
			successMessage("", "Create classrooms successfully!");
		} catch (Exception e) {
			// Todo: handle exception
			System.out.println(e.getStackTrace());
		}

	}

	private void errorMessage(String title, String error){
		JOptionPane.showMessageDialog(null, error, title, JOptionPane.WARNING_MESSAGE);
	}

	private void successMessage(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);
	}
}
