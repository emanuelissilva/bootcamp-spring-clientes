package com.bootcamp.clientesLoja.repositories;

import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.*;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryJsonImpl implements IClienteRepository{
    @Override
    public Cliente findById(Integer id) {
        List<Cliente> clientes = loadClientesDatabase();
        Optional<Cliente> result = clientes.stream().filter(c -> c.getId().equals(id)).findFirst();

        return result.get();
    }

    @Override
    public Cliente save(Cliente cliente) {
        List<Cliente> clientes = loadClientesDatabase();
        clientes.add(cliente);
        updateClientesDatabase(clientes);

        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {
        List<Cliente> clientes = loadClientesDatabase();

        for(int i = 0; i < clientes.size(); i++) {
            if(cliente.getId().equals(clientes.get(i).getId())) {
                clientes.remove(i);
                clientes.add(cliente);
            }
        }

        updateClientesDatabase(clientes);
        return cliente;
    }

    @Override
    public void delete(Integer idCliente) {
        List<Cliente> clientes = loadClientesDatabase();

        for(int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getId().equals(idCliente)) {
                clientes.remove(i);
            }
        }

        updateClientesDatabase(clientes);
    }

    @Override
    public Pedido addPedido(Integer idCliente, Pedido pedido) {
        List<Cliente> clientes = loadClientesDatabase();

        Cliente cliente = findById(idCliente);
        cliente.addPedido(pedido);
        update(cliente);

        return pedido;
    }

    @Override
    public List<Pedido> findPedidosById(Integer id) {
        Cliente cliente = findById(id);

        return cliente.getPedidos();
    }

    private List<Cliente> loadClientesDatabase() {
        File file = null;
        try{ file = ResourceUtils.getFile("./src/main/resources/clientes.json"); }
        catch (FileNotFoundException e){ e.printStackTrace(); }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Cliente>> typeReference = new TypeReference<>() {};
        List<Cliente> clientes = null;

        try { clientes = objectMapper.readValue(file, typeReference); }
        catch (IOException e) { e.printStackTrace(); }

        return clientes;
    }

    private void updateClientesDatabase(List<Cliente> clientes) {
        try {
            FileWriter file = new FileWriter("./src/main/resources/clientes.json");
            ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();
            writer.writeValue(file, clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
