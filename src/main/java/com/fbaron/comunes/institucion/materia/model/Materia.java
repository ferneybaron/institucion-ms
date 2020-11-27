package com.fbaron.comunes.institucion.materia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fbaron.comunes.institucion.config.Auditable;

import lombok.Data;

@Entity
@Table(name = "materia")
@Data
public class Materia extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "intensidad_horaria")
    private int intensidadHoraria;

    @Column(name = "grado_id")
    private long gradoId;

}
