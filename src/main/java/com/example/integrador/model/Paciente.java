package com.example.integrador.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(
        name="paciente",
        uniqueConstraints = {
                @UniqueConstraint(name="dni_constraint",columnNames = "dni")
        }
)
@Getter
@Setter
@AllArgsConstructor
public class Paciente {

    @Id
    @SequenceGenerator(
            name="paciente_sequence",
            sequenceName = "paciente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "paciente_sequence"
    )
    @Column(
            updatable = false,
            name="id"
    )
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
    private String dni;
    @Column(
            nullable = false
    )
    private String domicilio;
    @Column(
            nullable = false
    )
    private LocalDate alta;

    public Paciente(){};

    public Paciente(String apellido, String nombre, String dni, String domicilio, LocalDate alta) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio=domicilio;
        this.alta = alta;
    }
}
