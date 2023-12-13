package appModule;


    import javax.mail.*;
    import javax.mail.internet.*;
    import java.util.*;
    import java.io.*;

    /*
      You need to change only following constant values

        SMTP_HOST_NAME 
        SMTP_AUTH_USER 
        SMTP_AUTH_PWD  

      

      emailMsgTxt  
      emailSubjectTxt  
      emailFromAddress 

      emailList -  This String array contains all email addresses where user wish to send the email.


      Create object of this class as follows in the calling class, ScreenshotEmailTest in this case

     SendEmail email = new SendEmail();

    */

    public class SendEmail
    {

      public static final String SMTP_HOST_NAME = "mail.compumentor.org";
      public static final String SMTP_AUTH_USER = "mradford@techsoup.org";
      public static final String SMTP_AUTH_PWD  = "JUNE2018mr%"; 
      
      

      public static final String emailMsgTxt      = "This is a sample email for discourse login failure";
      public static final String emailSubjectTxt  = "Error Message From Selenium WebDriver";
      public static final String emailFromAddress = "mradford@techsoup.org";

      // Add List of Email address where user wish to send the email 
      public static final String[] emailList = {"matthewradford@sbcglobal.net", "blackdogairllc@gmail.com"};
    
      public void postMail( String recipients[ ], String subject,
                                String message , String from) throws MessagingException
      {
        boolean debug = false;

         //Set the host smtp address
         Properties props = new Properties();
//         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.smtp.host", SMTP_HOST_NAME);
         props.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);

        session.setDebug(debug);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++)
        {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);


        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        
        Transport.send(msg);
        System.out.println("Sucessfully Sent mail to All Users");
     }


    /**
    * SimpleAuthenticator is used to do simple authentication
    * when the SMTP server requires it.
    */
    private class SMTPAuthenticator extends javax.mail.Authenticator
    {

        public PasswordAuthentication getPasswordAuthentication()
        {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }

    }
