package edu.neu.csye6200.view;

import edu.neu.csye6200.controller.LoginCredentials;
import edu.neu.csye6200.controller.School;
import edu.neu.csye6200.controller.SchoolHelper;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Dimension;

public class LoginFrame {

    public static int id;

    private static JFrame frame;
    private GradientPanel gradientPanel;

    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;

    private JTextField textField_Username;
    private JTextField textField_Password;


    private JButton btnLogin;

    private String getUsername;
    private String getPassword;


    private StudentPage studentPage;
    private TeacherPage teacherPage;
    /**
     * Launch the application.
     */
    public static void demo() {
        try {
            SchoolHelper.demo();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame window = new LoginFrame();
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
    public LoginFrame() {
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
        gbl_gradientPanel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_gradientPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_gradientPanel.rowWeights = new double[]{1.0, 0.1, 0.1, 1.0};
        gradientPanel.setLayout(gbl_gradientPanel);

        JLabel lblStudentRegistration = new JLabel("DAYCARE LOGIN");
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
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        panel_2 = new JPanel();
        panel_2.setOpaque(false);
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 0);
        gbc_panel_2.fill = GridBagConstraints.VERTICAL;
        gbc_panel_2.gridx = 0;
        gbc_panel_2.gridy = 2;
        gradientPanel.add(panel_2, gbc_panel_2);
        panel_2.setLayout(new GridLayout(0, 1, 0, 0));

        textField_Username = new HintTextField("Enter Username");
        textField_Username.setColumns(50);
        panel_1.add(textField_Username);

        textField_Password = new HintTextField("Enter Password");
        textField_Password.setColumns(50);
        panel_2.add(textField_Password);

        panel_6 = new JPanel();
        panel_6.setOpaque(false);
        GridBagConstraints gbc_panel_6 = new GridBagConstraints();
        gbc_panel_6.insets = new Insets(0, 0, 5, 0);
        gbc_panel_6.gridx = 0;
        gbc_panel_6.gridy = 3;
        gradientPanel.add(panel_6, gbc_panel_6);

        btnLogin = new JButton("LOGIN");
        btnLogin.setPreferredSize(new Dimension(160, 40));
        btnLogin.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnLogin.setForeground(Color.white);
        btnLogin.setBorder(new RoundBtn(20));
        panel_6.add(btnLogin);

        btnLogin.addActionListener(e -> loginButtonPressed());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void loginButtonPressed() {
        getUsername = textField_Username.getText();
        if (getUsername.isEmpty()) {
            errorMessage("Please enter Username", "Invalid Input");
            return;
        }
        getPassword = textField_Password.getText();
        if (getPassword.isEmpty()) {
            errorMessage("Please enter Password", "Invalid Input");
            return;
        }
        School school = new School();
        if (LoginCredentials.isValidTeacherLogin(school.getTeacher(), getUsername, getPassword)) {
            // todo: compare with username = teacher first and password = date of birth from the database
            // open new teacher frame
            id = LoginCredentials.getidTeacher(school.getTeacher(), getUsername, getPassword);

            System.out.println("Teacher");
            teacherPressed();
        } else if (LoginCredentials.isValidStudentLogin(school.getStudent(), getUsername, getPassword)) {
            // todo: compare with username = student first and password = date of birth from the database
            // open new student frame
            id = LoginCredentials.getidStudent(school.getStudent(), getUsername, getPassword);

            System.out.println("Student");
            studentPressed();
        } else {
            errorMessage("Username or Password is incorrect", "Invalid Credentials");
            return;
        }

        System.out.println(getUsername);
        System.out.println(getPassword);
    }

    private void studentPressed() {
        if (!StudentPage.isInitialized()) {
            studentPage = StudentPage.getInstance();
            studentPage.initialize(frame, gradientPanel);
            studentPage.addBtnListener(frame, gradientPanel);

            studentPage.setVisible(true);
            gradientPanel.setVisible(false);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(studentPage, BorderLayout.CENTER);
        }
    }
    private void teacherPressed(){
        if (!TeacherPage.isInitialized()) {
            teacherPage = TeacherPage.getInstance();
            teacherPage.initialize(frame, gradientPanel);
            teacherPage.addBtnListener(frame, gradientPanel);
        }

        teacherPage.setVisible(true);
        gradientPanel.setVisible(false);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(teacherPage, BorderLayout.CENTER);
    }
    private void errorMessage (String error, String errorType){
        JOptionPane.showMessageDialog(null, error, errorType, JOptionPane.WARNING_MESSAGE);
    }
}

