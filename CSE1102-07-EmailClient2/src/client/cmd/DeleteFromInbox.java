package client.cmd;

import client.MailClient;
import java.util.Scanner;

public class DeleteFromInbox implements ICommand {

	@Override
	public void run(MailClient client) {
		Scanner in = new Scanner(System.in);
		int inboxSize = client.getInbox().count();
		if (inboxSize > 0){
			System.out.print("Enter message number: ");
			int n = in.nextInt();
			if(n > inboxSize || n <= 0){
				System.out.println("Message number " + n + " can't be found");
				in.nextLine();
			} else {
				client.getInbox().removeMessage(n - 1);
				in.nextLine();
			}
		} else {
			System.out.println("Inbox empty");
		}
	}

}
