// Project 6: Email Client
// CSE1102 Spring 2015
// Mark Bluemer
// 04/14/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

package client;

import java.util.ArrayList;

public class AddressBook {
	private ArrayList<Contact> _contactList = new ArrayList<>();
	
	public void addContact(Contact contact){
		this._contactList.add(contact);
	}
	
	public Contact search(String searchInput){
		if(searchInput.contains("@")){
			for(int i=0; i<_contactList.size(); i++){
				String contactEmail = _contactList.get(i).getEmailAddress();
				if(contactEmail.toLowerCase().equals(searchInput.toLowerCase())){
					return _contactList.get(i);
				}
			}
		} else {
			for(int i=0; i<_contactList.size(); i++){
				String contactNickName = _contactList.get(i).getNickName();
				if(contactNickName.toLowerCase().equals(searchInput.toLowerCase())){
					System.out.println(contactNickName);
					return _contactList.get(i);
				}
			}
		}
		
		
		 return null;
	}
	
	public void remove(Contact contact){
		if(this.search(contact.getNickName()) != null){
			this._contactList.remove(contact);
		} else {
			System.out.println("This contact doesn't exist");
		}
	}
	
	public void show(){
		for(int i=0; i<_contactList.size(); i++){
			System.out.println((i + 1) + ". " + _contactList.get(i).toString());
		}
	}
}
