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
@Entity(name = "RUA")
public class Rua implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codRua;
  @NotEmpty
  private String nomeRua;
  @NotEmpty
  private String cep;
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn
  @Valid
  private Bairro bairro;

  public Bairro getBairro()
  {
    return bairro;
  }

  public void setBairro(Bairro bairro)
  {
    this.bairro = bairro;
  }
  
  public Long getCodRua()
  {
    return codRua;
  }

  public void setCodRua(Long codRua)
  {
    this.codRua = codRua;
  }

  public String getNomeRua()
  {
    return nomeRua;
  }

  public void setNomeRua(String nomeRua)
  {
    this.nomeRua = nomeRua;
  }

  public String getCep()
  {
    return cep;
  }

  public void setCep(String cep)
  {
    this.cep = cep;
  }

  @Override
  public String toString()
  {
    return "Rua{" + "codRua=" + codRua + ", nomeRua=" + nomeRua + ", cep=" + cep + ", bairro=" + bairro.toString() + '}';
  }
  
  
}
