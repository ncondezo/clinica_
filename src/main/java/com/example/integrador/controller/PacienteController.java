package com.example.integrador.controller;

import com.example.integrador.exceptions.PacienteNotFound;
import com.example.integrador.model.Odontologo;
import com.example.integrador.model.Paciente;
import com.example.integrador.service.OdontologoService;
import com.example.integrador.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping(path="/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public Paciente register(@RequestBody Paciente p){return pacienteService.save(p);}

    @DeleteMapping(path="{id}")
    public void delete(@PathVariable Long id){pacienteService.delete(id);}

    @PutMapping
    public Paciente update(@RequestBody Paciente p){return pacienteService.update(p);}

    @GetMapping("/{id}")
    public Optional<Paciente> findBy(@PathVariable Long id){return pacienteService.findBy(id);

    }

    @GetMapping
    @ResponseBody
    public List<Paciente> findAll(){return pacienteService.findAll();}


}


