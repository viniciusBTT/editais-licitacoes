package br.gov.sp.franciscomorato.licitacoes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Jhonatan Colina
 */
@Entity(name = "ROLE")
public class Role implements GrantedAuthority
{
  //@NaturalId
  @Id
  private String nome;

  public Role(){}

  public Role(String nome)
  {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public String getAuthority()
  {
    return this.nome;
  }

  @Override
  public String toString()
  {
    return "Role{" + "nome=" + nome + '}';
  }
  
}
