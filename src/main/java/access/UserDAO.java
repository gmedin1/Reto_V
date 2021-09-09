package access;

import utils.DBConnection;
import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

public class UserDAO {

    public static ResultSet validateUser(User user) throws SQLException {
        // SQL Query to validate whether or not the User exists in the database.
        String query =  "SELECT user_alias, user_password FROM users WHERE user_alias = ? AND user_password = ?";
        // Connecting and Preparing the created SQL Statement to be executed.
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        // Get the values to be passed as arguments in the SQL Statement.
        statement.setString(1, user.getUserAlias());
        statement.setString(2, user.getUserPassword());
        // Result Set to store the query results.
        ResultSet results = statement.executeQuery();
        // Return the results.
        return results;
    }

    public static void insertUser(User user) throws SQLException {
        // SQL Query to create a new User in the database.
        String query =  "INSERT INTO users(" +
                        "user_alias,"       +
                        "user_name,"        +
                        "user_last_name,"   +
                        "user_email,"       +
                        "user_phone_number" +
                        "user_password,"    +
                        "user_bird_date) "  +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
        // Connecting and Preparing the created SQL Statement to be executed.
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        // Get the values to be passed as arguments in the SQL Statement.
        statement.setString(1, user.getUserAlias());
        statement.setString(2, user.getUserName());
        statement.setString(3, user.getUserLastName());
        statement.setString(4, user.getUserEmail());
        statement.setString(5, user.getUserPhoneNumber());
        statement.setString(6, user.getUserPassword());
        statement.setDate(7, Date.valueOf(user.getUserBirdDate()));
        // Execution.
        statement.executeUpdate();
    }

}
