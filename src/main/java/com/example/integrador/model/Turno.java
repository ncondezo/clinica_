package com.example.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table
@Getter
@Setter
public class Turno {

    @Id
    @SequenceGenerator(
            name="turno_sequence",
            sequenceName="turno_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "turno_sequence"
    )
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="odontologo_id")
    private Odontologo odontologo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private  Paciente paciente;
    @Column(nullable = false)
    private LocalDateTime fecha;

    public Turno(){};

    public Turno(Odontologo odontologo, Paciente paciente, LocalDateTime fecha) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }
}
