<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab5", "root", "root");
    String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student's Details</h1>
        <%
            PreparedStatement ps = c.prepareStatement("SELECT * FROM student WHERE StudentID='"+id+"'");
            //ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
        %>
        <p>Student ID: <%=rs.getString("StudentID")%></p>
        <p>Student name: <%=rs.getString("StudentName")%><%}%></p> 
        <h2>Select Course</h2>
        <form action="" method="post">
            Course:
            <select>
                <%
                    ps = c.prepareStatement("SELECT CourseName FROM course");
                    rs = ps.executeQuery();
                    while (rs.next()) {
                %>
                <option>
                    <%=rs.getString("CourseName")%><%}%>
                </option>
            </select>
            <input type="submit" value="Add">
        </form>
        <h3>Registered Courses:</h3>
        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Action</th>
            </tr>
            <%
                ps = c.prepareStatement("SELECT course.CourseName, studentcourse.*"
                        + "FROM course, studentcourse"
                        + "WHERE course.CourseID=studentcourse.CourseID"
                        + "AND studentcourse.StudentID='" + id + "'");
                //ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getString("CourseID")%></td>
                <td><%=rs.getString("CourseName")%></td>
                <td><a href="">Remove</a></td>
            </tr><%}%>
        </table><hr>
        <a href="FirstPage.jsp">Homepage</a>
    </body>
</html>