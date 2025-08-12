package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FaturamentoRepository extends JpaRepository<ConsultaModel, Integer> {
    List<ConsultaModel> findByDataHoraConsultaBetweenAndStatusIgnoreCase(LocalDate pDataHoraConsultaInicio, LocalDate pDataHoraConsultaFim, String status);
}
