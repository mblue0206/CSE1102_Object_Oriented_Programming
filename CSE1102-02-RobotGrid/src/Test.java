// Project 2: Robot Grid
// CSE1102 Spring 2015
// Mark Bluemer
// 2/3/15
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

import robotgrid.Grid;
import robotgrid.GridServer;
import robotgrid.Heading;
import robotgrid.Robot;
import robotgrid.Utils;
import robotgrid.TriggerCell;
import robotgrid.Wall;
import robotgrid.Layer;


public class Test {
	public static void main(String[] args){
		GridServer server = new GridServer();
		Grid grid = server.createGrid("Test", 10, 10);
		Robot robot1 = new Robot("Robot 1", Heading.East);
		grid.placeObject(robot1, 0, 0);
		setup(grid);
		//pause a bit before things start to happen
		Utils.sleep(500);
		
		//Let's make this robot move a bit.
		robot1.move();
		robot1.turnRight();
		int counter = 0;
		while (counter < 9){
			robot1.move();
			counter++;
		}
		 //First button down
		robot1.turnLeft(2);
		counter = 0;
		while (counter < 4){
			robot1.move();
			counter++;
		}
		robot1.turnRight();
		counter = 0;
		while (counter < 3){
			robot1.move();
			counter++;
		}
		robot1.turnRight();
		counter = 0;
		while (counter < 2){
			robot1.move();
			counter++;
		}
		 //Second button down
		robot1.turnLeft(2);
		counter = 0;
		while (counter < 4){
			robot1.move();
			counter++;
		}
		robot1.turnRight();//Third button down (checkpoint)
		robot1.move();
		robot1.turnRight();
		counter = 0;
		while (counter < 2){
			robot1.move();
			counter++;
		}
		robot1.turnLeft();
		counter = 0;
		while (counter < 4){
			robot1.move();
			counter++;
		}
		robot1.turnRight();
		counter = 0;
		while (counter < 4){
			robot1.move();
			counter++;
		}
		//Last button (finished)
		
		
	}
	
	private static void setup(final Grid grid) {
		
	    for(int n=0; n<10; n++) {
	      Wall wall = new Wall();
	      grid.placeObject(wall, 3, n);
	      grid.placeObject(wall, 6,  n);
	    }
	    
	    Layer layer = grid.getLayer(null);
	    TriggerCell tc1 = new TriggerCell(layer, 1, 9, "") {
	    	@Override
	    	public void activate()
	      {
		grid.removeObject(3, 5);
	      }
	    };
	    
	    TriggerCell tc2 = new TriggerCell(layer, 4, 7, "") {
	    	@Override
	      public void activate()
	      {
	        grid.removeObject(6, 5);
	      }
	    };
	    layer.setCell(1, 9, tc1);
	    layer.setCell(4, 7, tc2);
	    TriggerCell tc3 = new TriggerCell(layer, 5, 3, "Checkpoint");
	    layer.setCell(5, 3, tc3);
	    TriggerCell tc4 = new TriggerCell(layer, 9, 9, "Finished!");
	    layer.setCell(9, 9, tc4);
	}

}
