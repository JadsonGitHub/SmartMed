package br.com.smartmed.consultas.rest.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FaturamentoDTO {
    private BigDecimal totalGeral;
    private List<FaturamentoPorFormaPagamentoDTO> porFormaPagamento;
    private List<FaturamentoPorConvenioDTO> porConvenio;
}
