package com.example.Sherwin_Williams;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Clientes,Long> {


    boolean existsByCnpjCpf(String cnpjCpf);
}
