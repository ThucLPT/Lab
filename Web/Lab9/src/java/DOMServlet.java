
import java.io.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

@WebServlet(urlPatterns = {"/DOMServlet"})
public class DOMServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DOMServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>List of Students in Web Class</center></h1>");
            out.println("<center><table border=1 cellpadding=0bgcolor =#FFFFFF></center >");
            out.println("<tr><td><b>Name</b></td> <td><b>ID</b></td><td><b>DATE</b></td><td><b>CITY</b></td></tr>");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder parser = factory.newDocumentBuilder();
            Document document = parser.parse("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\WebLab9\\WebClass.xml");
            Node booklist = document.getDocumentElement();
            NodeList books = booklist.getChildNodes();
            int nBooks = books.getLength();
            for (int i = 0; i < nBooks; i++) {
                Node book = books.item(i);
                if (book.getNodeType() != Node.TEXT_NODE) {
                    out.println("<tr>");
                    printBook(book, out);
                    out.println("</tr>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        } catch (SAXException ex) {
            Logger.getLogger(DOMServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOMServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    private void printBook(Node book, PrintWriter out) {
        NamedNodeMap attributes = book.getAttributes();
        if (attributes != null) {
            NodeList childNodes = book.getChildNodes();
            String name = "";
            String id = "";
            String date = "";
            String city = "";
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node child = childNodes.item(i);
                String nodeName = child.getLocalName();
                if (nodeName != null) {
                    if (nodeName.equals("name")) {
                        NodeList children = child.getChildNodes();
                        Node dateNode = children.item(0);
                        if (dateNode.getNodeType() == Node.TEXT_NODE) {
                            name = dateNode.getNodeValue();
                        }
                    } else if (nodeName.equals("idNum")) {
                        NodeList children = child.getChildNodes();
                        Node dateNode = children.item(0);
                        if (dateNode.getNodeType() == Node.TEXT_NODE) {
                            id = dateNode.getNodeValue();
                        }
                    } else if (nodeName.equals("date-of-birth")) {
                        NodeList children = child.getChildNodes();
                        Node priceNode = children.item(0);
                        if (priceNode.getNodeType() == Node.TEXT_NODE) {
                            date = priceNode.getNodeValue();
                        }
                    } else if (nodeName.equals("city")) {
                        NodeList children = child.getChildNodes();
                        Node priceNode = children.item(0);
                        if (priceNode.getNodeType() == Node.TEXT_NODE) {
                            city = priceNode.getNodeValue();
                        }
                    }
                }
            }
            out.print("<td>" + name + "</td>" + "<td>" + id + "</td>"
                    + "<td>" + date + "</td>" + "<td>" + city + "</td>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
