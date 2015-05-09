// Project 2: Robot Grid
// CSE1102 Spring 2015
// Mark Bluemer
// 02/19/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

public class Main {
	public static void main(String[] args){
		
		//Let's start with some portals
		Portal wardrobe = new Portal();
		wardrobe.setName("wardrobe");
		wardrobe.setDirection("through");
				
		Portal ocean = new Portal();
		ocean.setName("ocean");
		ocean.setDirection("across");
		
				
		//Now let's create some new places
		Space bedroom = new Space();
		bedroom.setName("bedroom");
		bedroom.setDescription("A random room in a random house");
		bedroom.setPortal(wardrobe);
		
		Space narnia = new Space();
		narnia.setName("Narnia");
		narnia.setDescription("A distant land covered in snow");
		narnia.setPortal(ocean);
		wardrobe.setDestination(narnia);
		
		Space westeros = new Space();
		westeros.setName("Westeros");
		westeros.setDescription("The shores of the continent of Westeros");
		ocean.setDestination(westeros);
		
		
		//Here's an agent to get us through these portals
		Agent bond = new Agent();
		bond.setName("James Bond");
		bond.setLocation(bedroom);

		CommandInterpreter.run(bond);
		
		/* This is the example code. Original code is above
		//Creating a classroom
		Space classroom = new Space();
		classroom.setName("classroom");
		classroom.setDescription("a large lecture hall");
		
		//Creating a sidewalk
		Space sidewalk = new Space();
		sidewalk.setName("sidewalk");
		sidewalk.setDescription("a plain concrete sidewalk with weeds"
				+ " growing through the cracks");
		
		//Lets create a door to the sidewalk
		Portal door = new Portal();
		door.setName("door");
		door.setDirection("outside");
		door.setDestination(sidewalk);
		
		//The door leads from classroom to sidewalk
		classroom.setPortal(door); 
		
		//Creating an agent to make the traverse
		Agent student = new Agent();
		student.setName("Harry Potter");
		student.setLocation(classroom);
		
		CommandInterpreter.run(student); */
	}

}
