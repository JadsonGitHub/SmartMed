package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.exception.*;
import br.com.smartmed.consultas.model.EspecialidadeModel;
import br.com.smartmed.consultas.repository.EspecialidadeRepository;
import br.com.smartmed.consultas.rest.dto.EspecialidadeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadeService {
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public EspecialidadeDTO obterPorId(int id) {
        EspecialidadeModel especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Especialidade com ID " + id + " não encontrado."));
        return modelMapper.map(especialidade, EspecialidadeDTO.class);
    }

    @Transactional(readOnly = true)
    public List<EspecialidadeDTO> obterTodos() {
        List<EspecialidadeModel> especialidades = especialidadeRepository.findAll();
        return especialidades.stream()
                .map(especialidade -> modelMapper.map(especialidade, EspecialidadeDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public boolean existeNome(String cpf) {
        return especialidadeRepository.existsByNome(cpf);
    }

    @Transactional
    public EspecialidadeDTO salvar(EspecialidadeModel novoEspecialidade) {
        try {
            //Caso ocorra uma tentativa de salvar um novo especialidade com um id já existente.
            if (especialidadeRepository.existsById(novoEspecialidade.getId())) {
                throw new ConstraintException("Já existe um especialidade com esse ID " + novoEspecialidade.getId() + " na base de dados!");
            }
            //Salva o novo especialidade na base de dados.
            return modelMapper.map(especialidadeRepository.save(novoEspecialidade), EspecialidadeDTO.class);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o especialidade " + novoEspecialidade.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o especialidade " + novoEspecialidade.getNome() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar o especialidade " + novoEspecialidade.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar o especialidade " + novoEspecialidade.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public EspecialidadeDTO atualizar(EspecialidadeModel especialidadeExistente) {
        try {
            //Caso ocorra uma tentativa de salvar um especialidade que não existe utilizando um ID.
            if (!especialidadeRepository.existsById(especialidadeExistente.getId())) {
                throw new ConstraintException("O especialidade com esse ID " + especialidadeExistente.getId() + " não existe na base de dados!");
            }
            //Atualiza o especialidade na base de dados.
            return modelMapper.map(especialidadeRepository.save(especialidadeExistente), EspecialidadeDTO.class);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o especialidade " + especialidadeExistente.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar o especialidade " + especialidadeExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o especialidade " + especialidadeExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o especialidade " + especialidadeExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o especialidade" + especialidadeExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }

    @Transactional
    public void deletar(EspecialidadeModel especialidadeExistente) {
        try {
            //Caso ocorra uma tentativa de deletar um especialidade que não existe utilizando o id.
            if (!especialidadeRepository.existsById(especialidadeExistente.getId())) {
                throw new ConstraintException("Especialidade inexistente na base de dados!");
            }
            //Deletar o especialidade na base de dados.
            especialidadeRepository.delete(especialidadeExistente);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o especialidade " + especialidadeExistente.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar o especialidade " + especialidadeExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar o especialidade " + especialidadeExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + especialidadeExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o especialidade" + especialidadeExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
}
