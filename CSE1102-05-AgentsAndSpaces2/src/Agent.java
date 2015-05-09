// Project 5: Agents and Spaces 2
// CSE1102 Spring 2015
// Mark Bluemer
// 03/19/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

import jeff.textconsole.*;

public class Agent {
	private String _name;
	private Space _location;
	
	//constructor
	public Agent(String name, Space location) {
		this._name = name;
		this._location = location;
	}
	
	public Space getLocation() {
		return this._location;
	}
	public void setLocation(Space location) {
		this._location = location;
	}
	public String getName() {
		return this._name;
	}
	public void setName(String name) {
		this._name = name;
	}
	public String toString() {
		return this._name;
	}
	public String toStringLong() {
		return this._name + " is in " + this._location.toString();
	}
	public void usePortal(TextConsole console) {
		
		if (this._location.getPortal() != null){
			console.println(this._name + " is moving from " + this._location.toString()
					+ " to " + this._location.getPortal().getDestination());
			_location.getPortal().transport(this);
		} else {
			 console.println("There is no portal here.");
		}
	}
}
