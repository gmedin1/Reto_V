package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import access.UserDAO;
import models.User;
import views.LoginForm;
import views.MainMenu;

public class LoginEvent implements ActionListener {
    // Attributes
    LoginForm login;

    // Constructor
    public LoginEvent(LoginForm login) {
        // Creates the Login Event with the Login Form Class in Order and Interact with some Login Form Methods.
        this.login = login;
    }

    // Methods
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == login.getBtnLogin()) {
            // Simple Form Validation: User and Password could not be Empty.
            if (login.getTxtUserAlias().equals("") || login.getTxtUserPassword().equals("")) {
                login.setLblError(true, "User or/and Password Empty");
                return;
            }
            // If not Empty, Store the Inputs in Variables.
            String userAlias        = login.getTxtUserAlias();
            String userPassword     = login.getTxtUserPassword();
            // Try - Catch Block to Validate the User, Calls the UserDAO to query the DB.
            try {
                // Query the DB and Stores the Results in Variables.
                User user           = new User(userAlias, userPassword);
                ResultSet results   = UserDAO.validateUser(user);
                // Read the Results.
                while (results.next()) {
                    // If User and Password Matches, then Opens the Main Menu.
                    if (userAlias.equals(results.getString("user_alias")) && userPassword.equals(results.getString("user_password"))) {
                        login.dispose();
                        // Creates a New User, a Fully Informed User.
                        String userName         = results.getString("user_name");
                        String userLastName     = results.getString("user_last_name");
                        String userEmail        = results.getString("user_email");
                        String userPhoneNumber  = results.getString("user_phone_number");
                        Date userBirdDate       = results.getDate("user_bird_date");
                        User fullUser           = new User(userAlias, userName, userLastName, userEmail, userPhoneNumber, userPassword, userBirdDate);
                        // Opens Up the Main Menu.
                        new MainMenu(fullUser);
                    }
                }
                // If User and Password doesn't Match, Shows an Error Message.
                if(!results.next()) {
                    login.setLblError(true, "User or/and Password Incorrect");
                }
            // Exception and Error Handling.
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}
