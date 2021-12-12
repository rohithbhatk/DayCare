package edu.neu.csye6200.view;
import edu.neu.csye6200.controller.SchoolHelper;
import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ViewingPage extends GradientPanel {
	private static final ViewingPage instance = new ViewingPage();
	private static boolean isInitialized = false;

	private ViewingPage() {
		super();
	}
	
	public static boolean isInitialized() {
		return isInitialized;
	}

	public static ViewingPage getInstance() {
		return instance;
	}

	public void initialize() {
		isInitialized = true;
		GridBagLayout gbl_gradientPanel = new GridBagLayout();
		gbl_gradientPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_gradientPanel.rowHeights = new int[]{0, 0, 0};
		gbl_gradientPanel.columnWeights = new double[]{0.1, 1.0, 0.1, Double.MIN_VALUE};
		gbl_gradientPanel.rowWeights = new double[]{0.25, 1.0, 0.25};
		
		createLabel();
		createTable();
		createScrollPane();
		createButton();
		
		
		instance.setLayout(gbl_gradientPanel);
		instance.add(lblRecords, gbc_label);
		instance.add(scrollPane, gbc_scrollPane);
		instance.add(btnBack, gbc_button);
	}

	public void rerender() {
		instance.remove(scrollPane);
		createTable();
		createScrollPane();
		instance.add(scrollPane, gbc_scrollPane, 1);
	}

	public void createLabel() {
		lblRecords = new JLabel("RECORDS");
		lblRecords.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecords.setForeground(Color.WHITE);
		lblRecords.setFont(new Font("Roboto Condensed", Font.BOLD, 24));
		
		gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(50, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
	}
	public void createScrollPane() {
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(new Color(20, 20, 20));
		
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
	}

	public void getTableData() {
		// Todo: get table data from ClassRoom(?
		Object[][] classrooms = SchoolHelper.getClassrooms();
		for(int i = 0; i < classrooms.length; i++) {
			for(int j = 0; j < classrooms[i].length; j++) {
				System.out.println(i + " " + j);
				Map<Teacher, ArrayList<Student>> map = (Map<Teacher, ArrayList<Student>>)classrooms[i][j];
				map.forEach((key, value) -> {

				});
			}
		}
	};

	public void createTable() {
		getTableData();
		table = new JTable(data, columnNames){
			public boolean isCellEditable(int data,int columns) {
				return false;
			}
		};
		table.setFillsViewportHeight(true);
		table.setRowHeight(25);
		table.setShowVerticalLines(false);
		table.setBackground(new Color(0, 0, 0, 0));
		
		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0; i < columnNames.length; i++) {
			columnModel.getColumn(i).setCellRenderer(new CustomTableCellRenderer());
		}
		
		table.getTableHeader().setDefaultRenderer(new CustomHeaderCellRenderer());
		table.getTableHeader().setBackground(new Color(0,0,0,0));
		
		
		resizeColumnWidth(table);
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
		gbc_button.gridy = 2;

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
	
	private String[] columnNames = new String[] { "ID", "Name", "Gender", "Age", "Grade", "Date of Joining",
			"Annunal Renewal", "Hib", "DtaP", "Polio", "Hepatitis_B", "MMR", "Varicella" };
	private String[][] data = new String[][] {
			{ "1", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "2", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "3", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "4", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "5", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "6", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "7", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "8", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "9", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "10", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "11", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "12", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "13", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "14", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "15", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "16", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "17", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "18", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "19", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
			{ "20", "Akhil", "Male", "20", "2", "15/11/2020", "15/11/2022", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"}, };
	
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBack;
	private JLabel lblRecords;
	private GridBagConstraints gbc_label;
	private GridBagConstraints gbc_scrollPane;
	private GridBagConstraints gbc_button;
}
