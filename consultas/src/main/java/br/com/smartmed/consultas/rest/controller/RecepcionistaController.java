package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.RecepcionistaModel;
import br.com.smartmed.consultas.rest.dto.RecepcionistaDTO;
import br.com.smartmed.consultas.rest.dto.RecepcionistaDTO;
import br.com.smartmed.consultas.service.RecepcionistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos recepcionistas.
 */
@RestController
@RequestMapping("/recepcionista")
public class RecepcionistaController
{
    /**
     * Instância do serviço de recepcionistas, responsável por encapsular a lógica de negócios
     * e intermediar as operações entre o controlador e o repositório.
     */
    @Autowired
    private RecepcionistaService recepcionistaService;
    
   /**
     * Obtém um recepcionista pelo ID.
     * Link: http://localhost:8080/api/recepcionista/?
     *
     * @param id ID do recepcionista.
     * @return recepcionistaDTO representando o recepcionista encontrado.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<RecepcionistaDTO> obterPorId(@PathVariable int id)
    {
        RecepcionistaDTO recepcionistaDTO = recepcionistaService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(recepcionistaDTO);
    }
    
    /**
     * Obtém a lista de todos os recepcionistas cadastrados.
     * Link: http://localhost:8080/api/recepcionista
     *
     * @return Lista de recepcionistaDTO representando os recepcionistas cadastrados.
     */
    @GetMapping()
    public ResponseEntity<List<RecepcionistaDTO>> obterTodos()
    {
        List<RecepcionistaDTO> recepcionistaDTOList = recepcionistaService.obterTodos();
        return ResponseEntity.ok(recepcionistaDTOList);
    }

    /**
     * Obtém a lista de todos os recepcionista cadastrados com o nome.
     * Link: http://localhost:8080/api/recepcionista/?
     *
     * @return Lista de recepcionistaDTO representando os recepcionista cadastrados.
     */
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<RecepcionistaDTO>> obterPorNome(@PathVariable String nome)
    {
        List<RecepcionistaDTO> recepcionistaDTOList = recepcionistaService.obterPorNome(nome);
        return ResponseEntity.ok(recepcionistaDTOList);
    }

    /**
     * Obtém um recepcionista pelo CPF.
     * Link: http://localhost:8080/api/recepcionista/?
     *
     * @param cpf CPF do recepcionista.
     * @return recepcionistaDTO representando o recepcionista encontrado.
     */
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<RecepcionistaDTO> obterPorCpf(@PathVariable String cpf)
    {
        RecepcionistaDTO recepcionistaDTO = recepcionistaService.obterPorCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(recepcionistaDTO);
    }
    
    /**
     * Salva um novo recepcionista na base de dados.
     * Link: http://localhost:8080/api/recepcionista
     *
     * @param novoRecepcionista RecepcionistaModel contendo os dados do novo recepcionista.
     * @return recepcionistaDTO representando o recepcionista salvo.
     */
    @PostMapping()
    public ResponseEntity<RecepcionistaDTO> salvar(@Valid @RequestBody RecepcionistaModel novoRecepcionista)
    {
        RecepcionistaDTO novoRecepcionistaDTO = recepcionistaService.salvar(novoRecepcionista);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoRecepcionistaDTO);
    }
    
    /**
     * Atualiza os dados de um recepcionista existente.
     * Link: http://localhost:8080/api/recepcionista
     *
     * @param recepcionistaExistente recepcionistaModel contendo os dados atualizados do recepcionista.
     * @return recepcionistaDTO representando o recepcionista atualizado.
     * @link http://localhost:8080/api/recepcionista
     */
    @PutMapping
    public ResponseEntity<RecepcionistaDTO> atualizar(@Valid @RequestBody RecepcionistaModel recepcionistaExistente)
    {
        RecepcionistaDTO recepcionistaExistenteDTO = recepcionistaService.atualizar(recepcionistaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(recepcionistaExistenteDTO);
    }
    
    /**
     * Deleta um recepcionista da base de dados.
     * Link: http://localhost:8080/api/recepcionista
     *
     * @param recepcionistaExistente recepcionistaModel contendo os dados do recepcionista a ser deletado.
     * @link http://localhost:8080/api/recepcionista
     */
    @DeleteMapping
    public void deletar(@Valid @RequestBody RecepcionistaModel recepcionistaExistente)
    {
        recepcionistaService.deletar(recepcionistaExistente);
    }
}