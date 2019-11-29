<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Course Registration Demo</h1>
        <form method="post" action="SecondPage.jsp">
            <p>
                Student ID:
                <input type="text" name="id">
                <input type="submit" value="Submit">
            </p>
        </form>
        <h2>Manager</h2>
        <a href="StudentsManager.jsp">Students Manager</a><br>
        <a href="CoursesManager.jsp">Courses Manager</a>
    </body>
</html>