package com.codigomaestro.actividad7.controllers;

import com.codigomaestro.actividad7.models.UserData;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Objects;

public class CookiesController {
    private String username;
    private double lado,area,perimetro;

    public Cookie[] setValues(UserData userData)
    {
        Cookie[] cookies = {
                new Cookie("username", userData.getUsername()),
                new Cookie("lado", String.valueOf(userData.getLado())),
                new Cookie("area", String.valueOf(userData.getArea())),
                new Cookie("perimetro", String.valueOf(userData.getPerimetro()))
        };

        return cookies;
    }


    public UserData getValues(HttpServletRequest request) {
        UserData userData = new UserData();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                }
                if ("lado".equals(cookie.getName())) {
                    lado = Double.parseDouble(cookie.getValue());
                }
                if ("area".equals(cookie.getName())) {
                    area = Double.parseDouble(cookie.getValue());
                }
                if ("perimetro".equals(cookie.getName())) {
                    perimetro = Double.parseDouble(cookie.getValue());
                }
            }
        }
        userData.setUsername(username);
        userData.setLado(lado);
        userData.setArea(area);
        userData.setPerimetro(perimetro);
        return userData;
    }
}
