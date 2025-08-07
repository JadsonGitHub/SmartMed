package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer> {

    List<ConsultaModel> findByDataHoraConsulta(LocalDate pDataHoraConsulta);

    List<ConsultaModel> findByPacienteId(int pPacienteID);

    List<ConsultaModel> findByMedicoId(int pMedicoID);

    List<ConsultaModel> findByConvenioId(int pConvenioID);

    List<ConsultaModel> findByRecepcionistaId(int pRecepcionistaID);

    List<ConsultaModel> findByStatus(String pStatus);
}
