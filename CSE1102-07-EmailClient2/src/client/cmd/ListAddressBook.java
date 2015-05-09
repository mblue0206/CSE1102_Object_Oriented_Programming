package client.cmd;

import client.MailClient;

public class ListAddressBook implements ICommand {

	@Override
	public void run(MailClient client) {
		client.getAddressBook().show();
	}

}
