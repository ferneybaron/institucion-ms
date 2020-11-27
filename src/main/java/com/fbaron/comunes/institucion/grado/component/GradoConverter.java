package com.fbaron.comunes.institucion.grado.component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fbaron.comunes.institucion.grado.dto.GradoDto;
import com.fbaron.comunes.institucion.grado.model.Grado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component("gradoConverter")
public class GradoConverter {

    // Model --> Dto
    public GradoDto modelToDto(Grado grado) {
        GradoDto gradoDto = new GradoDto();
        gradoDto.setId(grado.getId());
        gradoDto.setNombre(grado.getNombre());
        gradoDto.setEdadInicial(grado.getEdadInicial());
        gradoDto.setEdadFinal(grado.getEdadFinal());
        gradoDto.setNivelId(grado.getNivelId());
        return gradoDto;
    }

    // ModelOptional --> DtoOptional
    public GradoDto modelOptionalToDtoOptional(Optional<Grado> grado) {
        if (grado.isPresent()) {
            GradoDto gradoDto = new GradoDto();
            gradoDto.setId(grado.get().getId());
            gradoDto.setNombre(grado.get().getNombre());
            gradoDto.setEdadInicial(grado.get().getEdadInicial());
            gradoDto.setEdadFinal(grado.get().getEdadFinal());
            gradoDto.setNivelId(grado.get().getNivelId());
            return gradoDto;
        }
        return null;
    }

    // Dto --> Model
    public Grado dtoToModel(GradoDto gradoDto) {
        Grado grado = new Grado();
        grado.setId(gradoDto.getId());
        grado.setNombre(gradoDto.getNombre());
        grado.setEdadInicial(gradoDto.getEdadInicial());
        grado.setEdadFinal(gradoDto.getEdadFinal());
        grado.setNivelId(gradoDto.getNivelId());
        return grado;
    }

    // List Model --> List Dto
    public List<GradoDto> modelListToDtoList(List<Grado> grados) {
        return grados.stream().map(grado -> modelToDto(grado)).collect(Collectors.toList());
    }

    // Dto --> Model
    public List<Grado> dtoListToModelList(List<GradoDto> gradosDto) {
        return gradosDto.stream().map(gradoDto -> dtoToModel(gradoDto)).collect(Collectors.toList());
    }

    // Page Model --> Page Dto
    public Page<GradoDto> modelPageToDtoPage(Page<Grado> grados) {
        return new PageImpl<>(grados.stream().map(grado -> modelToDto(grado)).collect(Collectors.toList()),
                grados.getPageable(), grados.getTotalElements());
    }

}
