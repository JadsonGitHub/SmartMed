package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.exception.*;
import br.com.smartmed.consultas.model.ConvenioModel;
import br.com.smartmed.consultas.model.ConvenioModel;
import br.com.smartmed.consultas.repository.ConvenioRepository;
import br.com.smartmed.consultas.rest.dto.ConvenioDTO;
import br.com.smartmed.consultas.rest.dto.ConvenioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelas operações relacionadas aos convenios.
 */
@Service
public class ConvenioService
{
    /**
     * Instância do repositório de convenios, responsável por realizar operações de
     * persistência e consulta diretamente no banco de dados.
     */
    @Autowired
    private ConvenioRepository convenioRepository;
    
    /**
     * Obtém um convenio pelo ID.
     *
     * @param id ID do convenio.
     * @return convenioDTO representando o convenio encontrado.
     * @throws ObjectNotFoundException Se o convenio não for encontrado.
     */
    @Transactional(readOnly = true)
    public ConvenioDTO obterPorId(int id)
    {
        ConvenioModel convenio = convenioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Convenio com ID " + id + " não encontrado."));
        return convenio.toDTO();
    }
    
    /**
     * Obtém a lista de todos os convenios cadastrados.
     *
     * @return Lista de ConvenioDTO representando os convenios cadastrados.
     */
    @Transactional(readOnly = true)
    public List<ConvenioDTO> obterTodos()
    {
        List<ConvenioModel> convenios = convenioRepository.findAll();
        return convenios.stream()
                .map(convenio -> convenio.toDTO())
                .collect(Collectors.toList());
    }

    /**
     * Obtém a lista de todos os convenios cadastrados com um nome.
     *
     * @return Lista de ConvenioDTO representando os convenios cadastrados com o nome.
     */
    @Transactional(readOnly = true)
    public List<ConvenioDTO> obterPorNome(String nome)
    {
        List<ConvenioModel> convenios = convenioRepository.findByNome(nome);
        return convenios.stream()
                .map(convenio -> convenio.toDTO())
                .collect(Collectors.toList());
    }

    /**
     * Obtém um convenio pelo CNPJ.
     *
     * @param cnpj CNPJ do convenio.
     * @return convenioDTO representando o convenio encontrado.
     * @throws ObjectNotFoundException Se o convenio não for encontrado.
     */
    @Transactional(readOnly = true)
    public ConvenioDTO obterPorCnpj(String cnpj)
    {
        ConvenioModel convenio = convenioRepository.findByCnpj(cnpj).orElseThrow(() -> new ObjectNotFoundException("Convenio com ID " + cnpj + " não encontrado."));
        return convenio.toDTO();
    }
    
    /**
     * Salva um novo convenio na base de dados.
     *
     * @param novoConvenio convenioModel contendo os dados do novo convenio.
     * @return convenioDTO representando o convenio salvo.
     * @throws ConstraintException       Se o telefone ou e-mail já existirem.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public ConvenioDTO salvar(ConvenioModel novoConvenio)
    {
        try {
            //Caso ocorra uma tentativa de salvar um novo convenio com um Cnpj já existente.
            if (convenioRepository.existsByCnpj(novoConvenio.getCnpj()))
            {
                throw new ConstraintException("Já existe um convenio com esse CNPJ " + novoConvenio.getCnpj() + " na base de dados!");
            }
            //Salva o novo convenio na base de dados.
            return convenioRepository.save(novoConvenio).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível salvar o convenio " + novoConvenio.getNome() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o convenio " + novoConvenio.getNome() + ".");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível salvar o convenio " + novoConvenio.getNome() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível salvar o convenio " + novoConvenio.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }
    
    /**
     * Atualiza os dados de um convenio existente.
     *
     * @param convenioExistente convenioModel contendo os dados atualizados do cliete.
     * @return convenioDTO representando o convenio atualizado.
     * @throws ConstraintException       Se o telefone ou e-mail não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public ConvenioDTO atualizar(ConvenioModel convenioExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de salvar um convenio que não existe utilizando um CNPJ.
            if (!convenioRepository.existsByCnpj(convenioExistente.getCnpj()))
            {
                throw new ConstraintException("O convenio com esse CNPJ " + convenioExistente.getCnpj() + " não existe na base de dados!");
            }
            //Atualiza o convenio na base de dados.
            return convenioRepository.save(convenioExistente).toDTO();
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o convenio " + convenioExistente.getNome() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao atualizar o convenio " + convenioExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o convenio " + convenioExistente.getNome() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o convenio " + convenioExistente.getNome() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o convenio" + convenioExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
    
    /**
     * Deleta um convenio da base de dados.
     *
     * @param convenioExistente convenioModel contendo os dados do convenio a ser deletado.
     * @throws ConstraintException       Se o convenio (id) não existir.
     * @throws DataIntegrityException    Se ocorrer violação de integridade.
     * @throws BusinessRuleException     Se houver violação de regra de negócio.
     * @throws SQLException              Se ocorrer falha de conexão com o banco de dados.
     */
    @Transactional
    public void deletar(ConvenioModel convenioExistente)
    {
        try
        {
            //Caso ocorra uma tentativa de deletar um convenio que não existe utilizando o id.
            if (!convenioRepository.existsById(convenioExistente.getId()))
            {
                throw new ConstraintException("Convenio inexistente na base de dados!");
            }
            //Deletar o convenio na base de dados.
            convenioRepository.delete(convenioExistente);
        }
        catch (DataIntegrityException e)
        {
            throw new DataIntegrityException("Erro! Não foi possível deletar o convenio " + convenioExistente.getNome() + " !");
        }
        catch (ConstraintException e)
        {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank())
            {
                throw new ConstraintException("Erro ao deletar o convenio " + convenioExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        }
        catch (BusinessRuleException e)
        {
            throw new BusinessRuleException("Erro! Não foi possível deletar o convenio " + convenioExistente.getNome() + ". Violação de regra de negócio!");
        }
        catch (SQLException e)
        {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + convenioExistente.getNome() + ". Falha na conexão com o banco de dados!");
        }
        catch (ObjectNotFoundException e)
        {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o convenio" + convenioExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
}