
package br.gov.sp.franciscomorato.licitacoes.service;

import br.gov.sp.franciscomorato.licitacoes.model.ArquivosEdital;
import br.gov.sp.franciscomorato.licitacoes.model.Edital;
import br.gov.sp.franciscomorato.licitacoes.model.SolicitacaoEdital;
import br.gov.sp.franciscomorato.licitacoes.repository.EditalDAO;
import br.gov.sp.franciscomorato.licitacoes.repository.SolicitacaoEditalDAO;
import br.gov.sp.franciscomorato.licitacoes.util.FileManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



/**
 *
 * @author thiago
 */
@Service
public class EditalService 
{
    @Autowired EditalDAO editalDAO;
    @Autowired FileManager fileManager;
    @Autowired SolicitacaoEditalDAO solicitacaoEditalDAO;
    
    @Value("${arquivos.edital}") private String pasta;
    
    public Edital save(Edital edital)
    {
        return editalDAO.save(edital);
    }
    
    public void delete(Edital edital)
    {
        editalDAO.deleteById(edital.getCodEdital());
    }
    
    /*retorna todos*/
    public List<Edital> listAll()
    {
        return editalDAO.findAll();
    }
    
    public Edital findById(Long codEdital)
    {
        return editalDAO.findById(codEdital).orElse(null);
    }
    
    
    public List<ArquivosEdital> saveFile(MultipartFile[] files, Edital edital)
    {
      List<ArquivosEdital> anexos = new ArrayList<>();

      for (MultipartFile file : files)
      {
        if(!file.isEmpty())
        {
          ArquivosEdital ae =  new ArquivosEdital();
          ae.setLocalAnexo(fileManager.save(pasta,file));
          ae.setEdital(edital);
          anexos.add(ae);
        }
      }

      return anexos;
    }
  
    public boolean removeArquivo(String nomeArquivo)
    {
      return fileManager.remove(pasta, nomeArquivo)!=null;
    }
    
    public List<Edital> listAllLimited(Integer offset, Integer rows)
    {
        return editalDAO.findByLimited(offset, rows);
    }
    
    public List<SolicitacaoEdital> listAllRequestsDesc()
    {
        return solicitacaoEditalDAO.findAllDesc();
    }
    
    public Long countAll()
    {
        return editalDAO.count();
    }
    
}
