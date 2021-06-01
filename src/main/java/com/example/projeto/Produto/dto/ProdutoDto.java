package com.example.projeto.Produto.dto;

import com.example.projeto.Produto.model.CategoryEnum;
import com.example.projeto.Produto.model.Produto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


public class ProdutoDto {

    private Long id;
    private String name;
    private Double value;
    private String description;
    private CategoryEnum category;

    public static ProdutoDto from(Produto produto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(produto, ProdutoDto.class);
    }

    public ProdutoDto(Long id, String name, Double value, String description, CategoryEnum category) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.description = description;
        this.category = category;
    }

    public ProdutoDto(Produto entity) {
        id = entity.getId();
        name = entity.getName();
        value = entity.getValue();
        description = entity.getDescription();
        category = entity.getCategory();
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
