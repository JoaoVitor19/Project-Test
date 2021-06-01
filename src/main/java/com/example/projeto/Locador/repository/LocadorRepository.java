package com.example.projeto.Locador.repository;

import com.example.projeto.Locador.model.Locador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocadorRepository extends JpaRepository<Locador, Long> {
    Optional<Locador> findByNameContaining(String name);
}
