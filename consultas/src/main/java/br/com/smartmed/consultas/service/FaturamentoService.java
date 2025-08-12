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
public class FaturamentoService {
    @Autowired
    private FaturamentoRepository faturamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public FaturamentoDTO obterFaturamento(LocalDate inicio, LocalDate fim) {

        List<ConsultaModel> faturamentos = faturamentoRepository
                .findByDataHoraConsultaBetweenAndStatusIgnoreCase(inicio, fim, "Realizada");

        float totalGeral = 0.00f;

        Map<String, Float> faturamentoFormaPagamento = new HashMap<>();
        Map<String, Float> faturamentoConvenio = new HashMap<>();
        Map<String, LocalDate> periodo = new HashMap<>();

        periodo.put("DE", inicio);
        periodo.put("ATÉ", fim);

        for (ConsultaModel faturamento : faturamentos) {
            totalGeral += faturamento.getValor();

            if (faturamento.getFormaPagamento() != null)
                faturamentoFormaPagamento.merge(faturamento.getFormaPagamento().getDescricao(), faturamento.getValor(), Float::sum);

            if (faturamento.getConvenio() != null)
                faturamentoConvenio.merge(faturamento.getConvenio().getNome(), faturamento.getValor(), Float::sum);
        }

        FaturamentoDTO relatorioFaturamento = new FaturamentoDTO();
        relatorioFaturamento.setPeriodo(periodo);
        relatorioFaturamento.setTotalGeral(totalGeral);
        relatorioFaturamento.setFaturamentoConvenio(faturamentoConvenio);
        relatorioFaturamento.setFaturamentoFormaPagamento(faturamentoFormaPagamento);

        return modelMapper.map(relatorioFaturamento, FaturamentoDTO.class);
    }
}
