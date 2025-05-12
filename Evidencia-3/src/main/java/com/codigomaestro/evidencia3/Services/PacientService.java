package com.codigomaestro.evidencia3.Services;

import com.codigomaestro.evidencia3.Models.Pacient;
import com.codigomaestro.evidencia3.Repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientService {

    @Autowired
    private PacientRepository pacientRepository;

    public Pacient savePacient(Pacient pacient) {
        calculateIMC(pacient);
        calculateIAC(pacient);
        return pacientRepository.save(pacient);
    }

    public List<Pacient> getAllPacients() {
        return pacientRepository.findAll();
    }

    public List<Object[]> getPacientsByUserId(Long userId) {
        return pacientRepository.findSpecificColumnsByUserId(userId);
    }


    private void calculateIMC(Pacient pacient) {
        if (pacient.getStature() > 0 && pacient.getWeight() > 0) {
            double imc = pacient.getWeight() / Math.pow(pacient.getStature(), 2);
            pacient.setImc(imc);
        } else {
            throw new IllegalArgumentException("Los valores de peso y estatura deben ser mayores a 0");
        }
    }

    private void calculateIAC(Pacient pacient) {
        double iac = (pacient.getCadera() / pacient.getStature()) - 18;
        pacient.setIac(iac);
    }
}
