package com.dh.PacienteIntegrador.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDto {
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
}
