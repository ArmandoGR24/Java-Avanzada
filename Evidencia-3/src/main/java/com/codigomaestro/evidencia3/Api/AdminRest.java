package com.codigomaestro.evidencia3.Api;


import com.codigomaestro.evidencia3.Models.Pacient;
import com.codigomaestro.evidencia3.Models.User;
import com.codigomaestro.evidencia3.Services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.codigomaestro.evidencia3.Services.PacientService;


@RestController
@RequestMapping("/api/admin")
public class AdminRest {

    @Autowired
    private UserService userService;
    @Autowired
    private PacientService pacientService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/pacients")
    public List<Pacient> getPacients() {
        return pacientService.getAllPacients();
    }


}
