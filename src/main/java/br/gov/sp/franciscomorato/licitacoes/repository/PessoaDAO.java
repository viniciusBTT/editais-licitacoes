
package br.gov.sp.franciscomorato.licitacoes.repository;

import br.gov.sp.franciscomorato.licitacoes.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thiago
 */
@Repository
public interface PessoaDAO extends JpaRepository<Pessoa, Long>
{
    @Query(value = "SELECT p FROM PESSOA p WHERE p.pessoaFisica.email = :e")
    public Pessoa findByEmail(@Param("e") String email);
}
