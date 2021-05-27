package com.bootcamp.clientesLoja.service.impl;

import com.bootcamp.clientesLoja.service.ClienteService;
import org.springframework.http.ResponseEntity;

public class ClienteServiceImpl implements ClienteService {
    @Override
    public ResponseEntity consultaPedidosPorCliente() {
        FileReader reader = new FileReader(jsonFile);

        JSONObject jsonObject = (JSONObject) new JSONParser().parse(reader);
        return null;
    }
}
