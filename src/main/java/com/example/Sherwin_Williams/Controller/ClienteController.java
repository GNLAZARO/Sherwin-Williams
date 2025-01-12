package com.example.Sherwin_Williams.Controller;

import com.example.Sherwin_Williams.Cliente;
import com.example.Sherwin_Williams.Services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")


public class ClienteController {
    @Autowired
    private ClienteServices service;

    @PostMapping("/cadastrar")
    public Cliente cadastrar(@RequestBody Cliente cliente) {

        return service.cadastrar(cliente);

    }

    @GetMapping("/consultar/{id}")
    public Cliente consultar(@PathVariable Long id) {
        return service.consultar(id);
    }

}