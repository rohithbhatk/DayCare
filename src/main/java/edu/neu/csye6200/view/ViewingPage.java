package edu.neu.csye6200.view;

import edu.neu.csye6200.controller.SchoolHelper;
import edu.neu.csye6200.controller.Vaccination;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        gbc_label.fill = GridBagConstraints.HORIZONTAL;
        gbc_label.insets = new Insets(50, 0, 20, 0);
        gbc_label.gridx = 1;
        gbc_label.gridy = 0;
    }

    public void createScrollPane() {
        scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(new Color(20, 20, 20));

        gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 1;
    }

    public void getTableData() {
        SchoolHelper.setClassrooms();
        Object[][] classrooms = SchoolHelper.getClassrooms();
        List<String[]> list = new ArrayList<>();
        if (classrooms != null)
            for (int i = 0; i < classrooms.length; i++) {
                for (int j = 0; j < classrooms[i].length; j++) {
                    Map<Teacher, ArrayList<Student>> map = (Map<Teacher, ArrayList<Student>>) classrooms[i][j];
                    if (map != null)
                        map.forEach((key, value) -> {
                            Teacher t = key;

                            for (Student s : value) {
                                String[] row = new String[14];
                                row[0] = Integer.toString(s.getId());
                                row[1] = s.getFirst_Name() + " " + s.getLast_name();
                                row[2] = s.getGender() == null ? "" : s.getGender();
                                row[3] = Integer.toString(s.getAge());
                                row[4] = s.getDate_of_joining() == null ? "" : s.getDate_of_joining();
                                row[5] = t.getFirst_Name() + " " + t.getLast_name();
                                row[6] = s.getParents_First_Name() + " " + s.getParents_Last_Name();

                                Vaccination v = s.getImmunization_Records();
                                row[7] = v == null || v.getHib() == null ? ""
                                        : String.join(",", (String[]) v.getHib().stream().map(d -> formatter.format(d)).toArray(String[]::new));
                                row[8] = v == null || v.getdTaP() == null ? ""
                                        : String.join(",", (String[]) v.getdTaP().stream().map(d -> formatter.format(d)).toArray(String[]::new));
                                row[9] = v == null || v.getPolio() == null ? ""
                                        : String.join(",", (String[]) v.getPolio().stream().map(d -> formatter.format(d)).toArray(String[]::new));
                                row[10] = v == null || v.getHepatitis_B() == null ? ""
                                        : String.join(",", (String[]) v.getHepatitis_B().stream().map(d -> formatter.format(d)).toArray(String[]::new));
                                row[11] = v == null || v.getmMR() == null ? ""
                                        : String.join(",", (String[]) v.getmMR().stream().map(d -> formatter.format(d)).toArray(String[]::new));
                                row[12] = v == null || v.getVaricella() == null ? ""
                                        : String.join(",", (String[]) v.getVaricella().stream().map(d -> formatter.format(d)).toArray(String[]::new));
                                list.add(row);
                            }
                        });
                }
            }

        data = new String[list.size()][14];
        int i = 0;
        for (int j = 0; j < list.size(); j++, i++) {
            data[i] = list.get(j);
        }
    }

    public void createTable() {
        getTableData();
        table = new JTable(data, columnNames) {
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        table.setShowVerticalLines(false);
        table.setBackground(new Color(0, 0, 0, 0));

        TableColumnModel columnModel = table.getColumnModel();

        for (int i = 0; i < columnNames.length; i++) {
            if(i >= 8) columnModel.getColumn(i).setPreferredWidth(20);
            columnModel.getColumn(i).setCellRenderer(new CustomTableCellRenderer());
        }

        table.getTableHeader().setDefaultRenderer(new CustomHeaderCellRenderer());
        table.getTableHeader().setBackground(new Color(0, 0, 0, 0));


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
        gbc_button.insets = new Insets(20, 0, 20, 0);
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
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300)
                width = 300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private final String[] columnNames = new String[]{"ID", "Name", "Gender", "Age", "Date of Joining", "Teacher", "Parent", "Hib", "DtaP", "Polio", "Hepatitis_B", "MMR", "Varicella"};
    private String[][] data;
    // Todo: add default student data for demo
    private final String[][] defaultData = new String[][]{
            {"1", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"2", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"3", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"4", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"5", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"6", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"7", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"8", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"9", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"10", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"11", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"12", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"13", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"14", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"15", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"16", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"17", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"18", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"19", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},
            {"20", "Akhil", "Male", "20", "15/11/2020", "Teacher", "Parent", "hib=0", "dTap=0", "polio=1", "hepatitis_B=0", "mMR=0", "varicella=0"},};

    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnBack;
    private JLabel lblRecords;
    private GridBagConstraints gbc_label;
    private GridBagConstraints gbc_scrollPane;
    private GridBagConstraints gbc_button;
    private final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
}
