package com.bootcamp.clientesLoja.repositories;

import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;
import java.util.List;

public interface IClienteRepository {
    Cliente findById(Integer id);

    Cliente save(Cliente cliente);

    Cliente update(Cliente cliente);

    void delete(Integer idCliente);

    Pedido addPedido(Integer idCliente, Pedido pedido);

    List<Pedido> findPedidosById(Integer id);
}
