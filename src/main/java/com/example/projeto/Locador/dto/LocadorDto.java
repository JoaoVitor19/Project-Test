package com.example.projeto.Locador.dto;

import com.example.projeto.Locador.model.Locador;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class LocadorDto {

    private Long id;
    private String name;
    private Double CPF;
    private String email;

    public static LocadorDto from(Locador locador) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(locador, LocadorDto.class);
    }

    public LocadorDto(String name, Double CPF, String email) {
        this.name = name;
        this.CPF = CPF;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCPF() {
        return CPF;
    }

    public void setCPF(Double CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
