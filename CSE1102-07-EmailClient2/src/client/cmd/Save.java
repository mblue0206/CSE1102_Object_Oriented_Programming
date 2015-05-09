package client.cmd;

import client.MailClient;

public class Save implements ICommand {
	public static final String CONTACTS = "Contacts.txt";
	public static final String INBOX = "Inbox.txt";
	public static final String OUTBOX = "Outbox.txt";
	
	@Override
	public void run(MailClient client) {
		client.getAddressBook().save(CONTACTS);
		client.getInbox().save(INBOX, client.getAddressBook());
		client.getOutbox().save(OUTBOX, client.getAddressBook());
	}

}
