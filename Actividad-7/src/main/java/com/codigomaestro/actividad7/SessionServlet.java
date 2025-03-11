package com.codigomaestro.actividad7;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "sessionServlet", value = "/session-servlet")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (session != null && session.getAttribute("username") != null) {
            out.println("<h1>Session Example</h1>");
            out.println("<p>Usuario: " + session.getAttribute("username") + "</p>"); // Recuperar datos de la sesión
        } else {
            out.println("<h1>No hay session Activa</h1>");
        }
        out.println("");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        if (username != null){
            session.setAttribute("username", username); // Almacenar el nombre de usuario en la sesión
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>Usuario registrado: " + session.getAttribute("username") + "</p>");
        out.println("</body></html>");
    }

}