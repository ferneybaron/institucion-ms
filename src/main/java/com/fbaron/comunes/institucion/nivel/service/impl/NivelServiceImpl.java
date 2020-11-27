package com.fbaron.comunes.institucion.nivel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fbaron.comunes.institucion.nivel.component.NivelConverter;
import com.fbaron.comunes.institucion.nivel.dto.NivelDto;
import com.fbaron.comunes.institucion.nivel.model.Nivel;
import com.fbaron.comunes.institucion.nivel.repo.NivelRepository;
import com.fbaron.comunes.institucion.nivel.service.NivelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service("nivelServiceImpl")
public class NivelServiceImpl implements NivelService {

    @Autowired
    @Qualifier("nivelRepository")
    private NivelRepository nivelRepository;

    @Autowired
    @Qualifier("nivelConverter")
    private NivelConverter nivelConverter;

    @Override
    public List<NivelDto> getAll() {
        List<Nivel> niveles = nivelRepository.findAll();
        return nivelConverter.modelListToDtoList(niveles);
    }

    @Override
    public Page<NivelDto> getPage(int page, int size, Direction direction, String properties) {
        Pageable pageRequest = PageRequest.of(page, size, direction, properties);
        Page<Nivel> niveles = nivelRepository.findAll(pageRequest);
        return nivelConverter.modelPageToDtoPage(niveles);
    }

    @Override
    public List<NivelDto> getById(long id) {
        Optional<Nivel> nivel = nivelRepository.findById(id);
        if (nivel.isPresent()) {
            List<NivelDto> nivelesDto = new ArrayList<>();
            nivelesDto.add(nivelConverter.modelOptionalToDtoOptional(nivel));
            return nivelesDto;
        }
        return new ArrayList<>();
    }

    @Override
    public NivelDto add(NivelDto nivelDto) {
        return nivelConverter.modelToDto(nivelRepository.save(nivelConverter.dtoToModel(nivelDto)));
    }

    @Override
    public NivelDto update(NivelDto nivelDto) {
        Optional<Nivel> nivelOpt = nivelRepository.findById(nivelDto.getId());
        if (nivelOpt.isPresent()) {
            Nivel nivel = nivelConverter.dtoToModel(nivelDto);
            nivel.setCreatedBy(nivelOpt.get().getCreatedBy());
            nivel.setCreatedDate(nivelOpt.get().getCreatedDate());
            return nivelConverter.modelToDto(nivelRepository.save(nivel));
        }
        return null;
    }

    @Override
    public void remove(long id) {
        nivelRepository.deleteById(id);
    }

}
