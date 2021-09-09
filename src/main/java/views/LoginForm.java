package views;

import javax.swing.*;
import java.awt.*;
import controllers.LoginEvent;

public class LoginForm extends JFrame {
    // Attributes
    JLabel lblUserAlias = new JLabel();
    JTextField txtUserAlias = new JTextField();
    JLabel lblUserPassword = new JLabel();
    JPasswordField txtUserPassword = new JPasswordField();
    JButton btnLogin = new JButton();
    JButton btnClose = new JButton();
    JLabel lblError = new JLabel();
    LoginEvent loginEvent = new LoginEvent(this);
    // Constants
    final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();

    public LoginForm() {
        initComponents();
    }

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
        lblUserAlias.setText("USER: ");
        lblUserAlias.setBounds(50, 50, 150, 20);
        lblUserAlias.setVisible(true);

        txtUserAlias.setBounds(160, 50, 150, 20);
        txtUserAlias.setVisible(true);

        // User Password
        lblUserPassword.setText("PASSWORD: ");
        lblUserPassword.setBounds(50, 80, 150, 20);
        lblUserPassword.setVisible(true);

        txtUserPassword.setBounds(160, 80, 150, 20);
        txtUserPassword.setVisible(true);

        // Error Label
        lblError.setText("Alias and/or Password Incorrect!");
        lblError.setForeground(new Color(0xBB0000));
        lblError.setBounds(160, 130, 200, 20);
        lblError.setVisible(false);

        // Buttons
        // Login Button
        btnLogin.setText("LOGIN");
        btnLogin.setBounds(160, 110, 75, 20);
        btnLogin.setVisible(true);
        btnLogin.addActionListener(loginEvent);

        // Close Button
        btnClose.setText("CLOSE");
        btnClose.setBounds(235, 110, 75, 20);
        btnClose.setVisible(true);
        btnClose.addActionListener(event -> this.dispose());

        // Additions
        this.add(lblUserAlias);
        this.add(txtUserAlias);
        this.add(lblUserPassword);
        this.add(txtUserPassword);
        this.add(btnLogin);
        this.add(btnClose);
        this.add(lblError);
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

    public void setLblError(boolean bool) {
        lblError.setVisible(bool);
    }
}
