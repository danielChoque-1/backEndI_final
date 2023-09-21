package com.dh.PacienteIntegrador.Controller;
import com.dh.PacienteIntegrador.Dto.TurnoDto;
import com.dh.PacienteIntegrador.Service.ITurnoService;
import com.dh.PacienteIntegrador.exceptions.TurnoBusinnesException;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
@RequestMapping("/turnos")

public class TurnoController {

    private static final Logger LOGGER = Logger.getLogger(TurnoController.class);

    @Autowired
    private ITurnoService turnoService;


    @PostMapping
    public ResponseEntity<?> agregarTurno(@RequestBody TurnoDto tDto) {

        ResponseEntity <?> respuesta;

        try {
            turnoService.agregarTurno(tDto);
            respuesta = ResponseEntity.ok().body("Turno Creado");

        } catch (TurnoBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            respuesta = ResponseEntity.internalServerError().body(e.getMessage());
        }

        return respuesta;
    }


    @GetMapping
    public Collection<TurnoDto> listarTurno(){
        return turnoService.listarTurno();
    }


    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDto tDto) {

        ResponseEntity <?> respuesta;

        try {
            turnoService.modificarTurno(tDto);
            respuesta = ResponseEntity.ok().body("Turno modificado");

        } catch (TurnoBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            respuesta = ResponseEntity.internalServerError().body(e.getMessage());
        }

        return respuesta;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTurnoPorId(@PathVariable Long id)  {

        ResponseEntity <?> respuesta;

        try{
            TurnoDto tDto = turnoService.buscarTurnoPorId(id);
            respuesta = ResponseEntity.ok().body(tDto);
        } catch (TurnoBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body("No se encontro el turno ingrese un id correcto");
        }

        return respuesta;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurnoPorId(@PathVariable Long id) {

        ResponseEntity <?> respuesta;

        try {
            turnoService.eliminarTurno(id);
            respuesta = ResponseEntity.ok().body("Turno eliminado");

        } catch (TurnoBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            respuesta = ResponseEntity.internalServerError().body(e.getMessage());
        }

        return respuesta;
    }

}





