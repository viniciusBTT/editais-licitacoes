
package br.gov.sp.franciscomorato.licitacoes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author thiago
 */
@Entity
@Data
public class Protocol 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProtocol;
    
    private Date generation;
    
    private String access;
    
    @OneToOne
    private SolicitacaoEdital solicitacaoEdital;
}
