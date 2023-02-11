
package br.gov.sp.franciscomorato.licitacoes.service;

import br.gov.sp.franciscomorato.licitacoes.model.Pessoa;
import br.gov.sp.franciscomorato.licitacoes.repository.PessoaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thiago
 */
@Service
public class PessoaService 
{
    @Autowired PessoaDAO pessoaDAO;
    
    public Pessoa save(Pessoa pessoa)
    {
        return pessoaDAO.save(pessoa);
    }
    
    public Pessoa findByEmail(String email)
    {
        return pessoaDAO.findByEmail(email);
    } 
    
    public Pessoa persist(Pessoa pessoa)
    {
        Pessoa p = new Pessoa();
        
        if(pessoa.getPessoaFisica() != null)
        {
            p = findByEmail(pessoa.getPessoaFisica().getEmail());
            
            if(p != null)
            {
                return p;
            }
            
            return save(pessoa);
        }
        
        p = findByEmail(pessoa.getPessoaJuridica().getEmail());
        
        if(p != null)
        {
            return p;
        }
        
        return save(pessoa);
        
    }
}
