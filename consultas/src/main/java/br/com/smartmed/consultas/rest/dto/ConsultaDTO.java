package br.com.smartmed.consultas.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsultaDTO {
    private int id;
    private String status;
    private String observacoes;
    private LocalDate dataHoraConsulta;
    private float valor;
    private int medicoID;
    private int pacienteID;
    private int convenioID;
    private int recepcionistaID;
    private int formaPagamentoID;
}
