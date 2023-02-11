
package br.gov.sp.franciscomorato.licitacoes.service;

import br.gov.sp.franciscomorato.licitacoes.model.Role;
import br.gov.sp.franciscomorato.licitacoes.repository.RoleDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thiago
 */
@Service
public class RoleService 
{
    @Autowired RoleDAO roleDAO;
    
    public List<Role> roles()
    {
        return roleDAO.findAll();
    }
}
