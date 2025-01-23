<%@ page import="com.codigomaestro.actividad1.Triangulo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Resultado del Cálculo</title>
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

    .container a {
      display: inline-block;
      margin-top: 20px;
      text-decoration: none;
      background-color: #4CAF50;
      color: white;
      padding: 10px 15px;
      border-radius: 4px;
      font-size: 16px;
      transition: background-color 0.3s ease;
    }

    .container a:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<%
  Triangulo triangulo = new Triangulo();
  triangulo.setLado(Double.parseDouble(request.getParameter("lado")));
  double lado = triangulo.getLado();
  double area = triangulo.CalcularArea();
  double perimetro = triangulo.CalcularPerimetro();
%>
<div class="container">
  <h1>Resultado del Cálculo</h1>
  <div class="result">
    <p><strong>Longitud del lado:</strong> <%=lado%></p>
    <p><strong>Área:</strong> <%=area%></p>
    <p><strong>Perímetro:</strong> <%=perimetro%></p>
  </div>
  <a href="index.jsp">Volver al formulario</a>
</div>
</body>
</html>
