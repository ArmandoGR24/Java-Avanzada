package com.codigomaestro.evidencia3.Controllers;

import com.codigomaestro.evidencia3.Models.User;
import com.codigomaestro.evidencia3.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {
        try {
            User user = userService.login(username, password, session);

            if ("admin".equals(user.getRole())) {
                return "redirect:/admin";
            } else if ("user".equals(user.getRole())) {
                return "redirect:/pacient";
            } else {
                model.addAttribute("error", "Rol no reconocido");
                return "login";
            }
        } catch (RuntimeException e) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}
