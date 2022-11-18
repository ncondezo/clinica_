package com.example.integrador.repository;

import com.example.integrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Long> {
    @Query(value="SELECT * FROM odontologos WHERE odontologos.matricula=?",nativeQuery = true)
    Optional<Odontologo> findByMatricula(String matricula);
}
