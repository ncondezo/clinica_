package com.example.integrador.service;

import com.example.integrador.exceptions.PacienteNotFound;
import com.example.integrador.model.Odontologo;
import com.example.integrador.model.Paciente;
import com.example.integrador.repository.OdontologoRepository;
import com.example.integrador.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PacienteService {

    @Autowired
    private final PacienteRepository pacienteRepository;

    public Paciente save(Paciente p) {
        return pacienteRepository.save(p);};

    public void delete(Long id){pacienteRepository.deleteById(id);}


    public Paciente update(Paciente p){

        pacienteRepository.deleteById(p.getId());
        pacienteRepository.save(p);
        return p;
    }
    public Optional<Paciente> findBy(Long id){return pacienteRepository.findById(id);}

    public List<Paciente> findAll(){return pacienteRepository.findAll();}

}
