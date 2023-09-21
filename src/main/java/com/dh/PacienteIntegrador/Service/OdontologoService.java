package com.dh.PacienteIntegrador.Service;
import com.dh.PacienteIntegrador.Dto.OdontologoDto;
import com.dh.PacienteIntegrador.exceptions.OdontologoBusinnesException;
import com.dh.PacienteIntegrador.model.Odontologo;
import com.dh.PacienteIntegrador.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void  agregarOdontologo(OdontologoDto o) throws OdontologoBusinnesException {

        Odontologo odontologo = mapper.convertValue(o, Odontologo.class);
        //validaciones

        if (odontologo.getNombre().equals(" ") || odontologo.getNombre() == null || odontologo.getNombre().length() >= 20 || odontologo.getNombre().length() == 0) {
            throw new OdontologoBusinnesException("Ingrese el nombre nuevamente");
        }
        if (odontologo.getApellido().equals(" ") || odontologo.getApellido() == null || odontologo.getApellido().length() >= 20 || odontologo.getApellido().length() == 0) {
            throw new OdontologoBusinnesException("Ingrese el apellido nuevamente");
        }
        if (odontologo.getMatricula() == null || odontologo.getMatricula() == 0) {
            throw new OdontologoBusinnesException("Ingrese matricula nuevamente");
        }

        odontologoRepository.save(odontologo);

    }


    @Override
    public Collection<OdontologoDto> listarOdontologo() {

        List<Odontologo> listaOdontologos = odontologoRepository.findAll();
        Set<OdontologoDto> listarOdontologosDto = new HashSet<>();

        for(Odontologo o: listaOdontologos)
            listarOdontologosDto.add(mapper.convertValue(o, OdontologoDto.class));

        return listarOdontologosDto;
    }


    @Override
    public void modificarOdontologo(OdontologoDto o) throws OdontologoBusinnesException {

        Odontologo odontologo = mapper.convertValue(o, Odontologo.class);

        if(odontologo.getId() == null || odontologo.getId() == 0){
            throw new OdontologoBusinnesException("Ingrese id nuevamente");
        }
        if (odontologo.getNombre().equals(" ") || odontologo.getNombre() == null || odontologo.getNombre().length() >= 20 || odontologo.getNombre().length() == 0) {
            throw new OdontologoBusinnesException("Ingrese el nombre nuevamente");
        }
        if (odontologo.getApellido().equals(" ") || odontologo.getApellido() == null || odontologo.getApellido().length() >= 20 || odontologo.getApellido().length() == 0) {
            throw new OdontologoBusinnesException("Ingrese el apellido nuevamente");
        }
        if (odontologo.getMatricula() == null || odontologo.getMatricula() == 0) {
            throw new OdontologoBusinnesException("Ingrese matricula nuevamente");
        }

        odontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDto buscarOdontologoPorId(Long id) throws OdontologoBusinnesException {

        Optional<Odontologo> odontologo = odontologoRepository.findById(id);

        if(odontologo.isPresent()) {
            return mapper.convertValue(odontologo, OdontologoDto.class);
        } else
            throw new OdontologoBusinnesException("No se encontro el odontologo ingrese un id correcto");
    }


    @Override
    public void eliminarOdontologo(Long id) throws OdontologoBusinnesException {
        Optional <Odontologo> odontologo = odontologoRepository.findById(id);

        if(odontologo.isPresent()){
            odontologoRepository.deleteById(id);
        } else {
            throw new OdontologoBusinnesException("El odontologo no existe ingrese un id correcto");
        }

    }


}

