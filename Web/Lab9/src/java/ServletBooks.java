
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

@WebServlet(urlPatterns = {"/ServletBooks"})
public class ServletBooks extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletBooks</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletBooks at " + request.getContextPath() + "</h1>");
            out.println("<table border='1'>"
                    + "<tr>"
                    + "<th>ISBN</th>"
                    + "<th>Title</th>"
                    + "<th>Author</th>"
                    + "<th>Publisher</th>"
                    + "<th>Publication date</th>"
                    + "<th>Price($)</th>"
                    + "</tr>");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\Assignment4\\web\\Books.xml");
            Node n = d.getDocumentElement();
            NodeList nl = n.getChildNodes();
            int a = nl.getLength();
            for (int i = 0; i < a; i++) {
                Node m = nl.item(i);
                if (m.getNodeType() != Node.TEXT_NODE) {
                    out.println("<tr>");
                    print(m, out);
                    out.println("</tr>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {

        }
    }

    private void print(Node n, PrintWriter pw) {
        NamedNodeMap nnm = n.getAttributes();
        if (nnm != null) {
            NodeList childNodes = n.getChildNodes();
            String isbn = "";
            String title = "";
            String author = "";
            String publisher = "";
            String date = "";
            String price = "";
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node child = childNodes.item(i);
                String nodeName = child.getLocalName();
                if (nodeName != null) {

                    if (nodeName.equals("isbn")) {
                        NodeList children = child.getChildNodes();
                        Node dateNode = children.item(0);
                        if (dateNode.getNodeType() == Node.TEXT_NODE) {
                            isbn = dateNode.getNodeValue();
                        }
                    } else if (nodeName.equals("title")) {
                        NodeList children = child.getChildNodes();
                        Node dateNode = children.item(0);
                        if (dateNode.getNodeType() == Node.TEXT_NODE) {
                            title = dateNode.getNodeValue();
                        }
                    } else if (nodeName.equals("author")) {
                        NodeList children = child.getChildNodes();
                        Node priceNode = children.item(0);
                        if (priceNode.getNodeType() == Node.TEXT_NODE) {
                            author = priceNode.getNodeValue();
                        }
                    } else if (nodeName.equals("publisher")) {
                        NodeList children = child.getChildNodes();
                        Node priceNode = children.item(0);
                        if (priceNode.getNodeType() == Node.TEXT_NODE) {
                            publisher = priceNode.getNodeValue();
                        }
                    } else if (nodeName.equals("date")) {
                        NodeList children = child.getChildNodes();
                        Node priceNode = children.item(0);
                        if (priceNode.getNodeType() == Node.TEXT_NODE) {
                            date = priceNode.getNodeValue();
                        }
                    } else if (nodeName.equals("price")) {
                        NodeList children = child.getChildNodes();
                        Node priceNode = children.item(0);
                        if (priceNode.getNodeType() == Node.TEXT_NODE) {
                            price = priceNode.getNodeValue();
                        }
                    }
                }

            }
            pw.print("<td>" + isbn + "</td>" + "<td>" + title + "</td>"
                    + "<td>" + author + "</td>" + "<td>" + publisher + "</td>"
                    + "<td>" + date + "</td>" + "<td>" + price + "</td>");
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
