package com.dh.PacienteIntegrador.Dto;

import com.dh.PacienteIntegrador.model.Domicilio;
import com.dh.PacienteIntegrador.model.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDto {

    private Long id;
    private String nombre;
    private String apellido;
    //private Integer dni;
    //private Date fechaDeAlta;
    //private Domicilio domicilio;

}
