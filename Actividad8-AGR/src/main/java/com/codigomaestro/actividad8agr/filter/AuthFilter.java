package com.codigomaestro.actividad8agr.filter;

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

@WebFilter(urlPatterns = {"/admin.jsp", "/user.jsp"})
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
        HttpSession session = httpRequest.getSession(false);

        String path = httpRequest.getServletPath();
        boolean isLoggedIn = (session != null && session.getAttribute("username") != null);
        boolean isAdminPage = path.equals("/admin.jsp");
        boolean isUserPage = path.equals("/user.jsp");

        if (!isLoggedIn) {
            httpResponse.sendRedirect("login.jsp");
        } else {
            String role = (String) session.getAttribute("role");
            if (isAdminPage && "admin".equals(role)) {
                chain.doFilter(request, response);
            } else if (isUserPage && ("user".equals(role) || "admin".equals(role))) {
                chain.doFilter(request, response);
            } else {
                httpResponse.sendRedirect("login.jsp");
            }
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}