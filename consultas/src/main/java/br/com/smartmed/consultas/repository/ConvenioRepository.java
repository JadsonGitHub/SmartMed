package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.ConvenioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConvenioRepository extends JpaRepository<ConvenioModel, Integer>
{
    List<ConvenioModel> findByNome(String pNome);

    Optional<ConvenioModel> findByCnpj(String pCnpj);
    /**
     * Verifica se existe um cliente cadastrado com o cpf especificado.
     *
     * @param cnpj O cnpj a ser verificado.
     * @return {@code true} se existir um cliente com o cpf fornecido, {@code false} caso contrário.
     */
    boolean existsByCnpj(String cnpj);
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