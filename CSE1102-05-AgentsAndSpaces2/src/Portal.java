// Project 5: Agents and Spaces 2
// CSE1102 Spring 2015
// Mark Bluemer
// 03/19/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

public class Portal {
	private String _name;
	private String _direction;
	private Space _destination;
	
	//Constructor
	public Portal(String name, String direction, Space destination) {
		this._name = name;
		this._direction = direction;
		this._destination = destination;
	}
	
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}
	public String getDirection() {
		return _direction;
	}
	public void setDirection(String direction) {
		this._direction = direction;
	}
	public Space getDestination() {
		return _destination;
	}
	public void setDestination(Space destination) {
		this._destination = destination;
	}
	
	public String toString() {
		return this._name + " that goes " + this._direction;
	}
	
	public String toStringLong() {
		return this._name + " that goes " + this._direction +
				" to " + this._destination;
	}
	public void transport(Agent agent) {
		agent.setLocation(this._destination);
	}
}
