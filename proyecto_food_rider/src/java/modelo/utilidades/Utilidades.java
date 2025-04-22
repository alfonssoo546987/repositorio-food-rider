/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.utilidades;

import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modelo.entidades.registros.Email;


/**
 *
 * @author alfon
 */
public class Utilidades {

    public void setEnviarEmail(Email email) {
        Properties p = new Properties();

        p.setProperty("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", email.getFrom());
        p.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(p);
        sesion.setDebug(false);

        MimeMessage mensaje = new MimeMessage(sesion);

        try {
            mensaje.setFrom(new InternetAddress(email.getFrom()));
            mensaje.addRecipient(RecipientType.TO, new InternetAddress(email.getTo()));
            mensaje.setSubject(email.getSubject());
            mensaje.setText(email.getText());

            Transport t = sesion.getTransport("smtp");

            t.connect(email.getFrom(), "uceukbegukahcrig");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            System.out.println("Mensaje enviado");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error en Utilidades");
        }
    }
}
