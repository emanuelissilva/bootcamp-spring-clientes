package com.bootcamp.clientesLoja.service;

import com.bootcamp.clientesLoja.dtos.Cliente;
import com.bootcamp.clientesLoja.dtos.Pedido;
import com.bootcamp.clientesLoja.repositories.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteServiceInterface{
    private IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvaCliente(Cliente cliente) {
        return clienteRepository.salva(cliente);
    }

    public Cliente getClienteById(Integer id) {
        return clienteRepository.encontraPorId(id);
    }

    public List<Pedido> getPedidos(Integer id) {
        return clienteRepository.encontraPedidosPorIdDoCliente(id);
    }

    public Pedido inserePedido(Integer id, Pedido pedido) {
        return clienteRepository.adicionaPedido(id, pedido);
    }
}
