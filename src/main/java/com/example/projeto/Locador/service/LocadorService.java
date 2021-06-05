package com.example.projeto.Locador.service;

import com.example.projeto.Locador.dto.LocadorDto;
import com.example.projeto.Locador.model.Locador;
import com.example.projeto.Locador.repository.LocadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocadorService {

    private LocadorRepository locadorRepository;
    private final Logger logger = LoggerFactory.getLogger(LocadorService.class);

    public List<LocadorDto> findAll(){
        List<Locador> rslocador = locadorRepository.findAll();
        return rslocador.stream().map(LocadorDto::from).collect(Collectors.toList());
    }

    public LocadorDto findById(Long id) {
        return LocadorDto.from(locadorRepository.findById(id).orElseThrow(() -> {
            logger.error("Esse Locador Já Existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }));
    }

    public LocadorDto save(LocadorDto locadorDto) {
        if (locadorRepository.findByNameContaining(locadorDto.getName()).isPresent()) {
            locadorDto.getName();
        }

        return LocadorDto.from(locadorRepository.save(new Locador(locadorDto.getName(), locadorDto.getEmail(), locadorDto.getCPF())));
    }

    public LocadorDto update(LocadorDto locadorDto, Long id) {
        Locador locador = locadorRepository.findById(id).orElseThrow(() -> {
            logger.error("Locador não encontrado", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        if (!locador.getId().equals(id)) {
            logger.error("conflito no id dos locadores", id);
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        locador.setName(locadorDto.getName());
        locador.setEmail(locadorDto.getEmail());
        locador.setCPF(locadorDto.getCPF());

        return LocadorDto.from(locadorRepository.save(locador));

    }

    public void delete(Long id) {
        Locador locador = locadorRepository.findById(id).orElseThrow(() -> {
            logger.error("ID não encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        locadorRepository.delete(locador);
    }
}

