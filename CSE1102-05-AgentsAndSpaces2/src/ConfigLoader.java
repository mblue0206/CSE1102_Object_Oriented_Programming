import java.io.File;
import java.util.HashMap;
import jeff.ini.*;

public class ConfigLoader {
	private Ini _ini;
	private HashMap<String, Space>  _spaces  = new HashMap<String, Space>();
	private HashMap<String, Portal> _portals = new HashMap<String, Portal>();
	private HashMap<String, Agent>  _agents  = new HashMap<String, Agent>();
	 
	public ConfigLoader(File iniFile) {
		_ini = new Ini(iniFile);
	}
	
	private void _buildSpaces() {
		for(String spaceName : _ini.keys("spaces")){
			
			String spaceDescription = _ini.get("spaces", spaceName);
			String imageName = _ini.get("images", spaceName);
			
			Space spaceInstance = new Space(spaceName, spaceDescription, imageName, null);
			
			_spaces.put(spaceName, spaceInstance);
		}
	}
	
	private void _buildPortals(){
		for(String portalName : _ini.keys("portals")){
			
			String portalDirection = _ini.get("portals", portalName);
			
			Portal portalInstance = new Portal(portalName, portalDirection, null);
			
			_portals.put(portalName, portalInstance);
		}
	}
	
	private void _buildExits(){
		for(String spaceName : _ini.keys("exits")){
			String exitName = _ini.get("exits", spaceName);
			Space space = _spaces.get(spaceName);
			Portal portal = _portals.get(exitName);
			
			space.setPortal(portal);
		}
	}
	
	private void _buildDestinations(){
		for(String portalName : _ini.keys("destinations")){
			String destinationName = _ini.get("destinations", portalName);
			
			Portal portal = _portals.get(portalName);
			
			Space destination = _spaces.get(destinationName);
			
			if(destination == null){
				System.out.println("destination does not exist");
				System.exit(1);
			} else {
				portal.setDestination(destination);
			}
		}
	}
	
	private void _buildAgents(){
		for(String agentName : _ini.keys("agents")){
			String spaceName = _ini.get("agents", agentName);
			
			Space startingLocation = _spaces.get(spaceName);
			
			if(spaceName == null){
				System.out.println("This space does not exist.");
				System.exit(1);
			} else {
				Agent agentInstance = new Agent(agentName, startingLocation);
				_agents.put(agentName, agentInstance);
			}
		}
	}
	
	private Agent _selectStartAgent(){
		String agentName = _ini.get("start", "agent");
		
		Agent startingAgent = _agents.get(agentName);
		
		if(startingAgent == null){
			System.out.println("The requested agent doesn't exist");
			System.exit(1);
		}
		
		return startingAgent;
	}
	
	public Agent buildAll() {
		_buildSpaces();
	    _buildPortals();
	    _buildExits();
	    _buildDestinations();
	    _buildAgents();
	    return _selectStartAgent();
	}
}
