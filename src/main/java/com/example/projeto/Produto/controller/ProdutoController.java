package com.example.projeto.Produto.controller;


import com.example.projeto.Produto.dto.ProdutoDto;
import com.example.projeto.Produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    private ResponseEntity<List<ProdutoDto>> findAll() {
        List<ProdutoDto> productList = produtoService.findAll();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> newProduct(@RequestBody @Validated ProdutoDto produtoDto) {
        return ResponseEntity.ok(produtoService.save(produtoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> updateProduct(@PathVariable Long id, @Validated @RequestBody ProdutoDto produtoDto) {
        return ResponseEntity.ok(produtoService.update(produtoDto, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable Long id) {
        produtoService.delete(id);
    }

}
