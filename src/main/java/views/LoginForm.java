package views;

import javax.swing.*;
import java.awt.*;
import controllers.LoginEvent;

public class LoginForm extends JFrame {
    // Attributes
    private final JLabel            lblUserAlias        = new JLabel();
    private final JTextField        txtUserAlias        = new JTextField();
    private final JLabel            lblUserPassword     = new JLabel();
    private final JPasswordField    txtUserPassword     = new JPasswordField();
    private final JButton           btnLogin            = new JButton();
    private final JButton           btnClose            = new JButton();
    private final JLabel            lblError            = new JLabel();
    private final LoginEvent        loginEvent          = new LoginEvent(this);
    private final Dimension         SCREEN              = Toolkit.getDefaultToolkit().getScreenSize();

    // Constructor
    public LoginForm() {
        initComponents();
    }

    // Methods
    private void initComponents() {
        // Settings
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(380, 220);
        this.setTitle("Login");
        this.setResizable(false);
        this.setLayout(null);
        this.setLocation((SCREEN.width - this.getWidth()) / 2, (SCREEN.height - this.getHeight()) / 2);

        // Labels and Text
        // User Alias
        getLblUserAlias().setText("USER: ");
        getLblUserAlias().setBounds(50, 50, 150, 20);
        getLblUserAlias().setVisible(true);
        txtUserAlias.setBounds(160, 50, 150, 20);
        txtUserAlias.setVisible(true);

        // User Password
        getLblUserPassword().setText("PASSWORD: ");
        getLblUserPassword().setBounds(50, 80, 150, 20);
        getLblUserPassword().setVisible(true);
        txtUserPassword.setBounds(160, 80, 150, 20);
        txtUserPassword.setVisible(true);

        // Error Label
        getLblError().setForeground(new Color(0xBB0000));
        getLblError().setBounds(160, 130, 200, 20);
        getLblError().setVisible(false);

        // Buttons
        // Login Button
        getBtnLogin().setText("LOGIN");
        getBtnLogin().setBounds(160, 110, 75, 20);
        getBtnLogin().setVisible(true);
        getBtnLogin().addActionListener(getLoginEvent());

        // Close Button
        getBtnClose().setText("CLOSE");
        getBtnClose().setBounds(235, 110, 75, 20);
        getBtnClose().setVisible(true);
        getBtnClose().addActionListener(event -> this.dispose());

        // Additions
        this.add(getLblUserAlias());
        this.add(txtUserAlias);
        this.add(getLblUserPassword());
        this.add(txtUserPassword);
        this.add(getBtnLogin());
        this.add(getBtnClose());
        this.add(getLblError());
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public String getTxtUserAlias() {
        return txtUserAlias.getText();
    }

    public String getTxtUserPassword() {
        return new String(txtUserPassword.getPassword());
    }

    public void setLblError(boolean bool, String text) {
        getLblError().setVisible(bool);
        getLblError().setText(text);
    }

    public JLabel getLblUserAlias() {
        return lblUserAlias;
    }

    public JLabel getLblUserPassword() {
        return lblUserPassword;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public JLabel getLblError() {
        return lblError;
    }

    public LoginEvent getLoginEvent() {
        return loginEvent;
    }
}
