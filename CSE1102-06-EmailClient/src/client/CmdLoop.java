 // Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;
import java.util.Scanner;

public class CmdLoop {
	private MailClient _mailClient;
	Scanner in = new Scanner(System.in);
	
	public CmdLoop(MailClient mailClient){
		this._mailClient = mailClient;
	}
	
	public void run(){
		Boolean loop = true;
		
		while(loop){
			
			System.out.print("Mail: ");
			String cmd = in.nextLine();
			
			if(cmd.equals("q")){
				loop = false;
			} else if(cmd.equals("h")){
				this.displayCommands();
			} else if(cmd.equals("")){
			}else if(cmd.equals("la")){
				this.listAddressBook();
			}else if(cmd.equals("li")){
				this.listInbox();
			}else if(cmd.equals("lo")){
				this.listOutbox();
			} else if(cmd.equals("aa")){
				this.addContact();
			} else if(cmd.equals("cm")){
				this.composeMessage();
			} else if(cmd.equals("ro")){
				this.readOutbox();
			} else if(cmd.equals("do")){
				this.deleteFromOutbox();
			} else if(cmd.equals("ri")){
				this.readInbox();
			} else if(cmd.equals("di")){
				this.deleteFromInbox();
			} else if(cmd.equals("sr")){
				this.sendReceive();
			} else if(cmd.equals("da")){
				this.deleteAddress();
			} else{
				System.out.println("Command not recognized. Enter 'h' for list of commands.");
			}
		}
		
	}
	
	private void listAddressBook(){
		this._mailClient.getAddressBook().show();
	}
	private void listInbox(){
		this._mailClient.getInbox().show();
	}
	private void listOutbox(){
		this._mailClient.getOutbox().show();
	}
	private void addContact(){
		System.out.println("Email: ");
		String email = in.nextLine();
		System.out.print("Full name: ");
		String fullName = in.nextLine();
		System.out.print("Nick name: ");
		String nickName = in.nextLine();
		
		Contact contact = new Contact(email, fullName, nickName);
		_mailClient.getAddressBook().addContact(contact);
	}
	private void deleteAddress(){
		System.out.print("Email address or nick name: ");
		String search = in.nextLine();
		Contact contact = this._mailClient.getAddressBook().search(search);
		this._mailClient.getAddressBook().remove(contact);
	}
	private void composeMessage(){
		System.out.print("Email address or nick name: ");
		String recipient = in.nextLine();
		Contact contact = this._mailClient.getAddressBook().search(recipient);
		while (contact == null){
			if(recipient.contains("@")){
				contact = new Contact(recipient);
			} else {
				System.out.print("This contact doesn't exist. Would you like to create one? ");
				String response = in.nextLine();
				if(response.equalsIgnoreCase("yes")){
					this.addContact();
					contact = this._mailClient.getAddressBook().search(recipient);
					break;
				} else {
					this.composeMessage();
				}
		}
		}
		System.out.print("Subject: ");
		String subject = in.nextLine();
		System.out.println("Body: ");
		String body = in.nextLine();
		
		Message message = new Message(this._mailClient.getMyAddress(), contact, subject, body);
		this._mailClient.addToOutbox(message);
	}
	private void readOutbox(){
		int outboxSize = this._mailClient.getOutbox().count();
		if (outboxSize > 0){
			System.out.print("Enter message number: ");
			int n = in.nextInt();
			if(n > outboxSize || n <= 0){
				System.out.println("Message number " + n + " can't be found");
				in.nextLine();
			} else {
				this._mailClient.getOutbox().getMessage(n - 1).show();
				in.nextLine();
			}
		} else {
			System.out.println("Outbox empty");
		}
	}
	private void deleteFromOutbox(){
		int outboxSize = this._mailClient.getOutbox().count();
		if (outboxSize > 0){
			System.out.print("Enter message number: ");
			int n = in.nextInt();
			if(n > outboxSize || n <= 0){
				System.out.println("Message number " + n + " can't be found");
				in.nextLine();
			} else {
				this._mailClient.getOutbox().removeMessage(n - 1);
				in.nextLine();
			}
		} else {
			System.out.println("Outbox empty");
		}
	}
	private void readInbox(){
		int inboxSize = this._mailClient.getInbox().count();
		if (inboxSize > 0){
			System.out.print("Enter message number: ");
			int n = in.nextInt();
			if(n > inboxSize || n <= 0){
				System.out.println("Message number " + n + " can't be found");
				in.nextLine();
			} else {
				this._mailClient.getInbox().getMessage(n - 1).show();
				in.nextLine();
			}
		} else {
			System.out.println("Inbox empty");
		}
	}
	private void deleteFromInbox(){
		int inboxSize = this._mailClient.getInbox().count();
		if (inboxSize > 0){
			System.out.print("Enter message number: ");
			int n = in.nextInt();
			if(n > inboxSize || n <= 0){
				System.out.println("Message number " + n + " can't be found");
				in.nextLine();
			} else {
				this._mailClient.getInbox().removeMessage(n - 1);
				in.nextLine();
			}
		} else {
			System.out.println("Inbox empty");
		}
	}
	private void sendReceive(){
		while(this._mailClient.getOutbox().count() > 0){
			this._mailClient.getInbox().addMessage(this._mailClient.getOutbox().getMessage(0));
			this._mailClient.getOutbox().removeMessage(0);
		}
	}
	private void displayCommands(){
		System.out.println(
				"h\tShows this help menu" +
				"\nq\tQuit" +
				"\nla\tLists your address book" +
				"\nli\tLists your inbox" +
				"\nlo\tLists your outbox" +
				"\naa\tAdd a contact to your address book" +
				"\nda\tDelete a contact from your address book" +
				"\ncm\tCompose a message" +
				"\nro\tRead a message from the outbox" +
				"\ndo\tDelete a message from the outbox" +
				"\nri\tRead a message from the inbox" +
				"\ndi\tDelete a message from the inbox" +
				"\nsr\tSend and recieve messages");
	}
	
}
