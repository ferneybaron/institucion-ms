package com.fbaron.comunes.institucion.grado.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fbaron.comunes.institucion.grado.component.GradoConverter;
import com.fbaron.comunes.institucion.grado.dto.GradoDto;
import com.fbaron.comunes.institucion.grado.model.Grado;
import com.fbaron.comunes.institucion.grado.repo.GradoRepository;
import com.fbaron.comunes.institucion.grado.service.GradoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service("gradoServiceImpl")
public class GradoServiceImpl implements GradoService {

    @Autowired
    @Qualifier("gradoRepository")
    private GradoRepository gradoRepository;

    @Autowired
    @Qualifier("gradoConverter")
    private GradoConverter gradoConverter;

    @Override
    public List<GradoDto> getAll() {
        List<Grado> grados = gradoRepository.findAll();
        return gradoConverter.modelListToDtoList(grados);
    }

    @Override
    public Page<GradoDto> getPage(int page, int size, Direction direction, String properties) {
        Pageable pageRequest = PageRequest.of(page, size, direction, properties);
        Page<Grado> grados = gradoRepository.findAll(pageRequest);
        return gradoConverter.modelPageToDtoPage(grados);
    }

    @Override
    public List<GradoDto> getById(long id) {
        Optional<Grado> grado = gradoRepository.findById(id);
        if (grado.isPresent()) {
            List<GradoDto> gradosDto = new ArrayList<>();
            gradosDto.add(gradoConverter.modelOptionalToDtoOptional(grado));
            return gradosDto;
        }
        return new ArrayList<>();
    }

    @Override
    public GradoDto add(GradoDto gradoDto) {
        return gradoConverter.modelToDto(gradoRepository.save(gradoConverter.dtoToModel(gradoDto)));
    }

    @Override
    public GradoDto update(GradoDto gradoDto) {
        Optional<Grado> gradoOpt = gradoRepository.findById(gradoDto.getId());
        if (gradoOpt.isPresent()) {
            Grado grado = gradoConverter.dtoToModel(gradoDto);
            grado.setCreatedBy(gradoOpt.get().getCreatedBy());
            grado.setCreatedDate(gradoOpt.get().getCreatedDate());
            return gradoConverter.modelToDto(gradoRepository.save(grado));
        }
        return null;
    }

    @Override
    public void remove(long id) {
        gradoRepository.deleteById(id);
    }

}
