package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.MedicoModel;
import br.com.smartmed.consultas.rest.dto.MedicoDTO;
import br.com.smartmed.consultas.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos medicos.
 */
@RestController
@RequestMapping("/medico")
public class MedicoController
{
    /**
     * Instância do serviço de medicos, responsável por encapsular a lógica de negócios
     * e intermediar as operações entre o controlador e o repositório.
     */
    @Autowired
    private MedicoService medicoService;
   /**
     * Obtém um medico pelo ID.
     * Link: http://localhost:8080/api/medico/?
     *
     * @param id ID do medico.
     * @return medicoDTO representando o medico encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> obterPorId(@PathVariable int id)
    {
        MedicoDTO medicoDTO = medicoService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(medicoDTO);
    }
    /**
     * Obtém a lista de todos os medicos cadastrados.
     * Link: http://localhost:8080/api/medico
     *
     * @return Lista de medicoDTO representando os medicos cadastrados.
     */
    @GetMapping()
    public ResponseEntity<List<MedicoDTO>> obterTodos()
    {
        List<MedicoDTO> medicoDTOList = medicoService.obterTodos();
        return ResponseEntity.ok(medicoDTOList);
    }
    /**
     * Salva um novo medico na base de dados.
     * Link: http://localhost:8080/api/medico
     *
     * @param novoMedico MedicoModel contendo os dados do novo medico.
     * @return medicoDTO representando o medico salvo.
     */
    @PostMapping()
    public ResponseEntity<MedicoDTO> salvar(@Valid @RequestBody MedicoModel novoMedico)
    {
        MedicoDTO novoMedicoDTO = medicoService.salvar(novoMedico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedicoDTO);
    }
    /**
     * Atualiza os dados de um medico existente.
     * Link: http://localhost:8080/api/medico
     *
     * @param medicoExistente medicoModel contendo os dados atualizados do medico.
     * @return medicoDTO representando o medico atualizado.
     * @link http://localhost:8080/api/medico
     */
    @PutMapping
    public ResponseEntity<MedicoDTO> atualizar(@Valid @RequestBody MedicoModel medicoExistente)
    {
        MedicoDTO medicoExistenteDTO = medicoService.atualizar(medicoExistente);
        return ResponseEntity.status(HttpStatus.OK).body(medicoExistenteDTO);
    }
    /**
     * Deleta um medico da base de dados.
     * Link: http://localhost:8080/api/medico
     *
     * @param medicoExistente medicoModel contendo os dados do medico a ser deletado.
     * @link http://localhost:8080/api/medico
     */
    @DeleteMapping
    public void deletar(@Valid @RequestBody MedicoModel medicoExistente)
    {
        medicoService.deletar(medicoExistente);
    }
}