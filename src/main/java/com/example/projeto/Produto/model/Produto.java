package com.example.projeto.Produto.model;


import com.example.projeto.Locador.model.Locador;

import javax.persistence.*;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double value;
    private String description;
    private CategoryEnum category;


    @ManyToOne
    @JoinColumn(name = "locador_id")
    private Locador locador;

    public Produto(){}

    public Produto(String name, Double value, String description, CategoryEnum category) {
        this.name = name;
        this.value = value;
        this.description = description;
        this.category = category;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
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
}
