package com.example.projeto.Produto.service;

import com.example.projeto.Produto.dto.ProdutoDto;
import com.example.projeto.Produto.model.Produto;
import com.example.projeto.Produto.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private final Logger logger = LoggerFactory.getLogger(ProdutoService.class);

    public List<ProdutoDto> findAll() {
        List<Produto> rsproduto = produtoRepository.findAll();
        return rsproduto.stream().map(x -> new ProdutoDto(x)).collect(Collectors.toList());
    }

    public ProdutoDto findById(Long id) {
        return ProdutoDto.from(produtoRepository.findById(id).orElseThrow(() -> {
            logger.error("Esse Produto Já Existe", id);
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }));
    }

    public ProdutoDto save(ProdutoDto produtoDto) {

        if (produtoRepository.findByNameContaining(produtoDto.getName()).isPresent()) {
            produtoDto.getName();

        }
        return ProdutoDto.from(produtoRepository.save(new Produto(produtoDto.getName(), produtoDto.getValue(), produtoDto.getDescription(), produtoDto.getCategory())));
    }

    public ProdutoDto update(ProdutoDto produtoDto, Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> {
            logger.error("Produto não encontrado", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        produto.setName(produtoDto.getName());
        produto.setValue(produtoDto.getValue());
        produto.setDescription(produtoDto.getDescription());
        produto.setCategory(produtoDto.getCategory());

        return ProdutoDto.from(produtoRepository.save(produto));

    }

    public void delete(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> {
            logger.error("Esse id não foi encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        produtoRepository.delete(produto);
    }
}
