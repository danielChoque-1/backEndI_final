package com.dh.PacienteIntegrador.Service;
import com.dh.PacienteIntegrador.Dto.TurnoDto;
import com.dh.PacienteIntegrador.exceptions.TurnoBusinnesException;
import com.dh.PacienteIntegrador.model.Turno;
import com.dh.PacienteIntegrador.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    TurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void agregarTurno(TurnoDto t) throws TurnoBusinnesException {

        Turno turno = mapper.convertValue(t, Turno.class);

        if(turno.getFecha() == null) {
            throw new TurnoBusinnesException("Fecha invalida");
        }

        if (turno.getOdontologo() == null) {
            throw  new TurnoBusinnesException("Ingrese id Odontologo");
        }
        if(turno.getPaciente() == null) {
            throw new TurnoBusinnesException("Ingrese id Paciente");
        }

        turnoRepository.save(turno);
    }


    @Override
    public Collection<TurnoDto> listarTurno() {

        List<Turno> listarTurnos = turnoRepository.findAll();
        Set<TurnoDto> listarTurnosDto = new HashSet<>();

        for(Turno turno: listarTurnos)
            listarTurnosDto.add(mapper.convertValue(turno, TurnoDto.class));

        return listarTurnosDto;
    }




    @Override
    public void modificarTurno(TurnoDto t) throws TurnoBusinnesException {

        Turno turno = mapper.convertValue(t, Turno.class);

        if(turno.getFecha() == null) {
            throw new TurnoBusinnesException("Fecha invalida");
        }
        if (turno.getOdontologo() == null) {
            throw  new TurnoBusinnesException("Ingrese id Odontologo");
        }
        if(turno.getPaciente() == null) {
            throw new TurnoBusinnesException("Ingrese id Paciente");
        }

        turnoRepository.save(turno);
    }

    @Override
    public TurnoDto buscarTurnoPorId(Long id) throws TurnoBusinnesException {

        Optional<Turno> turno = turnoRepository.findById(id);

        if (turno.isPresent()) {
            return mapper.convertValue(turno, TurnoDto.class);
        } else
            throw new TurnoBusinnesException("No se encontro el turno ingrese un id correcto");

    }

    @Override
    public void eliminarTurno(Long id) throws TurnoBusinnesException {

        Optional <Turno> turno = turnoRepository.findById(id);

        if (turno.isPresent()) {
            turnoRepository.deleteById(id);
        } else {
            throw new TurnoBusinnesException("El turno no existe ingrese un id correcto");
        }

        turnoRepository.deleteById(id);
    }



}











