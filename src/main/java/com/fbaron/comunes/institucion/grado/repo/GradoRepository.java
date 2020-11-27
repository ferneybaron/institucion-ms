package com.fbaron.comunes.institucion.grado.repo;

import java.util.Optional;

import com.fbaron.comunes.institucion.grado.model.Grado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("gradoRepository")
public interface GradoRepository extends JpaRepository<Grado, Long> {

    // Optional<Grado> findByNombre(String nombre);

}
