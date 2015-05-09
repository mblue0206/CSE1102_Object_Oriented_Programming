// Project 5: Agents and Spaces 2
// CSE1102 Spring 2015
// Mark Bluemer
// 03/19/2015
// TA: Jagriti Das
// Section: 003
// Instructor: Jeffrey A. Meunier

import java.util.Scanner;

import jeff.imagewindow.*;
import jeff.textconsole.*;

import java.io.*;

public class CommandInterpreter {
	public static void run(Agent agent, ImageWindow window, TextConsole console){
		Scanner input = new Scanner(System.in);
		boolean loop = true;
		
		console.println(agent.getName() + " is in " + agent.getLocation().getName());
		
		_showImage(window, agent);
		
		do {
			console.print("==> ");
			String choice = console.readLine();
			
			if (choice.equals("quit")){
				loop = false;
			} else if(choice.equals("go")) {
				agent.usePortal(console);
				_showImage(window, agent);
			} else if(choice.equals("look")) {
				console.println(agent.getLocation().toStringLong());
			} else if(choice.equals("where")) {
				console.println(agent.getLocation().toString());
			} else if(choice.equals("help")) {
				console.println("Available commands are:" 
						+ "\n\tgo"
						+ "\n\tlook"
						+ "\n\twhere"
						+ "\n\thelp"
						+ "\n\tquit");
			} else {
				console.println(choice + " is not a valid input.");
			}
		} while (loop);
		
		input.close();
		System.exit(0);
	}
	
	private static void _showImage(ImageWindow window, Agent agent) {
		String imageName = agent.getLocation().getImageName();
		File imageDir = new File("data", "images");
		File imageFile = new File(imageDir, imageName);
		window.loadImage(imageFile);
	}
}
