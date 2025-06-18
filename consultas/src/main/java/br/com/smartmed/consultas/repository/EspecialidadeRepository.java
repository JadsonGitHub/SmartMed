package br.com.smartmed.consultas.repository;

import br.com.smartmed.consultas.model.ConvenioModel;
import br.com.smartmed.consultas.model.EspecialidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadeRepository extends JpaRepository<EspecialidadeModel, Integer>
{
    /**
     * Verifica se existe uma especialidade cadastrado com o nome especificado.
     *
     * @param nome O nome a ser verificado.
     * @return {@code true} se existir uma especialidade com o nome fornecido, {@code false} caso contrário.
     */
    boolean existsByNome(String nome);
}