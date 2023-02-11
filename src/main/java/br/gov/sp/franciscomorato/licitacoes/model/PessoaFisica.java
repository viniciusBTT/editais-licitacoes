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

@Entity(name = "PESSOAFISICA")
@Getter
@Setter
public class PessoaFisica implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codPessoaFisica;
  
  @OneToOne(mappedBy="pessoaFisica",fetch = FetchType.LAZY,optional = false)
  private Pessoa pessoa;
  
  private String nomeCompleto;
  private String cpf;
  private String telefone;
  private String email;
  
}
