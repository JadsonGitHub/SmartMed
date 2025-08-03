package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.model.ConsultaModel;
import br.com.smartmed.consultas.repository.FaturamentoRepository;
import br.com.smartmed.consultas.rest.dto.FaturamentoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaturamentoService {
    @Autowired
    private FaturamentoRepository faturamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

//    @Transactional(readOnly = true)
//    public FaturamentoDTO obterFaturamento(LocalDate dataInicio, LocalDate dataFim) {
//        ConsultaModel faturamento = faturamentoRepository.findByDataHoraConsultaBetweenAndStatus(dataInicio, dataFim, "REALIZADA");
//        return modelMapper.map(faturamento, FaturamentoDTO.class);
//    }

    @Transactional(readOnly = true)
    public List<FaturamentoDTO> obterFaturamento(LocalDate dataInicio, LocalDate dataFim) {
        List<ConsultaModel> faturamentos = faturamentoRepository.findByDataHoraConsultaBetweenAndStatus(dataInicio, dataFim, "REALIZADA");
        return faturamentos.stream()
                .map(faturamento -> modelMapper.map(faturamento, FaturamentoDTO.class))
                .collect(Collectors.toList());
    }
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