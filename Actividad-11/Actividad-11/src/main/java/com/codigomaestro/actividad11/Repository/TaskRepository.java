package com.codigomaestro.actividad11.Repository;

import com.codigomaestro.actividad11.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByFechaLimiteBetween(LocalDateTime inicio, LocalDateTime fin);
}