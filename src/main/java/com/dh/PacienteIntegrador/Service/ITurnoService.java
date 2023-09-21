package com.dh.PacienteIntegrador.Service;
import com.dh.PacienteIntegrador.Dto.TurnoDto;
import com.dh.PacienteIntegrador.exceptions.TurnoBusinnesException;
import java.util.Collection;

public interface ITurnoService {

    void agregarTurno (TurnoDto t) throws TurnoBusinnesException;

    Collection<TurnoDto> listarTurno();

    void modificarTurno(TurnoDto t) throws TurnoBusinnesException;

    TurnoDto buscarTurnoPorId(Long id) throws TurnoBusinnesException;

    void eliminarTurno(Long id) throws TurnoBusinnesException;

}
