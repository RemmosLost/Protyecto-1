/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author David B
 */
public class SendEmail {
    private final static String EMAIL = "aion.clockmarket@gmail.com ";
    private final static String PASSWORD = "BasesDatos2020";
    private final static Properties PROPERTIES = initializeProperties();

    
    private static Properties initializeProperties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        return properties;
    }

    public boolean getEmailFromUserName(String username){
        return false;
    }
    
    
    
    public static boolean sendEmail(String email, String mensaje){
        Session sesion = Session.getInstance(PROPERTIES,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(EMAIL, PASSWORD);}});
        
        try {
            Message mail = new MimeMessage(sesion);
            mail.setFrom(new InternetAddress("poo.iiiproyecto.grupo06.2020@gmail.com"));
            mail.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(email));
            mail.setSubject("Mensaje de AyudaCR - Mariana y David");
            mail.setText(mensaje);
            Transport.send(mail);
            return true;
        } catch (MessagingException error) {
//            error.printStackTrace();
            return false;
        }
    }
    
    public static boolean validateEmailFormat(String email){
        Pattern patron= Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
        Matcher mather = patron.matcher(email);
        return mather.find();
    }
    
    
    
}
