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
@Entity(name= "ESTADO")
public class Estado implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codEstado;
  @NotEmpty
  private String nomeEstado;
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn
  @Valid
  private Pais pais;
  
  /*@OneToMany(mappedBy = "estado", targetEntity = Cidade.class, 
          fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Cidade> cidades;

  public List<Cidade> getCidades()
  {
    return cidades;
  }

  public void setCidades(List<Cidade> cidades)
  {
    this.cidades = cidades;
  }*/
  
  public Pais getPais()
  {
    return pais;
  }

  public void setPais(Pais pais)
  {
    this.pais = pais;
  }
  
  public Long getCodEstado()
  {
    return codEstado;
  }

  public void setCodEstado(Long codEstado)
  {
    this.codEstado = codEstado;
  }

  public String getNomeEstado()
  {
    return nomeEstado;
  }

  public void setNomeEstado(String nomeEstado)
  {
    this.nomeEstado = nomeEstado;
  }

  @Override
  public String toString()
  {
    return "Estado{" + "codEstado=" + codEstado + ", nomeEstado=" + nomeEstado + ", pais=" + pais.toString() + '}';
  }
  
  
}
