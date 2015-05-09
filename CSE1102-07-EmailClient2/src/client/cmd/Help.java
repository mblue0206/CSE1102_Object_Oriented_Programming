package client.cmd;

import client.MailClient;

public class Help implements ICommand {

	@Override
	public void run(MailClient client) {
		System.out.println(
				"h\tShows this help menu" +
				"\nq\tQuit" +
				"\nla\tLists your address book" +
				"\nli\tLists your inbox" +
				"\nlo\tLists your outbox" +
				"\naa\tAdd a contact to your address book" +
				"\nda\tDelete a contact from your address book" +
				"\ncm\tCompose a message" +
				"\nro\tRead a message from the outbox" +
				"\ndo\tDelete a message from the outbox" +
				"\nri\tRead a message from the inbox" +
				"\ndi\tDelete a message from the inbox" +
				"\nsr\tSend and recieve messages");
	}
}
