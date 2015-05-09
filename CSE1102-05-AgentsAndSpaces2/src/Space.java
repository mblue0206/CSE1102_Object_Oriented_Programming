// Project 5: Agents and Spaces 2
// CSE1102 Spring 2015
// Mark Bluemer
// 03/19/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

public class Space {
	private String _name;
	private String _description;
	private String _imageName;
	private Portal _portal;
	
	//A constructor
	public Space(String name, String description, String imageName, Portal portal){
		this._name = name;
		this._description = description;
		this._imageName = imageName;
		this._portal = portal;
	}
	
	//All of the getters and setters
	public String getName() {
		return this._name;
	}

	public void setName(String name) {
		this._name = name;
	}
	
	public String getDescription() {
		return this._description;
	}

	public void setDescription(String description) {
		this._description = description;
	}

	public String getImageName() {
		return this._imageName;
	}

	public Portal getPortal() {
		return this._portal;
	}

	public void setPortal(Portal portal) {
		this._portal = portal;
	}
	
	public String toString() {
		return this._name;
	}
	
	public String toStringLong() {
		
		if (this._portal == null) {
			return this._name + ": " + this._description + " which goes nowhere";
		} else {
			return this._name + ": " + this._description + 
					" with a " + this._portal.toStringLong();
		}
		
	}
	
}
