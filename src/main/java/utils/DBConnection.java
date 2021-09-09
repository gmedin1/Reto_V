package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DBConnection {

    public static Connection getConnection() {

        JSONParser parser   = new JSONParser();
        Connection conn     = null;

        try {
            // Read the JSON File.
            String pathCredentials  = System.getProperty("user.dir") + "/src/main/java/utils/credentials.json";
            JSONObject jsonObject   = (JSONObject)parser.parse(new FileReader(pathCredentials));

            // Assign JSON Keys to Variables, Casting each returned value.
            String host         = (String)jsonObject.get("ip");
            String port         = (String)jsonObject.get("port");
            String user         = (String)jsonObject.get("user");
            String password     = (String)jsonObject.get("password");
            String URL          = "jdbc:mysql://" + host + ":" + port + "/library";

            // Connect to Database using the given credentials.
            conn = DriverManager.getConnection(URL, user, password);
        }

        // Errors and Exceptions Handling
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Connection Object
        return conn;
    }
}
