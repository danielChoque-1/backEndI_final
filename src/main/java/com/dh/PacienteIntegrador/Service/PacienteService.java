package com.dh.PacienteIntegrador.Service;
import com.dh.PacienteIntegrador.Dto.PacienteDto;
import com.dh.PacienteIntegrador.exceptions.PacienteBusinnesException;
import com.dh.PacienteIntegrador.model.Paciente;
import com.dh.PacienteIntegrador.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void agregarPaciente(PacienteDto p) throws PacienteBusinnesException {

        Paciente paciente = mapper.convertValue(p, Paciente.class);

        if (paciente.getNombre().equals(" ") || paciente.getNombre() == null || paciente.getNombre().length() >= 20 || paciente.getNombre().length() == 0) {
            throw new PacienteBusinnesException("Ingrese el nombre nuevamente");
        }
        if (paciente.getApellido().equals(" ") || paciente.getApellido() == null || paciente.getApellido().length() >= 20 || paciente.getApellido().length() == 0) {
            throw new PacienteBusinnesException("Ingrese el apellido nuevamente");
        }

        pacienteRepository.save(paciente);

    }


    @Override
    public Collection<PacienteDto> listarPaciente() {

        List<Paciente> listaPacientes = pacienteRepository.findAll();
        Set<PacienteDto> listarPacientesDto = new HashSet<>();

        for(Paciente p: listaPacientes)
            listarPacientesDto.add(mapper.convertValue(p, PacienteDto.class));

        return listarPacientesDto;
    }


    @Override
    public void modificarPaciente(PacienteDto p) throws PacienteBusinnesException {

        Paciente paciente = mapper.convertValue(p, Paciente.class);

        if (paciente.getId() == null){
            throw new PacienteBusinnesException("Ingrese id nuevamente");
        }
        if (paciente.getNombre().equals(" ") || paciente.getNombre() == null || paciente.getNombre().length() >= 20 || paciente.getNombre().length() == 0) {
            throw new PacienteBusinnesException("Ingrese el nombre nuevamente");
        }
        if (paciente.getApellido().equals(" ") || paciente.getApellido() == null || paciente.getApellido().length() >= 20 || paciente.getApellido().length() == 0) {
            throw new PacienteBusinnesException("Ingrese el apellido nuevamente");
        }

        pacienteRepository.save(paciente);
    }


    @Override
    public PacienteDto buscarPacientePorId(Long id) throws PacienteBusinnesException {

        Optional <Paciente> paciente = pacienteRepository.findById(id);

        if (paciente.isPresent()) {
            return mapper.convertValue(paciente, PacienteDto.class);
        }
        else {
            throw new PacienteBusinnesException("No se encontro el paciente ingrese un id correcto");

        }

    }


    @Override
    public void eliminarPaciente(Long id) throws PacienteBusinnesException {

        Optional <Paciente> paciente = pacienteRepository.findById(id);

        if(paciente.isPresent()) {
            pacienteRepository.deleteById(id);
        } else {
            throw new PacienteBusinnesException("El paciente no existe ingrese un id correcto");
        }

    }

}

