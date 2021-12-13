package edu.neu.csye6200.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ReviewPage extends GradientPanel {
    private static final ReviewPage instance = new ReviewPage();
    private static boolean isInitialized = false;

    private ReviewPage() {
        super();
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static ReviewPage getInstance() {
        return instance;
    }

    public void initialize() {
        isInitialized = true;

        GridBagLayout gbl_gradientPanel = new GridBagLayout();
        gbl_gradientPanel.columnWidths = new int[]{0, 0, 0, 0};
        gbl_gradientPanel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_gradientPanel.columnWeights = new double[]{0.1, 1.0, 0.1, Double.MIN_VALUE};
        gbl_gradientPanel.rowWeights = new double[]{1.0, 0.1, 0.1, 1.0};

        createLabel();
        createButton();


        instance.setLayout(gbl_gradientPanel);
        instance.add(lblRecords, gbc_label);
        instance.add(btnSubmit, gbc_button);
        instance.add(btnBack, gbc_button2);
        instance.add(textField_Rating, gbc_Options);
    }

    public void rerender() {
//        instance.remove(scrollPane);
//        createTable();
//        createScrollPane();
//        instance.add(scrollPane, gbc_scrollPane, 1);
    }

    public void createLabel() {
        lblRecords = new JLabel("REVIEW DASHBOARD");
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

        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setPreferredSize(new Dimension(160, 40));
        btnSubmit.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        btnSubmit.setForeground(Color.white);
        btnSubmit.setBorder(new LineBorder(Color.white));
        btnSubmit.setBorder(new RoundBtn(20));

        gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 20, 0);
        gbc_button.gridx = 1;
        gbc_button.gridy = 2;

        gbc_button2 = new GridBagConstraints();
        gbc_button2.insets = new Insets(0, 0, 20, 0);
        gbc_button2.gridx = 1;
        gbc_button2.gridy = 3;

        textField_Rating = new HintTextField("Enter Rating (Out of 5)");

        gbc_Options = new GridBagConstraints();
        gbc_Options.insets = new Insets(0, 0, 20, 0);
        gbc_Options.gridx = 1;
        gbc_Options.gridy = 1;
        gbc_Options.fill = GridBagConstraints.VERTICAL;

        btnSubmit.addActionListener(e -> submitButtonPressed());
    }

    private void submitButtonPressed() {
        int intRating;
        rating = textField_Rating.getText();
        if(rating.isEmpty()){
            errorMessage("Please enter Rating","Invalid Input");
            return;
        }
        try{
            intRating = Integer.parseInt(rating);
            //todo: store in backend
        }
        catch (Exception e){
            errorMessage("Please input valid Rating","Invalid Input");
            return;
        }
        if(intRating<0 || intRating>5){
            errorMessage("Please input Rating between 0 and 5","Invalid Input");
            return;
        }
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

    private JFrame frame;
    private GradientPanel gradientPanel;
    private JTextField textField_Rating;
    private String rating;
}
