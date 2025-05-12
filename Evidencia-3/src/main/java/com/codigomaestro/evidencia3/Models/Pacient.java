package com.codigomaestro.evidencia3.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Pacient {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    private String name, sex;
    private int age;
    private double stature, weight, cadera;
    private double imc, iac;

    //Clave Foranea
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

}