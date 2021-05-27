package com.bootcamp.clientesLoja.dtos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private List<Produto> produtos = new ArrayList<>();
    private double valorTotal;


    public Pedido(int id, List<Produto> produtos, double valorTotal) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }


    public double getValorTotal() {
        double soma = 0;

        for(Produto produto : produtos) {
            soma += (produto.getPreco()* produto.getQuantidade());
        }
        return soma;
    }


}
