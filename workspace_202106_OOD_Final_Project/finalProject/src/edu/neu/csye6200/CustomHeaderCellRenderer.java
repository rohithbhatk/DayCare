package edu.neu.csye6200;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class CustomHeaderCellRenderer extends JLabel implements TableCellRenderer {
	public CustomHeaderCellRenderer() {
		setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		setBackground(new Color(20, 20, 20));
		setForeground(Color.WHITE);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText(value.toString());
		return this;
	}

}
