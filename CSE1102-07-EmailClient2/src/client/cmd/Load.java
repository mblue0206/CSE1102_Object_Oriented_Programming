package client.cmd;

import client.MailClient;

public class Load implements ICommand {

	@Override
	public void run(MailClient client) {
		client.getAddressBook().load(Save.CONTACTS);
		client.getInbox().load(Save.INBOX, client.getAddressBook());
		client.getOutbox().load(Save.OUTBOX, client.getAddressBook());
	}
}
