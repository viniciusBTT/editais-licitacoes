
package br.gov.sp.franciscomorato.licitacoes.repository;

import br.gov.sp.franciscomorato.licitacoes.model.ArquivosEdital;
import br.gov.sp.franciscomorato.licitacoes.model.Edital;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iii
 */
@Repository
public interface ArquivosDAO extends JpaRepository<ArquivosEdital, Long>
{
    @Query(value = "select new br.gov.sp.franciscomorato.licitacoes.model.ArquivosEdital(a.codArquivosEdital, a.localAnexo) from ARQUIVOSEDITAL a where a.edital.codEdital = :codEdital")
    List<ArquivosEdital> findByEdital(@Param("codEdital") Long codEdital);
}
