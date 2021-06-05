package com.example.projeto.Locador.controller;

import com.example.projeto.Locador.dto.LocadorDto;
import com.example.projeto.Locador.service.LocadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/locador")
public class LocadorController {

    @Autowired
    private LocadorService locadorService;

    @GetMapping
    private ResponseEntity<List<LocadorDto>> findAll(){
        List<LocadorDto> list = locadorService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocadorDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(locadorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<LocadorDto> create(@RequestBody @Validated LocadorDto locadorDto) {
        return ResponseEntity.ok(locadorService.save(locadorDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocadorDto> update(@PathVariable Long id, @Validated @RequestBody LocadorDto locadorDto) {
        return ResponseEntity.ok(locadorService.update(locadorDto, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        locadorService.delete(id);
    }
};
