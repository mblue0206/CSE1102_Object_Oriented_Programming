package client.cmd;

import client.Contact;
import client.MailClient;
import java.util.Scanner;

public class AddContact implements ICommand {

	@Override
	public void run(MailClient client) {
		Scanner in = new Scanner(System.in);
		System.out.println("Email: ");
		String email = in.nextLine();
		System.out.print("Full name: ");
		String fullName = in.nextLine();
		System.out.print("Nick name: ");
		String nickName = in.nextLine();
		Contact contact = new Contact(email, fullName, nickName);
		client.getAddressBook().addContact(contact);
	}

}
