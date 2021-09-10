package views;

import javax.swing.*;
import controllers.EditorData;

public class MainPanel extends JPanel {
    // Attributes
    private final JLabel    lblEditor       = new JLabel();
    private final JButton   btnEditor       = new JButton();
    private final JLabel    lblUser         = new JLabel();
    private final JButton   btnUser         = new JButton();
    private final JLabel    lblContent      = new JLabel();
    private final JButton   btnContent      = new JButton();
    private final JLabel    lblPublication  = new JLabel();
    private final JButton   btnPublication  = new JButton();
    private final JButton   btnLogOut        = new JButton();

    // Constructor
    public MainPanel() {
        initComponents();
    }

    // Method
    private void initComponents() {
        // Settings
        this.setVisible(true);
        this.setSize(350, 500);
        this.setLocation(400, 50);
        this.setLayout(null);
        // Labels
        getLblEditor().setText("\t\tEDITORS (CRUD)");
        getLblEditor().setBounds(50, 0, 350, 20);
        getLblEditor().setHorizontalAlignment(JLabel.LEFT);
        getLblEditor().setVisible(true);
        getLblUser().setText("\t\tUSERS");
        getLblUser().setBounds(50, 70, 350, 20);
        getLblUser().setHorizontalAlignment(JLabel.LEFT);
        getLblUser().setEnabled(false);
        getLblUser().setVisible(true);
        getLblContent().setText("\t\tBOOKS AND SERIES");
        getLblContent().setBounds(50, 140, 350, 20);
        getLblContent().setHorizontalAlignment(JLabel.LEFT);
        getLblContent().setEnabled(false);
        getLblContent().setVisible(true);
        getLblPublication().setText("\t\tPUBLICATIONS");
        getLblPublication().setBounds(50, 210, 350, 20);
        getLblPublication().setHorizontalAlignment(JLabel.LEFT);
        getLblPublication().setVisible(true);
        getLblPublication().setEnabled(false);
        // Buttons
        getBtnEditor().setText("EDITORS");
        getBtnEditor().setBounds(50, 30, 100, 30);
        getBtnEditor().setVisible(true);
        getBtnEditor().addActionListener(new EditorData(this));
        getBtnUser().setText("USERS");
        getBtnUser().setBounds(50, 100, 100, 30);
        getBtnUser().setEnabled(false);
        getBtnUser().setVisible(true);
        getBtnContent().setText("CONTENTS");
        getBtnContent().setBounds(50, 170, 100, 30);
        getBtnContent().setEnabled(false);
        getBtnContent().setVisible(true);
        getBtnPublication().setText("LOG");
        getBtnPublication().setBounds(50, 240, 100, 30);
        getBtnPublication().setEnabled(false);
        getBtnPublication().setVisible(true);
        getBtnLogOut().setText("LOG OUT");
        getBtnLogOut().setBounds(50, 300, 100, 30);
        getBtnLogOut().setVisible(true);
        getBtnLogOut().addActionListener(event -> {
            getParentMainMenu().dispose();
            new LoginForm();
        });
        // Additions
        this.add(getLblEditor());
        this.add(getBtnEditor());
        this.add(getLblUser());
        this.add(getBtnUser());
        this.add(getLblContent());
        this.add(getBtnContent());
        this.add(getLblPublication());
        this.add(getBtnPublication());
        this.add(getBtnLogOut());
    }

    public JButton getBtnEditor() {
        return btnEditor;
    }

    public MainMenu getParentMainMenu() {
        return (MainMenu) this.getParent().getParent().getParent().getParent();
    }

    public JLabel getLblEditor() {
        return lblEditor;
    }

    public JLabel getLblUser() {
        return lblUser;
    }

    public JButton getBtnUser() {
        return btnUser;
    }

    public JLabel getLblContent() {
        return lblContent;
    }

    public JButton getBtnContent() {
        return btnContent;
    }

    public JLabel getLblPublication() {
        return lblPublication;
    }

    public JButton getBtnPublication() {
        return btnPublication;
    }

    public JButton getBtnLogOut() {
        return btnLogOut;
    }
}
