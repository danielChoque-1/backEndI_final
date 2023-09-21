package com.dh.PacienteIntegrador.model;

//1 model 4
//2 repository 3
//3 service 2
//4 controller 1

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


@Table (name = "domicilio_pacientes")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

}

