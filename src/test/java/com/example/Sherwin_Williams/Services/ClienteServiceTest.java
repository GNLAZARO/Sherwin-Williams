package com.example.Sherwin_Williams.Services;

import com.example.Sherwin_Williams.Entities.Cliente;
import com.example.Sherwin_Williams.Repositories.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteServices;

    @Test
    @DisplayName("Deve lançar exceção ao tentar cadastrar um cliente com CPF ou CNPJ já existente")
    void deveLancarExcecaoSeCpfOuCnpjJaCadastrado() {
        var cliente = new Cliente();
        cliente.setCnpjCpf("12345678901");

        when(clienteRepository.existsByCnpjCpf(cliente.getCnpjCpf())).thenReturn(true);


        var exception = assertThrows(RuntimeException.class,
                () -> clienteServices.cadastrar(cliente),
                "Deveria lançar uma exceção para CPF/CNPJ já cadastrado"
        );


        assertEquals("Cliente com CPF/CNPJ já cadastrado: 12345678901", exception.getMessage());
    }

    @Test
    @DisplayName("Deve permitir cadastro de um cliente com CPF ou CNPJ único")
    void devePermitirCadastroDeClienteUnico() {

        var cliente = new Cliente();
        cliente.setCnpjCpf("987654321001");

        when(clienteRepository.existsByCnpjCpf(cliente.getCnpjCpf())).thenReturn(false);

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        var clienteSalvo = clienteServices.cadastrar(cliente);

        assertNotNull(clienteSalvo, "O cliente salvo não deve ser nulo");
        verify(clienteRepository, times(1)).save(cliente);
    }
}
