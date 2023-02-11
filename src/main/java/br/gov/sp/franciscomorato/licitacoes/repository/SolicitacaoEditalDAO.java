
package br.gov.sp.franciscomorato.licitacoes.repository;

import br.gov.sp.franciscomorato.licitacoes.model.SolicitacaoEdital;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



/**
 *  HQL IF - http://www.hplsql.org/if
 * @author thiago
 */
@Repository
public interface SolicitacaoEditalDAO extends JpaRepository<SolicitacaoEdital, Long>
{
    @Query(value = "SELECT * FROM SOLICITACAOEDITAL ORDER BY codSolicitacaoEdital DESC", nativeQuery = true)
    List<SolicitacaoEdital> findAllDesc();

    @Query(value = "select "
            + " new br.gov.sp.franciscomorato"
            + ".licitacoes.model"
            + ".SolicitacaoEdital(s.codSolicitacaoEdital, s.dataSolicitacao,s.edital.nomeEdital, "
            + "s.pessoa) "             
            + "from SOLICITACAOEDITAL s "
            + "order by s.codSolicitacaoEdital limit 10")
            
    List<SolicitacaoEdital> findHome();
}

