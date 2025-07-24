package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.EspecialidadeModel;
import br.com.smartmed.consultas.rest.dto.EspecialidadeDTO;
import br.com.smartmed.consultas.service.EspecialidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController {
    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> obterPorId(@PathVariable int id) {
        EspecialidadeDTO especialidadeDTO = especialidadeService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(especialidadeDTO);
    }

    @GetMapping()
    public ResponseEntity<List<EspecialidadeDTO>> obterTodos() {
        List<EspecialidadeDTO> especialidadeDTOList = especialidadeService.obterTodos();
        return ResponseEntity.ok(especialidadeDTOList);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Boolean> existeNome(@PathVariable String nome) {
        boolean existe = especialidadeService.existeNome(nome);
        return ResponseEntity.status(existe ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(existe);
    }

    @PostMapping()
    public ResponseEntity<EspecialidadeDTO> salvar(@Valid @RequestBody EspecialidadeModel novoEspecialidade) {
        EspecialidadeDTO novoEspecialidadeDTO = especialidadeService.salvar(novoEspecialidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEspecialidadeDTO);
    }

    @PutMapping
    public ResponseEntity<EspecialidadeDTO> atualizar(@Valid @RequestBody EspecialidadeModel especialidadeExistente) {
        EspecialidadeDTO especialidadeExistenteDTO = especialidadeService.atualizar(especialidadeExistente);
        return ResponseEntity.status(HttpStatus.OK).body(especialidadeExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody EspecialidadeModel especialidadeExistente) {
        especialidadeService.deletar(especialidadeExistente);
    }
}
