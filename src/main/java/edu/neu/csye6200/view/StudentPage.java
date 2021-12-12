package edu.neu.csye6200.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class StudentPage extends GradientPanel {
    private static final StudentPage instance = new StudentPage();
    private static boolean isInitialized = false;
    private JFrame frame;
    private GradientPanel gradientPanel;

    private StudentPage() {
        super();
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static StudentPage getInstance() {
        return instance;
    }

    public void initialize(JFrame frame, GradientPanel gradientPanel) {
        isInitialized = true;
        this.frame=frame;
        this.gradientPanel=gradientPanel;
        GridBagLayout gbl_gradientPanel = new GridBagLayout();
        gbl_gradientPanel.columnWidths = new int[]{0, 0, 0, 0};
        gbl_gradientPanel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_gradientPanel.columnWeights = new double[]{0.1, 1.0, 0.1, Double.MIN_VALUE};
        gbl_gradientPanel.rowWeights = new double[]{1.0, 0.1, 0.1, 1.0};

        createLabel();
        createButton();


        instance.setLayout(gbl_gradientPanel);
        instance.add(lblRecords, gbc_label);
        instance.add(btnBack, gbc_button);
        instance.add(btnTeacherReview, gbc_Options);
        instance.add(btnTrackImmunization,gbc_Options2);
    }

    public void rerender() {

    }

    public void createLabel() {
        lblRecords = new JLabel("STUDENT DASHBOARD");
        lblRecords.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecords.setForeground(Color.WHITE);
        lblRecords.setFont(new Font("Roboto Condensed", Font.BOLD, 24));

        gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.VERTICAL;
        gbc_label.insets = new Insets(50, 0, 5, 0);
        gbc_label.gridx = 1;
        gbc_label.gridy = 0;
    }


    public void getTableData() {
        // Todo: get table data from ClassRoom(?
    };


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
        gbc_button.gridy = 3;

        btnTeacherReview = new JButton("TEACHER REVIEW");
        btnTeacherReview.setPreferredSize(new Dimension(250, 40));
        btnTeacherReview.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnTeacherReview.setForeground(Color.white);
        btnTeacherReview.setBorder(new LineBorder(Color.white));
        btnTeacherReview.setBorder(new RoundBtn(20));

        gbc_Options = new GridBagConstraints();
        gbc_Options.insets = new Insets(0, 0, 20, 0);
        gbc_Options.gridx = 1;
        gbc_Options.gridy = 1;
        gbc_Options.fill = GridBagConstraints.VERTICAL;

        btnTrackImmunization = new JButton("TRACK IMMUNIZATION");
        btnTrackImmunization.setPreferredSize(new Dimension(250, 40));
        btnTrackImmunization.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnTrackImmunization.setForeground(Color.white);
        btnTrackImmunization.setBorder(new LineBorder(Color.white));
        btnTrackImmunization.setBorder(new RoundBtn(20));

        gbc_Options2 = new GridBagConstraints();
        gbc_Options2.insets = new Insets(0, 0, 20, 0);
        gbc_Options2.gridx = 1;
        gbc_Options2.gridy = 2;
        gbc_Options2.fill = GridBagConstraints.VERTICAL;

        btnTeacherReview.addActionListener(e -> teacherReviewButtonPressed());
        btnTrackImmunization.addActionListener(e -> trackImmunizationButtonPressed());
    }

    private void teacherReviewButtonPressed() {
        if(!ReviewPage.isInitialized()) {
            System.out.println("Review");
            reviewPage = ReviewPage.getInstance();
            reviewPage.initialize(frame,gradientPanel);
            reviewPage.addBtnListener(frame, gradientPanel);
        } else {
            reviewPage.rerender();
        }

        reviewPage.setVisible(true);
        instance.setVisible(false);
        System.out.println(frame.getContentPane());
        frame.getContentPane().removeAll();
        frame.getContentPane().add(reviewPage, BorderLayout.CENTER);
    }

    private void trackImmunizationButtonPressed() {
        if(!TrackImmunizationPage.isInitialized()) {
            System.out.println("Review");
            trackImmunizationPage = TrackImmunizationPage.getInstance();
            trackImmunizationPage.initialize(frame,gradientPanel);
            trackImmunizationPage.addBtnListener(frame, gradientPanel);
        } else {
            trackImmunizationPage.rerender();
        }

        trackImmunizationPage.setVisible(true);
        instance.setVisible(false);
        System.out.println(frame.getContentPane());
        frame.getContentPane().removeAll();
        frame.getContentPane().add(trackImmunizationPage, BorderLayout.CENTER);
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

    private JButton btnBack;
    private JButton btnTeacherReview;
    private JButton btnTrackImmunization;
    private JLabel lblRecords;
    private GridBagConstraints gbc_label;
    private GridBagConstraints gbc_button;
    private GridBagConstraints gbc_Options2;
    private GridBagConstraints gbc_Options;
    private ReviewPage reviewPage;
    private TrackImmunizationPage trackImmunizationPage;
}
