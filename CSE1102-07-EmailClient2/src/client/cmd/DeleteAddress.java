package client.cmd;

import client.Contact;
import client.MailClient;
import java.util.Scanner;

public class DeleteAddress implements ICommand {

	@Override
	public void run(MailClient client) {
		Scanner in = new Scanner(System.in);
		System.out.print("Email address or nick name: ");
		String search = in.nextLine();
		Contact contact = client.getAddressBook().search(search);
		if (contact == null) {
			System.out.println("Contact doesn't exist.");
			return;
		}
		client.getAddressBook().remove(contact);
	}

}
