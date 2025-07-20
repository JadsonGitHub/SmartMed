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

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Transactional(readOnly = true)
    public FormaPagamentoDTO obterPorId(int id) {
        FormaPagamentoModel formaPagamento = formaPagamentoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("FormaPagamento com ID " + id + " não encontrado."));
        return formaPagamento.toDTO();
    }

    @Transactional(readOnly = true)
    public List<FormaPagamentoDTO> obterTodos() {
        List<FormaPagamentoModel> formaPagamentos = formaPagamentoRepository.findAll();
        return formaPagamentos.stream()
                .map(formaPagamento -> formaPagamento.toDTO())
                .collect(Collectors.toList());
    }

    @Transactional
    public FormaPagamentoDTO salvar(FormaPagamentoModel novoFormaPagamento) {
        try {
            //Caso ocorra uma tentativa de salvar um novo formaPagamento com um Id já existente.
            if (formaPagamentoRepository.existsById(novoFormaPagamento.getId())) {
                throw new ConstraintException("Já existe um formaPagamento com esse ID " + novoFormaPagamento.getId() + " na base de dados!");
            }
            //Salva o novo formaPagamento na base de dados.
            return formaPagamentoRepository.save(novoFormaPagamento).toDTO();
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o formaPagamento " + novoFormaPagamento.getDescricao() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o formaPagamento " + novoFormaPagamento.getDescricao() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar o formaPagamento " + novoFormaPagamento.getDescricao() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar o formaPagamento " + novoFormaPagamento.getDescricao() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public FormaPagamentoDTO atualizar(FormaPagamentoModel formaPagamentoExistente) {
        try {
            //Caso ocorra uma tentativa de salvar um formaPagamento que não existe utilizando um Id.
            if (!formaPagamentoRepository.existsById(formaPagamentoExistente.getId())) {
                throw new ConstraintException("O formaPagamento com esse ID " + formaPagamentoExistente.getId() + " não existe na base de dados!");
            }
            //Atualiza o formaPagamento na base de dados.
            return formaPagamentoRepository.save(formaPagamentoExistente).toDTO();
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o formaPagamento " + formaPagamentoExistente.getDescricao() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar o formaPagamento " + formaPagamentoExistente.getDescricao() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o formaPagamento " + formaPagamentoExistente.getDescricao() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o formaPagamento " + formaPagamentoExistente.getDescricao() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o formaPagamento" + formaPagamentoExistente.getDescricao() + ". Não encontrado no banco de dados!");
        }
    }

    @Transactional
    public void deletar(FormaPagamentoModel formaPagamentoExistente) {
        try {
            //Caso ocorra uma tentativa de deletar um formaPagamento que não existe utilizando o id.
            if (!formaPagamentoRepository.existsById(formaPagamentoExistente.getId())) {
                throw new ConstraintException("FormaPagamento inexistente na base de dados!");
            }
            //Deletar o formaPagamento na base de dados.
            formaPagamentoRepository.delete(formaPagamentoExistente);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o formaPagamento " + formaPagamentoExistente.getDescricao() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar o formaPagamento " + formaPagamentoExistente.getDescricao() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar o formaPagamento " + formaPagamentoExistente.getDescricao() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + formaPagamentoExistente.getDescricao() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o formaPagamento" + formaPagamentoExistente.getDescricao() + ". Não encontrado no banco de dados!");
        }
    }
}
