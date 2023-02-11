
package br.gov.sp.franciscomorato.licitacoes.service;

import br.gov.sp.franciscomorato.licitacoes.model.Protocol;
import br.gov.sp.franciscomorato.licitacoes.model.SolicitacaoEdital;
import br.gov.sp.franciscomorato.licitacoes.repository.ProtocolDAO;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thiago
 */
@Service
public class ProtocolService
{
    @Autowired ProtocolDAO protocolDAO;
    
    /**
     * salva protocolo
     * @param protocol
     * @param solicitacaoEdital
     * @return 
     */
    public Protocol save(Protocol protocol, SolicitacaoEdital solicitacaoEdital)
    {
        Calendar c = Calendar.getInstance();
        Date d = new Date();
        c.setTime(d);
        c.add(Calendar.DATE, 1);
        d = c.getTime();
        protocol.setGeneration(d);
        protocol.setSolicitacaoEdital(solicitacaoEdital);
        protocol.setAccess(encode(solicitacaoEdital.getCodSolicitacaoEdital().toString()));
        return protocolDAO.save(protocol);
    }
    
    public String encode(String code)
    {
        return Base64.getEncoder().encodeToString(code.getBytes());
    }
    
    public String decode(String encoded)
    {
        return new String(Base64.getDecoder().decode(encoded.getBytes()));
    }
    
    public Protocol findById(Long protocol)
    {
        return protocolDAO.findById(protocol).orElse(null);
    }
    
    public boolean isValid(String protocolAccess)
    {
        String decoded = decode(protocolAccess);
        Long protocol = Long.valueOf(decoded);
        
        Protocol p = findById(protocol);
        
        //se for diferente de hoje e a data de gerecao for menor que hora, valido
        return p != null && p.getGeneration().before(new Date());
        
    }
    
}
