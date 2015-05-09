// Project 02 - Calculator
// CSE1102 - Object Oriented Design and Programming
// Mark Bluemer
// Jagriti Das - Section 003
// 2-11-15

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		boolean contin = true;
		double accumulator = 0.0;
		double input;
		while(contin){
			int opt;
			
			System.out.println("Accumulator = " + accumulator);
			
			System.out.println("1) Addition"
					+ "\n2) Subtraction" 
					+ "\n3) Multiplication"
					+ "\n4) Division"
					+ "\n5) Square Root"
					+ "\n6) Clear"
					+ "\n0) Exit");
			
			System.out.print("What is your option? ");
			opt = kbd.nextInt();
			
			if(opt == 0){
				contin = false;
			} else if(opt == 1){
				System.out.print("Enter a number: ");
				input = kbd.nextDouble();
				accumulator += input;
			} else if(opt == 2){
				System.out.print("Enter a number: ");
				input = kbd.nextDouble();
				accumulator -= input;
			} else if(opt == 3){
				System.out.print("Enter a number: ");
				input = kbd.nextDouble();
				accumulator *= input;
			} else if(opt == 4){
				System.out.print("Enter a number: ");
				input = kbd.nextDouble();
				accumulator /= input;
			} else if(opt == 5){
				if(accumulator > 0){
					accumulator = Math.sqrt(accumulator);
				} else {
					System.out.println("Not taking square root of a negative number.");
				}
				
			} else if(opt == 6){
				accumulator = 0.0;
			} else {
				System.out.println("Illegal operation: " + opt);
			}
		}

	}

}
