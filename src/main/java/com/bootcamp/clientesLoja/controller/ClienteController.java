package com.bootcamp.clientesLoja.controller;

import com.bootcamp.clientesLoja.controller.dtos.PedidoDTO;
import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.domain.Pedido;
import com.bootcamp.clientesLoja.service.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private ClienteServiceImpl clienteServiceImpl;

    public ClienteController(ClienteServiceImpl clienteServiceImpl) {
        this.clienteServiceImpl = clienteServiceImpl;
    }

    @PostMapping
    ResponseEntity insereCliente(@RequestBody Cliente cliente) {

        return new ResponseEntity(clienteServiceImpl.salvaCliente(cliente), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity getCliente(@RequestParam Integer id) {
        Cliente cliente = clienteServiceImpl.getClienteById(id);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @PostMapping("/pedido")
    ResponseEntity inserePedidoPorClienteId (@RequestBody PedidoDTO pedidoDTO) {

        return new ResponseEntity(clienteServiceImpl.inserePedido(pedidoDTO), HttpStatus.OK);
    }

    @GetMapping("/pedido")
    ResponseEntity getPedidosPorClienteId(@RequestParam Integer id) {

        return new ResponseEntity(clienteServiceImpl.getPedidos(id), HttpStatus.OK);
    }

}
