package br.com.smartmed.consultas.service;

import br.com.smartmed.consultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço responsavel pelas operacoes relacionadas aos pacientes
 */
@Service
public class PacienteService
{
    @Autowired
    private PacienteRepository pacienteRepository;
}
