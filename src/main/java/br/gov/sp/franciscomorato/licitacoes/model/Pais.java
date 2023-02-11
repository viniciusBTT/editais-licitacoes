package br.gov.sp.franciscomorato.licitacoes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Jhonatan Colina
 */
@Entity(name = "PAIS")
public class Pais implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codPais;
  @NotEmpty
  private String nomePais;
  /*@OneToMany(mappedBy = "pais", targetEntity = Estado.class, 
          fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Estado> estados;

  public List<Estado> getEstados()
  {
    return estados;
  }

  public void setEstados(List<Estado> estados)
  {
    this.estados = estados;
  }*/

  public Long getCodPais()
  {
    return codPais;
  }

  public void setCodPais(Long codPais)
  {
    this.codPais = codPais;
  }

  public String getNomePais()
  {
    return nomePais;
  }

  public void setNomePais(String nomePais)
  {
    this.nomePais = nomePais;
  }

  @Override
  public String toString()
  {
    return "Pais{" + "codPais=" + codPais + ", nomePais=" + nomePais + '}';
  }
  
  
}
