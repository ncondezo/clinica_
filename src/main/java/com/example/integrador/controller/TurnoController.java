package com.example.integrador.controller;

import com.example.integrador.exceptions.OdontologoNotFound;
import com.example.integrador.exceptions.PacienteNotFound;
import com.example.integrador.model.Turno;

import com.example.integrador.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping(path="/turno")
public class TurnoController {


    private final TurnoService turnoService;

    @PostMapping
    public ResponseEntity<String>register(@RequestBody Turno t) {
        try {
            turnoService.save(t);
        } catch (OdontologoNotFound e) {
            return new ResponseEntity<>("Odontologo no encontrado.",HttpStatus.BAD_REQUEST);
        } catch (PacienteNotFound e) {
            return new ResponseEntity<>("Paciente no encontrado.",HttpStatus.BAD_REQUEST);
            //throw new RuntimeException(e);
        }
        return new ResponseEntity<>("Turno guardado.",HttpStatus.ACCEPTED);}


    @DeleteMapping(path="{id}")
    public void delete(@PathVariable Long id){turnoService.delete(id);}

    @PutMapping
    public Turno update(@RequestBody Turno t){return turnoService.update(t);}

    @GetMapping("/{id}")
    public Optional<Turno> findBy(@PathVariable Long id){return turnoService.findBy(id);}

    @GetMapping
    @ResponseBody
    public List<Turno> findAll(){return turnoService.findAll();}


}
