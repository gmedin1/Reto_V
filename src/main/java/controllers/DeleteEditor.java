package controllers;

import access.EditorDAO;
import models.Editor;
import views.EditorForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteEditor implements ActionListener {
    // Attributes
    EditorForm frame;
    ArrayList<Editor> editors = new ArrayList<>();

    // Constructors
    public DeleteEditor(EditorForm frame) {
        this.frame = frame;
    }

    // Methods
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == frame.getBtnDeleteEditor()) {
            int     editorId    = Integer.parseInt(frame.getTxtEditorId().getText());
            Editor  editor      = new Editor(editorId);
            try {
                EditorDAO.deleteEditor(editor);
                frame.deleteTableResults(editorId);
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
