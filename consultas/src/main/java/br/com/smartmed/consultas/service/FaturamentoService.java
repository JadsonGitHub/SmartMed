package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.model.ConsultaModel;
import br.com.smartmed.consultas.repository.FaturamentoRepository;
import br.com.smartmed.consultas.rest.dto.FaturamentoDTO;
import br.com.smartmed.consultas.rest.dto.FaturamentoPorConvenioDTO;
import br.com.smartmed.consultas.rest.dto.FaturamentoPorFormaPagamentoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaturamentoService {
    @Autowired
    private FaturamentoRepository FaturamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

//    @Transactional(readOnly = true)
//    public FaturamentoDTO obterFaturamento(LocalDate dataInicio, LocalDate dataFim) {
//        FaturamentoModel faturamento = faturamentoRepository.findByDataFaturamentoBetween(dataInicio, dataFim);
//        return modelMapper.map(faturamento, FaturamentoDTO.class);
//    }

    @Transactional(readOnly = true)
    public FaturamentoDTO obterFaturamento(LocalDate dataInicio, LocalDate dataFim) {
        // Buscar consultas realizadas no período
        List<ConsultaModel> consultas = FaturamentoRepository.findConsultasRealizadasPorPeriodo(dataInicio, dataFim);

        // Calcular total geral
        BigDecimal totalGeral = consultas.stream()
                .map(consulta -> BigDecimal.valueOf(consulta.getValor()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Buscar faturamento por forma de pagamento - CORRIGIDO: Double para BigDecimal
        List<Object[]> faturamentoPorFormaPagamento = FaturamentoRepository.findFaturamentoPorFormaPagamento(dataInicio, dataFim);
        List<FaturamentoPorFormaPagamentoDTO> porFormaPagamento = faturamentoPorFormaPagamento.stream()
                .map(obj -> new FaturamentoPorFormaPagamentoDTO((String) obj[0], BigDecimal.valueOf((Double) obj[1])))
                .collect(Collectors.toList());

        // Buscar faturamento por convênio - CORRIGIDO: Double para BigDecimal
        List<Object[]> faturamentoPorConvenio = FaturamentoRepository.findFaturamentoPorConvenio(dataInicio, dataFim);
        List<FaturamentoPorConvenioDTO> porConvenio = faturamentoPorConvenio.stream()
                .map(obj -> new FaturamentoPorConvenioDTO((String) obj[0], BigDecimal.valueOf((Double) obj[1])))
                .collect(Collectors.toList());

        // Montar DTO de resposta
        FaturamentoDTO faturamento = new FaturamentoDTO();
        faturamento.setTotalGeral(totalGeral);
        faturamento.setPorFormaPagamento(porFormaPagamento);
        faturamento.setPorConvenio(porConvenio);

        return faturamento;
    }
}
