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
					return _contactList.get(i);
				}
			}
		}
		
		
		 return null;
	}
	
	public void remove(Contact contact){
		Contact nameSearch = this.search(contact.getNickName());
		if(nameSearch != null){
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
	
	public void save(String fileName) {
		
		try {
			File file = new File(fileName);
			PrintStream printStream = new PrintStream(file);
			for (Contact s: this._contactList) {
				s.saveFull(printStream);
			}
		} catch (FileNotFoundException e) {
			System.out.println("AddressBook unable to save file " + fileName);
			e.printStackTrace();
		}
	}
	
	public void load(String fileName) {
		try {
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			ArrayList<Contact> newArrayList = new ArrayList<Contact>();
			Contact myContact = Contact.loadFull(in);
			while (myContact  != null) {
				newArrayList.add(myContact);
				myContact = Contact.loadFull(in);
			}
			this._contactList = newArrayList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("AddressBook unable to load from file.");
			return;
		}	
	}
}
