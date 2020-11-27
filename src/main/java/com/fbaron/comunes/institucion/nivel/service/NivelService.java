package com.fbaron.comunes.institucion.nivel.service;

import java.util.List;

import com.fbaron.comunes.institucion.nivel.dto.NivelDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface NivelService {

    public abstract List<NivelDto> getAll();

    public abstract Page<NivelDto> getPage(int page, int size, Direction direction, String properties);

    public abstract List<NivelDto> getById(long id);

    public abstract NivelDto add(NivelDto nivelDto);

    public abstract NivelDto update(NivelDto nivelDto);

    public abstract void remove(long id);

}
