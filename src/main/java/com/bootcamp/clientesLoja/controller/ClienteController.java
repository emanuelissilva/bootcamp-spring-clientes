package com.bootcamp.clientesLoja.controller;

import com.bootcamp.clientesLoja.dtos.ClienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping
    ResponseEntity pedido(@RequestBody ClienteDTO clienteDTO1) {
        return new ResponseEntity(clienteDTO1.getPedidos(), HttpStatus.OK);
    }


}
