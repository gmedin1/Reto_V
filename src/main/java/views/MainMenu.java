package views;

import models.User;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainMenu extends JFrame {
    // Attributes
    private final JLabel        lblUserAlias        = new JLabel();
    private final JLabel        lblUserFullName     = new JLabel();
    private final JLabel        lblUserEmail        = new JLabel();
    private final JLabel        lblUserPhoneNumber  = new JLabel();
    private final JLabel        lblUserBirdDate     = new JLabel();
    private final MainPanel     pnlMainPanel        = new MainPanel();
    private final Border        border              = BorderFactory.createDashedBorder(new Color(0x3f2aa3));
    private final String        icnURL              = System.getProperty("user.dir") + "/src/main/java/static/user.png";
    private final ImageIcon     icnUserIcon         = new ImageIcon(new ImageIcon(icnURL).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    private final Dimension     SCREEN              = Toolkit.getDefaultToolkit().getScreenSize();

    // Constructor
    public MainMenu(User user) {
        initComponents(user);
    }

    // Methods
    private void initComponents(User user) {
        // Settings
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setTitle("Main Menu");
        this.setResizable(false);
        this.setLayout(null);
        this.setLocation((SCREEN.width - this.getWidth()) / 2, (SCREEN.height - this.getHeight()) / 2);
        // Labels
        // User
        getLblUserAlias().setText("WELCOME BACK, " + user.getUserAlias().toUpperCase());
        getLblUserAlias().setVerticalTextPosition(JLabel.BOTTOM);
        getLblUserAlias().setHorizontalTextPosition(JLabel.CENTER);
        getLblUserAlias().setVerticalAlignment(JLabel.TOP);
        getLblUserAlias().setHorizontalAlignment(JLabel.CENTER);
        getLblUserAlias().setBounds(new Rectangle(250, 150));
        getLblUserAlias().setLocation((this.getWidth() - getLblUserAlias().getWidth()) / 4, 50);
        getLblUserAlias().setVisible(true);
        getLblUserAlias().setBorder(new CompoundBorder(border, new EmptyBorder(10,10,10,10)));
        getLblUserAlias().setIcon(getIcnUserIcon());
        getLblUserFullName().setText("NAME: " + user.getUserName().toUpperCase() + " " + user.getUserLastName().toUpperCase());
        getLblUserFullName().setHorizontalAlignment(JLabel.CENTER);
        getLblUserFullName().setBounds(new Rectangle(250, 20));
        getLblUserFullName().setLocation((this.getWidth() - getLblUserAlias().getWidth()) / 4, 210);
        getLblUserFullName().setVisible(true);
        getLblUserEmail().setText("EMAIL: " + user.getUserEmail().toUpperCase());
        getLblUserEmail().setHorizontalAlignment(JLabel.CENTER);
        getLblUserEmail().setBounds(new Rectangle(250, 20));
        getLblUserEmail().setLocation((this.getWidth() - getLblUserAlias().getWidth()) / 4, 240);
        getLblUserEmail().setVisible(true);
        getLblUserPhoneNumber().setText("PHONE: +57 " + user.getUserPhoneNumber().toUpperCase());
        getLblUserPhoneNumber().setHorizontalAlignment(JLabel.CENTER);
        getLblUserPhoneNumber().setBounds(new Rectangle(250, 20));
        getLblUserPhoneNumber().setLocation((this.getWidth() - getLblUserAlias().getWidth()) / 4, 270);
        getLblUserPhoneNumber().setVisible(true);
        getLblUserBirdDate().setText("BIRD DATE: " + String.valueOf(user.getUserBirdDate()).toUpperCase());
        getLblUserBirdDate().setHorizontalAlignment(JLabel.CENTER);
        getLblUserBirdDate().setBounds(new Rectangle(250, 20));
        getLblUserBirdDate().setLocation((this.getWidth() - getLblUserAlias().getWidth()) / 4, 300);
        getLblUserBirdDate().setVisible(true);
        // Additions
        this.add(getLblUserAlias());
        this.add(getLblUserFullName());
        this.add(getLblUserEmail());
        this.add(getLblUserPhoneNumber());
        this.add(getLblUserBirdDate());
        this.add(getPnlMainPanel());
    }

    public JLabel getLblUserAlias() {
        return lblUserAlias;
    }

    public JLabel getLblUserFullName() {
        return lblUserFullName;
    }

    public JLabel getLblUserEmail() {
        return lblUserEmail;
    }

    public JLabel getLblUserPhoneNumber() {
        return lblUserPhoneNumber;
    }

    public JLabel getLblUserBirdDate() {
        return lblUserBirdDate;
    }

    public MainPanel getPnlMainPanel() {
        return pnlMainPanel;
    }

    public ImageIcon getIcnUserIcon() {
        return icnUserIcon;
    }
}
