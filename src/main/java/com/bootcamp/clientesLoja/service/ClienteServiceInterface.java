package com.bootcamp.clientesLoja.service;

import com.bootcamp.clientesLoja.controller.dtos.PedidoDTO;
import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;

import java.util.List;

public interface ClienteServiceInterface {
    public Cliente salvaCliente(Cliente cliente);

    public Cliente getClienteById(Integer id);

    public List<Pedido> getPedidos(Integer id);

    public Pedido inserePedido(PedidoDTO pedidoDTO);
}
