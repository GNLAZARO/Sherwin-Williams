package com.example.Sherwin_Williams.Services;

import com.example.Sherwin_Williams.Cliente;
import com.example.Sherwin_Williams.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository repository;


    public Cliente consultar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
    }

    public Cliente cadastrar(Cliente cliente) {

        if (repository.existsByCnpjCpf(cliente.getCnpjCpf())) {
            throw new RuntimeException("CPF/CNPJ já cadastrado.");
        }

        repository.save(cliente);
        return cliente;

    }

}
