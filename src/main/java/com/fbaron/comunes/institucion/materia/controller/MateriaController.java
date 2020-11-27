package com.fbaron.comunes.institucion.materia.controller;

import java.util.List;

import com.fbaron.comunes.institucion.materia.dto.MateriaDto;
import com.fbaron.comunes.institucion.materia.service.MateriaService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    public static Log LOG = LogFactory.getLog(MateriaController.class);

    @Autowired
    @Qualifier("materiaServiceImpl")
    private MateriaService materiaService;

    @GetMapping
    public List<MateriaDto> getAll() {
        return materiaService.getAll();
    }

    @GetMapping("/page")
    public Object getPage(@RequestParam int page, @RequestParam int size, @RequestParam Direction direction,
            @RequestParam String properties) {
        return materiaService.getPage(page, size, direction, properties);
    }

    @GetMapping("/{id}")
    public List<MateriaDto> getById(@PathVariable long id) {
        return materiaService.getById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object add(@RequestBody @Validated MateriaDto materiaDto) {
        return materiaService.add(materiaDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object update(@PathVariable long id, @RequestBody @Validated MateriaDto materiaDto) {
        return materiaService.update(materiaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        materiaService.remove(id);
    }

}
