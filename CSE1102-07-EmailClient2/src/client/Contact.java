// Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;

import java.io.PrintStream;
import java.util.Scanner;

public class Contact {
	private String _emailAddress;
	private String _fullName;
	private String _nickName;
	
	public Contact(String emailAddress, String fullName, String nickName){
		this._emailAddress = emailAddress;
		this._fullName = fullName;
		this._nickName = nickName;
	}

	public Contact(String emailAddress){
		this._emailAddress = emailAddress;
	}
	

	@Override public String toString(){
		if(this._fullName == null || this._nickName == null){
			return "<" + this._emailAddress + ">";
		} else {
			return this._fullName + " (" + this._nickName + ") <" + this._emailAddress + ">";
		}
	}
	
	public void save(PrintStream printStream, AddressBook book){
		if (book.search(this._nickName) != null) {
			printStream.append(this._nickName + "\n");
		} else {
			printStream.append(this._emailAddress + "\n");
		}
	}
	
	public void saveFull(PrintStream printStream) {
		printStream.append(this._emailAddress + "\n");
		printStream.append(this._fullName + "\n");
		printStream.append(this._nickName + "\n");
	}
	
	public static Contact loadFull(Scanner in) {
		try {
			String emailAddress = in.nextLine();
			String fullName = in.nextLine();
			String nickName = in.nextLine();
			Contact contact = new Contact(emailAddress, fullName, nickName);
			return contact;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Contact load(Scanner in, AddressBook book) {
		Contact result;
		try {
			String firstLine = in.nextLine();
			if(firstLine != null && firstLine.length() > 0) {
				if (firstLine.contains("@")) {
					result = new Contact(firstLine);
				} else {
					result = book.search(firstLine);
				}
			} else {
				result = null;
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	
	public String getEmailAddress(){
		return this._emailAddress;
	}
	public void setEmailAddress(String emailAddress){
		this._emailAddress = emailAddress;
	}
	public String getFullName(){
		return this._fullName;
	}
	public void setFullName(String fullName){
		this._fullName = fullName;
	}
	public String getNickName(){
		return this._nickName;
	}
	public void setNickName(String nickName){
		this._nickName = nickName;
	}
}
