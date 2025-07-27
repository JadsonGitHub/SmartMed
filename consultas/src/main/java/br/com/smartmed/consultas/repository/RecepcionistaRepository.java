package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.RecepcionistaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecepcionistaRepository extends JpaRepository<RecepcionistaModel, Integer> {

    List<RecepcionistaModel> findByNomeContainingIgnoreCase(String pNome);

    Optional<RecepcionistaModel> findByCpf(String pCpf);

    List<RecepcionistaModel> findByAtivo(Boolean pAtivo);

    boolean existsByCpf(String cpf);

    boolean existsByTelefone(String telefone);

    boolean existsByEmail(String email);
}
