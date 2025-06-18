package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, Integer>
{
    List<MedicoModel> findByNome(String pNome);

    Optional<MedicoModel> findByCrm(String pCrm);

    List<MedicoModel> findByEspecialidadeID(int pEspecialidadeID);

    List<MedicoModel> findByAtivo(Boolean pAtivo);

    boolean existsByCrm(String crm);
    /**
     * Verifica se existe um medico cadastrado com o telefone especificado.
     *
     * @param telefone O telefone a ser verificado.
     * @return {@code true} se existir um medico com o telefone fornecido, {@code false} caso contrário.
     */
    boolean existsByTelefone(String telefone);
    /**
     * Verifica se existe um medico cadastrado com o e-mail especificado.
     *
     * @param email O e-mail a ser verificado.
     * @return {@code true} se existir um medico com o e-mail fornecido, {@code false} caso contrário.
     */
    boolean existsByEmail(String email);
}