
public class Space {
	private String _name;
	private String _description;
	private Portal _portal;
	
	//All of the getters and setters
	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		this._description = description;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
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
