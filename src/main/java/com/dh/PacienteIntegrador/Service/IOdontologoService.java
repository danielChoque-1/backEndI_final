package com.dh.PacienteIntegrador.Service;
import com.dh.PacienteIntegrador.Dto.OdontologoDto;
import com.dh.PacienteIntegrador.exceptions.OdontologoBusinnesException;
import java.util.Collection;

public interface IOdontologoService {

    void  agregarOdontologo(OdontologoDto o) throws OdontologoBusinnesException;

    Collection<OdontologoDto> listarOdontologo();

    void modificarOdontologo(OdontologoDto o) throws OdontologoBusinnesException;

    OdontologoDto buscarOdontologoPorId(Long id) throws OdontologoBusinnesException;

    void eliminarOdontologo(Long id) throws OdontologoBusinnesException;

}



