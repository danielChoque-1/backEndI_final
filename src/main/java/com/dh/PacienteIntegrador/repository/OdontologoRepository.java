package com.dh.PacienteIntegrador.repository;
import com.dh.PacienteIntegrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

}
