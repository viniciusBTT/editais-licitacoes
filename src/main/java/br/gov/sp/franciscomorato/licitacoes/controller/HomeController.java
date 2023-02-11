
package br.gov.sp.franciscomorato.licitacoes.controller;

import br.gov.sp.franciscomorato.licitacoes.repository.SolicitacaoEditalDAO;
import br.gov.sp.franciscomorato.licitacoes.service.EditalService;
import br.gov.sp.franciscomorato.licitacoes.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 *
 * @author thiago
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController 
{
    @Autowired EditalService editalService;
    @Autowired RequestService requestService;
    @Autowired SolicitacaoEditalDAO solicitacaoEditalDAO;
    /**
     * primeira URL de acesso
     * @param model
     * @return 
     */
    @GetMapping
    public String home(Model model)
    {   

        model.addAttribute("pages", requestService.countAll() / 5);
        model.addAttribute("current", 1);
        model.addAttribute("solicitacoes", solicitacaoEditalDAO.findHome());
        return "home/home";
    }
}
