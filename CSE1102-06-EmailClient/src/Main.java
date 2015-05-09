 // Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

import client.*;


public class Main {

	public static void main(String[] args) {
		Contact c1 = new Contact("mark.bluemer@uconn.edu", "Mark", "Mark");
		
		MailClient client = new MailClient(c1);
		CmdLoop loop = new CmdLoop(client);
		loop.run();

	}

}
