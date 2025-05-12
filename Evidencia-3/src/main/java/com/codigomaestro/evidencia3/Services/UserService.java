package com.codigomaestro.evidencia3.Services;

import com.codigomaestro.evidencia3.Models.User;
import com.codigomaestro.evidencia3.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

    public User saveUser(User user) {
       user.setPwd(pwdEncoder.encode(user.getPwd()));
       return userRepository.save(user);
    }

    public User login(String username, String password, HttpSession session) {
        Optional<User> optionalUser = userRepository.findByUser(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (pwdEncoder.matches(password, user.getPwd())) {
                // Guarda el nombre de usuario y rol en la sesión
                session.setAttribute("user", user.getUser());
                session.setAttribute("role", user.getRole());
                session.setAttribute("id", user.getId());
                System.out.println("Usuario: " + session.getAttribute("user"));
                System.out.println("Rol: " + session.getAttribute("role"));
                return user;
            }
        }
        throw new RuntimeException("Credenciales inválidas");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }



}
