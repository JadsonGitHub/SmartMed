package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.ConvenioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConvenioRepository extends JpaRepository<ConvenioModel, Integer> {

    List<ConvenioModel> findByNomeContainingIgnoreCase(String pNome);

    Optional<ConvenioModel> findByCnpj(String pCnpj);

    List<ConvenioModel> findByAtivo(Boolean pAtivo);

    boolean existsByCnpj(String cnpj);
}
