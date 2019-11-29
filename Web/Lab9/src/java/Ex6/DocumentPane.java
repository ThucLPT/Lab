package Ex6;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class DocumentPane extends JEditorPane {

    public static final String TEXT = "text/plain";
    public static final String HTML = "text/html";

    private boolean loaded = false;
    private String filename = "";

    public void setPage(URL url) {
        loaded = false;
        try {
            super.setPage(url);
            File file = new File(getPage().toString());
            setFilename(file.getName());
            loaded = true;
        } catch (IOException ioe) {
            System.err.println("Unable to set page: " + url);
        }
    }

    public void setText(String text) {
        super.setText(text);
        setFilename("");
        loaded = true;
    }

    public void loadFile(String filename) {
        try {
            File file = new File(filename);
            setPage(file.toURL());
        } catch (IOException mue) {
            System.err.println("Unable to load file: " + filename);
        }
    }

    public void saveFile(String filename) {
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            writer.write(getText());
            writer.close();
            setFilename(file.getName());
        } catch (IOException ioe) {
            System.err.println("Unable to save file: " + filename);
        }
    }

    public String getFilename() {
        return (filename);
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean isLoaded() {
        return (loaded);
    }
}
