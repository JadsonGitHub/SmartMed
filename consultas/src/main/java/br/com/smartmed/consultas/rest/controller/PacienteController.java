package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.PacienteModel;
import br.com.smartmed.consultas.rest.dto.PacienteDTO;
import br.com.smartmed.consultas.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos pacientes.
 */
@RestController
@RequestMapping("/paciente")
public class PacienteController
{
    /**
     * Instância do serviço de pacientes, responsável por encapsular a lógica de negócios
     * e intermediar as operações entre o controlador e o repositório.
     */
    @Autowired
    private PacienteService pacienteService;

   /**
     * Obtém um paciente pelo ID.
     * Link: http://localhost:8080/api/paciente/?
     *
     * @param id ID do paciente.
     * @return pacienteDTO representando o paciente encontrado.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<PacienteDTO> obterPorId(@PathVariable int id)
    {
        PacienteDTO pacienteDTO = pacienteService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteDTO);
    }

    /**
     * Obtém a lista de todos os pacientes cadastrados.
     * Link: http://localhost:8080/api/paciente
     *
     * @return Lista de pacienteDTO representando os pacientes cadastrados.
     */
    @GetMapping()
    public ResponseEntity<List<PacienteDTO>> obterTodos()
    {
        List<PacienteDTO> pacienteDTOList = pacienteService.obterTodos();
        return ResponseEntity.ok(pacienteDTOList);
    }

    /**
     * Obtém a lista de todos os pacientes cadastrados com o nome.
     * Link: http://localhost:8080/api/paciente/?
     *
     * @return Lista de pacienteDTO representando os pacientes cadastrados.
     */
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<PacienteDTO>> obterPorNome(@PathVariable String nome)
    {
        List<PacienteDTO> pacienteDTOList = pacienteService.obterPorNome(nome);
        return ResponseEntity.ok(pacienteDTOList);
    }

    /**
     * Obtém um paciente pelo CPF.
     * Link: http://localhost:8080/api/paciente/?
     *
     * @param cpf CPF do paciente.
     * @return pacienteDTO representando o paciente encontrado.
     */
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PacienteDTO> obterPorCpf(@PathVariable String cpf)
    {
        PacienteDTO pacienteDTO = pacienteService.obterPorCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteDTO);
    }
//
//    /**
//     * Verifica se existe um cpf.
//     * Link: http://localhost:8080/api/paciente/existe/?
//     *
//     * @param cpf cpf do paciente.
//     * @return true or false.
//     */
//    @GetMapping("/existe/{cpf}")
//    public ResponseEntity<Boolean> existeCpf(@PathVariable String cpf)
//    {
//        boolean existe = pacienteService.existeCpf(cpf);
//        return ResponseEntity.status(existe ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(existe);
//    }
//
//    /**
//     * Verifica se existe um Telefone.
//     * Link: http://localhost:8080/api/paciente/existe/?
//     *
//     * @param Telefone Telefone do paciente.
//     * @return true or false.
//     */
//    @GetMapping("/existe/{Telefone}")
//    public ResponseEntity<Boolean> existeTelefone(@PathVariable String Telefone)
//    {
//        boolean existe = pacienteService.existeTelefone(Telefone);
//        return ResponseEntity.status(existe ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(existe);
//    }
//
//    /**
//     * Verifica se existe um email.
//     * Link: http://localhost:8080/api/paciente/existe/?
//     *
//     * @param email email do paciente.
//     * @return true or false.
//     */
//    @GetMapping("/existe/{email}")
//    public ResponseEntity<Boolean> existeEmail(@PathVariable String email)
//    {
//        boolean existe = pacienteService.existeEmail(email);
//        return ResponseEntity.status(existe ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(existe);
//    }

    /**
     * Salva um novo paciente na base de dados.
     * Link: http://localhost:8080/api/paciente
     *
     * @param novoPaciente PacienteModel contendo os dados do novo paciente.
     * @return pacienteDTO representando o paciente salvo.
     */
    @PostMapping()
    public ResponseEntity<PacienteDTO> salvar(@Valid @RequestBody PacienteModel novoPaciente)
    {
        PacienteDTO novoPacienteDTO = pacienteService.salvar(novoPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPacienteDTO);
    }

    /**
     * Atualiza os dados de um paciente existente.
     * Link: http://localhost:8080/api/paciente
     *
     * @param pacienteExistente pacienteModel contendo os dados atualizados do paciente.
     * @return pacienteDTO representando o paciente atualizado.
     * @link http://localhost:8080/api/paciente
     */
    @PutMapping
    public ResponseEntity<PacienteDTO> atualizar(@Valid @RequestBody PacienteModel pacienteExistente)
    {
        PacienteDTO pacienteExistenteDTO = pacienteService.atualizar(pacienteExistente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteExistenteDTO);
    }

    /**
     * Deleta um paciente da base de dados.
     * Link: http://localhost:8080/api/paciente
     *
     * @param pacienteExistente pacienteModel contendo os dados do paciente a ser deletado.
     * @link http://localhost:8080/api/paciente
     */
    @DeleteMapping
    public void deletar(@Valid @RequestBody PacienteModel pacienteExistente)
    {
        pacienteService.deletar(pacienteExistente);
    }
}