package edu.neu.csye6200;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class ViewingPage extends GradientPanel {
	private static final ViewingPage instance = new ViewingPage();

	private ViewingPage() {
		super();
	}

	public static ViewingPage getInstance() {
		return instance;
	}

	public void initialize() {
		createTable();
		createScrollPane();
		instance.add(scrollPane);
		createButton();
		instance.add(btnBack);
	}
	
	public void rerender() {
		instance.remove(scrollPane);
		createTable();
		createScrollPane();
		instance.add(scrollPane, 0);
	}

	public void createScrollPane() {
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(1200, 600));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
	}

	public void getTableData() {
		// Todo: get table data from ClassRoom(?
	};

	public void createTable() {
		getTableData();
		table = new JTable(data, columnNames);
		table.setRowHeight(30);
		table.setOpaque(false);
		table.setGridColor(Color.BLACK);
		table.setShowVerticalLines(false);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new CustomHeaderCellRenderer());
		header.setPreferredSize(new Dimension(1040, 35));
		header.setBackground(new Color(0,0,0,0));
		header.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(25);
		columnModel.getColumn(2).setPreferredWidth(30);
		columnModel.getColumn(4).setPreferredWidth(50);
		columnModel.getColumn(7).setPreferredWidth(50);
		for (int i = 0; i < columnNames.length; i++) {
			columnModel.getColumn(i).setCellRenderer(new CustomTableCellRenderer());
		}
	}
	
	public void createButton() {
		btnBack = new JButton("BACK");
		btnBack.setPreferredSize(new Dimension(160, 40));
		btnBack.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		btnBack.setForeground(Color.white);
		btnBack.setBorder(new LineBorder(Color.white));
		btnBack.setBorder(new RoundBtn(20));  
		
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

	private JScrollPane scrollPane;
	private String[] columnNames = new String[] { "Name", "Age", "Gender", "Date of Birth", "Parent's Name",
			"Parent's Phone", "Address", "Teacher", "Date of Joining", "Immunization Records" };
	private String[][] data = new String[][] {
			{ "Jenny", "25", "Female", "2020/09/12", "Parent", "222222222", "55 Temple St", "Teacher", "333333",
					"werweroijrijrijrijrijrijrijr" },
			{ "Jenny", "25", "Female", "2020/09/12", "Parent", "222222222", "55 Temple St", "Teacher", "333333",
					"werweroijrijrijrijrijrijrijr" } };
	private JTable table;
	private JButton btnBack;
}
