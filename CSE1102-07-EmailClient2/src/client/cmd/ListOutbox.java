package client.cmd;

import client.MailClient;

public class ListOutbox implements ICommand {

	@Override
	public void run(MailClient client) {
		client.getOutbox().show();
	}

}
