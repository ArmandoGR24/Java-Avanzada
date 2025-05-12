package com.codigomaestro.evidencia3.Api;

import com.codigomaestro.evidencia3.Models.User;
import com.codigomaestro.evidencia3.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class AuthRest {

    @Autowired
    private UserService userService = new UserService();

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> credentials, HttpSession session) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        return userService.login(username, password, session);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalida la sesión
        return "Sesión cerrada con éxito";
    }




}
