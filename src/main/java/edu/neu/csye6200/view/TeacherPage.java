package edu.neu.csye6200.view;

import edu.neu.csye6200.controller.SchoolHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class TeacherPage extends GradientPanel {
    private static final TeacherPage instance = new TeacherPage();
    private static boolean isInitialized = false;
    private JFrame frame;
    private GradientPanel gradientPanel;

    private TeacherPage() {
        super();
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static TeacherPage getInstance() {
        return instance;
    }

    public void initialize(JFrame frame, GradientPanel gradientPanel) {
        isInitialized = true;
        this.frame=frame;
        this.gradientPanel=gradientPanel;
        GridBagLayout gbl_gradientPanel = new GridBagLayout();
        gbl_gradientPanel.columnWidths = new int[]{0, 0, 0, 0};
        gbl_gradientPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_gradientPanel.columnWeights = new double[]{0.1, 1.0, 0.1, Double.MIN_VALUE};
        gbl_gradientPanel.rowWeights = new double[]{1.0, 0.1, 0.1, 0.1, 0.1, 1.0};

        createLabel();
        createButton();


        instance.setLayout(gbl_gradientPanel);
        instance.add(lblRecords, gbc_label);
        instance.add(btnBack, gbc_button);
        instance.add(btnStudentRegistration, gbc_Options);
        instance.add(btnAddStudentstoClassrooms,gbc_Options2);
        instance.add(btnSetGrade,gbc_Options3);
        instance.add(btnSetImmunization,gbc_Options4);
    }

    public void createLabel() {
        lblRecords = new JLabel("TEACHER DASHBOARD");
        lblRecords.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecords.setForeground(Color.WHITE);
        lblRecords.setFont(new Font("Roboto Condensed", Font.BOLD, 24));

        gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.VERTICAL;
        gbc_label.insets = new Insets(50, 0, 5, 0);
        gbc_label.gridx = 1;
        gbc_label.gridy = 0;
    }

    public void createButton() {

        btnBack = new JButton("BACK");
        btnBack.setPreferredSize(new Dimension(160, 40));
        btnBack.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnBack.setForeground(Color.white);
        btnBack.setBorder(new LineBorder(Color.white));
        btnBack.setBorder(new RoundBtn(20));

        gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 20, 0);
        gbc_button.gridx = 1;
        gbc_button.gridy = 5;

        btnStudentRegistration = new JButton("STUDENT REGISTRATION");
        btnStudentRegistration.setPreferredSize(new Dimension(250, 40));
        btnStudentRegistration.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnStudentRegistration.setForeground(Color.white);
        btnStudentRegistration.setBorder(new LineBorder(Color.white));
        btnStudentRegistration.setBorder(new RoundBtn(20));

        gbc_Options = new GridBagConstraints();
        gbc_Options.insets = new Insets(0, 0, 10, 0);
        gbc_Options.gridx = 1;
        gbc_Options.gridy = 1;
        gbc_Options.fill = GridBagConstraints.VERTICAL;

        btnAddStudentstoClassrooms = new JButton("ADD STUDENTS TO CLASSROOM");
        btnAddStudentstoClassrooms.setPreferredSize(new Dimension(250, 40));
        btnAddStudentstoClassrooms.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnAddStudentstoClassrooms.setForeground(Color.white);
        btnAddStudentstoClassrooms.setBorder(new LineBorder(Color.white));
        btnAddStudentstoClassrooms.setBorder(new RoundBtn(20));

        gbc_Options2 = new GridBagConstraints();
        gbc_Options2.insets = new Insets(0, 0, 10, 0);
        gbc_Options2.gridx = 1;
        gbc_Options2.gridy = 2;
        gbc_Options2.fill = GridBagConstraints.VERTICAL;

        btnSetGrade = new JButton("SET GRADE");
        btnSetGrade.setPreferredSize(new Dimension(250, 40));
        btnSetGrade.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnSetGrade.setForeground(Color.white);
        btnSetGrade.setBorder(new LineBorder(Color.white));
        btnSetGrade.setBorder(new RoundBtn(20));

        gbc_Options3 = new GridBagConstraints();
        gbc_Options3.insets = new Insets(0, 0, 10, 0);
        gbc_Options3.gridx = 1;
        gbc_Options3.gridy = 3;
        gbc_Options3.fill = GridBagConstraints.VERTICAL;

        btnSetImmunization = new JButton("SET IMMUNIZATION");
        btnSetImmunization.setPreferredSize(new Dimension(250, 40));
        btnSetImmunization.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnSetImmunization.setForeground(Color.white);
        btnSetImmunization.setBorder(new LineBorder(Color.white));
        btnSetImmunization.setBorder(new RoundBtn(20));

        gbc_Options4 = new GridBagConstraints();
        gbc_Options4.insets = new Insets(0, 0, 10, 0);
        gbc_Options4.gridx = 1;
        gbc_Options4.gridy = 4;
        gbc_Options4.fill = GridBagConstraints.VERTICAL;

        btnStudentRegistration.addActionListener(e -> studentRegistrationPressed());
        btnSetGrade.addActionListener(e -> setGradePressed());
        btnAddStudentstoClassrooms.addActionListener(e -> addStudentstoClassroomsPressed());
        btnSetImmunization.addActionListener(e->setImmunizationPressed());
    }

    private void studentRegistrationPressed() {
        MainFrame.demo();
    }

    private void setGradePressed() {
        if(!GradePage.isInitialized()) {
            System.out.println("Review");
            gradePage = GradePage.getInstance();
            gradePage.initialize(frame,gradientPanel);
            gradePage.addBtnListener(frame, gradientPanel);
        } else {
            gradePage.rerender();
        }

        gradePage.setVisible(true);
        instance.setVisible(false);
        System.out.println(frame.getContentPane());
        frame.getContentPane().removeAll();
        frame.getContentPane().add(gradePage, BorderLayout.CENTER);
    }

    private void addStudentstoClassroomsPressed() {
        //todo: assign students to classroom
        try {
            SchoolHelper.setClassrooms();
            successMessage("", "Create classrooms successfully!");
        } catch (Exception e) {
            // Todo: handle exception
            System.out.println(e.getStackTrace());
        }
        JOptionPane.showMessageDialog(null, "Students assigned to classrooms");
    }
    private void setImmunizationPressed() {
        if(!SetImmunizationPage.isInitialized()) {
            System.out.println("Review");
            setImmunizationPage = SetImmunizationPage.getInstance();
            setImmunizationPage.initialize(frame,gradientPanel);
            setImmunizationPage.addBtnListener(frame, gradientPanel);
        } else {
            setImmunizationPage.rerender();
        }

        setImmunizationPage.setVisible(true);
        instance.setVisible(false);
        System.out.println(frame.getContentPane());
        frame.getContentPane().removeAll();
        frame.getContentPane().add(setImmunizationPage, BorderLayout.CENTER);
    }

    public void addBtnListener(JFrame frame, GradientPanel gradientPanel) {
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instance.setVisible(false);
                frame.getContentPane().removeAll();
                gradientPanel.setVisible(true);
                frame.getContentPane().add(gradientPanel, BorderLayout.CENTER);
            }
        });
    }

    private void successMessage(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);
    }

    private JButton btnBack;

    private JButton btnStudentRegistration;
    private JButton btnSetGrade;
    private JButton btnAddStudentstoClassrooms;
    private JButton btnSetImmunization;

    private JLabel lblRecords;
    private GridBagConstraints gbc_label;
    private GridBagConstraints gbc_button;
    private GridBagConstraints gbc_Options;
    private GridBagConstraints gbc_Options2;
    private GridBagConstraints gbc_Options3;
    private GridBagConstraints gbc_Options4;

    private SetImmunizationPage setImmunizationPage;
    private GradePage gradePage;
}

