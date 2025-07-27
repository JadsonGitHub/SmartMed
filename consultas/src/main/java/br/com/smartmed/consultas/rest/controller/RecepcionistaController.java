package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.RecepcionistaModel;
import br.com.smartmed.consultas.rest.dto.RecepcionistaDTO;
import br.com.smartmed.consultas.service.RecepcionistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recepcionista")
public class RecepcionistaController {
    @Autowired
    private RecepcionistaService recepcionistaService;

    @GetMapping()
    public ResponseEntity<?> buscarRecepcionista(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "cpf", required = false) String cpf) {

        if (id != null) return ResponseEntity.ok(recepcionistaService.obterPorId(id));
        if (nome != null) return ResponseEntity.ok(recepcionistaService.obterPorNome(nome));
        if (cpf != null) return ResponseEntity.ok(recepcionistaService.obterPorCpf(cpf));
        return ResponseEntity.ok(recepcionistaService.obterTodos());
    }
//
//    @GetMapping()
//    public ResponseEntity<List<RecepcionistaDTO>> obterTodos() {
//        List<RecepcionistaDTO> recepcionistaDTOList = recepcionistaService.obterTodos();
//        return ResponseEntity.ok(recepcionistaDTOList);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RecepcionistaDTO> obterPorId(@PathVariable int id) {
//        RecepcionistaDTO recepcionistaDTO = recepcionistaService.obterPorId(id);
//        return ResponseEntity.status(HttpStatus.OK).body(recepcionistaDTO);
//    }
//
//    @GetMapping("/{nome}")
//    public ResponseEntity<List<RecepcionistaDTO>> obterPorNome(@PathVariable String nome) {
//        List<RecepcionistaDTO> recepcionistaDTOList = recepcionistaService.obterPorNome(nome);
//        return ResponseEntity.ok(recepcionistaDTOList);
//    }
//
//    @GetMapping("/{cpf}")
//    public ResponseEntity<RecepcionistaDTO> obterPorCpf(@PathVariable String cpf) {
//        RecepcionistaDTO recepcionistaDTO = recepcionistaService.obterPorCpf(cpf);
//        return ResponseEntity.status(HttpStatus.OK).body(recepcionistaDTO);
//    }

    @PostMapping()
    public ResponseEntity<RecepcionistaDTO> salvar(@Valid @RequestBody RecepcionistaModel novoRecepcionista) {
        RecepcionistaDTO novoRecepcionistaDTO = recepcionistaService.salvar(novoRecepcionista);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoRecepcionistaDTO);
    }

    @PutMapping
    public ResponseEntity<RecepcionistaDTO> atualizar(@Valid @RequestBody RecepcionistaModel recepcionistaExistente) {
        RecepcionistaDTO recepcionistaExistenteDTO = recepcionistaService.atualizar(recepcionistaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(recepcionistaExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody RecepcionistaModel recepcionistaExistente) {
        recepcionistaService.deletar(recepcionistaExistente);
    }
}
