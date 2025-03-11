<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>
<%@page import="jakarta.servlet.http.Cookie"%>
<%
    boolean sessionActive = (session != null && session.getAttribute("username") != null);
    String username = sessionActive ? (String) session.getAttribute("username") : null;
    double lado = 0.0, area = 0.0, perimetro = 0.0;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            switch (cookie.getName()) {
                case "lado":
                    lado = Double.parseDouble(cookie.getValue());
                    break;
                case "area":
                    area = Double.parseDouble(cookie.getValue());
                    break;
                case "perimetro":
                    perimetro = Double.parseDouble(cookie.getValue());
                    break;
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cálculo de Triángulo Equilátero</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .result {
            margin: 15px 0;
            padding: 10px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            border-radius: 4px;
            font-size: 16px;
            text-align: left;
            line-height: 1.6;
        }
        .container {
            background: #ffffff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        .container h1 {
            margin-bottom: 20px;
            color: #444;
        }

        .container label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        .container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .container button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Cálculo de Triángulo Equilátero</h1>
    <% if (sessionActive) { %>
    <p>Hola, <%= username %>!</p>
    <% } else { %>
    <script>
        let person = prompt("Ingresa un Nombre de Usuario");
        if (person != null) {
            fetch('session-servlet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: 'username=' + encodeURIComponent(person)
            })
                .then(response => {
                    if (response.ok) {
                        location.reload();
                    } else {
                        console.error('Error al registrar el usuario en la sesión');
                    }
                })
                .catch(error => console.error('Error:', error));
        }
    </script>
    <% } %>
    <% if (cookies != null) { %>
    <div class="result">
        <h4>Calculo pasado</h4>
        <p><strong>Longitud del lado:</strong> <%= lado %></p>
        <p><strong>Área:</strong> <%= area %></p>
        <p><strong>Perímetro:</strong> <%= perimetro %></p>
    </div>
    <% } %>
    <form action="main-servlet" method="post">
        <label for="lado">Longitud del lado del triángulo:</label>
        <input type="number" id="lado" name="lado" step="0.01" min="0" required>
        <button type="submit">Calcular</button>
    </form>
</div>
</body>
</html>