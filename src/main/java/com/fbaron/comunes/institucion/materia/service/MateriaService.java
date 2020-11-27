package com.fbaron.comunes.institucion.materia.service;

import java.util.List;

import com.fbaron.comunes.institucion.materia.dto.MateriaDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface MateriaService {

    public abstract List<MateriaDto> getAll();

    public abstract Page<MateriaDto> getPage(int page, int size, Direction direction, String properties);

    public abstract List<MateriaDto> getById(long id);

    public abstract MateriaDto add(MateriaDto materiaDto);

    public abstract MateriaDto update(MateriaDto materiaDto);

    public abstract void remove(long id);

}
