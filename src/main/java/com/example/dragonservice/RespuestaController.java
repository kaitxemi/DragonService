package com.example.dragonservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RespuestaController {

    @GetMapping("/respuesta")
    public String respuesta() {
        return "Hello world";
    }
}
