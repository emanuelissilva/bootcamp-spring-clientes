package com.bootcamp.clientesLoja.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private Long telefone;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(Integer id, String nome, String cpf, String email, Long telefone, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidos = pedidos;
    }

    public Cliente(Integer id, String nome, String cpf, String email, Long telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente() {

    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Integer getId() {
        return id;
    }
}

