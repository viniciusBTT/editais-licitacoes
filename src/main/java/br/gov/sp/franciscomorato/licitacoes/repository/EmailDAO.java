
package br.gov.sp.franciscomorato.licitacoes.repository;

import br.gov.sp.franciscomorato.licitacoes.util.EmailDetails;

/**
 * has methods to send emails
 * https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/
 * @author thiago
 * @see EmailDetails
 * @see EmailService
 */
public interface EmailDAO
{
    String sendEmail(EmailDetails email);
    
    String sendMailWithAttachment(EmailDetails details);
}
