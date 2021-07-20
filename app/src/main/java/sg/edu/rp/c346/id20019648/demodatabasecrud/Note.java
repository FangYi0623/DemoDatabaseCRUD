package sg.edu.rp.c346.id20019648.demodatabasecrud;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Note implements Serializable {

    private int id; // to prevent people from accessing the attributes
    private String noteContent;

    public Note (int id, String noteContent) {
        this.id = id;
        this.noteContent = noteContent;
    }

    public int getId() {
        return id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    @NonNull
    @Override
    public String toString() {
        return "ID: " + id + ", " + noteContent;
    }
}
