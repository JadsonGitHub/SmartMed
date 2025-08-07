package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, Integer> {

    List<MedicoModel> findByNomeContainingIgnoreCase(String pNome);

    Optional<MedicoModel> findByCrm(String pCrm);

    List<MedicoModel> findByEspecialidadeId(int pEspecialidadeID);

    List<MedicoModel> findByAtivo(Boolean pAtivo);

    boolean existsByCrm(String crm);
}
