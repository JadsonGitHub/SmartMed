package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.exception.*;
import br.com.smartmed.consultas.model.RecepcionistaModel;
import br.com.smartmed.consultas.model.RecepcionistaModel;
import br.com.smartmed.consultas.repository.RecepcionistaRepository;
import br.com.smartmed.consultas.rest.dto.RecepcionistaDTO;
import br.com.smartmed.consultas.rest.dto.RecepcionistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelas operações relacionadas aos recepcionistas.
 */
@Service
public class RecepcionistaService
{
    /**
     * Instância do repositório de recepcionistas, responsável por realizar operações de
     * persistência e consulta diretamente no banco de dados.
     */
    @Autowired
    private RecepcionistaRepository recepcionistaRepository;
    
    /**
     * Obtém um recepcionista pelo ID.
     *
     * @param id ID do recepcionista.
     * @return recepcionistaDTO representando o recepcionista encontrado.
     * @throws ObjectNotFoundException Se o recepcionista não for encontrado.
     */
    @Transactional(readOnly = true)
    public RecepcionistaDTO obterPorId(int id)
    {
        RecepcionistaModel recepcionista = recepcionistaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Recepcionista com ID " + id + " não encontrado."));
        return recepcionista.toDTO();
    }
    
    /**
     * Obtém a lista de todos os recepcionistas cadastrados.
     *
     * @return Lista de RecepcionistaDTO representando os recepcionistas cadastrados.
     */
    @Transactional(readOnly = true)
    public List<RecepcionistaDTO> obterTodos()
    {
        List<RecepcionistaModel> recepcionistas = recepcionistaRepository.findAll();
        return recepcionistas.stream()
                .map(recepcionista -> recepcionista.toDTO())
                .collect(Collectors.toList());
    }

    /**
     * Obtém a lista de todos os recepcionistas cadastrados com um nome.
     *
     * @return Lista de RecepcionistaDTO representando os recepcionistas cadastrados com o nome.
     */
    @Transactional(readOnly = true)
    public List<RecepcionistaDTO> obterPorNome(String nome)
    {
        List<RecepcionistaModel> recepcionistas = recepcionistaRepository.findByNome(nome);
        return recepcionistas.stream()
                .map(recepcionista -> recepcionista.toDTO())
                .collect(Collectors.toList());
    }

    /**
     * Obtém um recepcionista pelo CPF.
     *
     * @param cpf CPF do recepcionista.
     * @return recepcionistaDTO representando o recepcionista encontrado.
     * @throws ObjectNotFoundException Se o recepcionista não for encontrado.
     */
    @Transactional(readOnly = true)
    public RecepcionistaDTO obterPorCpf(String cpf)
    {
        RecepcionistaModel recepcionista = recepcionistaRepository.findByCpf(cpf).orElseThrow(() -> new ObjectNotFoundException("Recepcionista com ID " + cpf + " não encontrado."));
        return recepcionista.toDTO();
    }
    
    /**
     * Salva um novo recepcionista na base de dados.
     *
     * @param novoRecepcionista recepcionistaModel contendo os dados do novo recepcionista.
     * @return recepcionistaDTO representando o recepcionista salvo.
     * @throws ConstraintException       Se o telefone ou e-mail já existirem.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public RecepcionistaDTO salvar(RecepcionistaModel novoRecepcionista)
    {
        try
        {
            //Caso ocorra uma tentativa de salvar um novo recepcionista com um cpf já existente.
            if (recepcionistaRepository.existsByCpf(novoRecepcionista.getCpf()))
            {
                throw new ConstraintException("Já existe um recepcionista com esse CPF " + novoRecepcionista.getCpf() + " na base de dados!");
            }
            //Salva o novo recepcionista na base de dados.
            return recepcionistaRepository.save(novoRecepcionista).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível salvar o recepcionista " + novoRecepcionista.getNome() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o recepcionista " + novoRecepcionista.getNome() + ".");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível salvar o recepcionista " + novoRecepcionista.getNome() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível salvar o recepcionista " + novoRecepcionista.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }
    /**
     * Atualiza os dados de um recepcionista existente.
     *
     * @param recepcionistaExistente recepcionistaModel contendo os dados atualizados do cliete.
     * @return recepcionistaDTO representando o recepcionista atualizado.
     * @throws ConstraintException       Se o telefone ou e-mail não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public RecepcionistaDTO atualizar(RecepcionistaModel recepcionistaExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de salvar um recepcionista que não existe utilizando um CPF.
            if (!recepcionistaRepository.existsByCpf(recepcionistaExistente.getCpf()))
            {
                throw new ConstraintException("O recepcionista com esse CPF " + recepcionistaExistente.getCpf() + " não existe na base de dados!");
            }
            //Atualiza o recepcionista na base de dados.
            return recepcionistaRepository.save(recepcionistaExistente).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o recepcionista " + recepcionistaExistente.getNome() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao atualizar o recepcionista " + recepcionistaExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o recepcionista " + recepcionistaExistente.getNome() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o recepcionista " + recepcionistaExistente.getNome() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o recepcionista" + recepcionistaExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
    /**
     * Deleta um recepcionista da base de dados.
     *
     * @param recepcionistaExistente recepcionistaModel contendo os dados do recepcionista a ser deletado.
     * @throws ConstraintException       Se o recepcionista (id) não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public void deletar(RecepcionistaModel recepcionistaExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de deletar um recepcionista que não existe utilizando o id.
            if (!recepcionistaRepository.existsById(recepcionistaExistente.getId()))
            {
                throw new ConstraintException("Recepcionista inexistente na base de dados!");
            }
            //Deletar o recepcionista na base de dados.
            recepcionistaRepository.delete(recepcionistaExistente);
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível deletar o recepcionista " + recepcionistaExistente.getNome() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao deletar o recepcionista " + recepcionistaExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível deletar o recepcionista " + recepcionistaExistente.getNome() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + recepcionistaExistente.getNome() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o recepcionista" + recepcionistaExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
}