package br.com.smartmed.consultas.rest.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class FaturamentoDTO {
    private float totalGeral;
    private Map<String, LocalDate> periodo;
    private Map<String, Float> faturamentoConvenio;
    private Map<String, Float> faturamentoFormaPagamento;
}
