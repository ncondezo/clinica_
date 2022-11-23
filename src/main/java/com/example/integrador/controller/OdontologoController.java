package com.example.integrador.controller;

import com.example.integrador.model.Odontologo;
import com.example.integrador.service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping(path="/odontologo")
public class OdontologoController {


    private final OdontologoService odontologoService;

    @PostMapping
    public Odontologo register(@RequestBody Odontologo o){return odontologoService.save(o);}

    @DeleteMapping(path="{id}")
    public void delete(@PathVariable Long id){odontologoService.delete(id);}

    @PutMapping
    public Odontologo update(@RequestBody Odontologo o){return odontologoService.update(o);}

    @GetMapping("/{id}")
    public Optional<Odontologo> findBy(@PathVariable Long id){return odontologoService.findBy(id);}

    @GetMapping
    @ResponseBody
    public List<Odontologo> findAll(){return odontologoService.findAll();}


}
