package com.codigomaestro.evidencia3.Repository;

import com.codigomaestro.evidencia3.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUser(String user);

}
