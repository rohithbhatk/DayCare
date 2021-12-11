package edu.neu.csye6200;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;

public class ViewFrame {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void demo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFrame window = new ViewFrame();
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
	public ViewFrame() {
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
		frame.setBounds(100, 100, 1280, 720);
		frame.getContentPane().add(gradientPanel, BorderLayout.CENTER);
		GridBagLayout gbl_gradientPanel = new GridBagLayout();
		gbl_gradientPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_gradientPanel.rowHeights = new int[]{0, 0, 0};
		gbl_gradientPanel.columnWeights = new double[]{0.1, 1.0, 0.1, Double.MIN_VALUE};
		gbl_gradientPanel.rowWeights = new double[]{0.25, 1.0, 0.25};
		gradientPanel.setLayout(gbl_gradientPanel);
		
		JLabel lblStudentRegistration = new JLabel("RECORDS");
		lblStudentRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRegistration.setForeground(Color.WHITE);
		lblStudentRegistration.setFont(new Font("Roboto Condensed", Font.BOLD, 24));
		
		GridBagConstraints gbc_lblStudentRegistration = new GridBagConstraints();
		gbc_lblStudentRegistration.fill = GridBagConstraints.VERTICAL;
		gbc_lblStudentRegistration.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudentRegistration.gridx = 1;
		gbc_lblStudentRegistration.gridy = 0;
		gradientPanel.add(lblStudentRegistration, gbc_lblStudentRegistration);

		
		
		String columns[] = {"ID","Name","Gender","Age","Grade","Date of Joining","Annunal Renewal","Immunization Records"};
		String data[][] = {
				//columns,
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"1","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				{"2","Akhil","Male","20","2","15/11/2020","15/11/2022","hib=0, dTap=0, polio=1,hepatitis_B=0,mMR=0,varicella=0"},
				};
		
		table = new JTable(data,columns) {
			public boolean isCellEditable(int data,int columns) {
				return false;
			}
		};
		
		
		table.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		table.setFillsViewportHeight(true);
		table.setBackground(new Color(20, 20, 20));
		table.setForeground(Color.white);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(20, 20, 20));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		table.setShowVerticalLines(false);
		
		TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		
//		setColumnWidths(table, 20, 10000,10000);
		resizeColumnWidth(table);
		

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(20, 20, 20));
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		gradientPanel.add(scrollPane, gbc_scrollPane);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}
	
	public static void setColumnWidths(JTable table, int... widths) {
	    TableColumnModel columnModel = table.getColumnModel();
	    for (int i = 0; i < widths.length; i++) {
	        if (i < columnModel.getColumnCount()) {
	            columnModel.getColumn(i).setMaxWidth(widths[i]);
	        }
	        else break;
	    }
	}
	
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}

}
