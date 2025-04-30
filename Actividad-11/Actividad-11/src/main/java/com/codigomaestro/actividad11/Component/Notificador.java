package com.codigomaestro.actividad11.Component;
import com.codigomaestro.actividad11.Model.Task;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Notificador {

    @Async
    public void enviarNotificacion(Task tarea) {
        System.out.println("[NOTIFICACIÓN] Recuerda tu tarea: " + tarea.getTitulo() +
                " - Vence a las: " + tarea.getFechaLimite());
    }
}
