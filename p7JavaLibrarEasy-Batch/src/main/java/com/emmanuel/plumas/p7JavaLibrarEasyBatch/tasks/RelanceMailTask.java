package com.emmanuel.plumas.p7JavaLibrarEasyBatch.tasks;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p7JavaLibrarEasyBatch.Models.BorrowEntity;
import com.emmanuel.plumas.p7JavaLibrarEasyBatch.proxies.ApiProxy;

@Service
@Qualifier("relanceMailTask")
public class RelanceMailTask {

	
	@Autowired
	@Qualifier("ApiProxy")
	private ApiProxy apiProxy;
	
	
	public void execute() throws MessagingException {
		// ApiProxy Récuperer la liste des adresses mail des utilisateurs dont le prêt est arrivé à son terme
		List<String> userEntitiesMail = getMailUserOutOfTimeBorrow();
		
				
		//Paramètres d'initialisation
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.host", "smtp.free.fr");
		prop.put("mail.smtp.port", "25");


		//Création de la session de connection avec le serveur de mail et Authentification
		Session session = Session.getInstance(prop, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("epika@free.fr", "PETIL33");
		    }
		});

		for(String userEntityMail :userEntitiesMail) {
			//Création et envoi du message
			Message message = new MimeMessage(session);

			
			message.setFrom(new InternetAddress("epika@free.fr"));
			message.setRecipients(
			  Message.RecipientType.TO, InternetAddress.parse(userEntityMail));
			message.setSubject("Votre emprunt de livre");
			 
			String msg = "Vous avez un livre à nous rendre !";

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");
			 
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			 
			message.setContent(multipart);	
			
			try {        
		         Transport.send(message);
		         System.out.println("Message envoyé avec succès....");
				} catch (MessagingException mex) {
					mex.printStackTrace();
				}
		}
		
		}

	
	private List<String> getMailUserOutOfTimeBorrow(){
		List<BorrowEntity> borrowEntities=apiProxy.getOutOfTimeAndNotReturnedBorrow();
		List<String> userEntitiesMail = new ArrayList<String>();
		for(BorrowEntity borrowEntity:borrowEntities) {
			userEntitiesMail.add(borrowEntity.getUserEntity().getUserEmail());
		}
		return userEntitiesMail;
	}
	

	
}
