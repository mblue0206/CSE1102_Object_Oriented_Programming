// Project 5: Agents and Spaces 2
// CSE1102 Spring 2015
// Mark Bluemer
// 03/19/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

import java.io.File;

import jeff.imagewindow.*;
import jeff.textconsole.*;

public class Main {
	public static void main(String[] args){
		
		
		//Given to us by Jeff
		TextConsole console = TextConsole.create();
		ImageWindow imageWindow = new ImageWindow();
		File configFile = new File("data", "config.ini");
		ConfigLoader cl = new ConfigLoader(configFile);
		
		Agent a = cl.buildAll();
		
		CommandInterpreter.run(a, imageWindow, console);
	}

}
