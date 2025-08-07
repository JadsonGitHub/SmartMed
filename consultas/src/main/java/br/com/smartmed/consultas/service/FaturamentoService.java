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
        List<ConsultaModel> faturamentos = faturamentoRepository.findByDataHoraConsultaBetweenAndStatus(inicio, fim, "REALIZADA");

        float totalGeral = 0f;
        Map<String, Float> porFormaPagamento = new HashMap<>();
        Map<String, Float> porConvenio = new HashMap<>();

        for (ConsultaModel faturamento : faturamentos) {
            float valor = faturamento.getValor();
            totalGeral += valor;

            porFormaPagamento.merge(faturamento.getFormaPagamento().getDescricao(), valor, Float::sum);

            if (faturamento.getConvenio() != null)
                porConvenio.merge(faturamento.getConvenio().getNome(), valor, Float::sum);
        }

//        List<FaturamentoDTO.porFormaPagamento> listaFormaPagamentos = porFormaPagamento.entrySet().stream()
//                .map(entry -> {
//                    FaturamentoDTO.porFormaPagamento dto = new FaturamentoDTO.porFormaPagamento();
//                    dto.setFormaPagamento(entry.getKey());
//                    dto.setValor(entry.getValue());
//                    return dto;
//                })
//                .toList();
//
//        List<FaturamentoDTO.porConvenio> listaConvenios = porConvenio.entrySet().stream()
//                .map(entry -> {
//                    FaturamentoDTO.porConvenio dto = new FaturamentoDTO.porConvenio();
//                    dto.setConvenio(entry.getKey());
//                    dto.setValor(entry.getValue());
//                    return dto;
//                })
//                .toList();

        List<FaturamentoDTO.porFormaPagamento> listaFormaPagamentos = porFormaPagamento.entrySet().stream()
                .map(entry -> FaturamentoDTO.porFormaPagamento.from(entry.getKey(), entry.getValue()))
                .toList();

        List<FaturamentoDTO.porConvenio> listaConvenios = porConvenio.entrySet().stream()
                .map(entry -> FaturamentoDTO.porConvenio.from(entry.getKey(), entry.getValue()))
                .toList();

        FaturamentoDTO faturamentoDTO = new FaturamentoDTO();
        faturamentoDTO.setTotalGeral(totalGeral);
        faturamentoDTO.setPorFormaPagamentos(listaFormaPagamentos);
        faturamentoDTO.setPorConvenios(listaConvenios);

        return faturamentoDTO;
    }
}
