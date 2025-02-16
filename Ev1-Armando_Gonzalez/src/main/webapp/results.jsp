<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
<h2>Resultados</h2>
<p><strong>Nombre:</strong> ${user.name}</p>
<p><strong>Edad:</strong> ${user.age}</p>
<p><strong>Sexo:</strong> ${user.sex}</p>
<p><strong>Estatura (m):</strong> ${user.stature}</p>
<p><strong>Peso (kg):</strong> ${user.weight}</p>
<p><strong>Cadera (cm):</strong> ${user.cadera}</p>
<h3>Estadisticas Calculadas</h3>
<p><strong>IAC:</strong> ${stats.IAC}</p>
<p><strong>IMC:</strong> ${stats.IMC}</p>
</body>
</html>