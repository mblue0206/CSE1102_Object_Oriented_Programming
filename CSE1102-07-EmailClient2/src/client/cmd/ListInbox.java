package client.cmd;

import client.MailClient;

public class ListInbox implements ICommand {

	@Override
	public void run(MailClient client) {
		client.getInbox().show();
	}

}
