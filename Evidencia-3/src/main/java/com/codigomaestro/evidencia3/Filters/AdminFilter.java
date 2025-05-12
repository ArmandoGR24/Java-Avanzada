package com.codigomaestro.evidencia3.Filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Verificar el atributo de sesión
        Object role = httpRequest.getSession().getAttribute("role");
        if (role != null && role.equals("admin")) {
            chain.doFilter(request, response); // Continuar con la petición
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 Forbidden
            httpResponse.getWriter().write("Acceso denegado: solo administradores pueden acceder.");
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        }
    }
}