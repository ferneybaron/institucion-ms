package com.fbaron.comunes.institucion.grado.dto;

import lombok.Data;

@Data
public class GradoDto {

    private long id;
    private String nombre;
    private int edadInicial;
    private int edadFinal;
    private int nivelId;

}
