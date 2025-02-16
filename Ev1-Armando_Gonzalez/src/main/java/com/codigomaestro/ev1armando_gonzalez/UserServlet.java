package com.codigomaestro.ev1armando_gonzalez;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import com.codigomaestro.ev1armando_gonzalez.controllers.StatsController;
import com.codigomaestro.ev1armando_gonzalez.models.User;
import com.codigomaestro.ev1armando_gonzalez.models.Stats;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import com.codigomaestro.ev1armando_gonzalez.controllers.UserController;

@WebServlet(name = "userservlet", value = "/userservlet")
public class UserServlet extends HttpServlet {

    private UserController userController = new UserController();
    private Stats stats = new Stats();
    private StatsController statsController = new StatsController();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        double stature = Double.parseDouble(request.getParameter("stature"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        int cadera = Integer.parseInt(request.getParameter("cadera"));

        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setStature(stature);
        user.setWeight(weight);
        user.setCadera(cadera);

        int userId = userController.insertUser(user);
        if (userId != -1) {
            user.setId(userId);

            double iac = statsController.calculateIAC(cadera, stature);
            double imc = statsController.calculateIMC(weight, stature);

            stats.setIdUser(user.getId());
            stats.setIAC((float) iac);
            stats.setIMC((float) imc);

            statsController.insertStats(stats);

            request.setAttribute("user", user);
            request.setAttribute("stats", stats);
            RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Error: User insertion failed.");
        }
    }
}