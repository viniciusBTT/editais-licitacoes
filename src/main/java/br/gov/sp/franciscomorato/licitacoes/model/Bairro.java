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
 * @author Jhonaatn Colina
 */
@Entity(name = "BAIRRO")
public class Bairro implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codBairro;
  
  @NotEmpty
  private String nomeBairro;
  
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn
  @Valid
  private Cidade cidade;

  public Cidade getCidade()
  {
    return cidade;
  }

  public void setCidade(Cidade cidade)
  {
    this.cidade = cidade;
  }

  public Long getCodBairro()
  {
    return codBairro;
  }

  public void setCodBairro(Long codBairro)
  {
    this.codBairro = codBairro;
  }

  public String getNomeBairro()
  {
    return nomeBairro;
  }

  public void setNomeBairro(String nomeBairro)
  {
    this.nomeBairro = nomeBairro;
  }

  @Override
  public String toString()
  {
    return "Bairro{" + "codBairro=" + codBairro + ", nomeBairro=" + nomeBairro + ", cidade=" + cidade.toString() + '}';
  }
}
