package com.bootcamp.clientesLoja.controller.dtos;

import com.bootcamp.clientesLoja.domain.Pedido;

public class PedidoDTO {
    private Pedido pedido;
    private Integer clienteId;

    public PedidoDTO(Pedido pedido, Integer clienteId) {
        this.pedido = pedido;
        this.clienteId = clienteId;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public Integer getClienteId() {
        return clienteId;
    }
}
