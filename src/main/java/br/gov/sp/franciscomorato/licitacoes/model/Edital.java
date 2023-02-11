package br.gov.sp.franciscomorato.licitacoes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


/**
 *
 * @author Jhonatan Colina
 */
@Entity(name = "EDITAL")
@Data
public class Edital implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codEdital;
  
  private String nomeEdital;
  
  private String nEdital;
  
  @Lob
  private String descricaoEdital;
  
  @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone = "GMT-3")
  private Date dataPublicacao;
  
  @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone = "GMT-3")
  private Date dataUltimaAtualizacao;
  
  private boolean statusVisualizacao;
  
  private boolean statusAbertura;
  
  @ManyToOne(fetch = FetchType.EAGER)
  private Usuario usuario;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "edital",cascade = CascadeType.ALL)
  private List<ArquivosEdital> arquivosEdital = new ArrayList<>(0);

    public Edital() {
    }

    public Edital(String nomeEdital) {
        this.nomeEdital = nomeEdital;
    }
  
    
  
}
