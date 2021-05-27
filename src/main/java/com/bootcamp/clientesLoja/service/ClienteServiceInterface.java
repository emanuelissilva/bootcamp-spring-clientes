package com.bootcamp.clientesLoja.service;

import com.bootcamp.clientesLoja.dtos.Cliente;
import com.bootcamp.clientesLoja.dtos.Pedido;
import com.bootcamp.clientesLoja.repositories.IClienteRepository;

import java.util.List;

public interface ClienteServiceInterface {
    public Cliente salvaCliente(Cliente cliente);

    public Cliente getClienteById(Integer id);

    public List<Pedido> getPedidos(Integer id);

    public Pedido inserePedido(Integer id, Pedido pedido);
}
