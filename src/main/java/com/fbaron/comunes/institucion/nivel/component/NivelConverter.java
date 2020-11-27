package com.fbaron.comunes.institucion.nivel.component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fbaron.comunes.institucion.nivel.dto.NivelDto;
import com.fbaron.comunes.institucion.nivel.model.Nivel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component("nivelConverter")
public class NivelConverter {

    // Model --> Dto
    public NivelDto modelToDto(Nivel nivel) {
        NivelDto nivelDto = new NivelDto();
        nivelDto.setId(nivel.getId());
        nivelDto.setNombre(nivel.getNombre());
        nivelDto.setEdadInicial(nivel.getEdadInicial());
        nivelDto.setEdadFinal(nivel.getEdadFinal());
        return nivelDto;
    }

    // ModelOptional --> DtoOptional
    public NivelDto modelOptionalToDtoOptional(Optional<Nivel> nivel) {
        if (nivel.isPresent()) {
            NivelDto nivelDto = new NivelDto();
            nivelDto.setId(nivel.get().getId());
            nivelDto.setNombre(nivel.get().getNombre());
            nivelDto.setEdadInicial(nivel.get().getEdadInicial());
            nivelDto.setEdadFinal(nivel.get().getEdadFinal());
            return nivelDto;
        }
        return null;
    }

    // Dto --> Model
    public Nivel dtoToModel(NivelDto nivelDto) {
        Nivel nivel = new Nivel();
        nivel.setId(nivelDto.getId());
        nivel.setNombre(nivelDto.getNombre());
        nivel.setEdadInicial(nivelDto.getEdadInicial());
        nivel.setEdadFinal(nivelDto.getEdadFinal());
        return nivel;
    }

    // List Model --> List Dto
    public List<NivelDto> modelListToDtoList(List<Nivel> niveles) {
        return niveles.stream().map(nivel -> modelToDto(nivel)).collect(Collectors.toList());
    }

    // Dto --> Model
    public List<Nivel> dtoListToModelList(List<NivelDto> nivelesDto) {
        return nivelesDto.stream().map(nivelDto -> dtoToModel(nivelDto)).collect(Collectors.toList());
    }

    // Page Model --> Page Dto
    public Page<NivelDto> modelPageToDtoPage(Page<Nivel> niveles) {
        return new PageImpl<>(niveles.stream().map(nivel -> modelToDto(nivel)).collect(Collectors.toList()),
                niveles.getPageable(), niveles.getTotalElements());
    }

}
