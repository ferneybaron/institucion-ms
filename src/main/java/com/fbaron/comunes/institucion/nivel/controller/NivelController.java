package com.fbaron.comunes.institucion.nivel.controller;

import java.util.List;

import com.fbaron.comunes.institucion.nivel.dto.NivelDto;
import com.fbaron.comunes.institucion.nivel.service.NivelService;

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
@RequestMapping("/niveles")
public class NivelController {

    public static Log LOG = LogFactory.getLog(NivelController.class);

    @Autowired
    @Qualifier("nivelServiceImpl")
    private NivelService nivelService;

    @GetMapping
    public List<NivelDto> getAll() {
        return nivelService.getAll();
    }

    @GetMapping("/page")
    public Object getPage(@RequestParam int page, @RequestParam int size, @RequestParam Direction direction,
            @RequestParam String properties) {
        return nivelService.getPage(page, size, direction, properties);
    }

    @GetMapping("/{id}")
    public List<NivelDto> getById(@PathVariable long id) {
        return nivelService.getById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object add(@RequestBody @Validated NivelDto nivelDto) {
        return nivelService.add(nivelDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object update(@PathVariable long id, @RequestBody @Validated NivelDto nivelDto) {
        return nivelService.update(nivelDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        nivelService.remove(id);
    }

}
