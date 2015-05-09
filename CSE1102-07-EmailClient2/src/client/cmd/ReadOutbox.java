package client.cmd;

import client.MailClient;
import java.util.Scanner;

public class ReadOutbox implements ICommand {
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
				client.getOutbox().getMessage(n - 1).show();
				in.nextLine();
			}
		} else {
			System.out.println("Outbox empty");
		}
	}
}
