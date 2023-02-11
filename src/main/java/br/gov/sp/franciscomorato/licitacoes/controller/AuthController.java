
package br.gov.sp.franciscomorato.licitacoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author thiago
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthController 
{
    @GetMapping
    public String auth()
    {
        return "login";
    }
}
