/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package costosrecetas;

import Form.Form_Main;
/*import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

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
        Form_Main formMain = new Form_Main();
        formMain.setLocationRelativeTo(null);
        formMain.setVisible(true);
        /*File file = new File("content.txt","Hola");
        file.Writer();*/
        /*String to = "dairofernandoarenasgiraldo@gmail.com";
        String from = "dairo.arenas802@pascualbravo.edu.co";
        String host = "smtp.gmail.com";
        String user = "dairo.arenas802@pascualbravo.edu.co";
        String password = "cmkjkfervxuprmlu"; 
        String port = "587";

        // Configurar las propiedades del servidor SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Activar STARTTLS
        properties.put("mail.smtp.ssl.enable", "false"); // Desactivar SSL

        // Crear la sesión con autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

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
        }*/
    }
    
}
