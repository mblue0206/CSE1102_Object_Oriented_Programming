// Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;
import java.util.ArrayList;

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
	
	public ArrayList<Message> getMailBox(){
		return this._mailBox;
	}
	public void setMailBox(ArrayList<Message> mailBox){
		this._mailBox = mailBox;
	}
}
