package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.rest.dto.FaturamentoDTO;
import br.com.smartmed.consultas.service.FaturamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {
    @Autowired
    private FaturamentoService faturamentoService;

    @GetMapping("/faturamento")
    public ResponseEntity<FaturamentoDTO> faturamento(
            @RequestParam(name = "dataInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(name = "dataFim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        return (dataFim != null && dataInicio != null)
                ? ResponseEntity.ok(faturamentoService.obterFaturamento(dataInicio, dataFim))
                : ResponseEntity.ok(faturamentoService.obterFaturamento(LocalDate.of(2025, 01, 01), LocalDate.now()));
    }
}
