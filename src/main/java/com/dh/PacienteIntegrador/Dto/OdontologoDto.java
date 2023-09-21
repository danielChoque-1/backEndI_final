package com.dh.PacienteIntegrador.Dto;

import com.dh.PacienteIntegrador.model.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDto {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;

}
