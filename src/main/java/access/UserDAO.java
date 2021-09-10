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
        // SQL Query to validate if User exists in the DB.
        String query = "SELECT * FROM users WHERE user_alias = ? AND user_password = ?";
        // Connecting and Preparing the SQL Statement to be Executed.
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        // Prepare the Values to be Passed as Arguments in the SQL Statement.
        statement.setString(1, user.getUserAlias());
        statement.setString(2, user.getUserPassword());
        // Result Set to Store the Query Results.
        return statement.executeQuery();
    }
}
