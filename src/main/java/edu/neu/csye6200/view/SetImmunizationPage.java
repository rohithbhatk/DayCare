package edu.neu.csye6200.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class SetImmunizationPage extends GradientPanel {
    private static final SetImmunizationPage instance = new SetImmunizationPage();
    private static boolean isInitialized = false;


    private SetImmunizationPage() {
        super();
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static SetImmunizationPage getInstance() {
        return instance;
    }

    public void initialize(JFrame frame, GradientPanel gradientPanel) {
        isInitialized = true;
        this.frame=frame;
        this.gradientPanel=gradientPanel;
        GridBagLayout gbl_gradientPanel = new GridBagLayout();
        gbl_gradientPanel.columnWidths = new int[]{0, 0, 0, 0};
        gbl_gradientPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_gradientPanel.columnWeights = new double[]{0.1, 1.0, 0.1, Double.MIN_VALUE};
        gbl_gradientPanel.rowWeights = new double[]{1.0, 0.1, 0.1, 0.1, 0.1, 1.0};

        createLabel();
//        createTable();
//        createScrollPane();
        createButton();


        instance.setLayout(gbl_gradientPanel);
        instance.add(lblRecords, gbc_label);
        //instance.add(scrollPane, gbc_scrollPane);
        instance.add(btnSubmit, gbc_button);
        instance.add(btnBack, gbc_button2);

        instance.add(textField_StudentID,gbc_Options);
        instance.add(textField_VaccineName, gbc_Options2);
        instance.add(textField_DoseDate,gbc_Options3);

        //instance.add(btnTrackImmunization,gbc_Options2);
//        instance.add(panel, gbc_Options);
    }

    public void rerender() {
//        instance.remove(scrollPane);
//        createTable();
//        createScrollPane();
//        instance.add(scrollPane, gbc_scrollPane, 1);
    }

    public void createLabel() {
        lblRecords = new JLabel("SET IMMUNIZATION");
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
        btnBack = new JButton("LOGOUT");
        btnBack.setPreferredSize(new Dimension(160, 40));
        btnBack.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnBack.setForeground(Color.white);
        btnBack.setBorder(new LineBorder(Color.white));
        btnBack.setBorder(new RoundBtn(20));

        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setPreferredSize(new Dimension(160, 40));
        btnSubmit.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnSubmit.setForeground(Color.white);
        btnSubmit.setBorder(new LineBorder(Color.white));
        btnSubmit.setBorder(new RoundBtn(20));

        gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 20, 0);
        gbc_button.gridx = 1;
        gbc_button.gridy = 4;

        gbc_button2 = new GridBagConstraints();
        gbc_button2.insets = new Insets(0, 0, 20, 0);
        gbc_button2.gridx = 1;
        gbc_button2.gridy = 5;

        textField_VaccineName = new HintTextField("Enter Vaccine Name");
        textField_DoseDate = new HintTextField("Enter Dose Date");
        textField_StudentID = new HintTextField("Enter Student ID");
        //textField_Rating.setColumns(50);

        gbc_Options = new GridBagConstraints();
        gbc_Options.insets = new Insets(0, 0, 20, 0);
        gbc_Options.gridx = 1;
        gbc_Options.gridy = 1;
        gbc_Options.fill = GridBagConstraints.VERTICAL;

        gbc_Options2 = new GridBagConstraints();
        gbc_Options2.insets = new Insets(0, 0, 20, 0);
        gbc_Options2.gridx = 1;
        gbc_Options2.gridy = 2;
        gbc_Options2.fill = GridBagConstraints.VERTICAL;

        gbc_Options3 = new GridBagConstraints();
        gbc_Options3.insets = new Insets(0, 0, 20, 0);
        gbc_Options3.gridx = 1;
        gbc_Options3.gridy = 3;
        gbc_Options3.fill = GridBagConstraints.VERTICAL;

        btnSubmit.addActionListener(e -> submitButtonPressed());
    }

    private void submitButtonPressed() {
        studentID = textField_StudentID.getText();
        if(studentID.isEmpty()){
            errorMessage("Please enter Student ID","Invalid Input");
            return;
        }
        System.out.println(dose);
        dose = textField_VaccineName.getText();
        if(dose.isEmpty()){
            errorMessage("Please enter Vaccine Name","Invalid Input");
            return;
        }
        System.out.println(dose);
        //todo: add code to check dosage in database
        doseDate = textField_DoseDate.getText();
        if(doseDate.isEmpty()){
            errorMessage("Please enter Dose Date","Invalid Input");
            return;
        }
        formatter=new SimpleDateFormat("MM/dd/yyyy");
        try {
            date=formatter.parse(doseDate);
        } catch (ParseException e) {
            errorMessage("Please enter valid Dosage Date","Invalid Input");
            return;
        }
        System.out.println(dose);
        //todo: Store date in database
    }

    private void errorMessage(String error,String errorType){
        JOptionPane.showMessageDialog(null,error,errorType,JOptionPane.WARNING_MESSAGE);
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

    private JButton btnBack,btnSubmit;
    private JLabel lblRecords;
    private GridBagConstraints gbc_label;
    private GridBagConstraints gbc_button;
    private GridBagConstraints gbc_button2;
    private GridBagConstraints gbc_Options;
    private GridBagConstraints gbc_Options2;
    private GridBagConstraints gbc_Options3;

    private JFrame frame;
    private GradientPanel gradientPanel;
    private JTextField textField_VaccineName;
    private JTextField textField_DoseDate;
    private JTextField textField_StudentID;

    private String dose;
    private String doseDate;
    private Date date;
    private String studentID;

    private SimpleDateFormat formatter;
}
