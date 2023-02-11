
package br.gov.sp.franciscomorato.licitacoes.controller;

import br.gov.sp.franciscomorato.licitacoes.model.ArquivosEdital;
import br.gov.sp.franciscomorato.licitacoes.model.Protocol;
import br.gov.sp.franciscomorato.licitacoes.model.SolicitacaoEdital;
import br.gov.sp.franciscomorato.licitacoes.service.ArquivosEditalService;
import br.gov.sp.franciscomorato.licitacoes.service.EditalService;
import br.gov.sp.franciscomorato.licitacoes.service.PessoaService;
import br.gov.sp.franciscomorato.licitacoes.service.ProtocolService;
import br.gov.sp.franciscomorato.licitacoes.service.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author thiago
 */
@Controller
@RequestMapping("/request")
public class RequestEditalController 
{
    @Autowired private RequestService requestService;
    @Autowired private PessoaService pessoaService;
    @Autowired private EditalService editalService;
    @Autowired private ArquivosEditalService  arquivosService;
    @Autowired private ProtocolService protocolService;
    
    @PostMapping
    @ResponseBody
    //@Transactional(Transactional.TxType.NEVER)
    public Map<String, Object> request(@RequestBody SolicitacaoEdital solicitacaoEdital)
    {
        try 
        {
            //salva solicitante para evitar erro de transiet exception
            solicitacaoEdital
                    .setPessoa(pessoaService
                            .persist(solicitacaoEdital.getPessoa()));
            
            //salva solicitacao
            solicitacaoEdital = requestService.save(solicitacaoEdital);
            
            //cria protocolo
            Protocol p = protocolService.save(new Protocol(), solicitacaoEdital);
            
            //cria map para retornar como resposta o solicitante e os arquivos
            Map<String, Object> map = new HashMap<>();
            
            //pesquisa todos os arquivos do edital
            List<ArquivosEdital> arquivosEditals = arquivosService
                    .findByEdital(solicitacaoEdital.getEdital());
            
            map.put("files", arquivosEditals);
            map.put("_id", p.getAccess());
            
            return map;
        }
        catch (Exception e) 
        {
            System.out.println("Erro ao solicitar edital: " + e.getMessage());
            return null;
        }
    }
    
}
