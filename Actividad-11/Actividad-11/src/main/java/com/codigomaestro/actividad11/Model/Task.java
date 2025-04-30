package com.codigomaestro.actividad11.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private LocalDateTime fechaLimite;

    // Constructor vacío necesario para JPA
    public Task() {}

    public Task(String titulo, String descripcion, LocalDateTime fechaLimite) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;

        return Objects.equals(id, task.id) && Objects.equals(titulo, task.titulo) && Objects.equals(descripcion, task.descripcion) && Objects.equals(fechaLimite, task.fechaLimite);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(titulo);
        result = 31 * result + Objects.hashCode(descripcion);
        result = 31 * result + Objects.hashCode(fechaLimite);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDateTime fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
}