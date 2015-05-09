package client.cmd;

import client.MailClient;

public class SendReceive implements ICommand {

	@Override
	public void run(MailClient client) {
		while(client.getOutbox().count() > 0){
			client.getInbox().addMessage(client.getOutbox().getMessage(0));
			client.getOutbox().removeMessage(0);
		}
	}

}
