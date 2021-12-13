package edu.neu.csye6200.view;

import edu.neu.csye6200.data.VaccineDAO;
import edu.neu.csye6200.data.VaccineStatusDAO;
import edu.neu.csye6200.models.VaccineStatus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class TrackImmunizationPage extends GradientPanel {
    private static final TrackImmunizationPage instance = new TrackImmunizationPage();
    private static boolean isInitialized = false;

    private TrackImmunizationPage() {
        super();
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static TrackImmunizationPage getInstance() {
        return instance;
    }

    public void initialize(JFrame frame, GradientPanel gradientPanel) {
        isInitialized = true;
        this.frame=frame;
        this.gradientPanel=gradientPanel;
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
        lblRecords = new JLabel("IMMUNIZATION RECORDS");
        lblRecords.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecords.setForeground(Color.WHITE);
        lblRecords.setFont(new Font("Roboto Condensed", Font.BOLD, 24));

        gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.VERTICAL;
        gbc_label.insets = new Insets(50, 0, 5, 0);
        gbc_label.gridx = 1;
        gbc_label.gridy = 0;

//        private String[][] data = new String[][] {
//                { "15/11/2020", "16/11/2022", "16/11/2020", "17/11/2022","18/11/2020", "19/11/2022", },
//        };

        VaccineStatusDAO vaccineStatusDAO = new VaccineStatusDAO();
        List<VaccineStatus> list =  vaccineStatusDAO.get(LoginFrame.id);

      data = new String[list.size()];
      for(int i = 0; i<list.size();i++){
          if(list.get(i).getStudentId()==LoginFrame.id) {
              System.out.println(list.get(i).getDate());
              data[i] = list.get(i).getDate();
          }
      }

//        for(int i=0;i<list.size();i++){
//            VaccineStatus v = list.get(i);
//            if(v.getStudentId()==LoginFrame.id){
//                v = list.get(i);
//                data.add(v.getDate());
//            }
//
//            System.out.println(data);
//
//        }


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
        dataList[0]=data;
        System.out.println(Arrays.toString(dataList[0]));
    };

    public void createTable() {
        getTableData();
        table = new JTable(dataList, columnNames){
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


//    private String[][] data = new String[][]{
//            { "15/11/2020", "16/11/2022", "16/11/2020", "17/11/2022","18/11/2020", "19/11/2022", },
//    };



    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnBack;
    private JLabel lblRecords;
    private GridBagConstraints gbc_label;
    private GridBagConstraints gbc_scrollPane;
    private GridBagConstraints gbc_button;
    private String[] data;

    private JFrame frame;
    private GradientPanel gradientPanel;
    String[] columnNames = new String[] {"Hib", "DtaP", "Polio", "Hepatitis_B", "MMR", "Varicella" };
    String[][] dataList =new String[1][columnNames.length];
}
