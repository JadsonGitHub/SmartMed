package br.com.smartmed.consultas.rest.dto;

import lombok.Data;

@Data
public class FaturamentoDTO {
    private float totalGeral;
    private String formaPagamento;
    private float formaPagamentoValor;
    private String convenio;
    private float convenioValor;
}
//json
//{
//    "totalGeral": 10000.00,
//    "porFormaPagamento": [
//        {"formaPagamento": "Dinheiro", "valor": 5000.00},
//        {"formaPagamento": "Cartão de Crédito", "valor": 2000.00}
//    ],
//    "porConvenio": [
//        {"convenio": "Unimed", "valor": 3000.00}
//    ]
//}