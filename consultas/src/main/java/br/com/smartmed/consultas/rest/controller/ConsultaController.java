package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.ConsultaModel;
import br.com.smartmed.consultas.rest.dto.ConsultaDTO;
import br.com.smartmed.consultas.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ConsultaDTO> obterPorId(@PathVariable int id) {
        ConsultaDTO consultaDTO = consultaService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(consultaDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ConsultaDTO>> obterTodos() {
        List<ConsultaDTO> consultaDTOList = consultaService.obterTodos();
        return ResponseEntity.ok(consultaDTOList);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ConsultaDTO>> obterPorStatus(@PathVariable String status) {
        List<ConsultaDTO> consultaDTOList = consultaService.obterPorStatus(status);
        return ResponseEntity.ok(consultaDTOList);
    }

//    @GetMapping("/data/{datahora}")
//    public ResponseEntity<List<ConsultaDTO>> obterPorDataHoraConsulta(@PathVariable LocalDate DataHoraConsulta)
//    {
//        List<ConsultaDTO> consultaDTOList = consultaService.obterPorDataHoraConsulta(DataHoraConsulta);
//        return ResponseEntity.ok(consultaDTOList);
//    }

    @PostMapping()
    public ResponseEntity<ConsultaDTO> salvar(@Valid @RequestBody ConsultaModel novoConsulta) {
        ConsultaDTO novoConsultaDTO = consultaService.salvar(novoConsulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConsultaDTO);
    }

    @PutMapping
    public ResponseEntity<ConsultaDTO> atualizar(@Valid @RequestBody ConsultaModel consultaExistente) {
        ConsultaDTO consultaExistenteDTO = consultaService.atualizar(consultaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(consultaExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody ConsultaModel consultaExistente) {
        consultaService.deletar(consultaExistente);
    }
}
