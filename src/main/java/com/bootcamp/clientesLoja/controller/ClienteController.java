package com.bootcamp.clientesLoja.controller;

import com.bootcamp.clientesLoja.controller.dtos.PedidoDTO;
import com.bootcamp.clientesLoja.domain.Cliente;
import com.bootcamp.clientesLoja.service.ClienteServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private ClienteServiceInterface clienteService;
        
    public ClienteController(ClienteServiceInterface clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    ResponseEntity insereCliente(@RequestBody Cliente cliente) {

        return new ResponseEntity(clienteService.salvaCliente(cliente), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity getCliente(@RequestParam Integer id) {

        Cliente cliente = clienteService.getClienteById(id);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @PostMapping("/pedido")
    ResponseEntity inserePedidoPorClienteId (@RequestBody PedidoDTO pedidoDTO) {

        return new ResponseEntity(clienteService.inserePedido(pedidoDTO), HttpStatus.OK);
    }

    @GetMapping("/pedido")
    ResponseEntity getPedidosPorClienteId(@RequestParam Integer id) {

        return new ResponseEntity(clienteService.getPedidos(id), HttpStatus.OK);
    }
}
