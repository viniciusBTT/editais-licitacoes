
package br.gov.sp.franciscomorato.licitacoes.service;

import br.gov.sp.franciscomorato.licitacoes.model.Role;
import br.gov.sp.franciscomorato.licitacoes.model.Usuario;
import br.gov.sp.franciscomorato.licitacoes.repository.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author thiago
 */
@Service
public class UsuarioService
{
    @Autowired private UsuarioDAO usuarioDAO;
    
   
    public Usuario save(Usuario usuario)
    {
        return usuarioDAO.save(usuario);
    }
   
    public List<Usuario> listAll()
    {
        return usuarioDAO.findAll();
    }
    
    public Usuario findUser(String username)
    {
        return usuarioDAO.findById(username).orElse(null);
    }
    
    public Usuario changeRole(String username, String role)
    {
        Usuario u = findUser(username);
        
        if(u.getUsername() != null)
        {
            List<Role> roles = new ArrayList<>();
            
            roles.add(new Role(role));
            
            u.setRoles(roles);
            
            return u;
        }
        else
        {
            return null;
        }
    }

    
}
