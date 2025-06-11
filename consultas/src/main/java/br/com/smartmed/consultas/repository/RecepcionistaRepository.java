package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.RecepcionistaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecepcionistaRepository extends JpaRepository<RecepcionistaModel, Integer>
{
    List<RecepcionistaModel> findByNome(String pNome);

    Optional<RecepcionistaModel> findByCpf(String pCpf);
    /**
     * Verifica se existe um cliente cadastrado com o cpf especificado.
     *
     * @param cpf O cpf a ser verificado.
     * @return {@code true} se existir um cliente com o cpf fornecido, {@code false} caso contrário.
     */
    boolean existsByCpf(String cpf);
    /**
     * Verifica se existe um cliente cadastrado com o telefone especificado.
     *
     * @param telefone O telefone a ser verificado.
     * @return {@code true} se existir um cliente com o telefone fornecido, {@code false} caso contrário.
     */
    boolean existsByTelefone(String telefone);
    /**
     * Verifica se existe um cliente cadastrado com o e-mail especificado.
     *
     * @param email O e-mail a ser verificado.
     * @return {@code true} se existir um cliente com o e-mail fornecido, {@code false} caso contrário.
     */
    boolean existsByEmail(String email);
}