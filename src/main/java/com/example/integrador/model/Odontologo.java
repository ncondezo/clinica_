package com.example.integrador.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(
        name="odontologo",
        uniqueConstraints = {
        @UniqueConstraint(name = "matricula_constraint",columnNames = "matricula")
        })
@Getter
@Setter
@AllArgsConstructor
public class Odontologo {

    @Id
    @SequenceGenerator(
            name="odontologo_sequence",
            sequenceName = "odontologo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "odontologo_sequence"
    )
    @Column(name="id")
    private Long id;
    @Column(
            nullable = false
    )
    private String apellido;
    @Column(
            nullable = false
    )
    private String nombre;
    @Column(
            nullable = false
    )
    private String matricula;

    public Odontologo(){};
    public Odontologo(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }


}
