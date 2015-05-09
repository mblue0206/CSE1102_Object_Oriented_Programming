 // Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;
import java.util.Hashtable;
import java.util.Scanner;
import client.cmd.*;

public class CmdLoop {
	private MailClient _mailClient;
	private Hashtable<String, ICommand> _commands = new Hashtable<String, ICommand>();
	Scanner in = new Scanner(System.in);
	
	public CmdLoop(MailClient mailClient){
		this._mailClient = mailClient;
		
		_commands.put("h", new client.cmd.Help());
		_commands.put("la", new client.cmd.ListAddressBook());
		_commands.put("li", new client.cmd.ListInbox());
		_commands.put("lo", new client.cmd.ListOutbox());
		_commands.put("aa", new client.cmd.AddContact());
		_commands.put("cm", new client.cmd.ComposeMessage());
		_commands.put("ro", new client.cmd.ReadOutbox());
		_commands.put("do", new client.cmd.DeleteFromOutbox());
		_commands.put("ri", new client.cmd.ReadInbox());
		_commands.put("di", new client.cmd.DeleteFromInbox());
		_commands.put("da", new client.cmd.DeleteAddress());
		_commands.put("sr", new client.cmd.SendReceive());
		_commands.put("sv", new client.cmd.Save());
		_commands.put("ld", new client.cmd.Load());
		}
	
	public void run(){
		Boolean loop = true;
		// A loop constantly searching for commands
		while(loop){
			
			System.out.print("Mail: ");
			String cmd = in.nextLine();
			
			if(cmd.equals("q")){
				loop = false;
			} else {
				ICommand command = _commands.get(cmd);
				// Check for commands in _commands Hashtable
				if (command != null) {
					command.run(_mailClient);
				} else {
					System.out.println("Command not recognized. Enter 'h' for list of commands.");
				}
			}
		}
	}
}
