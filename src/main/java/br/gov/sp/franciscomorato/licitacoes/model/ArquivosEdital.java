package br.gov.sp.franciscomorato.licitacoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Jhonatan Colina
 */
@Entity(name = "ARQUIVOSEDITAL")
@Data
public class ArquivosEdital implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codArquivosEdital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Edital edital;

    private String localAnexo;

    public ArquivosEdital() {
        
    }

    public ArquivosEdital(Long codArquivosEdital, String localAnexo) {
        this.codArquivosEdital = codArquivosEdital;
        this.localAnexo = localAnexo;
    }
  
}
