package com.example.Sherwin_Williams.Repository;

import com.example.Sherwin_Williams.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {


    boolean existsByCnpjCpf(String cnpjCpf);
}
