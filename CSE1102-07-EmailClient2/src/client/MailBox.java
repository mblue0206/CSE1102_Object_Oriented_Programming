// Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MailBox {
	private ArrayList<Message> _mailBox;
	
	public MailBox() {
		_mailBox = new ArrayList<Message>();
	}
	
	public void addMessage(Message message){
		this._mailBox.add(message);
	}
	
	public int count(){
		return this._mailBox.size();
	}
	
	public Message getMessage(int n){
		if(n < this._mailBox.size()){
			return this._mailBox.get(n);
		} else {
			return null;
		}
	}
	
	public Message removeMessage(int n){
		if(n < _mailBox.size()){
			Message message = this._mailBox.get(n);
			this._mailBox.remove(n);
			return message;
		} else {
			return null;
		}
	}
	
	public void show(){
		for(int i=0; i<_mailBox.size(); i++){
			System.out.println( i + 1 + ". " + _mailBox.get(i).toString());
		}
	}
	
	public void save(String fileName, AddressBook book) {
		try {
			File file = new File(fileName);
			PrintStream printStream = new PrintStream(file);
			for (Message s: _mailBox) {
				s.save(printStream, book);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Mailbox unable to save file.");
			e.printStackTrace();
		}
	}
	
	public void load(String fileName, AddressBook book) {
		
		try {
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			ArrayList<Message> newList = new ArrayList<Message>();
			Message myMessage = Message.load(in, book);
			while (myMessage != null) {
				newList.add(myMessage);
				myMessage = Message.load(in, book);
			}
			_mailBox = newList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Mailbox unable to load from file.");
		}
		
		
	}
	
	public ArrayList<Message> getMailBox(){
		return this._mailBox;
	}
	public void setMailBox(ArrayList<Message> mailBox){
		this._mailBox = mailBox;
	}
}
