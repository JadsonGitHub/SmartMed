package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.model.ConsultaModel;
import br.com.smartmed.consultas.repository.FaturamentoRepository;
import br.com.smartmed.consultas.rest.dto.FaturamentoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Faturamento {
    @Autowired
    private FaturamentoRepository faturamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public FaturamentoDTO obterFaturamento(LocalDate inicio, LocalDate fim) {

        List<ConsultaModel> faturamentos = faturamentoRepository
                .findByDataHoraConsultaBetweenAndStatusIgnoreCase(inicio, fim, "REALIZADA");

        Map<String, LocalDate> periodo = new HashMap<>();
        periodo.put("Inicio", inicio);
        periodo.put("Fim", fim);

        if (faturamentos == null || faturamentos.isEmpty()) {
            FaturamentoDTO empty = new FaturamentoDTO();
            empty.setPeriodo(periodo);
            empty.setTotalGeral(0.00f);
            empty.setFaturamentoFormaPagamento(new HashMap<>());
            empty.setFaturamentoConvenio(new HashMap<>());
            return modelMapper.map(empty, FaturamentoDTO.class);
        }

        float totalGeral = 0.00f;
        Map<String, Float> faturamentoConvenio = new HashMap<>();
        Map<String, Float> faturamentoFormaPagamento = new HashMap<>();

        for (ConsultaModel c : faturamentos) {
            float valor = c.getValor();
            totalGeral += valor;

            if (c.getFormaPagamento() != null && c.getFormaPagamento().getDescricao() != null) {
                String desc = c.getFormaPagamento().getDescricao();
                faturamentoFormaPagamento.merge(desc, valor, Float::sum);
            }

            if (c.getConvenio() != null && c.getConvenio().getNome() != null) {
                String nome = c.getConvenio().getNome();
                faturamentoConvenio.merge(nome, valor, Float::sum);
            }
        }

        FaturamentoDTO relatorioFaturamento = new FaturamentoDTO();
        relatorioFaturamento.setPeriodo(periodo);
        relatorioFaturamento.setTotalGeral(totalGeral);
        relatorioFaturamento.setFaturamentoFormaPagamento(faturamentoFormaPagamento);
        relatorioFaturamento.setFaturamentoConvenio(faturamentoConvenio);

        return modelMapper.map(relatorioFaturamento, FaturamentoDTO.class);
    }
}
