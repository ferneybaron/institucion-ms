package com.fbaron.comunes.institucion.grado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fbaron.comunes.institucion.config.Auditable;

import lombok.Data;

@Entity
@Table(name = "grado")
@Data
public class Grado extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nombre", unique = true)
    private String nombre;

    @Column(name = "edad_inicial")
    private int edadInicial;

    @Column(name = "edad_final")
    private int edadFinal;

    @Column(name = "nivel_id")
    private int nivelId;

}
