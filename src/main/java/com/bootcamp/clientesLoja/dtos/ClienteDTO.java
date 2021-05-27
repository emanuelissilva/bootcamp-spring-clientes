package com.bootcamp.clientesLoja.dtos;

import java.util.ArrayList;
import java.util.List;

public class ClienteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private Long telefone;
    private List<PedidoDTO> pedidoDTOS = new ArrayList<>();

    public ClienteDTO(Integer id, String nome, String cpf, String email, Long telefone, List<PedidoDTO> pedidoDTOS) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidoDTOS = pedidoDTOS;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidoDTOS;
    }
}

