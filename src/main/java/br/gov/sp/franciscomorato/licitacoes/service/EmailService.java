
package br.gov.sp.franciscomorato.licitacoes.service;

import br.gov.sp.franciscomorato.licitacoes.repository.EmailDAO;
import br.gov.sp.franciscomorato.licitacoes.util.EmailDetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * service to send e-mails, has implementation of EmailDAO
 * https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/
 * @author thiago
 * @see EmailDAO
 * @see EmailDetails
 */
@Service
public class EmailService implements EmailDAO
{
    @Autowired JavaMailSender javaMailSender;
    
    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendEmail(EmailDetails email)
    {
        try 
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            
            mailMessage.setFrom(sender);
            mailMessage.setTo(email.getRecipient());
            mailMessage.setText(email.getMsgBody());
            mailMessage.setSubject(email.getSubject());
            
            //envia
            javaMailSender.send(mailMessage);
            return "E-mail enviado com sucesso!";
        } 
        catch (MailException e) 
        {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
            return "Erro ao enviar e-mail";
        }
    }

    @Override
    public String sendMailWithAttachment(EmailDetails email) 
    {
        /**
         * Multipurpose Internet Mail Extensions
         * used to support the transfer of single or multiple text and non-text attachments
         * Non-text attachments can include graphics, audio, and video files
         */
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        
        MimeMessageHelper mimeMessageHelper;
        
        try 
        {
            //preparing to send
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setText(email.getMsgBody());
            mimeMessageHelper.setSubject(email.getSubject());
            
            //adding the attachment
            FileSystemResource file = new FileSystemResource(email.getAttachment());
            
            mimeMessageHelper.addAttachment(file.getFilename(), file);
            
            //send
            javaMailSender.send(mimeMessage);
            
            return "E-mail enviado com sucesso!";
            
        } catch (MessagingException | MailException e) 
        {
            System.out.println("Erro ao enviar e-mail com anexos: " + e.getMessage());
            return "Erro ao enviar e-mail com anexos: " + e.getMessage();
        }
    }
    
    
}
