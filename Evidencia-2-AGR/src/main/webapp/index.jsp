<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora IMC e IAC</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-light">
<div class="text-center">
    <h1 class="mb-2">Evidencia 2</h1>
    <h1 class="mb-2">Computación Avanzada en Java</h1>
    <h1 class="mb-4">Calculadora de IMC e IAC</h1>
    <%
        HttpSession currentSession = request.getSession(false);
        if (currentSession == null || currentSession.getAttribute("username") == null) {
    %>
    <a href="login.jsp" class="btn btn-primary btn-lg">Login</a>
    <%
    } else {
    %>
    <a href="LogoutServlet" class="btn btn-danger btn-lg">Logout</a>
    <a href="user/pacient.jsp" class="btn btn-secondary btn-lg">Pacientes</a>
    <%
        if ("admin".equals(currentSession.getAttribute("role"))) {
    %>
    <a href="admin/users.jsp" class="btn btn-secondary btn-lg">Usuarios</a>
    <%
        }
    %>
    <%
        }
    %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>