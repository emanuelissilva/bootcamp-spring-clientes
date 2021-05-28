package com.bootcamp.clientesLoja.repositories;

import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;

import java.util.List;

public interface IClienteRepository {
    Cliente encontraPorId(Integer id);

    Cliente salva(Cliente cliente);

    Pedido adicionaPedido(Integer idCliente, Pedido pedido);

    List<Pedido> encontraPedidosPorIdDoCliente(Integer id);
}
