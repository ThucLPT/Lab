package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Scanner;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public final class Books_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Books.xml");
    _jspx_dependants.add("/Books.xsl");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table border=\"1\" width=\"100%\">\n");
      out.write("            <tr><td colspan=\"2\">");
      out.print(transform());
      out.write("</td></tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>XML</th>\n");
      out.write("                <th>XSL</th>\n");
      out.write("            </tr>            \n");
      out.write("            <tr>\n");
      out.write("                <td><textarea readonly rows=\"41\" style=\"width: 100%; border: none; resize: none\">");
      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
      out.write("<?xml-stylesheet type=\"text/xsl\" href=\"Books.xsl\"?>\n");
      out.write("<books>\n");
      out.write("    <book>\n");
      out.write("        <isbn>0470114878</isbn>\n");
      out.write("        <title>Beginning XML, 4th Edition(Programmer to Programmer)</title>\n");
      out.write("        <author>David Hunter, Jeff Rafter, Joe Fawcett, Eric van Dist</author>\n");
      out.write("        <publisher>Wrox</publisher>\n");
      out.write("        <date>May 21, 2007</date>\n");
      out.write("        <price>26.39</price>\n");
      out.write("    </book>\n");
      out.write("    \n");
      out.write("    <book>\n");
      out.write("        <isbn>0596007647</isbn>\n");
      out.write("        <title>XML in a Nutshell, 3rd Edition</title>\n");
      out.write("        <author>Elliotte Rusty Harold, Scott Means</author>\n");
      out.write("        <publisher>O'Reilly Media, Inc</publisher>\n");
      out.write("        <date>September 2004</date>\n");
      out.write("        <price>26.37</price>\n");
      out.write("    </book>\n");
      out.write("    \n");
      out.write("    <book>\n");
      out.write("        <isbn>0596004206</isbn>\n");
      out.write("        <title>Learning XML, 2nd Edition</title>\n");
      out.write("        <author>Erik Ray</author>\n");
      out.write("        <publisher>O'Reilly Media, Inc</publisher>\n");
      out.write("        <date>September 22, 2003</date>\n");
      out.write("        <price>26.37</price>\n");
      out.write("    </book>\n");
      out.write("    \n");
      out.write("    <book>\n");
      out.write("        <isbn>0130655678</isbn>\n");
      out.write("        <title>Definitive XML Schema(The Charles Goldfarb Definitive XML Series)</title>\n");
      out.write("        <author>Priscilla Walmsley</author>\n");
      out.write("        <publisher>Prentice Hall</publisher>\n");
      out.write("        <date>December 17, 2001</date>\n");
      out.write("        <price>33.38</price>\n");
      out.write("    </book>\n");
      out.write("</books>\n");
      out.write("</textarea></td>\n");
      out.write("                <td><textarea readonly rows=\"41\" style=\"width: 100%; border: none; resize: none\">");
      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
      out.write("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\r\n");
      out.write("    <xsl:template match=\"/\">\r\n");
      out.write("        <html>\r\n");
      out.write("            <body>\r\n");
      out.write("                <table border=\"1\">\r\n");
      out.write("                    <tr bgcolor=\"#9acd32\">\r\n");
      out.write("                        <th>ISBN</th>\r\n");
      out.write("                        <th>Title</th>\r\n");
      out.write("                        <th>Author</th>\r\n");
      out.write("                        <th>Publisher</th>\r\n");
      out.write("                        <th>Publication date</th>\r\n");
      out.write("                        <th>Price($)</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <xsl:for-each select=\"books/book\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <xsl:value-of select=\"isbn\"/>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <xsl:value-of select=\"title\"/>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <xsl:value-of select=\"author\"/>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <xsl:value-of select=\"publisher\"/>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <xsl:value-of select=\"date\"/>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <xsl:value-of select=\"price\"/>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </xsl:for-each>\r\n");
      out.write("                </table>\r\n");
      out.write("            </body>\r\n");
      out.write("        </html>\r\n");
      out.write("    </xsl:template>\r\n");
      out.write("</xsl:stylesheet>");
      out.write("</textarea></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
