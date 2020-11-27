package com.fbaron.comunes.institucion.materia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fbaron.comunes.institucion.materia.component.MateriaConverter;
import com.fbaron.comunes.institucion.materia.dto.MateriaDto;
import com.fbaron.comunes.institucion.materia.model.Materia;
import com.fbaron.comunes.institucion.materia.repo.MateriaRepository;
import com.fbaron.comunes.institucion.materia.service.MateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service("materiaServiceImpl")
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    @Qualifier("materiaRepository")
    private MateriaRepository materiaRepository;

    @Autowired
    @Qualifier("materiaConverter")
    private MateriaConverter materiaConverter;

    @Override
    public List<MateriaDto> getAll() {
        List<Materia> materias = materiaRepository.findAll();
        return materiaConverter.modelListToDtoList(materias);
    }

    @Override
    public Page<MateriaDto> getPage(int page, int size, Direction direction, String properties) {
        Pageable pageRequest = PageRequest.of(page, size, direction, properties);
        Page<Materia> materias = materiaRepository.findAll(pageRequest);
        return materiaConverter.modelPageToDtoPage(materias);
    }

    @Override
    public List<MateriaDto> getById(long id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        if (materia.isPresent()) {
            List<MateriaDto> materiasDto = new ArrayList<>();
            materiasDto.add(materiaConverter.modelOptionalToDtoOptional(materia));
            return materiasDto;
        }
        return new ArrayList<>();
    }

    @Override
    public MateriaDto add(MateriaDto materiaDto) {
        return materiaConverter.modelToDto(materiaRepository.save(materiaConverter.dtoToModel(materiaDto)));
    }

    @Override
    public MateriaDto update(MateriaDto materiaDto) {
        Optional<Materia> materiaOpt = materiaRepository.findById(materiaDto.getId());
        if (materiaOpt.isPresent()) {
            Materia materia = materiaConverter.dtoToModel(materiaDto);
            materia.setCreatedBy(materiaOpt.get().getCreatedBy());
            materia.setCreatedDate(materiaOpt.get().getCreatedDate());
            return materiaConverter.modelToDto(materiaRepository.save(materia));
        }
        return null;
    }

    @Override
    public void remove(long id) {
        materiaRepository.deleteById(id);
    }

}
