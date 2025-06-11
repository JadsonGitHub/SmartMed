package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.exception.*;
import br.com.smartmed.consultas.model.ConsultaModel;
import br.com.smartmed.consultas.repository.ConsultaRepository;
import br.com.smartmed.consultas.rest.dto.ConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelas operações relacionadas aos consultas.
 */
@Service
public class ConsultaService
{
    /**
     * Instância do repositório de consultas, responsável por realizar operações de
     * persistência e consulta diretamente no banco de dados.
     */
    @Autowired
    private ConsultaRepository consultaRepository;
    /**
     * Obtém um consulta pelo ID.
     *
     * @param id ID do consulta.
     * @return consultaDTO representando o consulta encontrado.
     * @throws ObjectNotFoundException Se o consulta não for encontrado.
     */
    @Transactional(readOnly = true)
    public ConsultaDTO obterPorId(int id)
    {
        ConsultaModel consulta = consultaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Consulta com ID " + id + " não encontrado."));
        return consulta.toDTO();
    }
    /**
     * Obtém a lista de todos os consultas cadastrados.
     *
     * @return Lista de ConsultaDTO representando os consultas cadastrados.
     */
    @Transactional(readOnly = true)
    public List<ConsultaDTO> obterTodos()
    {
        List<ConsultaModel> consultas = consultaRepository.findAll();
        return consultas.stream()
                .map(consulta -> consulta.toDTO())
                .collect(Collectors.toList());
    }
    /**
     * Salva um novo consulta na base de dados.
     *
     * @param novoConsulta consultaModel contendo os dados do novo consulta.
     * @return consultaDTO representando o consulta salvo.
     * @throws ConstraintException       Se o telefone ou e-mail já existirem.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public ConsultaDTO salvar(ConsultaModel novoConsulta)
    {
        try {
            //Caso ocorra uma tentativa de salvar um novo consulta com um id já existente.
            if (consultaRepository.existsById(novoConsulta.getId()))
            {
                throw new ConstraintException("Já existe um consulta com esse ID " + novoConsulta.getId() + " na base de dados!");
            }
            //Salva o novo consulta na base de dados.
            return consultaRepository.save(novoConsulta).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível salvar o consulta " + novoConsulta.getStatus() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o consulta " + novoConsulta.getStatus() + ".");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível salvar o consulta " + novoConsulta.getStatus() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível salvar o consulta " + novoConsulta.getStatus() + ". Falha na conexão com o banco de dados!");
        }
    }
    /**
     * Atualiza os dados de um consulta existente.
     *
     * @param consultaExistente consultaModel contendo os dados atualizados do cliete.
     * @return consultaDTO representando o consulta atualizado.
     * @throws ConstraintException       Se o telefone ou e-mail não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public ConsultaDTO atualizar(ConsultaModel consultaExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de salvar um consulta que não existe utilizando um ID.
            if (!consultaRepository.existsById(consultaExistente.getId()))
            {
                throw new ConstraintException("O consulta com esse ID " + consultaExistente.getId() + " não existe na base de dados!");
            }
            //Atualiza o consulta na base de dados.
            return consultaRepository.save(consultaExistente).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o consulta " + consultaExistente.getStatus() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao atualizar o consulta " + consultaExistente.getStatus() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o consulta " + consultaExistente.getStatus() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o consulta " + consultaExistente.getStatus() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o consulta" + consultaExistente.getStatus() + ". Não encontrado no banco de dados!");
        }
    }
    /**
     * Deleta um consulta da base de dados.
     *
     * @param consultaExistente consultaModel contendo os dados do consulta a ser deletado.
     * @throws ConstraintException       Se o consulta (id) não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public void deletar(ConsultaModel consultaExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de deletar um consulta que não existe utilizando o id.
            if (!consultaRepository.existsById(consultaExistente.getId()))
            {
                throw new ConstraintException("Consulta inexistente na base de dados!");
            }
            //Deletar o consulta na base de dados.
            consultaRepository.delete(consultaExistente);
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível deletar o consulta " + consultaExistente.getStatus() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao deletar o consulta " + consultaExistente.getStatus() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível deletar o consulta " + consultaExistente.getStatus() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + consultaExistente.getStatus() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o consulta" + consultaExistente.getStatus() + ". Não encontrado no banco de dados!");
        }
    }
}