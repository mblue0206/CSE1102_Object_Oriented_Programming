// Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;

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
