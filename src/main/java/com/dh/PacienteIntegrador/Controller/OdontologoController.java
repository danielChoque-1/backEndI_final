package com.dh.PacienteIntegrador.Controller;
import com.dh.PacienteIntegrador.Dto.OdontologoDto;
import com.dh.PacienteIntegrador.Service.IOdontologoService;
import com.dh.PacienteIntegrador.exceptions.OdontologoBusinnesException;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private static final Logger LOGGER = Logger.getLogger(OdontologoController.class);

    @Autowired
    private IOdontologoService odontologoService;


    @PostMapping
    public ResponseEntity<?> agregarOdontologo(@RequestBody OdontologoDto oDto) {

        ResponseEntity <?> respuesta;

        try {
            odontologoService.agregarOdontologo(oDto);
            respuesta = ResponseEntity.ok().body("Odontologo creado");

        } catch (OdontologoBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            respuesta = ResponseEntity.internalServerError().body(e.getMessage());
        }

        return respuesta;
    }


    @GetMapping
    public ResponseEntity <Collection <OdontologoDto>> listarOdontologo() {
        return ResponseEntity.ok().body(odontologoService.listarOdontologo());
    }


    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDto oDto) {

        ResponseEntity <?> respuesta ;

        try {
            odontologoService.modificarOdontologo(oDto);
            respuesta = ResponseEntity.ok().body("Odontologo modificado");

        } catch (OdontologoBusinnesException e){
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            respuesta = ResponseEntity.internalServerError().body(e.getMessage());
        }
        return respuesta;
    }



    @GetMapping("/{id}")
        public ResponseEntity<?> buscarOdontologoPorId(@PathVariable Long id) {

            ResponseEntity respuesta;

            try {
                OdontologoDto oDto = odontologoService.buscarOdontologoPorId(id);
                respuesta = ResponseEntity.ok().body(oDto);

            } catch (OdontologoBusinnesException e) {
                respuesta = ResponseEntity.badRequest().body("No se encontro el odontologo ingrese un id correcto");
            }

            return respuesta;
        }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologoPorId(@PathVariable Long id) {

        ResponseEntity <?> respuesta;

        try {
            odontologoService.eliminarOdontologo(id);
            respuesta = ResponseEntity.ok().body("Odontologo eliminado");

        } catch (OdontologoBusinnesException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            respuesta = ResponseEntity.internalServerError().body(e.getMessage());
        }

        return respuesta;
    }


}





