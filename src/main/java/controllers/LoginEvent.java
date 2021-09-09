package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import access.UserDAO;
import models.User;
import views.LoginForm;
import views.MainMenu;

public class LoginEvent implements ActionListener {
    // Attributes
    LoginForm login;

    public LoginEvent(LoginForm login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == login.getBtnLogin()) {
            // Simple form validation. The user should input an Alias and Password!.
            if (login.getTxtUserAlias().equals("") || login.getTxtUserPassword().equals("")) {
                login.setLblError(true);
                return;
            }
            // Given an input, capture this values into variables.
            String userAlias = login.getTxtUserAlias();
            String userPassword = login.getTxtUserPassword();
            // Try to validate the Alias and Password in the Database.
            try {
                // Executes the DAO Method for User validation and stores its results set into a variable.
                User user = new User(userAlias, userPassword);
                ResultSet results = UserDAO.validateUser(user);
                // Read the results.
                while(results.next()) {

                    if (userAlias.equals(results.getString("user_alias")) && userPassword.equals(results.getString("user_password"))) {
                        login.setVisible(false);
                        new MainMenu(user);
                    }
                }
            // Exception and Error Handling.
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
