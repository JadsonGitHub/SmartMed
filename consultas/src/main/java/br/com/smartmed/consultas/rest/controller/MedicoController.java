package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.MedicoModel;
import br.com.smartmed.consultas.rest.dto.MedicoDTO;
import br.com.smartmed.consultas.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @GetMapping()
    public ResponseEntity<?> buscarMedico(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "crm", required = false) String crm) {

        if (id != null) return ResponseEntity.ok(medicoService.obterPorId(id));
        if (nome != null) return ResponseEntity.ok(medicoService.obterPorNome(nome));
        if (crm != null) return ResponseEntity.ok(medicoService.obterPorCrm(crm));
        return ResponseEntity.ok(medicoService.obterTodos());
    }

//    @GetMapping()
//    public ResponseEntity<List<MedicoDTO>> obterTodos() {
//        List<MedicoDTO> medicoDTOList = medicoService.obterTodos();
//        return ResponseEntity.ok(medicoDTOList);
//    }
//    
//    @GetMapping("/{id}")
//    public ResponseEntity<MedicoDTO> obterPorId(@PathVariable int id) {
//        MedicoDTO medicoDTO = medicoService.obterPorId(id);
//        return ResponseEntity.status(HttpStatus.OK).body(medicoDTO);
//    }
//
//    @GetMapping("/{nome}")
//    public ResponseEntity<List<MedicoDTO>> obterPorNome(@PathVariable String nome) {
//        List<MedicoDTO> medicoDTOList = medicoService.obterPorNome(nome);
//        return ResponseEntity.ok(medicoDTOList);
//    }
//
//    @GetMapping("/{crm}")
//    public ResponseEntity<MedicoDTO> obterPorCrm(@PathVariable String crm) {
//        MedicoDTO medicoDTO = medicoService.obterPorCrm(crm);
//        return ResponseEntity.status(HttpStatus.OK).body(medicoDTO);
//    }

    @PostMapping()
    public ResponseEntity<MedicoDTO> salvar(@Valid @RequestBody MedicoModel novoMedico) {
        MedicoDTO novoMedicoDTO = medicoService.salvar(novoMedico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedicoDTO);
    }

    @PutMapping
    public ResponseEntity<MedicoDTO> atualizar(@Valid @RequestBody MedicoModel medicoExistente) {
        MedicoDTO medicoExistenteDTO = medicoService.atualizar(medicoExistente);
        return ResponseEntity.status(HttpStatus.OK).body(medicoExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody MedicoModel medicoExistente) {
        medicoService.deletar(medicoExistente);
    }
}
