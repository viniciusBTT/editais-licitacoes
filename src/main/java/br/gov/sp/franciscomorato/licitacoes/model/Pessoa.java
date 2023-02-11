package br.gov.sp.franciscomorato.licitacoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Jhonatan Colina
 */
@Entity(name = "PESSOA")
@Getter
@Setter
public class Pessoa
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codPessoa;
  
  @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
  @JoinColumn
  private Rua rua;
  private String numeroCasa;
  
  @OneToOne(cascade = CascadeType.ALL)
  private PessoaFisica pessoaFisica;
  
  @OneToOne(cascade = CascadeType.ALL)
  private PessoaJuridica pessoaJuridica;

    public Pessoa() {
    }

    public Pessoa(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
  
    
  
}

