package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer>
{
    List<ConsultaModel> findByDataHoraConsulta(LocalDate pDataHoraConsulta);

    List<ConsultaModel> findByPacienteID(int pPacienteID);

    List<ConsultaModel> findByMedicoID(int pMedicoID);

    List<ConsultaModel> findByConvenioID(int pConvenioID);
}