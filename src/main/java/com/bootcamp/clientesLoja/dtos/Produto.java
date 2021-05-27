package com.bootcamp.clientesLoja.dtos;

public class Produto {
    private int id;
    private String descricao;
    private String cor;
    private int quantidade;
    private Double preco;

    public Produto(int id, String descricao, String cor, int quantidade, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.cor = cor;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCor() {
        return cor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }
}
