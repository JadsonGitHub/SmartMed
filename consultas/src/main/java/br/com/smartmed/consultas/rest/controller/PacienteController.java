package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.PacienteModel;
import br.com.smartmed.consultas.rest.dto.PacienteDTO;
import br.com.smartmed.consultas.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping()
    public ResponseEntity<?> buscarPaciente(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "cpf", required = false) String cpf,
            @RequestParam(name = "telefone", required = false) String telefone,
            @RequestParam(name = "email", required = false) String email) {

        if (id != null) return ResponseEntity.ok(pacienteService.obterPorId(id));
        if (nome != null) return ResponseEntity.ok(pacienteService.obterPorNome(nome));
        if (cpf != null) return ResponseEntity.ok(pacienteService.obterPorCpf(cpf));
        if (telefone != null) return ResponseEntity.ok(pacienteService.existeTelefone(telefone));
        if (email != null) return ResponseEntity.ok(pacienteService.existeEmail(email));
        return ResponseEntity.ok(pacienteService.obterTodos());
    }

//    @GetMapping()
//    public ResponseEntity<List<PacienteDTO>> obterTodos() {
//        List<PacienteDTO> pacienteDTOList = pacienteService.obterTodos();
//        return ResponseEntity.ok(pacienteDTOList);
//    }
//    
//    @GetMapping("/{id}")
//    public ResponseEntity<PacienteDTO> obterPorId(@PathVariable int id) {
//        PacienteDTO pacienteDTO = pacienteService.obterPorId(id);
//        return ResponseEntity.status(HttpStatus.OK).body(pacienteDTO);
//    }
//
//    @GetMapping("/{nome}")
//    public ResponseEntity<List<PacienteDTO>> obterPorNome(@PathVariable String nome) {
//        List<PacienteDTO> pacienteDTOList = pacienteService.obterPorNome(nome);
//        return ResponseEntity.ok(pacienteDTOList);
//    }
//
//    @GetMapping("/{cpf}")
//    public ResponseEntity<PacienteDTO> obterPorCpf(@PathVariable String cpf) {
//        PacienteDTO pacienteDTO = pacienteService.obterPorCpf(cpf);
//        return ResponseEntity.status(HttpStatus.OK).body(pacienteDTO);
//    }
//
//    @GetMapping("/{Telefone}")
//    public ResponseEntity<Boolean> existeTelefone(@PathVariable String Telefone) {
//        boolean existe = pacienteService.existeTelefone(Telefone);
//        return ResponseEntity.status(existe ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(existe);
//    }
//
//    @GetMapping("/{email}")
//    public ResponseEntity<Boolean> existeEmail(@PathVariable String email) {
//        boolean existe = pacienteService.existeEmail(email);
//        return ResponseEntity.status(existe ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(existe);
//    }

    @PostMapping()
    public ResponseEntity<PacienteDTO> salvar(@Valid @RequestBody PacienteModel novoPaciente) {
        PacienteDTO novoPacienteDTO = pacienteService.salvar(novoPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPacienteDTO);
    }

    @PutMapping
    public ResponseEntity<PacienteDTO> atualizar(@Valid @RequestBody PacienteModel pacienteExistente) {
        PacienteDTO pacienteExistenteDTO = pacienteService.atualizar(pacienteExistente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteExistenteDTO);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody PacienteModel pacienteExistente) {
        this.pacienteService.deletar(pacienteExistente);
    }
}
