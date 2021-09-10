package access;

import models.Editor;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class EditorDAO {

    public static ResultSet getAllEditors() throws SQLException {
        // SQL Query to validate if User exists in the DB.
        String query = "SELECT * FROM editors";
        // Connecting and Preparing the SQL Statement to be Executed.
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        // Result Set to Store the Query Results.
        return statement.executeQuery();
    }

    public static void addNewEditor(Editor editor) throws SQLException {
        // SQL Query to validate if User exists in the DB.
        String query = "INSERT INTO editors VALUES (?, ?, ?, ?)";
        // Connecting and Preparing the SQL Statement to be Executed.
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, editor.getEditorId());
        statement.setString(2, editor.getEditorName());
        statement.setString(3, editor.getEditorLastName());
        statement.setString(4, editor.getEditorNationality());
        // Execution
        statement.executeUpdate();
    }

    public static void deleteEditor(Editor editor) throws SQLException {
        // SQL Query to validate if User exists in the DB.
        String query = "DELETE FROM editors WHERE editor_id = ?";
        // Connecting and Preparing the SQL Statement to be Executed.
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, editor.getEditorId());
        // Execution
        statement.executeUpdate();
    }

    public static void updateEditor(Editor editor, ArrayList<String> options) throws SQLException {
        // SQL Query to validate if User exists in the DB.
        String query = "UPDATE editors SET ";
        int control = 0;
        for (int i = 0; i < options.size(); i++) {
            if (i == 0 && !options.get(i).equals("")) {
                if (control > 0) {
                    query = query + ",";
                }
                query = query + "editor_name = ?";
                control += 1;
            }
            if (i == 1 && !options.get(i).equals("")) {
                if (control > 0) {
                    query = query + ",";
                }
                query = query + "editor_last_name = ?";
                control += 3;
            }
            if (i == 2 && !options.get(i).equals("")) {
                if (control > 0) {
                    query = query + ", ";
                }
                query = query + "editor_nationality = ?";
                control += 5;
            }
        }
        query = query + " WHERE editor_id = ?";
        // Connecting and Preparing the SQL Statement to be Executed.
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        // Name
        if (control == 1) {
            statement.setString(1, options.get(0));
            statement.setInt(2, editor.getEditorId());
        }
        // Last Name
        if (control == 3) {
            statement.setString(1, options.get(1));
            statement.setInt(2, editor.getEditorId());
        }
        // Nationality
        if (control == 5) {
            statement.setString(1, options.get(2));
            statement.setInt(2, editor.getEditorId());
        }
        // Name, Last Name
        if (control == 4) {
            statement.setString(1, options.get(0));
            statement.setString(2, options.get(1));
            statement.setInt(3, editor.getEditorId());
        }
        // Name, Nationality
        if (control == 6) {
            statement.setString(1, options.get(0));
            statement.setString(2, options.get(2));
            statement.setInt(3, editor.getEditorId());
        }
        // Last Name, Nationality
        if (control == 8) {
            statement.setString(1, options.get(1));
            statement.setString(2, options.get(2));
            statement.setInt(3, editor.getEditorId());
        }
        // Name, Last Name, Nationality
        if (control == 9) {
            statement.setString(1, options.get(0));
            statement.setString(2, options.get(1));
            statement.setString(3, options.get(2));
            statement.setInt(4, editor.getEditorId());
        }
        // Execution
        statement.executeUpdate();
    }
}
