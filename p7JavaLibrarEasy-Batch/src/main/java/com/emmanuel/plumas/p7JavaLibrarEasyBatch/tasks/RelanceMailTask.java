package com.emmanuel.plumas.p7JavaLibrarEasyBatch.tasks;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

import java.util.HashMap;
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
		Map<String,String> userEntitiesMailandBook = getOutOfTimeBorrow();
		if(userEntitiesMailandBook.size()!=0) {
				
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
			for(Entry<String, String> userEntityMailAndBookEntry : userEntitiesMailandBook.entrySet()) {
				//Création et envoi du message
				Message message = new MimeMessage(session);
	
				
				message.setFrom(new InternetAddress("epika@free.fr"));
				message.setRecipients(
				  Message.RecipientType.TO, InternetAddress.parse(userEntityMailAndBookEntry.getKey()));
				message.setSubject("Votre emprunt de livre");
				 
				String newLine=System.lineSeparator();
				String line1 = "Bonjour,"+newLine;
				String line2= "Vous avez emprunté à la bibliothèque l'ouvrage suivant : "+newLine;
				String line3= newLine+". Merci de bien vouloir le rapporter dans les plus brefs délais. D'autres ouvrages sont à découvrir avec chaque mois des nouveautés."+newLine;
				String line4="Au plaisir de vour revoir dans nos rayons."+newLine;
				String line5="Toute l'équipe de la bibliothèque";
	
				MimeBodyPart mimeBodyPart = new MimeBodyPart();
				mimeBodyPart.setContent(line1+line2+(userEntityMailAndBookEntry.getValue())+line3+line4+line5, "text/html");
				 
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
		
			} else {
				System.out.println("Pas de message à envoyer");
			}
		
		}

	
	private Map<String, String> getOutOfTimeBorrow(){
		List<BorrowEntity> borrowEntities=apiProxy.getOutOfTimeAndNotReturnedBorrow();
		Map<String,String> userEntitiesMailandBook = new HashMap<String,String>();
		for(BorrowEntity borrowEntity:borrowEntities) {
			userEntitiesMailandBook.put(borrowEntity.getUserEntity().getUserEmail(),borrowEntity.getCopyEntity().getBookEntity().getBookTitle());
		}
		return userEntitiesMailandBook;
	}
	

	
}
