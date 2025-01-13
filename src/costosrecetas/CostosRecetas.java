/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package costosrecetas;

import Form.Form_Main;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author DanielSantiago
 */
public class CostosRecetas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Form_Main formMain = new Form_Main();
        formMain.setLocationRelativeTo(null);
        formMain.setVisible(true);*/
        /*File file = new File("content.txt","Hola");
        file.Writer();*/
        String to = "supercell19230@gmail.com";
        String from = "dairofernandoarenasgiraldo@gmail.com";
        String host = "smtp.google.com";
        String user = "dairofernandoarenasgiraldo@gmail.com";
        String password = "";
        String port = "587";
        
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.ssl.trust", host);
        
        // Crear la sesión con autenticación
        Session session = Session.getInstance(properties);

        try {
            // Crear el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from)); // Remitente
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // Destinatario
            message.setSubject("Prueba de correo"); // Asunto
            message.setText("Este es un mensaje de prueba enviado desde Java."); // Cuerpo del mensaje

            // Enviar el mensaje
            Transport.send(message);
            System.out.println("Mensaje enviado con éxito.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    
}
