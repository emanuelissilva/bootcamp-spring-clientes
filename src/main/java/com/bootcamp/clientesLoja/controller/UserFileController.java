package com.bootcamp.clientesLoja.controller;

import com.fasterxml.jackson.core.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class UserFileController {
         

         public UserFileController() {
                 try {
                         FileReader reader = new FileReader("./src/main/resources/clientes.json");
                         JsonParser

                         Object obj = parser.parse();
                 } catch (FileNotFoundException e) {
                         e.printStackTrace();
                 }
         }

        public void adicionaCliente() {


        }
}
