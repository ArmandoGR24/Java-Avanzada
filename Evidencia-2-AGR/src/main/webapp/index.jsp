<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codigomaestro.evidencia2agr.DB.DB" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Hello World!</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<h2>Databases:</h2>
<ul>
    <%
        try {
            List<String> databases = DB.getDatabases();
            for (String dbName : databases) {
                out.println("<li>" + dbName + "</li>");
            }
        } catch (Exception e) {
            out.println("<li>Error retrieving databases: " + e.getMessage() + "</li>");
        }
    %>
</ul>
</body>
</html>