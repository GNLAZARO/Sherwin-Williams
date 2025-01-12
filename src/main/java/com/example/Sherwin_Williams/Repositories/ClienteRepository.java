package com.example.Sherwin_Williams.Repositories;

import com.example.Sherwin_Williams.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {


    boolean existsByCnpjCpf(String cnpjCpf);
}
