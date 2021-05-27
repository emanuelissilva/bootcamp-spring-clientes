package com.bootcamp.clientesLoja.dtos;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
    private int id;
    private List<ProdutoDTO> produtoDTOS = new ArrayList<>();
    private double valorTotal;


    public PedidoDTO(int id, List<ProdutoDTO> produtoDTOS, double valorTotal) {
        this.id = id;
        this.produtoDTOS = produtoDTOS;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtoDTOS;
    }


    public double getValorTotal() {
        double soma = 0;

        for(ProdutoDTO produtoDTO : produtoDTOS) {
            soma += (produtoDTO.getPreco()* produtoDTO.getQuantidade());
        }
        return soma;
    }


}
