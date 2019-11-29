<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Using JavaBeans with JSP</h1>
        <jsp:useBean id="stringBean" class="Example.StringBean"/>
        <ol>
            <li>Initial value(from jsp:getProperty): <jsp:getProperty name="stringBean" property="message"/></li>
            <li>Initial value(from JSP expression): <%=stringBean.getMessage()%></li>
            <li><jsp:setProperty name="stringBean" property="message" value="Best string bean: Fortex"/>
                Value after setting property with jsp:setProperty: <jsp:getProperty name="stringBean" property="message"/></li>
            <li><%stringBean.setMessage("My favorite: Kentucky Wonder");%>
                Value after setting property with scriptlet: <%=stringBean.getMessage()%></li>
        </ol>
    </body>
</html>