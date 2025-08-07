package br.com.smartmed.consultas.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class FaturamentoDTO {

    private float totalGeral;
    private List<porFormaPagamento> porFormaPagamentos;
    private List<porConvenio> porConvenios;

//    @Data
//    public static class porFormaPagamento {
//        private String formaPagamento;
//        private float valor;
//    }
//
//    @Data
//    public static class porConvenio {
//        private String convenio;
//        private float valor;
//    }

    @Data
    public static class porFormaPagamento {
        private String formaPagamento;
        private float valor;

        public static porFormaPagamento from(String formaPagamento, float valor) {
            porFormaPagamento dto = new porFormaPagamento();
            dto.setFormaPagamento(formaPagamento);
            dto.setValor(valor);
            return dto;
        }
    }

    @Data
    public static class porConvenio {
        private String convenio;
        private float valor;

        public static porConvenio from(String convenio, float valor) {
            porConvenio dto = new porConvenio();
            dto.setConvenio(convenio);
            dto.setValor(valor);
            return dto;
        }
    }
}
