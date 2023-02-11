
package br.gov.sp.franciscomorato.licitacoes.service;

import br.gov.sp.franciscomorato.licitacoes.model.SolicitacaoEdital;
import br.gov.sp.franciscomorato.licitacoes.repository.SolicitacaoEditalDAO;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thiago
 */
@Service
public class RequestService 
{
    @Autowired private SolicitacaoEditalDAO solicitacaoEditalDAO;
    
    public SolicitacaoEdital save(SolicitacaoEdital solicitacaoEdital)
    {
        //altera a data de solicitacao para a data corrente
        solicitacaoEdital.setDataSolicitacao(new Date());
        return solicitacaoEditalDAO.save(solicitacaoEdital);
    }
    
     public Long countAll()
    {
        return solicitacaoEditalDAO.count();
    }
    
}
