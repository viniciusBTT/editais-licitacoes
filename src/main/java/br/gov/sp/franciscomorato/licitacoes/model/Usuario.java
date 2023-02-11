package br.gov.sp.franciscomorato.licitacoes.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Jhonatan Colina
 */
@Entity(name = "USUARIO")
public class Usuario implements UserDetails
{
  @Id
  @NotEmpty
  @NotNull
  private String usuario;
  @NotEmpty
  @NotNull
  private String passwd;
 // @OneToOne(fetch = FetchType.EAGER)
 // private Funcionario funcionario;
  @NotEmpty
  @NotNull
  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
  @Column(name = "USUARIO_ROLE")
  private List<Role> roles = new ArrayList<>();
  private boolean situacao;

  public List<Role> getRoles()
  {
    return roles;
  }

  public void setRoles(List<Role> roles)
  {
    this.roles = roles;
  }

  public boolean isSituacao()
  {
    return situacao;
  }

  public void setSituacao(boolean situacao)
  {
    this.situacao = situacao;
  }

  public String getUsuario()
  {
    return usuario;
  }

  public void setUsuario(String usuario)
  {
    this.usuario = usuario;
  }

  public String getPasswd()
  {
    return passwd;
  }

  public void setPasswd(String passwd)
  {
    this.passwd = passwd;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities()
  {
    return this.roles;
  }

  @Override
  public String getPassword()
  {
    return this.passwd;
  }

  @Override
  public String getUsername()
  {
    return this.usuario;
  }

  @Override
  public boolean isAccountNonExpired()
  {
    return true;
  }

  @Override
  public boolean isAccountNonLocked()
  {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired()
  {
    return true;
  }

  @Override
  public boolean isEnabled()
  {
    return this.situacao;
  }
  
  
}
