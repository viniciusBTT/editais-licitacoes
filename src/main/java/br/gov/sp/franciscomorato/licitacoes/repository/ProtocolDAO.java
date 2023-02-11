
package br.gov.sp.franciscomorato.licitacoes.repository;

import br.gov.sp.franciscomorato.licitacoes.model.Protocol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thiago
 */
@Repository
public interface ProtocolDAO extends JpaRepository<Protocol, Long>{
    
}
