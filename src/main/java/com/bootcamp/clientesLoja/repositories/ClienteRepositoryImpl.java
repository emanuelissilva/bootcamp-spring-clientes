package com.bootcamp.clientesLoja.repositories;

import com.bootcamp.clientesLoja.dtos.Cliente;
import com.bootcamp.clientesLoja.dtos.Pedido;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteRepositoryImpl implements IClienteRepository{
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente encontraPorId(Integer id) {
        for (Cliente cliente: this.clientes) {
            if(cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente salva(Cliente cliente) {
       this.clientes.add(cliente);
       return cliente;
    }

    @Override
    public Pedido adicionaPedido(Integer idCliente, Pedido pedido) {
        Cliente cliente = encontraPorId(idCliente);
        cliente.addPedido(pedido);
        return pedido;
    }

    @Override
    public List<Pedido> encontraPedidosPorIdDoCliente(Integer id) {
        Cliente cliente = encontraPorId(id);

        return cliente.getPedidos();
    }
}
