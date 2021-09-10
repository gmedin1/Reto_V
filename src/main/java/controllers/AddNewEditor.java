package controllers;

import access.EditorDAO;
import models.Editor;
import views.EditorForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddNewEditor implements ActionListener {
    // Attributes
    EditorForm frame;

    // Constructors
    public AddNewEditor(EditorForm frame) {
        this.frame = frame;
    }

    // Methods
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == frame.getBtnAddEditor()) {
            int     editorId             = Integer.parseInt(frame.getTxtEditorId().getText());
            String  editorName           = frame.getTxtEditorName().getText();
            String  editorLastName       = frame.getTxtEditorLastName().getText();
            String  editorNationality    = frame.getTxtEditorNationality().getText();
            Editor  editor               = new Editor(editorId, editorName, editorLastName, editorNationality);
            try {
                EditorDAO.addNewEditor(editor);
                frame.addTableResults(editor);
                frame.getTxtEditorId().setText("");
                frame.getTxtEditorName().setText("");
                frame.getTxtEditorLastName().setText("");
                frame.getTxtEditorNationality().setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
