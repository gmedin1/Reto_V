package controllers;

import access.EditorDAO;
import models.Editor;
import views.EditorForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateEditor implements ActionListener {
    // Attributes
    EditorForm frame;
    ArrayList<String> options = null;

    // Constructors
    public UpdateEditor(EditorForm frame) {
        this.frame = frame;
    }

    // Methods
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == frame.getBtnUpdateEditor()) {
            int     editorId    = Integer.parseInt(frame.getTxtEditorId().getText());
            Editor  editor      = new Editor(editorId);
            options = new ArrayList<>();
            options.add(frame.getTxtEditorName().getText());
            options.add(frame.getTxtEditorLastName().getText());
            options.add(frame.getTxtEditorNationality().getText());
            try {
                EditorDAO.updateEditor(editor, options);
                frame.updateTableResults(editor, options);
                frame.getTxtEditorId().setText("");
                frame.getTxtEditorName().setText("");
                frame.getTxtEditorLastName().setText("");
                frame.getTxtEditorNationality().setText("");
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

    }
}
