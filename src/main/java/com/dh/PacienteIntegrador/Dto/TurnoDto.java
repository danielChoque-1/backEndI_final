package com.dh.PacienteIntegrador.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDto {

    private Long id;
    private OdontologoDto odontologo;
    private PacienteDto paciente;
    private Date fecha;

}
