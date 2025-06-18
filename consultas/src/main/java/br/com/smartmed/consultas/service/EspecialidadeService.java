package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.exception.*;
import br.com.smartmed.consultas.model.EspecialidadeModel;
import br.com.smartmed.consultas.model.EspecialidadeModel;
import br.com.smartmed.consultas.repository.EspecialidadeRepository;
import br.com.smartmed.consultas.rest.dto.EspecialidadeDTO;
import br.com.smartmed.consultas.rest.dto.EspecialidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelas operações relacionadas aos especialidades.
 */
@Service
public class EspecialidadeService
{
    /**
     * Instância do repositório de especialidades, responsável por realizar operações de
     * persistência e consulta diretamente no banco de dados.
     */
    @Autowired
    private EspecialidadeRepository especialidadeRepository;
    
    /**
     * Obtém um especialidade pelo ID.
     *
     * @param id ID do especialidade.
     * @return especialidadeDTO representando o especialidade encontrado.
     * @throws ObjectNotFoundException Se o especialidade não for encontrado.
     */
    @Transactional(readOnly = true)
    public EspecialidadeDTO obterPorId(int id)
    {
        EspecialidadeModel especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Especialidade com ID " + id + " não encontrado."));
        return especialidade.toDTO();
    }
    
    /**
     * Obtém a lista de todos os especialidades cadastrados.
     *
     * @return Lista de EspecialidadeDTO representando os especialidades cadastrados.
     */
    @Transactional(readOnly = true)
    public List<EspecialidadeDTO> obterTodos()
    {
        List<EspecialidadeModel> especialidades = especialidadeRepository.findAll();
        return especialidades.stream()
                .map(especialidade -> especialidade.toDTO())
                .collect(Collectors.toList());
    }

    /**
     * Verifica a existencia de um especialidade pelo CPF.
     *
     * @return Se o especialidade existe.
     */
    @Transactional(readOnly = true)
    public boolean existeNome(String cpf)
    {
        return especialidadeRepository.existsByNome(cpf);
    }
    
    /**
     * Salva um novo especialidade na base de dados.
     *
     * @param novoEspecialidade especialidadeModel contendo os dados do novo especialidade.
     * @return especialidadeDTO representando o especialidade salvo.
     * @throws ConstraintException       Se o telefone ou e-mail já existirem.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public EspecialidadeDTO salvar(EspecialidadeModel novoEspecialidade)
    {
        try {
            //Caso ocorra uma tentativa de salvar um novo especialidade com um id já existente.
            if (especialidadeRepository.existsById(novoEspecialidade.getId()))
            {
                throw new ConstraintException("Já existe um especialidade com esse ID " + novoEspecialidade.getId() + " na base de dados!");
            }
            //Salva o novo especialidade na base de dados.
            return especialidadeRepository.save(novoEspecialidade).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível salvar o especialidade " + novoEspecialidade.getNome() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o especialidade " + novoEspecialidade.getNome() + ".");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível salvar o especialidade " + novoEspecialidade.getNome() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível salvar o especialidade " + novoEspecialidade.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }
    
    /**
     * Atualiza os dados de um especialidade existente.
     *
     * @param especialidadeExistente especialidadeModel contendo os dados atualizados do cliete.
     * @return especialidadeDTO representando o especialidade atualizado.
     * @throws ConstraintException       Se o telefone ou e-mail não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public EspecialidadeDTO atualizar(EspecialidadeModel especialidadeExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de salvar um especialidade que não existe utilizando um ID.
            if (!especialidadeRepository.existsById(especialidadeExistente.getId()))
            {
                throw new ConstraintException("O especialidade com esse ID " + especialidadeExistente.getId() + " não existe na base de dados!");
            }
            //Atualiza o especialidade na base de dados.
            return especialidadeRepository.save(especialidadeExistente).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o especialidade " + especialidadeExistente.getNome() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao atualizar o especialidade " + especialidadeExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o especialidade " + especialidadeExistente.getNome() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o especialidade " + especialidadeExistente.getNome() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o especialidade" + especialidadeExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
    
    /**
     * Deleta um especialidade da base de dados.
     *
     * @param especialidadeExistente especialidadeModel contendo os dados do especialidade a ser deletado.
     * @throws ConstraintException       Se o especialidade (id) não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public void deletar(EspecialidadeModel especialidadeExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de deletar um especialidade que não existe utilizando o id.
            if (!especialidadeRepository.existsById(especialidadeExistente.getId()))
            {
                throw new ConstraintException("Especialidade inexistente na base de dados!");
            }
            //Deletar o especialidade na base de dados.
            especialidadeRepository.delete(especialidadeExistente);
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível deletar o especialidade " + especialidadeExistente.getNome() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao deletar o especialidade " + especialidadeExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível deletar o especialidade " + especialidadeExistente.getNome() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + especialidadeExistente.getNome() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o especialidade" + especialidadeExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
}