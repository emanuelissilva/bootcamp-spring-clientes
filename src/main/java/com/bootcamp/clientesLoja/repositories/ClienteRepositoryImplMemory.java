//package com.bootcamp.clientesLoja.repositories;
//
//import com.bootcamp.clientesLoja.domain.Cliente;
//import com.bootcamp.clientesLoja.domain.Pedido;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class ClienteRepositoryImpl implements IClienteRepository{
//    private List<Cliente> clientes = new ArrayList<>();
//
//    @Override
//    public Cliente findById(Integer id) {
//        for (Cliente cliente: this.clientes) {
//            if(cliente.getId().equals(id)) {
//                return cliente;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Cliente save(Cliente cliente) {
//       this.clientes.add(cliente);
//       return cliente;
//    }
//
//    @Override
//    public Cliente update(Cliente cliente) {
//        return null;
//    }
//
//    @Override
//    public Cliente delete(Integer idCliente) {
//        return null;
//    }
//
//    @Override
//    public Pedido addPedido(Integer idCliente, Pedido pedido) {
//        Cliente cliente = findById(idCliente);
//        cliente.addPedido(pedido);
//        return pedido;
//    }
//
//    @Override
//    public List<Pedido> findPedidosById(Integer id) {
//        Cliente cliente = findById(id)//
//        return cliente.getPedidos();
//    }
//}
