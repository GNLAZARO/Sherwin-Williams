package com.example.Sherwin_Williams;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpjCpf;
    private String telefone;
    private String status;
}

