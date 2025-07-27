package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.exception.*;
import br.com.smartmed.consultas.model.PacienteModel;
import br.com.smartmed.consultas.repository.PacienteRepository;
import br.com.smartmed.consultas.rest.dto.PacienteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public PacienteDTO obterPorId(int id) {
        PacienteModel paciente = pacienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Paciente com ID " + id + " não encontrado."));
//        return paciente.toDTO();
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Transactional(readOnly = true)
    public List<PacienteDTO> obterTodos() {
        List<PacienteModel> pacientes = pacienteRepository.findAll();
//        return pacientes.stream()
//                .map(paciente -> paciente.toDTO())
//                .collect(Collectors.toList());
        return pacientes.stream()
                .map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PacienteDTO> obterPorNome(String nome) {
        List<PacienteModel> pacientes = pacienteRepository.findByNomeContainingIgnoreCase(nome);
//        return pacientes.stream()
//                .map(paciente -> paciente.toDTO())
//                .collect(Collectors.toList());
        return pacientes.stream()
                .map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PacienteDTO obterPorCpf(String cpf) {
        PacienteModel paciente = pacienteRepository.findByCpf(cpf).orElseThrow(() -> new ObjectNotFoundException("Paciente com ID " + cpf + " não encontrado."));
//        return paciente.toDTO();
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Transactional(readOnly = true)
    public boolean existeTelefone(String telefone) {
        return pacienteRepository.existsByTelefone(telefone);
    }

    @Transactional(readOnly = true)
    public boolean existeEmail(String email) {
        return pacienteRepository.existsByEmail(email);
    }

    @Transactional
    public PacienteDTO salvar(PacienteModel novoPaciente) {
        try {
            //Caso ocorra uma tentativa de salvar um novo paciente com um cpf já existente.
            if (pacienteRepository.existsByCpf(novoPaciente.getCpf())) {
                throw new ConstraintException("Já existe um paciente com esse CPF " + novoPaciente.getCpf() + " na base de dados!");
            }
            //Salva o novo paciente na base de dados.
//            return pacienteRepository.save(novoPaciente).toDTO();
            return modelMapper.map(pacienteRepository.save(novoPaciente), PacienteDTO.class);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível salvar o paciente " + novoPaciente.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro de restrição de integridade ao salvar o paciente " + novoPaciente.getNome() + ".");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível salvar o paciente " + novoPaciente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível salvar o paciente " + novoPaciente.getNome() + ". Falha na conexão com o banco de dados!");
        }
    }

    @Transactional
    public PacienteDTO atualizar(PacienteModel pacienteExistente) {
        try {
            //Caso ocorra uma tentativa de salvar um paciente que não existe utilizando um CPF.
            if (!pacienteRepository.existsByCpf(pacienteExistente.getCpf())) {
                throw new ConstraintException("O paciente com esse CPF " + pacienteExistente.getCpf() + " não existe na base de dados!");
            }
            //Atualiza o paciente na base de dados.
//            return pacienteRepository.save(pacienteExistente).toDTO();
            return modelMapper.map(pacienteRepository.save(pacienteExistente), PacienteDTO.class);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível atualizar o paciente " + pacienteExistente.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao atualizar o paciente " + pacienteExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível atualizar o paciente " + pacienteExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o paciente " + pacienteExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível atualizar o paciente" + pacienteExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }

    @Transactional
    public void deletar(PacienteModel pacienteExistente) {
        try {
            //Caso ocorra uma tentativa de deletar um paciente que não existe utilizando o id.
            if (!pacienteRepository.existsById(pacienteExistente.getId())) {
                throw new ConstraintException("Paciente inexistente na base de dados!");
            }
            //Deletar o paciente na base de dados.
            pacienteRepository.delete(pacienteExistente);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Erro! Não foi possível deletar o paciente " + pacienteExistente.getNome() + " !");
        } catch (ConstraintException e) {
            // Relança a mensagem original ou adiciona contexto
            if (e.getMessage() == null || e.getMessage().isBlank()) {
                throw new ConstraintException("Erro ao deletar o paciente " + pacienteExistente.getNome() + ": Restrição de integridade de dados.");
            }
            throw e;
        } catch (BusinessRuleException e) {
            throw new BusinessRuleException("Erro! Não foi possível deletar o paciente " + pacienteExistente.getNome() + ". Violação de regra de negócio!");
        } catch (SQLException e) {
            throw new SQLException("Erro! Não foi possível atualizar o deletar " + pacienteExistente.getNome() + ". Falha na conexão com o banco de dados!");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Erro! Não foi possível deletar o paciente" + pacienteExistente.getNome() + ". Não encontrado no banco de dados!");
        }
    }
}
