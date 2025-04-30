package com.codigomaestro.actividad11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Actividad11Application {

    public static void main(String[] args) {
        SpringApplication.run(Actividad11Application.class, args);
    }

}
