package br.gov.sp.franciscomorato.licitacoes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;



/**
 *
 * @author Jhonatan Colina
 */
@Entity(name = "SOLICITACAOEDITAL")
@Data
public class SolicitacaoEdital implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codSolicitacaoEdital;
  
  @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone = "GMT-3")
  private Date dataSolicitacao; 
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Edital edital;
  
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn
  private Pessoa pessoa;
  
  private boolean status; 
  
  @Transient
  private String nomeCompleto;
  
  @Transient
  private String email;
  
  @Transient
  private String telefone;

  
  public SolicitacaoEdital()
  {
      
  }
  
  public SolicitacaoEdital(Long codigoSolicitacao, 
            Date dataSolicitacao, 
            String nomeEdital,
            Pessoa pessoa)
  {
      this.codSolicitacaoEdital = codigoSolicitacao;
      this.dataSolicitacao = dataSolicitacao;
      this.edital = new Edital(nomeEdital);
      this.nomeCompleto = Objects.isNull(pessoa.getPessoaFisica())
              ? pessoa.getPessoaJuridica().getNomeCompleto() : 
              pessoa.getPessoaFisica().getNomeCompleto();
      this.email = Objects.isNull(pessoa.getPessoaFisica())
              ? pessoa.getPessoaJuridica().getEmail(): 
              pessoa.getPessoaFisica().getEmail();
      this.telefone = Objects.isNull(pessoa.getPessoaFisica())
              ? pessoa.getPessoaJuridica().getTelefone(): 
              pessoa.getPessoaFisica().getTelefone();
      

      
  }
}
