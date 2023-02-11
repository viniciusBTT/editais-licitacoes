
package br.gov.sp.franciscomorato.licitacoes.repository;

import br.gov.sp.franciscomorato.licitacoes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thiago
 */
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, String>
{
    
}
