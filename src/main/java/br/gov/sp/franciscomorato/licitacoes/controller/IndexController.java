
package br.gov.sp.franciscomorato.licitacoes.controller;

import br.gov.sp.franciscomorato.licitacoes.service.EditalService;
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
@RequestMapping("/")
public class IndexController 
{
    
    @Autowired private EditalService editalService;
    
    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("pages", editalService.countAll() / 5);
        model.addAttribute("current", 1);
        model.addAttribute("editais", editalService.listAllLimited(0, 5));
        return "index";
    }
    
}
