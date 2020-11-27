package com.fbaron.comunes.institucion.materia.component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fbaron.comunes.institucion.materia.dto.MateriaDto;
import com.fbaron.comunes.institucion.materia.model.Materia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component("materiaConverter")
public class MateriaConverter {

    // Model --> Dto
    public MateriaDto modelToDto(Materia materia) {
        MateriaDto materiaDto = new MateriaDto();
        materiaDto.setId(materia.getId());
        return materiaDto;
    }

    // ModelOptional --> DtoOptional
    public MateriaDto modelOptionalToDtoOptional(Optional<Materia> materia) {
        if (materia.isPresent()) {
            MateriaDto materiaDto = new MateriaDto();
            materiaDto.setId(materia.get().getId());
            return materiaDto;
        }
        return null;
    }

    // Dto --> Model
    public Materia dtoToModel(MateriaDto materiaDto) {
        Materia materia = new Materia();
        materia.setId(materiaDto.getId());
        return materia;
    }

    // List Model --> List Dto
    public List<MateriaDto> modelListToDtoList(List<Materia> materias) {
        return materias.stream().map(materia -> modelToDto(materia)).collect(Collectors.toList());
    }

    // Dto --> Model
    public List<Materia> dtoListToModelList(List<MateriaDto> materiasDto) {
        return materiasDto.stream().map(materiaDto -> dtoToModel(materiaDto)).collect(Collectors.toList());
    }

    // Page Model --> Page Dto
    public Page<MateriaDto> modelPageToDtoPage(Page<Materia> materias) {
        return new PageImpl<>(materias.stream().map(materia -> modelToDto(materia)).collect(Collectors.toList()),
                materias.getPageable(), materias.getTotalElements());
    }

}
