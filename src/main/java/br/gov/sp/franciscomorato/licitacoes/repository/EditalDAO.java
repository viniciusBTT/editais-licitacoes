
package br.gov.sp.franciscomorato.licitacoes.repository;

import br.gov.sp.franciscomorato.licitacoes.model.Edital;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thiago
 */
@Repository
public interface EditalDAO extends JpaRepository<Edital, Long>
{
    @Query(value = "select * from EDITAL where statusVisualizacao = true order by codEdital desc limit :offset, :page", nativeQuery = true)
    List<Edital> findByLimited(@Param("offset") Integer offset, @Param("page") Integer page);
}
