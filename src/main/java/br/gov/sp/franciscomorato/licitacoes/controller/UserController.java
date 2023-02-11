
package br.gov.sp.franciscomorato.licitacoes.controller;

import br.gov.sp.franciscomorato.licitacoes.model.Role;
import br.gov.sp.franciscomorato.licitacoes.model.Usuario;
import br.gov.sp.franciscomorato.licitacoes.service.RoleService;
import br.gov.sp.franciscomorato.licitacoes.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author thiago
 */
@Controller
@RequestMapping("/user")
public class UserController 
{
    
    @Autowired private RoleService roleService;
    @Autowired private UsuarioService usuarioService;
    
    @GetMapping
    public String user()
    {
        return "user/user";
    }
    
    @GetMapping(value = "/roles")
    @ResponseBody
    public List<Role> roles()
    {
        return roleService.roles();
    }
    
    @PostMapping(value = "/change")
    @ResponseBody
    public Usuario changeRole(@RequestParam("username") String username, @RequestParam("role") String role)
    {
        try 
        {
            Usuario u = usuarioService.changeRole(username, role);
            
            usuarioService.save(u);
            
            return u;
            
        } catch (Exception e)
        {
            System.out.println("Erro ao trocar senha");
            return null;
        }
    }
    
    
}
