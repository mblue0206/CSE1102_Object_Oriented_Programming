import java.util.Scanner;

public class CommandInterpreter {
	public static void run(Agent agent){
		Scanner input = new Scanner(System.in);
		boolean loop = true;
		
		System.out.println(agent.getName() + " is in " + agent.getLocation().getName());
		
		do {
			System.out.print("==> ");
			String choice = input.next();
			
			if (choice.equals("quit")){
				loop = false;
			} else if(choice.equals("go")) {
				agent.usePortal();
			} else if(choice.equals("look")) {
				System.out.println(agent.getLocation().toStringLong());
			} else if(choice.equals("where")) {
				System.out.println(agent.getLocation().toString());
			} else if(choice.equals("help")) {
				System.out.println("Available commands are:" 
						+ "\n\tgo"
						+ "\n\tlook"
						+ "\n\twhere"
						+ "\n\thelp"
						+ "\n\tquit");
			} else {
				System.out.println(choice + " is not a valid input.");
			}
		} while (loop);
		
		input.close();
	}
}
