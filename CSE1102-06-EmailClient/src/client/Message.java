// Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;
import java.util.*;
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
