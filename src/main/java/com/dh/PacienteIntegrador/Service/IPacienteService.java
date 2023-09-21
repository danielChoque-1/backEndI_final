package com.dh.PacienteIntegrador.Service;
import com.dh.PacienteIntegrador.Dto.PacienteDto;
import com.dh.PacienteIntegrador.exceptions.PacienteBusinnesException;
import java.util.Collection;

public interface IPacienteService {

    void  agregarPaciente(PacienteDto p) throws PacienteBusinnesException;

    Collection<PacienteDto> listarPaciente();

    void modificarPaciente(PacienteDto p) throws PacienteBusinnesException;

    PacienteDto buscarPacientePorId(Long id) throws PacienteBusinnesException;

    void eliminarPaciente(Long id) throws PacienteBusinnesException;

}
