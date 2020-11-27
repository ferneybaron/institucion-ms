package com.fbaron.comunes.institucion.nivel.repo;

import java.util.Optional;

import com.fbaron.comunes.institucion.nivel.model.Nivel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("nivelRepository")
public interface NivelRepository extends JpaRepository<Nivel, Long> {

    // Optional<Nivel> findByNombre(String nombre);

}
