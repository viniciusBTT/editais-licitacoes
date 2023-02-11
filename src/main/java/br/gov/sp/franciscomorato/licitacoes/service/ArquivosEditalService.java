/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.licitacoes.service;

import br.gov.sp.franciscomorato.licitacoes.model.ArquivosEdital;
import br.gov.sp.franciscomorato.licitacoes.model.Edital;
import br.gov.sp.franciscomorato.licitacoes.repository.ArquivosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iii
 */
@Service
public class ArquivosEditalService 
{
    @Autowired ArquivosDAO arquivosDAO;
    
    public List<ArquivosEdital> findByEdital(Edital edital)
    {
        return arquivosDAO.findByEdital(edital.getCodEdital());
    }
}
