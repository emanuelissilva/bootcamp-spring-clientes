package com.bootcamp.clientesLoja.service.impl;

import com.bootcamp.clientesLoja.controller.dtos.PedidoDTO;
import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;
import com.bootcamp.clientesLoja.repositories.IClienteRepository;
import com.bootcamp.clientesLoja.service.ClienteServiceInterface;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteServiceInterface {
    private IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvaCliente(Cliente cliente) throws IOException, ParseException {
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    public List<Pedido> getPedidos(Integer id) {
        return clienteRepository.findPedidosById(id);
    }

    public Pedido inserePedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoDTO.getPedido();
        Integer clienteId = pedidoDTO.getClienteId();
        return clienteRepository.addPedido(clienteId, pedido);
    }

    public Cliente atualizaCliente(Cliente cliente) throws IOException, ParseException {
        return clienteRepository.update(cliente);
    }

    public void deleteCliente(Integer id) throws IOException {
        clienteRepository.delete(id);
    }
}
