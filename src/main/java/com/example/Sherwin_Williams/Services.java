package com.example.Sherwin_Williams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Services {
    @Autowired
    private Repository repository;

    public Clientes consultar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
    }

    public Clientes cadastrar(Clientes cliente) {

        if (repository.existsByCnpjCpf(cliente.getCnpjCpf())) {
            throw new RuntimeException("CPF/CNPJ já cadastrado.");
        }

        repository.save(cliente);
        return cliente;

    }

}
