package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {

    List<PacienteModel> findByNome(String pNome);

    Optional<PacienteModel> findByCpf(String pCpf);

    boolean existsByCpf(String cpf);

    boolean existsByTelefone(String telefone);

    boolean existsByEmail(String email);
}
