package com.codigomaestro.evidencia2agr;

import com.codigomaestro.evidencia2agr.Controllers.PacientController;
import com.codigomaestro.evidencia2agr.Models.Pacient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PacientServlet", value = "/PacientServlet")
public class PacientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("role");
        double stature = Double.parseDouble(request.getParameter("stature"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        double cadera = Double.parseDouble(request.getParameter("cadera"));

        Pacient pacient = new Pacient();
        pacient.setName(name);
        pacient.setAge(age);
        pacient.setSex(sex);
        pacient.setStature(stature);
        pacient.setWeight(weight);
        pacient.setCadera(cadera);

        PacientController pacientController = new PacientController();

        if (pacientController.registerPacient(pacient)) {
            response.sendRedirect("user/pacient.jsp");
        } else {
            response.sendRedirect("user/pacient.jsp?error=true");
        }
    }
}