package com.codigomaestro.actividad7;

import com.codigomaestro.actividad7.controllers.CookiesController;
import com.codigomaestro.actividad7.controllers.Triangulo;
import com.codigomaestro.actividad7.models.UserData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "mainServlet", value = "/main-servlet")
public class MainServlet extends HttpServlet
{
    Triangulo triangulo = new Triangulo();
    CookiesController cookiesController = new CookiesController();
    UserData userData = new UserData();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " " + cookie.getValue());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        String username = session.getAttribute("username").toString();
        double lado = Double.parseDouble(request.getParameter("lado"));
        triangulo.setLado(lado);
        double area = triangulo.CalcularArea();
        double perimetro = triangulo.CalcularPerimetro();

        userData.setUsername(username);
        userData.setLado(lado);
        userData.setArea(area);
        userData.setPerimetro(perimetro);

        Cookie[] cookies = cookiesController.setValues(userData);
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
        }


        request.setAttribute("lado", lado);
        request.setAttribute("area", area);
        request.setAttribute("perimetro", perimetro);

        request.getRequestDispatcher("resultado.jsp").forward(request,response);

    }
}
