package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.exception.*;
import br.com.smartmed.consultas.model.ConsultaModel;
import br.com.smartmed.consultas.repository.ConsultaRepository;
import br.com.smartmed.consultas.rest.dto.ConsultaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ConsultaDTO obterPorId(int id) {
        ConsultaModel consulta = consultaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Consulta com ID " + id + " não encontrado."));
        return modelMapper.map(consulta, ConsultaDTO.class);
    }

    @Transactional(readOnly = true)
    public List<ConsultaDTO> obterTodos() {
        List<ConsultaModel> consultas = consultaRepository.findAll();
        return consultas.stream()
                .map(consulta -> modelMapper.map(consulta, ConsultaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ConsultaDTO> obterPorDataHoraConsulta(LocalDate DataHoraConsulta) {
        List<ConsultaModel> consultas = consultaRepository.findByDataHoraConsulta(DataHoraConsulta);
        return consultas.stream()
                .map(consulta -> modelMapper.map(consulta, ConsultaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ConsultaDTO> obterPorPacienteID(int PacienteID) {
        List<ConsultaModel> consultas = consultaRepository.findByPacienteId(PacienteID);
        return consultas.stream()
                .map(consulta -> modelMapper.map(consulta, ConsultaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ConsultaDTO> obterPorMedicoID(int MedicoID) {
        List<ConsultaModel> consultas = consultaRepository.findByMedicoId(MedicoID);
        return consultas.stream()
                .map(consulta -> modelMapper.map(consulta, ConsultaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ConsultaDTO> obterPorConvenioID(int ConvenioID) {
        List<ConsultaModel> consultas = consultaRepository.findByConvenioId(ConvenioID);
        return consultas.stream()
                .map(consulta -> modelMapper.map(consulta, ConsultaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ConsultaDTO> obterPorStatus(String Status) {
        List<ConsultaModel> consultas = consultaRepository.findByStatus(Status);
        return consultas.stream()
                .map(consulta -> modelMapper.map(consulta, ConsultaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ConsultaDTO> obterPorRecepcionistaID(int RecepcionistaID) {
        List<ConsultaModel> consultas = consultaRepository.findByRecepcionistaId(RecepcionistaID);
        return consultas.stream()
                .map(consulta -> modelMapper.map(consulta, ConsultaDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public ConsultaDTO salvar(ConsultaModel novoConsulta) {
        try {
            //Caso ocorra uma tentativa de salvar um novo consulta com um id já existente.
            if (consultaRepository.existsById(novoConsulta.getId())) {
                throw new ConstraintException("Já existe um consulta com esse ID " + novoConsulta.getId() + " na base de dados!");
            }
            //Salva o novo consulta na base de dados.
            return modelMapper.map(consultaRepository.save(novoConsulta), ConsultaDTO.class);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o consulta " + novoConsulta.getStatus() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o consulta " + novoConsulta.getStatus() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar o consulta " + novoConsulta.getStatus() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar o consulta " + novoConsulta.getStatus() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public ConsultaDTO atualizar(ConsultaModel consultaExistente) {
        try {
            //Caso ocorra uma tentativa de salvar um consulta que não existe utilizando um ID.
            if (!consultaRepository.existsById(consultaExistente.getId())) {
                throw new ConstraintException("O consulta com esse ID " + consultaExistente.getId() + " não existe na base de dados!");
            }
            //Atualiza o consulta na base de dados.
            return modelMapper.map(consultaRepository.save(consultaExistente), ConsultaDTO.class);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o consulta " + consultaExistente.getStatus() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar o consulta " + consultaExistente.getStatus() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o consulta " + consultaExistente.getStatus() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o consulta " + consultaExistente.getStatus() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o consulta" + consultaExistente.getStatus() + ". Não encontrado no banco de dados!");
        }
    }

    @Transactional
    public void deletar(ConsultaModel consultaExistente) {
        try {
            //Caso ocorra uma tentativa de deletar um consulta que não existe utilizando o id.
            if (!consultaRepository.existsById(consultaExistente.getId())) {
                throw new ConstraintException("Consulta inexistente na base de dados!");
            }
            //Deletar o consulta na base de dados.
            consultaRepository.delete(consultaExistente);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o consulta " + consultaExistente.getStatus() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar o consulta " + consultaExistente.getStatus() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar o consulta " + consultaExistente.getStatus() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + consultaExistente.getStatus() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o consulta" + consultaExistente.getStatus() + ". Não encontrado no banco de dados!");
        }
    }
}
