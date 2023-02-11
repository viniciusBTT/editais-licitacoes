
package br.gov.sp.franciscomorato.licitacoes.application;

import br.gov.sp.franciscomorato.licitacoes.service.UsuarioService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.web.SecurityFilterChain;



/**
 *
 * @author thiago
 */
@Configuration
@EnableWebSecurity
@PropertySource("classpath:ldap.properties")
public class SpringSecurityConfiguration 
{
    @Autowired UsuarioService usuarioService;
    
    @Value("${ldap.url}")
    private String url;
    
    @Value("${ldap.port}")
    private Integer port;
    
    @Value("${ldap.username}")
    private String userManager;
    
    @Value("${ldap.password}")
    private String password;
    
    @Value("${ldap.group.filter}")
    private String searchFilter;
    
    @Value("${ldap.search.base}")
    private String groupSearchFilter;
    
    @Value("${ldap.base.dn}")
    private String baseDn;
    
    @Value("${ldap.user.search.filter}")
    private String userSearchFilter;
    
    /**
     * configura rotas de acesso
     * @param httpSecurity
     * @return
     * @throws Exception 
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception 
    {
        httpSecurity.authorizeHttpRequests(
            (requests) ->
                requests
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/assets/**").permitAll()
                    .requestMatchers("/edital/request/**").permitAll()
                    .requestMatchers("/request/**").permitAll()
                    .anyRequest().authenticated()
            )         
            .formLogin((form) -> form
               .loginPage("/auth").permitAll()
                    .defaultSuccessUrl("/home", true)
            )
            .logout(
                (logout) -> 
                    logout.logoutUrl("/logout").logoutSuccessUrl("/auth")
        ).csrf().disable();
        return httpSecurity.build();
    }
    
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
            .ldapAuthentication()
            .userSearchFilter(this.userSearchFilter)
            .userSearchBase(this.baseDn)
            .groupSearchBase(this.groupSearchFilter+","+ this.baseDn)
            .groupSearchFilter(this.groupSearchFilter)
                .ldapAuthoritiesPopulator(LdapAuthoritiesPopulator())
            .contextSource()
                .url(this.url)
                .port(this.port)
                .managerDn(this.userManager) 
                .managerPassword(this.password);
    }
    
    private LdapAuthoritiesPopulator LdapAuthoritiesPopulator()
    {
        /*
        preenche authorities para acessar o sistema. 
        */
        return (DirContextOperations userData, String username) -> Arrays.asList(new SimpleGrantedAuthority(        
            usuarioService.findUser(username) != null ? 
                    !usuarioService.findUser(username).getRoles().isEmpty() ? 
                            usuarioService.findUser(username).getRoles().get(0).getNome()
                    : "ROLE_COMUM"
            : "ROLE_COMUM"
        ));
        //return (DirContextOperations userData, String username) -> Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
