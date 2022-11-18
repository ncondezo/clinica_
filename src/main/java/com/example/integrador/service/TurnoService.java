package com.example.integrador.service;

import com.example.integrador.exceptions.OdontologoNotFound;
import com.example.integrador.exceptions.PacienteNotFound;
import com.example.integrador.model.Paciente;
import com.example.integrador.model.Turno;
import com.example.integrador.repository.OdontologoRepository;
import com.example.integrador.repository.PacienteRepository;
import com.example.integrador.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TurnoService {

    @Autowired
    private final TurnoRepository turnoRepository;
    @Autowired
    private final PacienteRepository pacienteRepository;
    @Autowired
    private final OdontologoRepository odontologoRepository;

    public Turno save(Turno t)throws OdontologoNotFound, PacienteNotFound {

        var odontologo=odontologoRepository.findById(t.getOdontologo().getId()).orElseThrow(OdontologoNotFound::new);
        var paciente=pacienteRepository.findById(t.getPaciente().getId()).orElseThrow(PacienteNotFound::new);
        var validTurno=new Turno(odontologo,paciente,t.getFecha());
        return turnoRepository.save(validTurno);};

    public void delete(Long id){turnoRepository.deleteById(id);}


    public Turno update(Turno t){

        turnoRepository.deleteById(t.getId());
        turnoRepository.save(t);
        return t;
    }
    public Optional<Turno> findBy(Long id){return turnoRepository.findById(id);}

    public List<Turno> findAll(){return turnoRepository.findAll();}

}
