/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
    private final static String CORREO = "poo.iiiproyecto.grupo06.2020@gmail.com";
    private final static String CONTRASENNIA = "MarianaDavid2020";
    private final static Properties PROPIEDADES = inicializarPropiedades();

    
    private static Properties inicializarPropiedades(){
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        return propiedades;
    }
    
    public static boolean enviarCorreo(String email, String mensaje){
        Session sesion = Session.getInstance(PROPIEDADES,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(CORREO, CONTRASENNIA);}});
        
        try {
            Message correo = new MimeMessage(sesion);
            correo.setFrom(new InternetAddress("poo.iiiproyecto.grupo06.2020@gmail.com"));
            correo.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(email));
            correo.setSubject("Mensaje de AyudaCR - Mariana y David");
            correo.setText(mensaje);
            Transport.send(correo);
            return true;
        } catch (MessagingException error) {
//            error.printStackTrace();
            return false;
        }
    }
    
    public static boolean validarFormatoCorreo(String email){
        Pattern patron= Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
        Matcher mather = patron.matcher(email);
        return mather.find();
    }
    
    
    
}
