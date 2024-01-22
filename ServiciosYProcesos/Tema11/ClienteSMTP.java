package Tema11;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ClienteSMTP {

    public static void main(String[] args) {
        // Configurar las propiedades para la sesión
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Crear una sesión de correo electrónico
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("correo gmail", "contraseña");
            }
        });

        try {
            // Crear un mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("correo gmail"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("correo destinatario"));
            message.setSubject("Asunto del Correo");
            message.setText("Cuerpo del Correo");

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo electrónico enviado con éxito.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}