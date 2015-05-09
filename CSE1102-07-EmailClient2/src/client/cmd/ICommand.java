package client.cmd;

import client.MailClient;

public interface ICommand {
	public void run(MailClient client);
}
