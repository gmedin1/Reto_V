package controllers;

import access.EditorDAO;
import models.Editor;
import models.User;
import views.EditorForm;
import views.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditorData implements ActionListener {
    // Attributes
    MainPanel panel;
    ArrayList<Editor> editors = new ArrayList<>();

    // Constructors
    public EditorData(MainPanel panel) {
        this.panel = panel;
    }

    // Methods
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == panel.getBtnEditor()) {
            try {
                // Get Results.
                ResultSet results = EditorDAO.getAllEditors();
                // Read the Results.
                while(results.next()) {
                    int editorId                = results.getInt("editor_id");
                    String editorName           = results.getString("editor_name");
                    String editorLastName       = results.getString("editor_last_name");
                    String editorNationality    = results.getString("editor_nationality");
                    Editor editor               = new Editor(editorId, editorName, editorLastName, editorNationality);
                    editors.add(editor);
                }
                // Create a new Editor Menu.
                new EditorForm(editors);
                // Exception and Error Handler.
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}
