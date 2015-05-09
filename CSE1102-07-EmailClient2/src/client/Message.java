// Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;
import java.util.*;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Message {
	private Contact _sender;
	private Contact _receiver;
	private String _subject;
	private String _body;
	private Date _creationTime;
	private String _dateString;
	
	public Message(Contact sender, Contact receiver, String subject, String body){
		this._sender = sender;
		this._receiver = receiver;
		this._subject = subject;
		this._body = body;
		
		_creationTime = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
		this._dateString = dateFormat.format(_creationTime);
	}
	
	public void show(){
		System.out.println("Date: " + _dateString);
		System.out.println("From: " + this.getSender().toString());
		System.out.println("Subj: " + this.getSubject());
		System.out.println(this.getBody());
	}
	
	@Override public String toString(){
		return "FROM: " + this.getSender().toString() + ", TO: " + this.getReceiver().toString()
				+ ", SUBJ: " + this.getSubject() + ", DATE: " + this._dateString;
	}
	
	public void save(PrintStream printStream, AddressBook book) {
		this._sender.save(printStream, book);
		this._receiver.save(printStream, book);
		printStream.append(this._subject + "\n" +
				this._body + "\n" +
				this._dateString + "\n");
	}
	
	public static Message load(Scanner in, AddressBook book) {
		try {
			String first = in.nextLine();
			String second = in.nextLine();
			if (book.search(first) == null || book.search(second) == null) {
				return null;
			} 
			Contact from = book.search(first);
			Contact to = book.search(second);
			String subj = in.nextLine();
			String body = in.nextLine();
			String dateString = in.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
			Date date = null;
			try {
				date = sdf.parse(dateString);
			}
			catch(ParseException e)
			{}
			Message newMessage = new Message(from, to, subj, body);
			newMessage.setCreationTime(date);
			return newMessage;
		} catch (Exception e) {
	 		return null;
		}
	}
	
	public Contact getSender(){
		return this._sender;
	}
	public void setSender(Contact sender){
		this._sender = sender;
	}
	public Contact getReceiver(){
		return this._receiver;
	}
	public void setReceiver(Contact receiver){
		this._receiver = receiver;
	}
	public String getSubject(){
		return this._subject;
	}
	public void setSubject(String subject){
		this._subject = subject;
	}
	public String getBody(){
		return this._body;
	}
	public void setBody(String body){
		this._body = body;
	}
	public Date getCreationTime(){
		return this._creationTime;
	}
	public void setCreationTime(Date creationTime){
		this._creationTime = creationTime;
	}
}
