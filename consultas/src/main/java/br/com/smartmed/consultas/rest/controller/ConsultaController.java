package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.ConsultaModel;
import br.com.smartmed.consultas.rest.dto.ConsultaDTO;
import br.com.smartmed.consultas.rest.dto.ConsultaDTO;
import br.com.smartmed.consultas.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos consultas.
 */
@RestController
@RequestMapping("/consulta")
public class ConsultaController
{
    /**
     * Instância do serviço de consultas, responsável por encapsular a lógica de negócios
     * e intermediar as operações entre o controlador e o repositório.
     */
    @Autowired
    private ConsultaService consultaService;
    
   /**
     * Obtém um consulta pelo ID.
     * Link: http://localhost:8080/api/consulta/?
     *
     * @param id ID do consulta.
     * @return consultaDTO representando o consulta encontrado.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<ConsultaDTO> obterPorId(@PathVariable int id)
    {
        ConsultaDTO consultaDTO = consultaService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(consultaDTO);
    }
    
    /**
     * Obtém a lista de todos os consultas cadastrados.
     * Link: http://localhost:8080/api/consulta
     *
     * @return Lista de consultaDTO representando os consultas cadastrados.
     */
    @GetMapping()
    public ResponseEntity<List<ConsultaDTO>> obterTodos()
    {
        List<ConsultaDTO> consultaDTOList = consultaService.obterTodos();
        return ResponseEntity.ok(consultaDTOList);
    }

    /**
     * Obtém a lista de todos os consultas cadastrados com o status.
     * Link: http://localhost:8080/api/consulta/?
     *
     * @return Lista de consultaDTO representando os consultas cadastrados.
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<ConsultaDTO>> obterPorStatus(@PathVariable String status)
    {
        List<ConsultaDTO> consultaDTOList = consultaService.obterPorStatus(status);
        return ResponseEntity.ok(consultaDTOList);
    }

//    /**
//     * Obtém a lista de todos os consultas cadastrados com o DataHoraConsulta.
//     * Link: http://localhost:8080/api/consulta/?
//     *
//     * @return Lista de consultaDTO representando os consultas cadastrados.
//     */
//    @GetMapping("/data/{datahora}")
//    public ResponseEntity<List<ConsultaDTO>> obterPorDataHoraConsulta(@PathVariable LocalDate DataHoraConsulta)
//    {
//        List<ConsultaDTO> consultaDTOList = consultaService.obterPorDataHoraConsulta(DataHoraConsulta);
//        return ResponseEntity.ok(consultaDTOList);
//    }
    
    /**
     * Salva um novo consulta na base de dados.
     * Link: http://localhost:8080/api/consulta
     *
     * @param novoConsulta ConsultaModel contendo os dados do novo consulta.
     * @return consultaDTO representando o consulta salvo.
     */
    @PostMapping()
    public ResponseEntity<ConsultaDTO> salvar(@Valid @RequestBody ConsultaModel novoConsulta)
    {
        ConsultaDTO novoConsultaDTO = consultaService.salvar(novoConsulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConsultaDTO);
    }
    
    /**
     * Atualiza os dados de um consulta existente.
     * Link: http://localhost:8080/api/consulta
     *
     * @param consultaExistente consultaModel contendo os dados atualizados do consulta.
     * @return consultaDTO representando o consulta atualizado.
     * @link http://localhost:8080/api/consulta
     */
    @PutMapping
    public ResponseEntity<ConsultaDTO> atualizar(@Valid @RequestBody ConsultaModel consultaExistente)
    {
        ConsultaDTO consultaExistenteDTO = consultaService.atualizar(consultaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(consultaExistenteDTO);
    }
    
    /**
     * Deleta um consulta da base de dados.
     * Link: http://localhost:8080/api/consulta
     *
     * @param consultaExistente consultaModel contendo os dados do consulta a ser deletado.
     * @link http://localhost:8080/api/consulta
     */
    @DeleteMapping
    public void deletar(@Valid @RequestBody ConsultaModel consultaExistente)
    {
        consultaService.deletar(consultaExistente);
    }
}