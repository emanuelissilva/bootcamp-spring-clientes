package com.bootcamp.clientesLoja.repositories;

import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IClienteRepository {
    Cliente findById(Integer id);

    Cliente save(Cliente cliente) throws IOException, ParseException;

    Cliente update(Cliente cliente) throws IOException, ParseException;

    void delete(Integer idCliente) throws IOException;

    Pedido addPedido(Integer idCliente, Pedido pedido);

    List<Pedido> findPedidosById(Integer id);
}
