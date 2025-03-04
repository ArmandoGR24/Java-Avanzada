<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.codigomaestro.com/tags" prefix="tagcustom"%>
<!DOCTYPE html>
<html>
<head>
    <title>Actividad 6</title>
    <meta charset="UTF-8">
</head>
<body>
<h1><%= "Acticidad 6" %></h1>
<br/>

<%
    String nombre = request.getParameter("name");
    if (nombre == null || nombre.trim().isEmpty()) {
        nombre = "Invitado";
    }
%>
<form action="index.jsp" method="post">
    <input type="text" name="name" id="name" placeholder="Ingresa tu Nombre"/>
    <button type="submit">Enviar</button>
</form>
<tagcustom:saludo message="Hola como estas" name="<%= nombre %>"/>
<%
    int juego = 0;
    if (request.getParameter("juego") != null) {
        try {
            juego = Integer.parseInt(request.getParameter("juego"));
        } catch (NumberFormatException e) {
            juego = 0;
        }
    }
%>
<form action="index.jsp" method="post">
    <label for="name"> Elije uno </label>
    <select name="juego">
        <option value="1">Piedra</option>
        <option value="2">Papel</option>
        <option value="3">Tijera</option>
    </select>
    <button type="submit">Enviar</button>
</form>
<tagcustom:lol seleccion="<%= String.valueOf(juego) %>"/>
</body>
</html>