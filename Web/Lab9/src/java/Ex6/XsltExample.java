package Ex6;

import javax.xml.transform.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class XsltExample extends JFrame implements ChangeListener {

    private static final int XML = 0;
    private static final int XSL = 1;
    private static final int XSLT = 2;
    private static final String DEFAULT_TITLE = "XSLT Example";
    private static final String[] tabTitles = {"XML", "XSL", "XSLT"};
    private static final String[] extensions = {"xml", "xsl", "html"};
    private Action openAction, saveAction, exitAction;
    private JTabbedPane tabbedPane;
    private DocumentPane[] documents;
    private XslTransformer transformer;

    public XsltExample() {
        super(DEFAULT_TITLE);
        transformer = new XslTransformer();
        WindowUtilities.setNativeLookAndFeel();
        Container content = getContentPane();
        content.setBackground(SystemColor.control);

        JMenuBar menubar = new JMenuBar();
        openAction = new OpenAction();
        saveAction = new SaveAction();
        exitAction = new ExitAction();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(openAction);
        fileMenu.add(saveAction);
        fileMenu.add(exitAction);
        menubar.add(fileMenu);
        setJMenuBar(menubar);

        tabbedPane = new JTabbedPane();
        documents = new DocumentPane[3];
        for (int i = 0; i < 3; i++) {
            documents[i] = new DocumentPane();
            JPanel panel = new JPanel();
            JScrollPane scrollPane = new JScrollPane(documents[i]);
            panel.add(scrollPane);
            tabbedPane.add(tabTitles[i], scrollPane);
        }

        documents[XML].loadFile("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\Assignment4\\web\\Books.xml");
        documents[XML].setEditable(false);
        //documents[XML].setContentType(DocumentPane.XML);

        documents[XSL].loadFile("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\Assignment4\\web\\Books.xsl");
        documents[XSL].setEditable(false);
        documents[XSL].setContentType(DocumentPane.TEXT);

        documents[XSLT].loadFile("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\Assignment4\\web\\Books.html");
        documents[XSLT].setEditable(false);
        //documents[XSLT].setContentType(DocumentPane.XML);

        tabbedPane.addChangeListener(this);
        content.add(tabbedPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setVisible(true);
    }

    public void stateChanged(ChangeEvent event) {
        int index = tabbedPane.getSelectedIndex();
        switch (index) {
            case XSLT:
                if (documents[XML].isLoaded() && documents[XSL].isLoaded()) {
                    //doTransform();
                }
            case XML:
            case XSL:
                updateMenuAndTitle(index);
                break;
            default:
        }
    }

    private void doTransform() {
        StringWriter strWriter = new StringWriter();
        try {
            Reader xmlInput = new StringReader(documents[XML].getText());
            Reader xslInput = new StringReader(documents[XSL].getText());
            transformer = new XslTransformer();
            transformer.process(xmlInput, xslInput, strWriter);
        } catch (TransformerException te) {
            JOptionPane.showMessageDialog(this, "Error: " + te.getMessage());
        }
        documents[XSLT].setText(strWriter.toString());
        System.out.println("test");
    }

    private void updateMenuAndTitle(int index) {
        if ((index > -1) && (index < documents.length)) {
            saveAction.setEnabled(documents[index].isLoaded());
            openAction.setEnabled(documents[index].isEditable());
            String title = DEFAULT_TITLE;
            String filename = documents[index].getFilename();
            if (filename.length() > 0) {
                title += " - [" + filename + "]";
            }
            setTitle(title);
        }
    }

    private void updateDocument(int mode) {
        int index = tabbedPane.getSelectedIndex();
        String description = tabTitles[index] + " Files";
        String filename = ExtensionFileFilter.getFileName(".", description, extensions[index], mode);
        if (filename != null) {
            if (mode == ExtensionFileFilter.SAVE) {
                documents[index].saveFile(filename);
            } else {
                documents[index].loadFile(filename);
            }
            updateMenuAndTitle(index);
        }
    }

    public static void main(String[] args) {
        new XsltExample();
    }

    class OpenAction extends AbstractAction {

        public OpenAction() {
            super("Open ...");
        }

        public void actionPerformed(ActionEvent event) {
            updateDocument(ExtensionFileFilter.LOAD);
        }
    }

    class SaveAction extends AbstractAction {

        public SaveAction() {
            super("Save");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent event) {
            updateDocument(ExtensionFileFilter.SAVE);
        }
    }

    class ExitAction extends AbstractAction {

        public ExitAction() {
            super("Exit");
        }

        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }
}
