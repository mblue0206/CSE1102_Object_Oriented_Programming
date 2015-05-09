package client.cmd;

import client.Contact;
import client.MailClient;
import client.Message;
import java.util.Scanner;

public class ComposeMessage implements ICommand {

	@Override
	public void run(MailClient client) {
		Scanner in = new Scanner(System.in);
		System.out.print("Email address or nick name: ");
		String recipient = in.nextLine();
		Contact contact = client.getAddressBook().search(recipient);
		while (contact == null){
			if(recipient.contains("@")){
				contact = new Contact(recipient);
			} else {
				System.out.print("This contact doesn't exist. Would you like to create one? ");
				String response = in.nextLine();
				if(response.equalsIgnoreCase("yes")){
					AddContact addContact = new AddContact();
					addContact.run(client);
					contact = client.getAddressBook().search(recipient);
					break;
				} else {
					return;
				}
			}
		}
		System.out.print("Subject: ");
		String subject = in.nextLine();
		System.out.println("Body: ");
		String body = in.nextLine();
		Message message = new Message(client.getMyAddress(), contact, subject, body);
		client.addToOutbox(message);
	}

}
