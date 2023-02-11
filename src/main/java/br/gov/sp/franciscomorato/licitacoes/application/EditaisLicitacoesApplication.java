package br.gov.sp.franciscomorato.licitacoes.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

/**
 * java packages
 */
@ComponentScan(basePackages = {
    "br.gov.sp.franciscomorato.licitacoes.application",
    "br.gov.sp.franciscomorato.licitacoes.controller",
    "br.gov.sp.franciscomorato.licitacoes.model",
    "br.gov.sp.franciscomorato.licitacoes.repository",
    "br.gov.sp.franciscomorato.licitacoes.service",
    "br.gov.sp.franciscomorato.licitacoes.util"
})

@EntityScan(basePackages = {"br.gov.sp.franciscomorato.licitacoes.model"})
@EnableJpaRepositories("br.gov.sp.franciscomorato.licitacoes.repository")
@EnableAutoConfiguration

public class EditaisLicitacoesApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(EditaisLicitacoesApplication.class, args);
    }

}
