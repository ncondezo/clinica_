package com.example.integrador.service;

import com.example.integrador.model.Odontologo;
import com.example.integrador.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OdontologoService {

    @Autowired
    private final OdontologoRepository odontologoRepository;

    public Odontologo save(Odontologo o){return odontologoRepository.save(o);};

    public void delete(Long id){odontologoRepository.deleteById(id);}


    public Odontologo update(Odontologo o){

        odontologoRepository.deleteById(o.getId());
        odontologoRepository.save(o);
        return o;
    }
    public Optional<Odontologo>findBy(Long id){return odontologoRepository.findById(id);}

    public List<Odontologo> findAll(){return odontologoRepository.findAll();}

}
