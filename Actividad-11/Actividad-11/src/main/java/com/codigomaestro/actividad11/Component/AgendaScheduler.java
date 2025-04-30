package com.codigomaestro.actividad11.Component;

import com.codigomaestro.actividad11.Model.Task;
import com.codigomaestro.actividad11.Repository.TaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class AgendaScheduler {
    private final TaskRepository taskRepository;
    private final Notificador notificador;

    public AgendaScheduler(TaskRepository taskRepository, Notificador notificador) {
        this.taskRepository = taskRepository;
        this.notificador = notificador;
    }

    @Scheduled(fixedRate = 60000) // cada 60 segundos
    public void verificarTareas() {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime time = ahora.plusMinutes(5);

        List<Task> tareasProximas = taskRepository.findByFechaLimiteBetween(ahora, time);

        for (Task tarea : tareasProximas) {
            notificador.enviarNotificacion(tarea);
        }
    }
}