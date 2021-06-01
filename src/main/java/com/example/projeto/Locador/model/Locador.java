package com.example.projeto.Locador.model;


import com.example.projeto.Produto.model.Produto;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_locador")

public class Locador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double CPF;
    private String email;

    @OneToMany(mappedBy = "locador")
    List<Produto> produtos = new ArrayList<>();

    public Locador(){}

    public Locador(String name, String email, Double CPF) {
        this.name = name;
        this.email = email;
        this.CPF = CPF;
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

    public List<Produto> getProdutos() {
        return produtos;
    }
}
