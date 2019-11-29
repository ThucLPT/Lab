<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Testing JSP and JavaBeans</h1>
        <jsp:useBean id="counter" scope="session" class="Example.Counter"/>
        <jsp:setProperty name="counter" property="count" param="count"/>
        <%out.println("Value of counter: "+counter.getCount());%>
    </body>
</html>