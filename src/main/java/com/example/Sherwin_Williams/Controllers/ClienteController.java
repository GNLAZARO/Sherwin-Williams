package com.example.Sherwin_Williams.Controllers;

import com.example.Sherwin_Williams.Entities.Cliente;
import com.example.Sherwin_Williams.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")


public class ClienteController {
    @Autowired
    private ClienteService service;

    @PostMapping("/cadastrar")
    public Cliente cadastrar(@RequestBody Cliente cliente) {

        return service.cadastrar(cliente);

    }

    @GetMapping("/consultar/{id}")
    public Cliente consultar(@PathVariable Long id) {
        return service.consultar(id);
    }

}