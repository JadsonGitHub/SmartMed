package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.exception.*;
import br.com.smartmed.consultas.model.FormaPagamentoModel;
import br.com.smartmed.consultas.repository.FormaPagamentoRepository;
import br.com.smartmed.consultas.rest.dto.FormaPagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelas operações relacionadas aos formaPagamentos.
 */
@Service
public class FormaPagamentoService
{
    /**
     * Instância do repositório de formaPagamentos, responsável por realizar operações de
     * persistência e consulta diretamente no banco de dados.
     */
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;
    /**
     * Obtém um formaPagamento pelo ID.
     *
     * @param id ID do formaPagamento.
     * @return formaPagamentoDTO representando o formaPagamento encontrado.
     * @throws ObjectNotFoundException Se o formaPagamento não for encontrado.
     */
    @Transactional(readOnly = true)
    public FormaPagamentoDTO obterPorId(int id)
    {
        FormaPagamentoModel formaPagamento = formaPagamentoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("FormaPagamento com ID " + id + " não encontrado."));
        return formaPagamento.toDTO();
    }
    /**
     * Obtém a lista de todos os formaPagamentos cadastrados.
     *
     * @return Lista de FormaPagamentoDTO representando os formaPagamentos cadastrados.
     */
    @Transactional(readOnly = true)
    public List<FormaPagamentoDTO> obterTodos()
    {
        List<FormaPagamentoModel> formaPagamentos = formaPagamentoRepository.findAll();
        return formaPagamentos.stream()
                .map(formaPagamento -> formaPagamento.toDTO())
                .collect(Collectors.toList());
    }
    /**
     * Salva um novo formaPagamento na base de dados.
     *
     * @param novoFormaPagamento formaPagamentoModel contendo os dados do novo formaPagamento.
     * @return formaPagamentoDTO representando o formaPagamento salvo.
     * @throws ConstraintException       Se o telefone ou e-mail já existirem.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public FormaPagamentoDTO salvar(FormaPagamentoModel novoFormaPagamento)
    {
        try {
            //Caso ocorra uma tentativa de salvar um novo formaPagamento com um Id já existente.
            if (formaPagamentoRepository.existsById(novoFormaPagamento.getId()))
            {
                throw new ConstraintException("Já existe um formaPagamento com esse ID " + novoFormaPagamento.getId() + " na base de dados!");
            }
            //Salva o novo formaPagamento na base de dados.
            return formaPagamentoRepository.save(novoFormaPagamento).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível salvar o formaPagamento " + novoFormaPagamento.getDescricao() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o formaPagamento " + novoFormaPagamento.getDescricao() + ".");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível salvar o formaPagamento " + novoFormaPagamento.getDescricao() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível salvar o formaPagamento " + novoFormaPagamento.getDescricao() + ". Falha na conexão com o banco de dados!");
        }
    }
    /**
     * Atualiza os dados de um formaPagamento existente.
     *
     * @param formaPagamentoExistente formaPagamentoModel contendo os dados atualizados do cliete.
     * @return formaPagamentoDTO representando o formaPagamento atualizado.
     * @throws ConstraintException       Se o telefone ou e-mail não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public FormaPagamentoDTO atualizar(FormaPagamentoModel formaPagamentoExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de salvar um formaPagamento que não existe utilizando um Id.
            if (!formaPagamentoRepository.existsById(formaPagamentoExistente.getId()))
            {
                throw new ConstraintException("O formaPagamento com esse ID " + formaPagamentoExistente.getId() + " não existe na base de dados!");
            }
            //Atualiza o formaPagamento na base de dados.
            return formaPagamentoRepository.save(formaPagamentoExistente).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o formaPagamento " + formaPagamentoExistente.getDescricao() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao atualizar o formaPagamento " + formaPagamentoExistente.getDescricao() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o formaPagamento " + formaPagamentoExistente.getDescricao() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o formaPagamento " + formaPagamentoExistente.getDescricao() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o formaPagamento" + formaPagamentoExistente.getDescricao() + ". Não encontrado no banco de dados!");
        }
    }
    /**
     * Deleta um formaPagamento da base de dados.
     *
     * @param formaPagamentoExistente formaPagamentoModel contendo os dados do formaPagamento a ser deletado.
     * @throws ConstraintException       Se o formaPagamento (id) não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public void deletar(FormaPagamentoModel formaPagamentoExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de deletar um formaPagamento que não existe utilizando o id.
            if (!formaPagamentoRepository.existsById(formaPagamentoExistente.getId()))
            {
                throw new ConstraintException("FormaPagamento inexistente na base de dados!");
            }
            //Deletar o formaPagamento na base de dados.
            formaPagamentoRepository.delete(formaPagamentoExistente);
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível deletar o formaPagamento " + formaPagamentoExistente.getDescricao() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao deletar o formaPagamento " + formaPagamentoExistente.getDescricao() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível deletar o formaPagamento " + formaPagamentoExistente.getDescricao() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + formaPagamentoExistente.getDescricao() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o formaPagamento" + formaPagamentoExistente.getDescricao() + ". Não encontrado no banco de dados!");
        }
    }
}