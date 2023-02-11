
package br.gov.sp.franciscomorato.licitacoes.controller;

import br.gov.sp.franciscomorato.licitacoes.model.Protocol;
import br.gov.sp.franciscomorato.licitacoes.service.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thiago
 */
@Controller
@RequestMapping("/uploads")
public class UploadsController
{
    @Autowired ProtocolService protocolService;
    
    @GetMapping(value = "/{file}")
    public ModelAndView downloadFile(@PathVariable String file, @RequestParam("sessionId") String sessionId)
    {
        try 
        {
            if(protocolService.isValid(sessionId))
            {
                System.out.println("Entrou");
                return new ModelAndView("redirect:/acesso/" + file);
            }
            else
            {
                return new ModelAndView("redirect:/404");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao retornar file");
        }
        return new ModelAndView("redirect:/");
    }
    
}
