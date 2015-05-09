 // Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;

public class MailClient {
	private Contact _user;
	private AddressBook _addressBook;
	private MailBox _inbox;
	private MailBox _outbox;
	
	public MailClient(Contact user){
		this._user = user;
		this._addressBook = new AddressBook();
		this._inbox = new MailBox();
		this._outbox = new MailBox();
		
		this._addressBook.addContact(this._user);
	}
	public void addContact(Contact contact){
		this._addressBook.addContact(contact);
	}
	public Contact searchForContact(String nickName){
		return this._addressBook.search(nickName);
	}
	
	public void addToInbox(Message message){
		this._inbox.addMessage(message);
	}
	public void addToOutbox(Message message){
		this._outbox.addMessage(message);
	}
	public MailBox getInbox(){
		return this._inbox;
	}
	public MailBox getOutbox(){
		return this._outbox;
	}
	public Contact getMyAddress(){
		return this._user;
	}
	public AddressBook getAddressBook(){
		return this._addressBook;
	}
	
}