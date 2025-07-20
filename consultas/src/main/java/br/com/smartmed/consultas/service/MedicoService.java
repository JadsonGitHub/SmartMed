package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.exception.*;
import br.com.smartmed.consultas.model.MedicoModel;
import br.com.smartmed.consultas.repository.MedicoRepository;
import br.com.smartmed.consultas.rest.dto.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional(readOnly = true)
    public MedicoDTO obterPorId(int id) {
        MedicoModel medico = medicoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Médico com ID " + id + " não encontrado."));
        return medico.toDTO();
    }

    @Transactional(readOnly = true)
    public List<MedicoDTO> obterTodos() {
        List<MedicoModel> medicos = medicoRepository.findAll();
        return medicos.stream()
                .map(medico -> medico.toDTO())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MedicoDTO> obterPorNome(String nome) {
        List<MedicoModel> medicos = medicoRepository.findByNome(nome);
        return medicos.stream()
                .map(medico -> medico.toDTO())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MedicoDTO obterPorCrm(String crm) {
        MedicoModel medico = medicoRepository.findByCrm(crm).orElseThrow(() -> new ObjectNotFoundException("Medico com ID " + crm + " não encontrado."));
        return medico.toDTO();
    }

    @Transactional
    public MedicoDTO salvar(MedicoModel novoMedico) {
        try {
            //Caso ocorra uma tentativa de salvar um novo medico com um crm já existente.
            if (medicoRepository.existsByCrm(novoMedico.getCrm())) {
                throw new ConstraintException("Já existe um medico com esse CRM " + novoMedico.getCrm() + " na base de dados!");
            }
            //Salva o novo medico na base de dados.
            return medicoRepository.save(novoMedico).toDTO();
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o medico " + novoMedico.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o medico " + novoMedico.getNome() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar o medico " + novoMedico.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar o medico " + novoMedico.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public MedicoDTO atualizar(MedicoModel medicoExistente) {
        try {
            //Caso ocorra uma tentativa de salvar um medico que não existe utilizando um CRM.
            if (!medicoRepository.existsByCrm(medicoExistente.getCrm())) {
                throw new ConstraintException("O medico com esse CRM " + medicoExistente.getCrm() + " não existe na base de dados!");
            }
            //Atualiza o medico na base de dados.
            return medicoRepository.save(medicoExistente).toDTO();

        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o medico " + medicoExistente.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar o medico " + medicoExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o medico " + medicoExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o medico " + medicoExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o medico" + medicoExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }

    @Transactional
    public void deletar(MedicoModel medicoExistente) {
        try {
            //Caso ocorra uma tentativa de deletar um medico que não existe utilizando o id.
            if (!medicoRepository.existsById(medicoExistente.getId())) {
                throw new ConstraintException("Medico inexistente na base de dados!");
            }
            //Deletar o medico na base de dados.
            medicoRepository.delete(medicoExistente);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o medico " + medicoExistente.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar o medico " + medicoExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar o medico " + medicoExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + medicoExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o medico" + medicoExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
}
