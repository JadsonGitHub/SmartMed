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

/**
 * Controlador responsável por gerenciar as operações relacionadas aos especialidades.
 */
@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController
{
    /**
     * Instância do serviço de especialidades, responsável por encapsular a lógica de negócios
     * e intermediar as operações entre o controlador e o repositório.
     */
    @Autowired
    private EspecialidadeService especialidadeService;
   /**
     * Obtém um especialidade pelo ID.
     * Link: http://localhost:8080/api/especialidade/?
     *
     * @param id ID do especialidade.
     * @return especialidadeDTO representando o especialidade encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> obterPorId(@PathVariable int id)
    {
        EspecialidadeDTO especialidadeDTO = especialidadeService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(especialidadeDTO);
    }
    /**
     * Obtém a lista de todos os especialidades cadastrados.
     * Link: http://localhost:8080/api/especialidade
     *
     * @return Lista de especialidadeDTO representando os especialidades cadastrados.
     */
    @GetMapping()
    public ResponseEntity<List<EspecialidadeDTO>> obterTodos()
    {
        List<EspecialidadeDTO> especialidadeDTOList = especialidadeService.obterTodos();
        return ResponseEntity.ok(especialidadeDTOList);
    }
    /**
     * Salva um novo especialidade na base de dados.
     * Link: http://localhost:8080/api/especialidade
     *
     * @param novoEspecialidade EspecialidadeModel contendo os dados do novo especialidade.
     * @return especialidadeDTO representando o especialidade salvo.
     */
    @PostMapping()
    public ResponseEntity<EspecialidadeDTO> salvar(@Valid @RequestBody EspecialidadeModel novoEspecialidade)
    {
        EspecialidadeDTO novoEspecialidadeDTO = especialidadeService.salvar(novoEspecialidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEspecialidadeDTO);
    }
    /**
     * Atualiza os dados de um especialidade existente.
     * Link: http://localhost:8080/api/especialidade
     *
     * @param especialidadeExistente especialidadeModel contendo os dados atualizados do especialidade.
     * @return especialidadeDTO representando o especialidade atualizado.
     * @link http://localhost:8080/api/especialidade
     */
    @PutMapping
    public ResponseEntity<EspecialidadeDTO> atualizar(@Valid @RequestBody EspecialidadeModel especialidadeExistente)
    {
        EspecialidadeDTO especialidadeExistenteDTO = especialidadeService.atualizar(especialidadeExistente);
        return ResponseEntity.status(HttpStatus.OK).body(especialidadeExistenteDTO);
    }
    /**
     * Deleta um especialidade da base de dados.
     * Link: http://localhost:8080/api/especialidade
     *
     * @param especialidadeExistente especialidadeModel contendo os dados do especialidade a ser deletado.
     * @link http://localhost:8080/api/especialidade
     */
    @DeleteMapping
    public void deletar(@Valid @RequestBody EspecialidadeModel especialidadeExistente)
    {
        especialidadeService.deletar(especialidadeExistente);
    }
}