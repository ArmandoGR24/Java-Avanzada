package com.codigomaestro.evidencia2agr.Filters;

import com.codigomaestro.evidencia2agr.Controllers.SessionController;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/admin/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = SessionController.getSession(httpRequest);
        if (session != null) {
            String role = (String) session.getAttribute("role");
            if ("admin".equals(role)) {
                // Allow access to admin resources
                chain.doFilter(request, response);
            } else {
                // Redirect to login if role is not admin
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            }
        } else {
            // Redirect to login if session is not found
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}