package views;

import controllers.DeleteEditor;
import controllers.UpdateEditor;
import models.Editor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import controllers.AddNewEditor;

public class EditorForm extends JFrame {
    // Attributes
    private final JLabel            lblEditorId             = new JLabel();
    private final JLabel            lblEditorName           = new JLabel();
    private final JLabel            lblEditorLastName       = new JLabel();
    private final JLabel            lblEditorNationality    = new JLabel();
    private final JTextField        txtEditorId             = new JTextField();
    private final JTextField        txtEditorName           = new JTextField();
    private final JTextField        txtEditorLastName       = new JTextField();
    private final JTextField        txtEditorNationality    = new JTextField();
    private final JButton           btnAddEditor            = new JButton();
    private final JButton           btnUpdateEditor         = new JButton();
    private final JButton           btnDeleteEditor         = new JButton();
    private final JButton           btnClose                = new JButton();
    private final JTable            tblEditor               = new JTable();
    private final DefaultTableModel defaultTableModel       = new DefaultTableModel();
    private final JScrollPane       jspScrollPane           = new JScrollPane(getTblEditor());
    private final Dimension         SCREEN                  = Toolkit.getDefaultToolkit().getScreenSize();
    private final String []         headers                 = { "ID", "NAME", "LASTNAME", "NATIONALITY" };

    public EditorForm(ArrayList<Editor> editors) {
        initComponents(editors);
    }

    private void initComponents(ArrayList<Editor> editors) {
        // Settings
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setTitle("Editor Menu");
        this.setResizable(false);
        this.setLayout(null);
        this.setLocation((SCREEN.width - this.getWidth()) / 2, (SCREEN.height - this.getHeight()) / 2);
        // Labels
        getLblEditorId().setText("ID: ");
        getLblEditorId().setBounds(50, 50, 100, 20);
        getLblEditorId().setVisible(true);
        getLblEditorName().setText("NAME: ");
        getLblEditorName().setBounds(160, 50, 100, 20);
        getLblEditorName().setVisible(true);
        getLblEditorLastName().setText("LAST NAME: ");
        getLblEditorLastName().setBounds(270, 50, 100, 20);
        getLblEditorLastName().setVisible(true);
        getLblEditorNationality().setText("NATIONALITY: ");
        getLblEditorNationality().setBounds(380, 50, 100, 20);
        getLblEditorNationality().setVisible(true);
        getLblEditorNationality().setVisible(true);
        // Text Fields
        getTxtEditorId().setBounds(50, 80, 100, 20);
        getTxtEditorId().setVisible(true);
        getTxtEditorName().setBounds(160, 80, 100, 20);
        getTxtEditorName().setVisible(true);
        getTxtEditorLastName().setBounds(270, 80, 100, 20);
        getTxtEditorLastName().setVisible(true);
        getTxtEditorNationality().setBounds(380, 80, 100, 20);
        getTxtEditorNationality().setVisible(true);
        // Buttons
        getBtnAddEditor().setVisible(true);
        getBtnAddEditor().setText("ADD NEW");
        getBtnAddEditor().setBounds(50, 110, 100, 30);
        getBtnAddEditor().addActionListener(new AddNewEditor(this));
        getBtnUpdateEditor().addActionListener(new UpdateEditor(this));
        getBtnUpdateEditor().setVisible(true);
        getBtnUpdateEditor().setText("UPDATE");
        getBtnUpdateEditor().setBounds(160, 110, 100, 30);
        getBtnDeleteEditor().addActionListener(new DeleteEditor(this));
        getBtnDeleteEditor().setVisible(true);
        getBtnDeleteEditor().setText("DELETE");
        getBtnDeleteEditor().setBounds(270, 110, 100, 30);
        getBtnClose().setVisible(true);
        getBtnClose().setText("< BACK");
        getBtnClose().setBounds(this.getWidth() - 150, 80, 80, 20);
        getBtnClose().addActionListener(event -> {
            this.dispose();
        });
        // Set Table.
        getTblEditor().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        getTblEditor().setLocation(0, 0);
        getTblEditor().setPreferredSize(new Dimension(800, 200));
        getTblEditor().setVisible(true);
        getTblEditor().removeAll();
        getDefaultTableModel().setColumnIdentifiers(headers);
        for (Editor editor : editors) {
            getDefaultTableModel().addRow(editor.getAsRow());
        }
        getTblEditor().setModel(getDefaultTableModel());
        // Set Pane.
        getJspScrollPane().setBounds(0, 200,800,200);
        getJspScrollPane().setVisible(true);
        getJspScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // Additions.
        this.add(getJspScrollPane());
        this.add(getLblEditorId());
        this.add(getLblEditorName());
        this.add(getLblEditorLastName());
        this.add(getLblEditorNationality());
        this.add(getTxtEditorId());
        this.add(getTxtEditorName());
        this.add(getTxtEditorLastName());
        this.add(getTxtEditorNationality());
        this.add(getBtnAddEditor());
        this.add(getBtnUpdateEditor());
        this.add(getBtnDeleteEditor());
        this.add(getBtnClose());
    }

    public JLabel getLblEditorId() {
        return lblEditorId;
    }

    public JLabel getLblEditorName() {
        return lblEditorName;
    }

    public JLabel getLblEditorLastName() {
        return lblEditorLastName;
    }

    public JLabel getLblEditorNationality() {
        return lblEditorNationality;
    }

    public JTextField getTxtEditorId() {
        return txtEditorId;
    }

    public JTextField getTxtEditorName() {
        return txtEditorName;
    }

    public JTextField getTxtEditorLastName() {
        return txtEditorLastName;
    }

    public JTextField getTxtEditorNationality() {
        return txtEditorNationality;
    }

    public JButton getBtnAddEditor() {
        return btnAddEditor;
    }

    public JButton getBtnUpdateEditor() {
        return btnUpdateEditor;
    }

    public JButton getBtnDeleteEditor() {
        return btnDeleteEditor;
    }

    public JTable getTblEditor() {
        return tblEditor;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public JScrollPane getJspScrollPane() {
        return jspScrollPane;
    }

    public void addTableResults(Editor editor) {
            getDefaultTableModel().addRow(editor.getAsRow());
        }

    public void deleteTableResults(int editorId) {
        for (int i = 0; i < getDefaultTableModel().getRowCount(); i++) {
            for (int j = 0; j < getDefaultTableModel().getColumnCount(); j++) {
               if (getDefaultTableModel().getValueAt(i, j).toString().equals(String.valueOf(editorId))) {
                    getDefaultTableModel().removeRow(i);
                    break;
                }
            }
        }
    }

    public void updateTableResults(Editor editor, ArrayList<String> options) {
        int rowId = 0;
        for (int i = 0; i < getDefaultTableModel().getRowCount(); i++) {
            for (int j = 0; j < getDefaultTableModel().getColumnCount(); j++) {
                if (getDefaultTableModel().getValueAt(i, j).toString().equals(String.valueOf(editor.getEditorId()))) {
                    rowId = i;
                    break;
                }
            }
        }

        int control = 0;
        for (int i = 0; i < options.size(); i++) {
            if (i == 0 && !options.get(i).equals("")) {
                control += 1;
            }
            if (i == 1 && !options.get(i).equals("")) {
                control += 3;
            }
            if (i == 2 && !options.get(i).equals("")) {
                control += 5;
            }
        }

        if (control == 1) {
            getDefaultTableModel().setValueAt(options.get(0), rowId, 1);
        }
        // Last Name
        if (control == 3) {
            getDefaultTableModel().setValueAt(options.get(1), rowId, 2);
        }
        // Nationality
        if (control == 5) {
            getDefaultTableModel().setValueAt(options.get(2), rowId, 3);
        }
        // Name, Last Name
        if (control == 4) {
            getDefaultTableModel().setValueAt(options.get(0), rowId, 1);
            getDefaultTableModel().setValueAt(options.get(1), rowId, 2);
        }
        // Name, Nationality
        if (control == 6) {
            getDefaultTableModel().setValueAt(options.get(0), rowId, 1);
            getDefaultTableModel().setValueAt(options.get(2), rowId, 3);
        }
        // Last Name, Nationality
        if (control == 8) {
            getDefaultTableModel().setValueAt(options.get(1), rowId, 2);
            getDefaultTableModel().setValueAt(options.get(2), rowId, 3);
        }
        // Name, Last Name, Nationality
        if (control == 9) {
            getDefaultTableModel().setValueAt(options.get(0), rowId, 1);
            getDefaultTableModel().setValueAt(options.get(1), rowId, 2);
            getDefaultTableModel().setValueAt(options.get(2), rowId, 3);
        }
    }

    public JButton getBtnClose() {
        return btnClose;
    }
}
