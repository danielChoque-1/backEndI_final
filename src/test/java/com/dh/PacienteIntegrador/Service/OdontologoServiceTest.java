package com.dh.PacienteIntegrador.Service;
import com.dh.PacienteIntegrador.Dto.OdontologoDto;
import com.dh.PacienteIntegrador.exceptions.OdontologoBusinnesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    IOdontologoService iOdontologoService;

    @Test
    void agregarOdontologo()  {
        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        Assertions.assertDoesNotThrow(()-> {
            iOdontologoService.agregarOdontologo(odontologoDto);
        });
    }

    @Test
    void listarOdontologo() {
        Collection <OdontologoDto> listaOdontologos = iOdontologoService.listarOdontologo();

        Collection <OdontologoDto> listaOdontologosEsperada = new HashSet<>();

        Assertions.assertEquals(listaOdontologosEsperada, listaOdontologos);
    }

    @Test
    void modificarOdontologo() {

        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        Assertions.assertDoesNotThrow(()-> {
            iOdontologoService.modificarOdontologo(odontologoDto);
        });
    }

    @Test
    void buscarOdontologoPorId() throws OdontologoBusinnesException {

        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        iOdontologoService.agregarOdontologo(odontologoDto);

        Assertions.assertDoesNotThrow(()-> {
            iOdontologoService.buscarOdontologoPorId(1L);
        });
    }

    @Test
    void eliminarOdontologo() throws OdontologoBusinnesException {

        OdontologoDto odontologoDto = new OdontologoDto(1L, "dani", "choque", 1234);

        iOdontologoService.agregarOdontologo(odontologoDto);

        Assertions.assertDoesNotThrow(()-> {
            iOdontologoService.eliminarOdontologo(1L);
        });
    }

}


