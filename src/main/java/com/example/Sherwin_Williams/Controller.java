package com.example.Sherwin_Williams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")


public class Controller {
    @Autowired
    private Services service;

    @PostMapping("/cadastrar")
    public Clientes cadastrar(@RequestBody Clientes cliente) {

        return service.cadastrar(cliente);

    }

    @GetMapping("/consultar/{id}")
    public Clientes consultar(@PathVariable Long id) {
        return service.consultar(id);
    }

}