package br.gov.sp.franciscomorato.licitacoes.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Jhonatan Colina
 */
@Entity(name = "CIDADE")
public class Cidade implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codCidade;
  @NotEmpty 
  private String nomeCidade;
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn
  @Valid
  private Estado estado;
  
  /*@OneToMany(mappedBy = "cidade", targetEntity = Bairro.class, 
          fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Bairro> bairros;

  public List<Bairro> getBairros()
  {
    return bairros;
  }

  public void setBairros(List<Bairro> bairros)
  {
    this.bairros = bairros;
  }*/

  public Estado getEstado()
  {
    return estado;
  }

  public void setEstado(Estado estado)
  {
    this.estado = estado;
  }

  public Long getCodCidade()
  {
    return codCidade;
  }

  public void setCodCidade(Long codCidade)
  {
    this.codCidade = codCidade;
  }

  public String getNomeCidade()
  {
    return nomeCidade;
  }

  public void setNomeCidade(String nomeCidade)
  {
    this.nomeCidade = nomeCidade;
  } 

  @Override
  public String toString()
  {
    return "Cidade{" + "codCidade=" + codCidade + ", nomeCidade=" + nomeCidade + ", estado=" + estado.toString()  + '}';
  }
  
  
}
