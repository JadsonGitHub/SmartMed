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

    List<ConsultaModel> findByRecepcionistaID(int pRecepcionistaID);

    List<ConsultaModel> findByStatus(String pStatus);

    /**
     * Verifica se existe um cliente cadastrado com a dataHoraConsulta especificado.
     *
     * @param dataHoraConsulta A Data/Hora da Consulta a ser verificada.
     * @return {@code true} se existir um cliente com o dataHoraConsulta fornecido, {@code false} caso contrário.
     */
    boolean existsByDataHoraConsulta(LocalDate dataHoraConsulta);
    /**
     * Verifica se existe um cliente cadastrado com o status especificado.
     *
     * @param status O Status a ser verificado.
     * @return {@code true} se existir um cliente com o status fornecido, {@code false} caso contrário.
     */
    boolean existsByStatus(String status);
    /**
     * Verifica se existe um cliente cadastrado com o pacienteID especificado.
     *
     * @param pacienteID O Paciente ID a ser verificado.
     * @return {@code true} se existir um cliente com o pacienteID fornecido, {@code false} caso contrário.
     */
    boolean existsByPacienteID(int pacienteID);
    /**
     * Verifica se existe um cliente cadastrado com o medicoID especificado.
     *
     * @param medicoID O Medico ID a ser verificado.
     * @return {@code true} se existir um cliente com o medicoID fornecido, {@code false} caso contrário.
     */
    boolean existsByMedicoID(int medicoID);
    /**
     * Verifica se existe um cliente cadastrado com o formaPagamentoID especificado.
     *
     * @param formaPagamentoID O Forma Pagamento ID a ser verificado.
     * @return {@code true} se existir um cliente com o formaPagamentoID fornecido, {@code false} caso contrário.
     */
    boolean existsByFormaPagamentoID(int formaPagamentoID);
    /**
     * Verifica se existe um cliente cadastrado com o convenioID especificado.
     *
     * @param convenioID O Convenio ID a ser verificado.
     * @return {@code true} se existir um cliente com o convenioID fornecido, {@code false} caso contrário.
     */
    boolean existsByConvenioID(int convenioID);
    /**
     * Verifica se existe um cliente cadastrado com o recepcionistaID especificado.
     *
     * @param recepcionistaID O Recepcionista ID a ser verificado.
     * @return {@code true} se existir um cliente com o recepcionistaID fornecido, {@code false} caso contrário.
     */
    boolean existsByRecepcionistaID(int recepcionistaID);
}