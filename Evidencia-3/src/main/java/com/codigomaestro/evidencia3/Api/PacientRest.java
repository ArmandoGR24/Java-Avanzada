package com.codigomaestro.evidencia3.Api;

import com.codigomaestro.evidencia3.Models.Pacient;
import com.codigomaestro.evidencia3.Models.User;
import com.codigomaestro.evidencia3.Services.PacientService;
import com.codigomaestro.evidencia3.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/pacient")
public class PacientRest {

    @Autowired
    private PacientService pacientService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Pacient savePacient(@RequestBody Pacient pacient, HttpSession session) {
        Long userId = (Long) session.getAttribute("id");
        if (userId == null) {
            throw new RuntimeException("Usuario no autenticado");
        }

        User user = userService.getUserById(userId);
        pacient.setUser(user);

        return pacientService.savePacient(pacient);
    }

    @GetMapping("/all")
    public List<Object[]> getPacientsByCurrentUser(HttpSession session) {
        Long userId = (Long) session.getAttribute("id");
        if (userId == null) {
            throw new RuntimeException("Usuario no autenticado");
        }
        return pacientService.getPacientsByUserId(userId);
    }


}
