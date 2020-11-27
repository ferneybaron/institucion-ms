package com.fbaron.comunes.institucion.grado.controller;

import java.util.List;

import com.fbaron.comunes.institucion.grado.dto.GradoDto;
import com.fbaron.comunes.institucion.grado.service.GradoService;

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
@RequestMapping("/grados")
public class GradoController {

    public static Log LOG = LogFactory.getLog(GradoController.class);

    @Autowired
    @Qualifier("gradoServiceImpl")
    private GradoService gradoService;

    @GetMapping
    public List<GradoDto> getAll() {
        return gradoService.getAll();
    }

    @GetMapping("/page")
    public Object getPage(@RequestParam int page, @RequestParam int size, @RequestParam Direction direction,
            @RequestParam String properties) {
        return gradoService.getPage(page, size, direction, properties);
    }

    @GetMapping("/{id}")
    public List<GradoDto> getById(@PathVariable long id) {
        return gradoService.getById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object add(@RequestBody @Validated GradoDto gradoDto) {
        return gradoService.add(gradoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object update(@PathVariable long id, @RequestBody @Validated GradoDto gradoDto) {
        return gradoService.update(gradoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        gradoService.remove(id);
    }

}
