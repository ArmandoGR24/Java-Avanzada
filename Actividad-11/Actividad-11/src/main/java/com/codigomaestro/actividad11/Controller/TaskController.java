package com.codigomaestro.actividad11.Controller;

import com.codigomaestro.actividad11.Model.Task;
import com.codigomaestro.actividad11.Repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TaskController {

    private final TaskRepository tareaRepository;

    public TaskController(TaskRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // Crear nueva tarea
    @PostMapping
    public Task crearTarea(@RequestBody Task tarea) {
        return tareaRepository.save(tarea);
    }

    // Obtener todas las tareas
    @GetMapping
    public List<Task> listarTareas() {
        return tareaRepository.findAll();
    }

    // Obtener una tarea por su ID
    @GetMapping("/{id}")
    public Task obtenerTarea(@PathVariable Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id));
    }

    // Actualizar una tarea existente
    @PutMapping("/{id}")
    public Task actualizarTarea(@PathVariable Long id, @RequestBody Task tareaActualizada) {
        Task tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id));

        tarea.setTitulo(tareaActualizada.getTitulo());
        tarea.setDescripcion(tareaActualizada.getDescripcion());
        tarea.setFechaLimite(tareaActualizada.getFechaLimite());

        return tareaRepository.save(tarea);
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaRepository.deleteById(id);
    }
}