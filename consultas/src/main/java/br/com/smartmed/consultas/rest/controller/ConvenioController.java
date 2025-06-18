package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.ConvenioModel;
import br.com.smartmed.consultas.rest.dto.ConvenioDTO;
import br.com.smartmed.consultas.rest.dto.ConvenioDTO;
import br.com.smartmed.consultas.service.ConvenioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos convenios.
 */
@RestController
@RequestMapping("/convenio")
public class ConvenioController
{
    /**
     * Instância do serviço de convenios, responsável por encapsular a lógica de negócios
     * e intermediar as operações entre o controlador e o repositório.
     */
    @Autowired
    private ConvenioService convenioService;
    
   /**
     * Obtém um convenio pelo ID.
     * Link: http://localhost:8080/api/convenio/?
     *
     * @param id ID do convenio.
     * @return convenioDTO representando o convenio encontrado.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<ConvenioDTO> obterPorId(@PathVariable int id)
    {
        ConvenioDTO convenioDTO = convenioService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(convenioDTO);
    }
    
    /**
     * Obtém a lista de todos os convenios cadastrados.
     * Link: http://localhost:8080/api/convenio
     *
     * @return Lista de convenioDTO representando os convenios cadastrados.
     */
    @GetMapping()
    public ResponseEntity<List<ConvenioDTO>> obterTodos()
    {
        List<ConvenioDTO> convenioDTOList = convenioService.obterTodos();
        return ResponseEntity.ok(convenioDTOList);
    }

    /**
     * Obtém a lista de todos os convenios cadastrados com o nome.
     * Link: http://localhost:8080/api/convenio/?
     *
     * @return Lista de convenioDTO representando os convenios cadastrados.
     */
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ConvenioDTO>> obterPorNome(@PathVariable String nome)
    {
        List<ConvenioDTO> convenioDTOList = convenioService.obterPorNome(nome);
        return ResponseEntity.ok(convenioDTOList);
    }

    /**
     * Obtém um convenio pelo CNPJ.
     * Link: http://localhost:8080/api/convenio/?
     *
     * @param cnpj CNPJ do convenio.
     * @return convenioDTO representando o convenio encontrado.
     */
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<ConvenioDTO> obterPorCnpj(@PathVariable String cnpj)
    {
        ConvenioDTO convenioDTO = convenioService.obterPorCnpj(cnpj);
        return ResponseEntity.status(HttpStatus.OK).body(convenioDTO);
    }
    
    /**
     * Salva um novo convenio na base de dados.
     * Link: http://localhost:8080/api/convenio
     *
     * @param novoConvenio ConvenioModel contendo os dados do novo convenio.
     * @return convenioDTO representando o convenio salvo.
     */
    @PostMapping()
    public ResponseEntity<ConvenioDTO> salvar(@Valid @RequestBody ConvenioModel novoConvenio)
    {
        ConvenioDTO novoConvenioDTO = convenioService.salvar(novoConvenio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConvenioDTO);
    }
    
    /**
     * Atualiza os dados de um convenio existente.
     * Link: http://localhost:8080/api/convenio
     *
     * @param convenioExistente convenioModel contendo os dados atualizados do convenio.
     * @return convenioDTO representando o convenio atualizado.
     * @link http://localhost:8080/api/convenio
     */
    @PutMapping
    public ResponseEntity<ConvenioDTO> atualizar(@Valid @RequestBody ConvenioModel convenioExistente)
    {
        ConvenioDTO convenioExistenteDTO = convenioService.atualizar(convenioExistente);
        return ResponseEntity.status(HttpStatus.OK).body(convenioExistenteDTO);
    }
    
    /**
     * Deleta um convenio da base de dados.
     * Link: http://localhost:8080/api/convenio
     *
     * @param convenioExistente convenioModel contendo os dados do convenio a ser deletado.
     * @link http://localhost:8080/api/convenio
     */
    @DeleteMapping
    public void deletar(@Valid @RequestBody ConvenioModel convenioExistente)
    {
        convenioService.deletar(convenioExistente);
    }
}