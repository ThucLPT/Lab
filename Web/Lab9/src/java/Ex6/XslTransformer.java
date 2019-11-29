package Ex6;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class XslTransformer {

    private TransformerFactory factory;

    public XslTransformer() {
        factory = TransformerFactory.newInstance();
    }

    public void process(Reader xmlFile, Reader xslFile, Writer output) throws TransformerException {
        process(new StreamSource(xmlFile), new StreamSource(xslFile), new StreamResult(output));
    }

    public void process(File xmlFile, File xslFile, Writer output) throws TransformerException {
        process(new StreamSource(xmlFile), new StreamSource(xslFile), new StreamResult(output));
    }

    public void process(File xmlFile, File xslFile, OutputStream out) throws TransformerException {
        process(new StreamSource(xmlFile), new StreamSource(xslFile), new StreamResult(out));
    }

    public void process(Source xml, Source xsl, Result result) throws TransformerException {
        try {
            Templates template = factory.newTemplates(xsl);
            Transformer transformer = template.newTransformer();
            transformer.transform(xml, result);
        } catch (TransformerConfigurationException tce) {
            throw new TransformerException(tce.getMessageAndLocation());
        } catch (TransformerException te) {
            throw new TransformerException(te.getMessageAndLocation());
        }
    }
}
