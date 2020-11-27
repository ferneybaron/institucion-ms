package com.fbaron.comunes.institucion.materia.repo;

import java.util.Optional;

import com.fbaron.comunes.institucion.materia.model.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("materiaRepository")
public interface MateriaRepository extends JpaRepository<Materia, Long> {

    // Optional<Materia> findByNombre(String nombre);

}
