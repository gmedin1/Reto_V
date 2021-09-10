package models;

public class Editor {
    // Attributes
    private int editorId;
    private String editorName;
    private String editorLastName;
    private String editorNationality;

    // Constructors
    public Editor(int editorId) {
        this.editorId = editorId;
    }

    public Editor(int editorId, String editorName, String editorLastName, String editorNationality) {
        this.setEditorId(editorId);
        this.setEditorName(editorName);
        this.setEditorLastName(editorLastName);
        this.setEditorNationality(editorNationality);
    }

    public String[] getAsRow() {
        return new String[] { String.valueOf(getEditorId()), getEditorName(), getEditorLastName(), getEditorNationality() };
    }

    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getEditorLastName() {
        return editorLastName;
    }

    public void setEditorLastName(String editorLastName) {
        this.editorLastName = editorLastName;
    }

    public String getEditorNationality() {
        return editorNationality;
    }

    public void setEditorNationality(String editorNationality) {
        this.editorNationality = editorNationality;
    }

    @Override
    public String toString() {
        return "Id: " + getEditorId() + "\nName: " + getEditorName() + "\nLastName: " + getEditorLastName() + "\nNationality: " + getEditorNationality();
    }
}
