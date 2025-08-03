package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FaturamentoRepository extends JpaRepository<ConsultaModel, Integer> {
    List<ConsultaModel> findByDataHoraConsultaBetweenAndStatus(LocalDate pDataHoraConsultaInicio, LocalDate pDataHoraConsultaFim, String status);

    @Query("SELECT c " +
            "FROM ConsultaModel c " +
            "WHERE c.dataHoraConsulta BETWEEN :dataInicio AND :dataFim AND c.status = 'REALIZADA'")
    List<ConsultaModel> findConsultasRealizadasPorPeriodo(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

    @Query("SELECT fp.descricao as formaPagamento, SUM(c.valor) as valor " +
            "FROM ConsultaModel c JOIN FormaPagamentoModel fp ON c.formaPagamentoID = fp.id " +
            "WHERE c.dataHoraConsulta BETWEEN :dataInicio AND :dataFim AND c.status = 'REALIZADA' " +
            "GROUP BY fp.descricao")
    List<Object[]> findFaturamentoPorFormaPagamento(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

    @Query("SELECT conv.nome as convenio, SUM(c.valor) as valor " +
            "FROM ConsultaModel c JOIN ConvenioModel conv ON c.convenioID = conv.id " +
            "WHERE c.dataHoraConsulta BETWEEN :dataInicio AND :dataFim AND c.status = 'REALIZADA' " +
            "GROUP BY conv.nome")
    List<Object[]> findFaturamentoPorConvenio(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
}
