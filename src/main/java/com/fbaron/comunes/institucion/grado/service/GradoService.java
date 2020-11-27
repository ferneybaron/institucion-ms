package com.fbaron.comunes.institucion.grado.service;

import java.util.List;

import com.fbaron.comunes.institucion.grado.dto.GradoDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface GradoService {

    public abstract List<GradoDto> getAll();

    public abstract Page<GradoDto> getPage(int page, int size, Direction direction, String properties);

    public abstract List<GradoDto> getById(long id);

    public abstract GradoDto add(GradoDto gradoDto);

    public abstract GradoDto update(GradoDto gradoDto);

    public abstract void remove(long id);

}
