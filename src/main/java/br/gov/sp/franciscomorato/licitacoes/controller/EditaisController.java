
package br.gov.sp.franciscomorato.licitacoes.controller;

import br.gov.sp.franciscomorato.licitacoes.model.Edital;
import br.gov.sp.franciscomorato.licitacoes.model.SolicitacaoEdital;
import br.gov.sp.franciscomorato.licitacoes.service.EditalService;
import jakarta.transaction.Transactional;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author thiago
 */
@Controller
@RequestMapping("/edital")
public class EditaisController 
{
    @Autowired EditalService editalService;
    
    /**
     * 
     * @param edital
     * @return retorna view de adição de página
     */
    @GetMapping(value = "/add")
    public String add(Edital edital)
    {
        edital.setDataPublicacao(new Date());
        return "edital/add";
    }
    
    /**
     * 
     * @param model
     * @return view de editais
     */
    @GetMapping(value = "/list")
    public String list(Model model)
    {
         model.addAttribute("pages", editalService.countAll() / 5);
        model.addAttribute("current", 1);
        model.addAttribute("editais", editalService.listAllLimited(0, 5));
       
        
        return "edital/list";
    }
    
    /**
     * salva edital e arquivos
     * @param edital
     * @param multipartfile
     * @param ra
     * @param authentication
     * @return 
     */
    @PostMapping(value = "/add")
    @Transactional
    public String save(@Valid Edital edital, 
            @RequestPart("attachments[]") MultipartFile[] multipartfile,
            RedirectAttributes ra, Authentication authentication)
    {
        try 
        {
            /**
             * validação do arquivo
             */
            edital.setArquivosEdital(editalService.saveFile(multipartfile, edital));
            
            edital.setDataUltimaAtualizacao(new Date());
            
            editalService.save(edital);
            
            
            ra.addFlashAttribute("success", "Edital salvo com sucesso!");
        } 
        catch (Exception e) 
        {
            System.out.println("Erro ao salvar: " + e.getMessage());
            ra.addFlashAttribute("error", "Erro ao salvar edital");
        }
        ra.addFlashAttribute("editalView", true);
        return "redirect:/home";
    }
    
    @GetMapping(value = "/request/{codEdital}")
    public String request(@PathVariable Long codEdital, Model model)
    {
        model.addAttribute("edital", editalService.findById(codEdital));
        model.addAttribute("solicitacao", new SolicitacaoEdital());
        return "index/request";
    }
    
    @GetMapping(value = "/request/findLimited/{page}/{offset}")
    public String findLimited(@PathVariable Integer page, @PathVariable Integer offset, Model model)
    {
        model.addAttribute("pages", editalService.countAll() / 5);
        model.addAttribute("current", (page / 5) + 1);
        model.addAttribute("editais", editalService.listAllLimited(page, offset));
        return "index/editais";
    }
    
    
    
           
}
