package br.com.smartmed.consultas.rest.controller;

import br.com.smartmed.consultas.model.FormaPagamentoModel;
import br.com.smartmed.consultas.rest.dto.FormaPagamentoDTO;
import br.com.smartmed.consultas.service.FormaPagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos formaPagamentos.
 */
@RestController
@RequestMapping("/formaPagamento")
public class FormaPagamentoController
{
    /**
     * Instância do serviço de formaPagamentos, responsável por encapsular a lógica de negócios
     * e intermediar as operações entre o controlador e o repositório.
     */
    @Autowired
    private FormaPagamentoService formaPagamentoService;
   /**
     * Obtém um formaPagamento pelo ID.
     * Link: http://localhost:8080/api/formaPagamento/?
     *
     * @param id ID do formaPagamento.
     * @return formaPagamentoDTO representando o formaPagamento encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamentoDTO> obterPorId(@PathVariable int id)
    {
        FormaPagamentoDTO formaPagamentoDTO = formaPagamentoService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(formaPagamentoDTO);
    }
    /**
     * Obtém a lista de todos os formaPagamentos cadastrados.
     * Link: http://localhost:8080/api/formaPagamento
     *
     * @return Lista de formaPagamentoDTO representando os formaPagamentos cadastrados.
     */
    @GetMapping()
    public ResponseEntity<List<FormaPagamentoDTO>> obterTodos()
    {
        List<FormaPagamentoDTO> formaPagamentoDTOList = formaPagamentoService.obterTodos();
        return ResponseEntity.ok(formaPagamentoDTOList);
    }
    /**
     * Salva um novo formaPagamento na base de dados.
     * Link: http://localhost:8080/api/formaPagamento
     *
     * @param novoFormaPagamento FormaPagamentoModel contendo os dados do novo formaPagamento.
     * @return formaPagamentoDTO representando o formaPagamento salvo.
     */
    @PostMapping()
    public ResponseEntity<FormaPagamentoDTO> salvar(@Valid @RequestBody FormaPagamentoModel novoFormaPagamento)
    {
        FormaPagamentoDTO novoFormaPagamentoDTO = formaPagamentoService.salvar(novoFormaPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFormaPagamentoDTO);
    }
    /**
     * Atualiza os dados de um formaPagamento existente.
     * Link: http://localhost:8080/api/formaPagamento
     *
     * @param formaPagamentoExistente formaPagamentoModel contendo os dados atualizados do formaPagamento.
     * @return formaPagamentoDTO representando o formaPagamento atualizado.
     * @link http://localhost:8080/api/formaPagamento
     */
    @PutMapping
    public ResponseEntity<FormaPagamentoDTO> atualizar(@Valid @RequestBody FormaPagamentoModel formaPagamentoExistente)
    {
        FormaPagamentoDTO formaPagamentoExistenteDTO = formaPagamentoService.atualizar(formaPagamentoExistente);
        return ResponseEntity.status(HttpStatus.OK).body(formaPagamentoExistenteDTO);
    }
    /**
     * Deleta um formaPagamento da base de dados.
     * Link: http://localhost:8080/api/formaPagamento
     *
     * @param formaPagamentoExistente formaPagamentoModel contendo os dados do formaPagamento a ser deletado.
     * @link http://localhost:8080/api/formaPagamento
     */
    @DeleteMapping
    public void deletar(@Valid @RequestBody FormaPagamentoModel formaPagamentoExistente)
    {
        formaPagamentoService.deletar(formaPagamentoExistente);
    }
}