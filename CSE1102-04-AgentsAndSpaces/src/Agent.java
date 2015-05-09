
public class Agent {
	private Space _location;
	private String _name;
	
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
	public void usePortal() {
		
		if (this._location.getPortal() != null){
			System.out.println(this._name + " is moving from " + this._location.toString()
					+ " to " + this._location.getPortal().getDestination());
			_location.getPortal().transport(this);
		} else {
			System.out.println("There is no portal here.");
		}
	}
}
