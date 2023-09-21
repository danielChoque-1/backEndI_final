package com.dh.PacienteIntegrador.Controller;
import com.dh.PacienteIntegrador.Dto.PacienteDto;
import com.dh.PacienteIntegrador.Service.IPacienteService;
import com.dh.PacienteIntegrador.exceptions.PacienteBusinnesException;
import com.dh.PacienteIntegrador.model.Paciente;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    private static final Logger LOGGER = Logger.getLogger(PacienteController.class);

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> agregarPaciente(@RequestBody PacienteDto pDto) {

        ResponseEntity <?> respuesta;

        try {
            pacienteService.agregarPaciente(pDto);
            respuesta = ResponseEntity.ok().body("Paciente creado");

        } catch (PacienteBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            respuesta = ResponseEntity.internalServerError().body(e.getMessage());
        }
        return respuesta;
    }

    @GetMapping
    public Collection<PacienteDto> listarPaciente() {
        return pacienteService.listarPaciente();
    }


    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDto pDto) {

        ResponseEntity <?> respuesta;

        try {
            pacienteService.modificarPaciente(pDto);
            respuesta = ResponseEntity.ok().body("Paciente modificado");

        } catch (PacienteBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            respuesta = ResponseEntity.internalServerError().body(e.getMessage());
        }

        return respuesta;

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPacientePorId(@PathVariable Long id) {

        ResponseEntity <?> respuesta;

        try {
            PacienteDto pDto = pacienteService.buscarPacientePorId(id);
            respuesta = ResponseEntity.ok().body(pDto);

        } catch (PacienteBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body("No se encontro el paciente ingrese un id correcto");
        }

        return respuesta;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPacientePorId(@PathVariable Long id) {

        ResponseEntity <?> respuesta;

        try {
            pacienteService.eliminarPaciente(id);
            respuesta = ResponseEntity.ok().body("Paciente eliminado");

        } catch (PacienteBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            respuesta = ResponseEntity.internalServerError().body(e.getMessage());
        }

        return respuesta;
    }


}










