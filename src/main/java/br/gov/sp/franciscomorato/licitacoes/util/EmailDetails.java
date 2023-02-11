
package br.gov.sp.franciscomorato.licitacoes.util;

import lombok.Data;

/**
 * Details to send email, has abstraction of email component
 * https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/
 * @author thiago
 * @see EmailService
 * @see EmailDAO
 */
@Data
public class EmailDetails 
{
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;

    public EmailDetails() {
    }

    public EmailDetails(String recipient, String msgBody, String subject, String attachment) {
        this.recipient = recipient;
        this.msgBody = msgBody;
        this.subject = subject;
        this.attachment = attachment;
    }
    
    
}
