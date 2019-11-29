<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.w3c.dom.*, javax.xml.parsers.*"%>
<%
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document d = db.parse("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\Assignment4\\web\\Books.xml");
%>
<%!
    public boolean isTextNode(Node n) {
        return n.getNodeName().equals("#text");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1">

            <tr>
                <th>ISBN</th>
                <th>Title</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Publication date</th>
                <th>Price($)</th>
            </tr>

            <%
                Element e = d.getDocumentElement();
                NodeList nl = e.getChildNodes();
                for (int i = 0; i < nl.getLength(); i++) {
                    Node n = nl.item(i);
                    if (isTextNode(n)) {
                        continue;
                    }
                    NodeList ln = n.getChildNodes();
            %>

            <tr>
                <%
                    for (int j = 0; j < ln.getLength(); j++) {
                        Node m = ln.item(j);
                        if (isTextNode(m)) {
                            continue;
                        }
                %>
                <td><%=m.getFirstChild().getNodeValue()%></td><%}%>
            </tr><%}%>

        </table>
    </body>
</html>