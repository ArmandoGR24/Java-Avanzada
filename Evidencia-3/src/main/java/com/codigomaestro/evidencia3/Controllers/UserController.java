package com.codigomaestro.evidencia3.Controllers;

import com.codigomaestro.evidencia3.Models.Pacient;
import com.codigomaestro.evidencia3.Services.PacientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codigomaestro.evidencia3.Models.User;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PacientService pacientService;

    @GetMapping("/pacient")
    public String ShowPacientPage(HttpSession session, Model model) {
        String role = (String) session.getAttribute("role");
        String username = (String) session.getAttribute("user");
        List<Pacient> pacients;

        if ("admin".equals(role)) {
            pacients = pacientService.getAllPacients();
        } else {
            Long userId = (Long) session.getAttribute("id");
            pacients = pacientService.getPacientsByUserId(userId).stream()
                    .map(obj -> {
                        Pacient pacient = new Pacient();
                        pacient.setId((Long) obj[0]);
                        pacient.setName((String) obj[1]);
                        pacient.setSex((String) obj[2]);
                        pacient.setAge((Integer) obj[3]);
                        pacient.setStature((Double) obj[4]);
                        pacient.setWeight((Double) obj[5]);
                        pacient.setCadera((Double) obj[6]);
                        pacient.setImc((Double) obj[7]);
                        pacient.setIac((Double) obj[8]);
                        return pacient;
                    }).toList();
        }
        model.addAttribute("username", username);
        model.addAttribute("pacients", pacients);
        model.addAttribute("role", role);

        return "./User/user";
    }

    @PostMapping("/pacient")
    public String registerPacient(@RequestParam("name") String name,
                                  @RequestParam("sex") String sex,
                                  @RequestParam("age") int age,
                                  @RequestParam("stature") double stature,
                                  @RequestParam("weight") double weight,
                                  @RequestParam("cadera") double cadera,
                                  HttpSession session, Model model) {
        try {
            // Crear un nuevo objeto Pacient
            Pacient pacient = new Pacient();
            pacient.setName(name);
            pacient.setSex(sex);
            pacient.setAge(age);
            pacient.setStature(stature);
            pacient.setWeight(weight);
            pacient.setCadera(cadera);

            Long userId = (Long) session.getAttribute("id");
            User user = new User();
            user.setId(userId);
            pacient.setUser(user);

            // Guardar el paciente
            pacientService.savePacient(pacient);

            model.addAttribute("successMessage", "Paciente registrado con éxito.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al registrar el paciente: " + e.getMessage());
        }
        return "redirect:/pacient";
    }


}
