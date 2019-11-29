<%@page import="java.util.Scanner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="javax.xml.transform.*"%>
<%@page import="javax.xml.transform.stream.*"%>
<%!
    String transform() {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer(new StreamSource("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\Assignment4\\web\\Books.xsl"));
            t.transform(new StreamSource("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\Assignment4\\web\\Books.xml"), new StreamResult(new FileOutputStream("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\Assignment4\\web\\Books.html")));
            return new Scanner(new File("C:\\Users\\ThangPham\\Documents\\NetBeansProjects\\Assignment4\\web\\Books.html")).useDelimiter("\\a").next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" width="100%">
            <tr><td colspan="2"><%=transform()%></td></tr>
            <tr>
                <th>XML</th>
                <th>XSL</th>
            </tr>            
            <tr>
                <td><textarea readonly rows="41" style="width: 100%; border: none; resize: none"><%@include file='Books.xml'%></textarea></td>
                <td><textarea readonly rows="41" style="width: 100%; border: none; resize: none"><%@include file='Books.xsl'%></textarea></td>
            </tr>
        </table>
    </body>
</html>