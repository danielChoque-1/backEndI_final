package com.dh.PacienteIntegrador.Controller;
import com.dh.PacienteIntegrador.Dto.OdontologoDto;
import com.dh.PacienteIntegrador.Service.OdontologoService;
import com.dh.PacienteIntegrador.exceptions.OdontologoBusinnesException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collection;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class OdontologoControllerTest {

    @Mock
    OdontologoService odontologoService;

    @InjectMocks
    private OdontologoController odontologoController;

    @Test
    void agregarOdontologo() throws OdontologoBusinnesException {
        //Arrange
        doNothing().when(odontologoService).agregarOdontologo(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.agregarOdontologo(odontologoDto);

        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void agregarOdontologoBadRequest() throws OdontologoBusinnesException {
        //Arrange
        doThrow(OdontologoBusinnesException.class).when(odontologoService).agregarOdontologo(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.agregarOdontologo(odontologoDto);

        //Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void agregarOdontologoInternalServerError() throws OdontologoBusinnesException {
        //Arrange
        doThrow(DataIntegrityViolationException.class).when(odontologoService).agregarOdontologo(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.agregarOdontologo(odontologoDto);

        //Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }


    @Test
    void listarOdontologos() {
        //Arrange
        Collection <OdontologoDto> listaOdontologos = new HashSet<>();
        when(odontologoService.listarOdontologo()).thenReturn(listaOdontologos);

        //Act
        ResponseEntity <?> response = odontologoController.listarOdontologo();

        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }



    @Test
    void modificarOdontologo() throws OdontologoBusinnesException {
        //Arrange
        doNothing().when(odontologoService).modificarOdontologo(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.modificarOdontologo(odontologoDto);

        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    void modificarOdontologoBadRequest() throws OdontologoBusinnesException {
        //Arrange
        doThrow(OdontologoBusinnesException.class).when(odontologoService).modificarOdontologo(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.modificarOdontologo(odontologoDto);

        //Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void modifcarOdontologoInternalServerError() throws OdontologoBusinnesException {
        //Arrange
        doThrow(DataIntegrityViolationException.class).when(odontologoService).modificarOdontologo(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.modificarOdontologo(odontologoDto);

        //Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void buscarOdontologoPorId() throws OdontologoBusinnesException {
        //Arrange
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);
        doReturn(odontologoDto).when(odontologoService).buscarOdontologoPorId(any());

        //Act
        ResponseEntity <?> response = odontologoController.buscarOdontologoPorId(1L);

        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void buscarOdontologoPorIdBadRequest() throws OdontologoBusinnesException {
        //Arrange
        doThrow(OdontologoBusinnesException.class).when(odontologoService).buscarOdontologoPorId(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.buscarOdontologoPorId(odontologoDto.getId());

        //Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }

    @Test
    void eliminarOdontologoPorId() throws OdontologoBusinnesException {
        //Arrange
        doNothing().when(odontologoService).eliminarOdontologo(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.eliminarOdontologoPorId(odontologoDto.getId());

        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }


    @Test
    void eliminarOdontologoPorIdBadRequest() throws OdontologoBusinnesException {
        //Arrange
        doThrow(OdontologoBusinnesException.class).when(odontologoService).eliminarOdontologo(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.eliminarOdontologoPorId(odontologoDto.getId());

        //Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void eliminarOdontologoPorIdInternalServerError() throws OdontologoBusinnesException {
        //Arrange
        doThrow(DataIntegrityViolationException.class).when(odontologoService).eliminarOdontologo(any());
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        //Act
        ResponseEntity <?> response = odontologoController.eliminarOdontologoPorId(odontologoDto.getId());

        //Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

}