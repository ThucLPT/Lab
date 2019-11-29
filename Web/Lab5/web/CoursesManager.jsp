<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab5", "root", "root");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Course List</h1>
        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Action</th>
            </tr>
            <%
                PreparedStatement ps=c.prepareStatement("SELECT * FROM course");
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
            %>
            <tr>
                <td><%=rs.getString("CourseID")%></td>
                <td><a href="CourseDetails.jsp" name="detail"><%=rs.getString("CourseName")%></a></td>
                <td>
                    <a href="">Edit</a>
                    <a href="">Delete</a>
                </td>
            </tr><%}%>
        </table>
        <a href="">New course</a><hr>
        <a href="FirstPage.jsp">Homepage</a>
    </body>
</html>