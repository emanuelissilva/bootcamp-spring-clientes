package com.bootcamp.clientesLoja.repositories;

import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;
import java.util.Optional;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Repository
public class ClienteRepositoryImpl2 implements IClienteRepository{

    public ClienteRepositoryImpl2() throws FileNotFoundException {
    }

    JSONParser jsonParser = new JSONParser();

    @Override
    public Cliente findById(Integer id) {
        List<Cliente> clientes = null;
        clientes = loadClientesDatabase();
        Cliente result = null;
        if (clientes != null){
            Optional<Cliente> item = clientes.stream()
                    .filter(cliente -> cliente.getId().equals(id))
                    .findFirst();
            if(item.isPresent()){
                result = item.get();
            }
        }
        return result;
    }

    @Override
    public Cliente save(Cliente cliente) throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {
        };

        List<Cliente> clientes = objectMapper.readValue(ResourceUtils.getFile("classpath:clientes.json"), typeReference);
        clientes.add(cliente);

        FileWriter file = new FileWriter("./src/main/resources/clientes.json");

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, clientes);

        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {
        };

        List<Cliente> clientes = objectMapper.readValue(ResourceUtils.getFile("classpath:clientes.json"), typeReference);

        for(int i = 0; i < clientes.size(); i++) {
            if(cliente.getId().equals(clientes.get(i).getId())) {
                clientes.remove(i);
                clientes.add(cliente);
            }
        }

        FileWriter file = new FileWriter("./src/main/resources/clientes.json");

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, clientes);

        return cliente;
    }

    @Override
    public void delete(Integer idCliente) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {
        };

        List<Cliente> clientes = objectMapper.readValue(ResourceUtils.getFile("classpath:clientes.json"), typeReference);

        for(int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getId().equals(idCliente)) {
                clientes.remove(i);
            }
        }

        FileWriter file = new FileWriter("./src/main/resources/clientes.json");

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, clientes);
    }

    @Override
    public Pedido addPedido(Integer idCliente, Pedido pedido) {
        return null;
    }

    @Override
    public List<Pedido> findPedidosById(Integer id) {
        return null;
    }

    public List<Cliente> loadClientesDatabase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:clientes.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {
        };
        List<Cliente> clientes = null;
        try{
            clientes = objectMapper.readValue(file, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }
        return clientes;
    }
}
