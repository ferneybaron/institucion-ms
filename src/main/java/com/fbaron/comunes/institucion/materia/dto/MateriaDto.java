package com.fbaron.comunes.institucion.materia.dto;

import lombok.Data;

@Data
public class MateriaDto {

    private long id;
    private String nombre;
    private int intensidadHoraria;
    private long gradoId;

}
