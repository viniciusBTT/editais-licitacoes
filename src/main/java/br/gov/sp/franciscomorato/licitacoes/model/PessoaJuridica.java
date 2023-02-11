package br.gov.sp.franciscomorato.licitacoes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "PESSOAJURIDICA")
@Getter
@Setter
public class PessoaJuridica implements Serializable 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codPessoaJuridica;
  
  @OneToOne(fetch = FetchType.LAZY,optional = false,mappedBy="pessoaJuridica")
  private Pessoa pessoa;
  
  private String nomeCompleto;
  private String cnpj;
  private String telefone;
  private String email;
  
  
  public  PessoaJuridica ()
  {
      
  }
  
 
}
