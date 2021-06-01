package com.example.projeto.Produto.repository;

import com.example.projeto.Produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNameContaining(String name);
}
