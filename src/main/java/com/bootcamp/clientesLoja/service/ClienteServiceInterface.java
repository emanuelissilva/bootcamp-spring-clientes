package com.bootcamp.clientesLoja.service;

import com.bootcamp.clientesLoja.controller.dtos.PedidoDTO;
import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface ClienteServiceInterface {
    public Cliente salvaCliente(Cliente cliente) throws IOException, ParseException;

    public Cliente getClienteById(Integer id);

    public List<Pedido> getPedidos(Integer id);

    public Pedido inserePedido(PedidoDTO pedidoDTO);

    public Cliente atualizaCliente(Cliente cliente) throws IOException, ParseException;

    public void deleteCliente(Integer id) throws IOException;
}
