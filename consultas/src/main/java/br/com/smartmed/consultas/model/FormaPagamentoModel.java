package br.com.smartmed.consultas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "forma_pagamento")
public class FormaPagamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descricao", length = 64, nullable = true)
    private String descricao;

//    memory leak
//    public FormaPagamentoDTO toDTO() {
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(this, FormaPagamentoDTO.class);
//    }
}
