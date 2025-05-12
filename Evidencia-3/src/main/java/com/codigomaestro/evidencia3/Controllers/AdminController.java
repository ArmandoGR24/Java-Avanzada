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

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String ShowAdminPage(Model model, HttpSession session) {
        // Obtén el nombre de usuario desde la sesión
        String username = (String) session.getAttribute("user");
        model.addAttribute("username", username);

        // Obtén la lista de usuarios
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "./admin/admin";
    }

    @PostMapping("/admin")
    public String registerUser(@RequestParam("user") String username,
                               @RequestParam("pass") String password,
                               @RequestParam("role") String role,
                               Model model) {
        try {
            User adduser = new User();
            adduser.setUser(username);
            adduser.setPwd(password);
            adduser.setRole(role);

            userService.saveUser(adduser);

            model.addAttribute("successMessage", "Usuario registrado con éxito.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al registrar el usuario: " + e.getMessage());
        }
        return "redirect:/admin";
    }
}