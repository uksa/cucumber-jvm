package support;

import com.google.common.base.Function;
import org.openqa.selenium.support.ui.FluentWait;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by sam on 10/03/2015.
 */
public class GMailerReader {
	
    private final String userName = "uksa-testing@gmail.com";
    private final String password = "Password1";
    
    public String getLatestEmail() {
    	Session session = createSession();
    	
    	try {
    		Store store = session.getStore("imaps");
    		store.connect();
    		
    		Folder inbox = store.getFolder("INBOX");
    		inbox.open(Folder.READ_WRITE);
    		
    		Message newMessage = pollForLatestNewMessage(inbox);
    		if (newMessage == null) {
    			return "";
    		}
    		return processMessageBody(newMessage);
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }
    
    
    private Message pollForLatestNewMessage(Folder inbox) {
		FluentWait<Folder> wait = new FluentWait<>(inbox);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		Message m = wait.until(new Function<Folder, Message>() {

			@Override
			public Message apply(Folder folder) {
				try {
					Message[] messages = folder.getMessages();
					for (Message m : messages) {
						if (!m.isSet(Flags.Flag.SEEN)) {
							return m;
						}
					}
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
				return null;
			}
		});
		return m;
	}


	private Session createSession() {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "imap.gmail.com");
        properties.setProperty("mail.port", "995");
        properties.setProperty("mail.transport.protocol", "imaps");
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        return session;
    }

    private String processMessageBody(Message message) throws IOException, MessagingException {
		Object content = message.getContent();
		if (content instanceof String) {
			return (String) content;
		}
		
		throw new IllegalStateException("Unhandled message type '" + message.getClass().toString() + "'");
    }
}
