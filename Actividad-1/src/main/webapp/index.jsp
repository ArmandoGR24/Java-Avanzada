<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <form action="resultado.jsp" method="post">
        <label for="lado">Longitud del lado del triángulo:</label>
        <input type="number" id="lado" name="lado" step="0.01" min="0" required>
        <button type="submit">Calcular</button>
    </form>
</div>
</body>
</html>
