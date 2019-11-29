
import java.io.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class Ex5 extends HandlerBase {

    static private Writer out;

    public static void main(String[] arg) {
        SAXParserFactory sbf = SAXParserFactory.newInstance();
        try {
            out = new OutputStreamWriter(System.out, "UTF8");
            SAXParser sp = sbf.newSAXParser();
            sp.parse(new File("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\WebLab9\\Books.xml"), new Ex5());

        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.exit(0);
    }

    private void showData(String s) throws SAXException {
        try {
            out.write(s);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Ex5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void newLine() throws SAXException {
        String lineEnd = System.getProperty("line.separator");
        try {
            out.write(lineEnd);
        } catch (IOException ex) {
            Logger.getLogger(Ex5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startDocument() throws SAXException {
        showData("<?xml version='1.0' encoding='UTF-8'?>");
        newLine();
    }

    public void endDocument() throws SAXException {
        try {
            newLine();
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Ex5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startElement(String name, AttributeList al) throws SAXException {
        showData("<" + name);
        if (al != null) {
            for (int i = 0; i < al.getLength(); i++) {
                showData(" ");
                showData(al.getName(i) + "=\"" + al.getValue(i) + "\"");
            }
        }
        showData(">");
    }

    public void endElement(String name) throws SAXException {
        showData("</" + name + ">");
    }

    public void characters(char[] buf, int offset, int len) throws SAXException {
        String s = new String(buf, offset, len);
        showData(s);
    }
}
