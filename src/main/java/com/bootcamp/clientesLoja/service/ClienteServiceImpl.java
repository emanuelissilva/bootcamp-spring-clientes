package com.bootcamp.clientesLoja.service;

import com.bootcamp.clientesLoja.controller.dtos.PedidoDTO;
import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;
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

    public Pedido inserePedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoDTO.getPedido();
        Integer clienteId = pedidoDTO.getClienteId();
        return clienteRepository.adicionaPedido(clienteId, pedido);
    }
}
