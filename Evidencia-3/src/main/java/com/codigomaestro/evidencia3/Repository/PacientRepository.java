package com.codigomaestro.evidencia3.Repository;

import com.codigomaestro.evidencia3.Models.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacientRepository extends JpaRepository<Pacient, Long> {

    @Query("SELECT p.id, p.name, p.sex, p.age, p.stature, p.weight, p.cadera, p.imc, p.iac FROM Pacient p WHERE p.user.id = :userId")
    List<Object[]> findSpecificColumnsByUserId(@Param("userId") Long userId);
}
