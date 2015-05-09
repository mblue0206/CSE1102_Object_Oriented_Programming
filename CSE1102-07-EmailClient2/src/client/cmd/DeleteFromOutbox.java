package client.cmd;

import client.MailClient;
import java.util.Scanner;

public class DeleteFromOutbox implements ICommand {

	@Override
	public void run(MailClient client) {
		Scanner in = new Scanner(System.in);
		int outboxSize = client.getOutbox().count();
		if (outboxSize > 0){
			System.out.print("Enter message number: ");
			int n = in.nextInt();
			if(n > outboxSize || n <= 0){
				System.out.println("Message number " + n + " can't be found");
				in.nextLine();
			} else {
				client.getOutbox().removeMessage(n - 1);
				in.nextLine();
			}
		} else {
			System.out.println("Outbox empty");
		}
	}

}
