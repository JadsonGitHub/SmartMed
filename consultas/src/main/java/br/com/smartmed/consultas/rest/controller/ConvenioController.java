package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.ConvenioModel;
import br.com.smartmed.consultas.rest.dto.ConvenioDTO;
import br.com.smartmed.consultas.service.ConvenioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {
    @Autowired
    private ConvenioService convenioService;

    @GetMapping()
    public ResponseEntity<?> buscarConvenio(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "cnpj", required = false) String cnpj) {

        if (id != null) return ResponseEntity.ok(convenioService.obterPorId(id));
        if (cnpj != null) return ResponseEntity.ok(convenioService.obterPorCnpj(cnpj));
        return ResponseEntity.ok(convenioService.obterTodos());
    }

//    @GetMapping()
//    public ResponseEntity<List<ConvenioDTO>> obterTodos() {
//        List<ConvenioDTO> convenioDTOList = convenioService.obterTodos();
//        return ResponseEntity.ok(convenioDTOList);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ConvenioDTO> obterPorId(@PathVariable int id) {
//        ConvenioDTO convenioDTO = convenioService.obterPorId(id);
//        return ResponseEntity.status(HttpStatus.OK).body(convenioDTO);
//    }
//
//    @GetMapping("/{cnpj}")
//    public ResponseEntity<ConvenioDTO> obterPorCnpj(@PathVariable String cnpj) {
//        ConvenioDTO convenioDTO = convenioService.obterPorCnpj(cnpj);
//        return ResponseEntity.status(HttpStatus.OK).body(convenioDTO);
//    }

    @PostMapping()
    public ResponseEntity<ConvenioDTO> salvar(@Valid @RequestBody ConvenioModel novoConvenio) {
        ConvenioDTO novoConvenioDTO = convenioService.salvar(novoConvenio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConvenioDTO);
    }

    @PutMapping
    public ResponseEntity<ConvenioDTO> atualizar(@Valid @RequestBody ConvenioModel convenioExistente) {
        ConvenioDTO convenioExistenteDTO = convenioService.atualizar(convenioExistente);
        return ResponseEntity.status(HttpStatus.OK).body(convenioExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody ConvenioModel convenioExistente) {
        convenioService.deletar(convenioExistente);
    }
}
