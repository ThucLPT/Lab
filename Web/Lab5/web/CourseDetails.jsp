<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab5", "root", "root");
    String detail=request.getParameter("detail");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Course's Details</h1>
        <%
            PreparedStatement ps=c.prepareStatement("SELECT * FROM course WHERE CourseName=?");
            ps.setString(1, detail);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
        %>
        <p>Course ID: <%=rs.getString("CourseID")%></p>
        <p>Course Name: <%=rs.getString("CourseName")%></p><%}%>
        <h2>Student list:</h2>
        <table>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Action</th>
            </tr>
            <%
                PreparedStatement ps2=c.prepareStatement("SELECT * FROM student, studentcourse"
                                                        +"WHERE student.StudentID=studentcourse.StudentID"
                                                        +"AND studentcourse.CourseName=?");
                ps2.setString(1, detail);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next()){
            %>
            <tr>
                <td><%=rs2.getString("StudentID")%></td>
                <td><%=rs2.getString("StudentName")%></td>
                <td><a href="">Remove</a></td>
            </tr><%}%>
        </table><hr>
        <a href="FirstPage.jsp">Homepage</a>
    </body>
</html>