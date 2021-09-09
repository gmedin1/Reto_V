package views;

import models.User;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    // Attributes
    JLabel lblUserAlias = new JLabel();

    // Constants
    final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();

    public MainMenu(User user) {
        // Settings
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(980, 700);
        this.setTitle("Main Menu");
        this.setResizable(false);
        this.setLayout(null);
        this.setLocation((SCREEN.width - this.getWidth()) / 2, (SCREEN.height - this.getHeight()) / 2);

        // Labels
        // User
        lblUserAlias.setText(user.getUserAlias());
        lblUserAlias.setHorizontalAlignment(JLabel.CENTER);
        lblUserAlias.setVisible(true);

        // Additions
        this.add(lblUserAlias);
    }

}
